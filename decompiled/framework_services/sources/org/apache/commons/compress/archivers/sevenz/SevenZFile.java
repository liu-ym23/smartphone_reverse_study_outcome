package org.apache.commons.compress.archivers.sevenz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.hardware.tv.mediaquality.ParameterName;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.zip.CRC32;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public class SevenZFile implements Closeable {
    private static final CharsetEncoder PASSWORD_ENCODER = null;
    static final int SIGNATURE_HEADER_SIZE = 32;
    static final byte[] sevenZSignature = null;
    private final Archive archive;
    private SeekableByteChannel channel;
    private long compressedBytesReadFromCurrentEntry;
    private int currentEntryIndex;
    private int currentFolderIndex;
    private InputStream currentFolderInputStream;
    private final ArrayList<InputStream> deferredBlockStreams;
    private final String fileName;
    private byte[] password;
    private long uncompressedBytesReadFromCurrentEntry;

    static /* synthetic */ long access$000(SevenZFile x0) {
        return x0.compressedBytesReadFromCurrentEntry;
    }

    static /* synthetic */ long access$014(SevenZFile x0, long x1) {
        long r0 = x0.compressedBytesReadFromCurrentEntry + x1;
        x0.compressedBytesReadFromCurrentEntry = r0;
        return r0;
    }

    static /* synthetic */ long access$100(SevenZFile x0) {
        return x0.uncompressedBytesReadFromCurrentEntry;
    }

    static {
        sevenZSignature = new byte[]{55, 122, -68, -81, ParameterName.COLOR_TEMPERATURE_BLUE_GAIN, ParameterName.GAMUT_MAPPING};
        PASSWORD_ENCODER = StandardCharsets.UTF_16LE.newEncoder();
    }

    public SevenZFile(File filename, char[] password) throws IOException {
        this(Files.newByteChannel(filename.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), filename.getAbsolutePath(), utf16Decode(password), true);
    }

    public SevenZFile(File filename, byte[] password) throws IOException {
        this(Files.newByteChannel(filename.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), filename.getAbsolutePath(), password, true);
    }

    public SevenZFile(SeekableByteChannel channel) throws IOException {
        this(channel, "unknown archive", null);
    }

    public SevenZFile(SeekableByteChannel channel, char[] password) throws IOException {
        this(channel, "unknown archive", utf16Decode(password));
    }

    public SevenZFile(SeekableByteChannel channel, String filename, char[] password) throws IOException {
        this(channel, filename, utf16Decode(password), false);
    }

    public SevenZFile(SeekableByteChannel channel, String filename) throws IOException {
        this(channel, filename, null, false);
    }

    public SevenZFile(SeekableByteChannel channel, byte[] password) throws IOException {
        this(channel, "unknown archive", password);
    }

    public SevenZFile(SeekableByteChannel channel, String filename, byte[] password) throws IOException {
        this(channel, filename, password, false);
    }

    private SevenZFile(SeekableByteChannel channel, String filename, byte[] password, boolean closeOnError) throws IOException {
        this.currentEntryIndex = -1;
        this.currentFolderIndex = -1;
        this.currentFolderInputStream = null;
        this.deferredBlockStreams = new ArrayList();
        this.channel = channel;
        this.fileName = filename;
        this.archive = readHeaders(password);     // Catch: Throwable -> L6
        if (password == null) goto L8;
        this.password = Arrays.copyOf(password, password.length);     // Catch: Throwable -> L6
    L10:
        if (1 != 0) goto L19;
        if (closeOnError == false) goto L20;
        this.channel.close();
        return;
    L20:
        return;
    L19:
        return;
    L8:
        this.password = null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        if (0 != 0) goto L17;
        if (closeOnError == false) goto L17;
        this.channel.close();
    L17:
        throw th;
    }

    public SevenZFile(File filename) throws IOException {
        this(filename, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.channel != null) goto L17;
        return;
    L17:
        this.channel.close();     // Catch: Throwable -> L10
        this.channel = null;
        if (this.password == null) goto L9;
        Arrays.fill(this.password, (byte) 0);
    L9:
        this.password = null;
        return;
    L10:
        th = move-exception;
        this.channel = null;
        if (this.password == null) goto L14;
        Arrays.fill(this.password, (byte) 0);
    L14:
        this.password = null;
        throw th;
    }

    public SevenZArchiveEntry getNextEntry() throws IOException {
        if (this.currentEntryIndex < (this.archive.files.length - 1)) goto L6;
        return null;
    L6:
        this.currentEntryIndex++;
        SevenZArchiveEntry entry = this.archive.files[this.currentEntryIndex];
        buildDecodingStream();
        this.compressedBytesReadFromCurrentEntry = 0;
        this.uncompressedBytesReadFromCurrentEntry = 0;
        return entry;
    }

    public Iterable<SevenZArchiveEntry> getEntries() {
        return Arrays.asList(this.archive.files);
    }

    private Archive readHeaders(byte[] password) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN);
        readFully(buf);
        byte[] signature = new byte[6];
        buf.get(signature);
        if (Arrays.equals(signature, sevenZSignature) == false) goto L26;
        byte archiveVersionMajor = buf.get();
        byte archiveVersionMinor = buf.get();
        if (archiveVersionMajor != 0) goto L24;
        long startHeaderCrc = ((long) buf.getInt()) & 4294967295L;
        StartHeader startHeader = readStartHeader(startHeaderCrc);
        int nextHeaderSizeInt = (int) startHeader.nextHeaderSize;
        if (nextHeaderSizeInt != startHeader.nextHeaderSize) goto L22;
        this.channel.position(startHeader.nextHeaderOffset + 32);
        ByteBuffer buf2 = ByteBuffer.allocate(nextHeaderSizeInt).order(ByteOrder.LITTLE_ENDIAN);
        readFully(buf2);
        CRC32 crc = new CRC32();
        crc.update(buf2.array());
        if (startHeader.nextHeaderCrc != crc.getValue()) goto L20;
        Archive archive = new Archive();
        int nid = getUnsignedByte(buf2);
        if (nid != 23) goto L14;
        buf2 = readEncodedHeader(buf2, archive, password);
        archive = new Archive();
        nid = getUnsignedByte(buf2);
    L14:
        if (nid != 1) goto L18;
        readHeader(buf2, archive);
        return archive;
    L18:
        throw new IOException("Broken or unsupported archive: no Header");
    L20:
        throw new IOException("NextHeader CRC mismatch");
    L22:
        throw new IOException("cannot handle nextHeaderSize " + startHeader.nextHeaderSize);
    L24:
        throw new IOException(String.format("Unsupported 7z version (%d,%d)", new Object[]{Byte.valueOf(archiveVersionMajor), Byte.valueOf(archiveVersionMinor)}));
    L26:
        throw new IOException("Bad 7z signature");
    }

    private StartHeader readStartHeader(long startHeaderCrc) throws IOException {
        StartHeader startHeader = new StartHeader();
        DataInputStream dataInputStream = new DataInputStream(new CRC32VerifyingInputStream(new BoundedSeekableByteChannelInputStream(this.channel, 20), 20, startHeaderCrc));
        startHeader.nextHeaderOffset = Long.reverseBytes(dataInputStream.readLong());     // Catch: Throwable -> L6
        startHeader.nextHeaderSize = Long.reverseBytes(dataInputStream.readLong());     // Catch: Throwable -> L6
        startHeader.nextHeaderCrc = ((long) Integer.reverseBytes(dataInputStream.readInt())) & 4294967295L;     // Catch: Throwable -> L6
        dataInputStream.close();
        return startHeader;
    L6:
        th = move-exception;
        dataInputStream.close();     // Catch: Throwable -> L10
        throw th;
    L10:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    }

    private void readHeader(ByteBuffer header, Archive archive) throws IOException {
        int nid = getUnsignedByte(header);
        if (nid != 2) goto L6;
        readArchiveProperties(header);
        nid = getUnsignedByte(header);
    L6:
        if (nid == 3) goto L18;
        if (nid != 4) goto L11;
        readStreamsInfo(header, archive);
        nid = getUnsignedByte(header);
    L11:
        if (nid != 5) goto L13;
        readFilesInfo(header, archive);
        nid = getUnsignedByte(header);
    L13:
        if (nid != 0) goto L16;
        return;
    L16:
        throw new IOException("Badly terminated header, found " + nid);
    L18:
        throw new IOException("Additional streams unsupported");
    }

    private void readArchiveProperties(ByteBuffer input) throws IOException {
        int nid = getUnsignedByte(input);
    L3:
        if (nid == 0) goto L5;
        long propertySize = readUint64(input);
        byte[] property = new byte[(int) propertySize];
        input.get(property);
        nid = getUnsignedByte(input);
        goto L3
    }

    private ByteBuffer readEncodedHeader(ByteBuffer header, Archive archive, byte[] password) throws IOException {
        readStreamsInfo(header, archive);
        Folder folder = archive.folders[0];
        long folderOffset = (archive.packPos + 32) + 0;
        this.channel.position(folderOffset);
        InputStream inputStreamStack = new BoundedSeekableByteChannelInputStream(this.channel, archive.packSizes[0]);
        Iterator<Coder> r3 = folder.getOrderedCoders().iterator();
        InputStream inputStreamStack2 = inputStreamStack;
    L4:
        if (r3.hasNext() == false) goto L13;
        Coder coder = r3.next();
        if (coder.numInStreams != 1) goto L11;
        if (coder.numOutStreams != 1) goto L11;
        inputStreamStack2 = Coders.addDecoder(this.fileName, inputStreamStack2, folder.getUnpackSizeForCoder(coder), coder, password);
    L11:
        throw new IOException("Multi input/output stream coders are not yet supported");
    L13:
        if (folder.hasCrc == false) goto L15;
        inputStreamStack2 = new CRC32VerifyingInputStream(inputStreamStack2, folder.getUnpackSize(), folder.crc);
    L15:
        byte[] nextHeader = new byte[(int) folder.getUnpackSize()];
        DataInputStream nextHeaderInputStream = new DataInputStream(inputStreamStack2);
        nextHeaderInputStream.readFully(nextHeader);     // Catch: Throwable -> L19
        nextHeaderInputStream.close();
        return ByteBuffer.wrap(nextHeader).order(ByteOrder.LITTLE_ENDIAN);
    L19:
        th = move-exception;
        nextHeaderInputStream.close();     // Catch: Throwable -> L23
        throw th;
    L23:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    }

    private void readStreamsInfo(ByteBuffer header, Archive archive) throws IOException {
        int nid = getUnsignedByte(header);
        if (nid != 6) goto L6;
        readPackInfo(header, archive);
        nid = getUnsignedByte(header);
    L6:
        if (nid != 7) goto L8;
        readUnpackInfo(header, archive);
        nid = getUnsignedByte(header);
    L10:
        if (nid != 8) goto L12;
        readSubStreamsInfo(header, archive);
        nid = getUnsignedByte(header);
    L12:
        if (nid != 0) goto L15;
        return;
    L15:
        throw new IOException("Badly terminated StreamsInfo");
    L8:
        archive.folders = new Folder[0];
        goto L10
    }

    private void readPackInfo(ByteBuffer header, Archive archive) throws IOException {
        archive.packPos = readUint64(header);
        long numPackStreams = readUint64(header);
        int nid = getUnsignedByte(header);
        if (nid != 9) goto L10;
        archive.packSizes = new long[(int) numPackStreams];
        int i = 0;
    L6:
        if (i >= archive.packSizes.length) goto L8;
        archive.packSizes[i] = readUint64(header);
        i = i + 1;
        goto L6
    L8:
        nid = getUnsignedByte(header);
    L10:
        if (nid != 10) goto L19;
        archive.packCrcsDefined = readAllOrBits(header, (int) numPackStreams);
        archive.packCrcs = new long[(int) numPackStreams];
        int i2 = 0;
    L13:
        if (i2 >= ((int) numPackStreams)) goto L18;
        if (archive.packCrcsDefined.get(i2) == false) goto L17;
        archive.packCrcs[i2] = ((long) header.getInt()) & 4294967295L;
    L17:
        i2 = i2 + 1;
        goto L13
    L18:
        nid = getUnsignedByte(header);
    L19:
        if (nid != 0) goto L22;
        return;
    L22:
        throw new IOException("Badly terminated PackInfo (" + nid + ")");
    }

    private void readUnpackInfo(ByteBuffer header, Archive archive) throws IOException {
        int nid = getUnsignedByte(header);
        if (nid != 11) goto L40;
        long numFolders = readUint64(header);
        Folder[] folders = new Folder[(int) numFolders];
        archive.folders = folders;
        int external = getUnsignedByte(header);
        if (external != 0) goto L38;
        int i = 0;
    L8:
        if (i >= ((int) numFolders)) goto L10;
        folders[i] = readFolder(header);
        i = i + 1;
        goto L8
    L10:
        int nid2 = getUnsignedByte(header);
        if (nid2 != 12) goto L36;
        int r6 = folders.length;
        int r8 = 0;
    L13:
        if (r8 >= r6) goto L19;
        Folder folder = folders[r8];
        folder.unpackSizes = new long[(int) folder.totalOutputStreams];
        int i2 = 0;
    L16:
        if (i2 >= folder.totalOutputStreams) goto L18;
        folder.unpackSizes[i2] = readUint64(header);
        i2 = i2 + 1;
        goto L16
    L18:
        r8 = r8 + 1;
        goto L13
    L19:
        int nid3 = getUnsignedByte(header);
        if (nid3 != 10) goto L31;
        BitSet crcsDefined = readAllOrBits(header, (int) numFolders);
        int i3 = 0;
    L23:
        if (i3 >= ((int) numFolders)) goto L29;
        if (crcsDefined.get(i3) == false) goto L27;
        folders[i3].hasCrc = true;
        folders[i3].crc = ((long) header.getInt()) & 4294967295L;
    L28:
        i3 = i3 + 1;
        goto L23
    L27:
        folders[i3].hasCrc = false;
        goto L28
    L29:
        nid3 = getUnsignedByte(header);
    L31:
        if (nid3 != 0) goto L34;
        return;
    L34:
        throw new IOException("Badly terminated UnpackInfo");
    L36:
        throw new IOException("Expected kCodersUnpackSize, got " + nid2);
    L38:
        throw new IOException("External unsupported");
    L40:
        throw new IOException("Expected kFolder, got " + nid);
    }

    private void readSubStreamsInfo(ByteBuffer header, Archive archive) throws IOException {
        Folder[] r1 = archive.folders;
        int r2 = r1.length;
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L6;
        r1[r4].numUnpackSubStreams = 1;
        r4 = r4 + 1;
        goto L4
    L6:
        int totalUnpackStreams = archive.folders.length;
        int nid = getUnsignedByte(header);
        if (nid != 13) goto L12;
        totalUnpackStreams = 0;
        Folder[] r5 = archive.folders;
        int r6 = r5.length;
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L11;
        Folder folder = r5[r7];
        long numStreams = readUint64(header);
        folder.numUnpackSubStreams = (int) numStreams;
        totalUnpackStreams = (int) (((long) totalUnpackStreams) + numStreams);
        r7 = r7 + 1;
        goto L9
    L11:
        nid = getUnsignedByte(header);
    L12:
        SubStreamsInfo subStreamsInfo = new SubStreamsInfo();
        subStreamsInfo.unpackSizes = new long[totalUnpackStreams];
        subStreamsInfo.hasCrc = new BitSet(totalUnpackStreams);
        subStreamsInfo.crcs = new long[totalUnpackStreams];
        int nextUnpackStream = 0;
        Folder[] r8 = archive.folders;
        int r9 = r8.length;
        int r10 = 0;
    L14:
        if (r10 >= r9) goto L26;
        Folder folder2 = r8[r10];
        if (folder2.numUnpackSubStreams == 0) goto L25;
        long sum = 0;
        if (nid != 9) goto L24;
        int i = 0;
    L22:
        if (i >= (folder2.numUnpackSubStreams - 1)) goto L24;
        long size = readUint64(header);
        subStreamsInfo.unpackSizes[nextUnpackStream] = size;
        sum = sum + size;
        i = i + 1;
        nextUnpackStream = nextUnpackStream + 1;
    L24:
        subStreamsInfo.unpackSizes[nextUnpackStream] = folder2.getUnpackSize() - sum;
        nextUnpackStream = nextUnpackStream + 1;
    L25:
        r10 = r10 + 1;
        goto L14
    L26:
        if (nid != 9) goto L28;
        nid = getUnsignedByte(header);
    L28:
        int numDigests = 0;
        Folder[] r11 = archive.folders;
        int r12 = r11.length;
        int r13 = 0;
    L29:
        if (r13 >= r12) goto L37;
        Folder folder3 = r11[r13];
        if (folder3.numUnpackSubStreams == 1) goto L33;
    L34:
        numDigests = numDigests + folder3.numUnpackSubStreams;
    L35:
        r13 = r13 + 1;
        goto L29
    L33:
        if (folder3.hasCrc == true) goto L35;
    L37:
        if (nid != 10) goto L58;
        BitSet hasMissingCrc = readAllOrBits(header, numDigests);
        long[] missingCrcs = new long[numDigests];
        int i2 = 0;
    L39:
        if (i2 >= numDigests) goto L44;
        if (hasMissingCrc.get(i2) == false) goto L43;
        missingCrcs[i2] = ((long) header.getInt()) & 4294967295L;
    L43:
        i2 = i2 + 1;
        goto L39
    L44:
        Folder[] r14 = archive.folders;
        int r15 = r14.length;
        int nextMissingCrc = 0;
        int nextCrc = 0;
        int nextCrc2 = 0;
    L45:
        if (nextCrc2 >= r15) goto L56;
        Folder folder4 = r14[nextCrc2];
        int totalUnpackStreams2 = totalUnpackStreams;
        int totalUnpackStreams3 = folder4.numUnpackSubStreams;
        int nid2 = nid;
        if (totalUnpackStreams3 == 1) goto L49;
    L51:
        int i3 = 0;
    L53:
        if (i3 >= folder4.numUnpackSubStreams) goto L55;
        subStreamsInfo.hasCrc.set(nextCrc, hasMissingCrc.get(nextMissingCrc));
        subStreamsInfo.crcs[nextCrc] = missingCrcs[nextMissingCrc];
        nextCrc = nextCrc + 1;
        nextMissingCrc = nextMissingCrc + 1;
        i3 = i3 + 1;
    L55:
        nextCrc2 = nextCrc2 + 1;
        numDigests = numDigests;
        totalUnpackStreams = totalUnpackStreams2;
        nid = nid2;
        goto L45
    L49:
        if (folder4.hasCrc == false) goto L51;
        subStreamsInfo.hasCrc.set(nextCrc, true);
        subStreamsInfo.crcs[nextCrc] = folder4.crc;
        nextCrc = nextCrc + 1;
        goto L55
    L56:
        nid = getUnsignedByte(header);
    L58:
        if (nid != 0) goto L62;
        archive.subStreamsInfo = subStreamsInfo;
        return;
    L62:
        throw new IOException("Badly terminated SubStreamsInfo");
    }

    private Folder readFolder(ByteBuffer header) throws IOException {
        Folder folder = new Folder();
        long numCoders = readUint64(header);
        Coder[] coders = new Coder[(int) numCoders];
        long totalInStreams = 0;
        long totalOutStreams = 0;
        int i = 0;
    L4:
        if (i >= coders.length) goto L28;
        coders[i] = new Coder();
        int bits = getUnsignedByte(header);
        int idSize = bits & 15;
        if ((bits & 16) != 0) goto L8;
        boolean isSimple = true;
    L10:
        if ((bits & 32) == 0) goto L12;
        boolean hasAttributes = true;
    L14:
        if ((bits & 128) == 0) goto L16;
        boolean moreAlternativeMethods = true;
    L17:
        coders[i].decompressionMethodId = new byte[idSize];
        header.get(coders[i].decompressionMethodId);
        if (isSimple == false) goto L20;
        coders[i].numInStreams = 1;
        coders[i].numOutStreams = 1;
    L21:
        totalInStreams = totalInStreams + coders[i].numInStreams;
        totalOutStreams = totalOutStreams + coders[i].numOutStreams;
        if (hasAttributes == false) goto L24;
        long propertiesSize = readUint64(header);
        coders[i].properties = new byte[(int) propertiesSize];
        header.get(coders[i].properties);
    L24:
        if (moreAlternativeMethods == true) goto L27;
        i = i + 1;
        numCoders = numCoders;
        goto L4
    L27:
        throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either.");
    L20:
        coders[i].numInStreams = readUint64(header);
        coders[i].numOutStreams = readUint64(header);
        goto L21
    L16:
        moreAlternativeMethods = false;
        goto L17
    L12:
        hasAttributes = false;
        goto L14
    L8:
        isSimple = false;
        goto L10
    L28:
        folder.coders = coders;
        folder.totalInputStreams = totalInStreams;
        folder.totalOutputStreams = totalOutStreams;
        if (totalOutStreams == 0) goto L59;
        long numBindPairs = totalOutStreams - 1;
        BindPair[] bindPairs = new BindPair[(int) numBindPairs];
        int i2 = 0;
    L32:
        if (i2 >= bindPairs.length) goto L34;
        bindPairs[i2] = new BindPair();
        bindPairs[i2].inIndex = readUint64(header);
        bindPairs[i2].outIndex = readUint64(header);
        i2 = i2 + 1;
        goto L32
    L34:
        folder.bindPairs = bindPairs;
        if (totalInStreams < numBindPairs) goto L57;
        long numPackedStreams = totalInStreams - numBindPairs;
        long[] packedStreams = new long[(int) numPackedStreams];
        if (numPackedStreams != 1) goto L50;
        int i3 = 0;
    L40:
        if (i3 >= ((int) totalInStreams)) goto L46;
        if (folder.findBindPairForInStream(i3) < 0) goto L46;
        i3 = i3 + 1;
    L46:
        if (i3 == ((int) totalInStreams)) goto L49;
        packedStreams[0] = i3;
    L54:
        folder.packedStreams = packedStreams;
        return folder;
    L49:
        throw new IOException("Couldn't find stream's bind pair index");
    L50:
        int i4 = 0;
    L52:
        if (i4 >= ((int) numPackedStreams)) goto L54;
        packedStreams[i4] = readUint64(header);
        i4 = i4 + 1;
        goto L52
    L57:
        throw new IOException("Total input streams can't be less than the number of bind pairs");
    L59:
        throw new IOException("Total output streams can't be 0");
    }

    private BitSet readAllOrBits(ByteBuffer header, int size) throws IOException {
        int areAllDefined = getUnsignedByte(header);
        if (areAllDefined == 0) goto L9;
        BitSet bits = new BitSet(size);
        int i = 0;
    L5:
        if (i >= size) goto L11;
        bits.set(i, true);
        i = i + 1;
        goto L5
    L11:
        return bits;
    L9:
        return readBits(header, size);
    }

    private BitSet readBits(ByteBuffer header, int size) throws IOException {
        BitSet bits = new BitSet(size);
        int mask = 0;
        int cache = 0;
        int i = 0;
    L3:
        if (i >= size) goto L12;
        if (mask != 0) goto L7;
        mask = 128;
        cache = getUnsignedByte(header);
    L7:
        if ((cache & mask) == 0) goto L9;
        boolean r4 = true;
    L10:
        bits.set(i, r4);
        mask = mask >>> 1;
        i = i + 1;
        goto L3
    L9:
        r4 = false;
        goto L10
    L12:
        return bits;
    }

    private void readFilesInfo(ByteBuffer header, Archive archive) throws IOException {
        long numFiles = readUint64(header);
        SevenZArchiveEntry[] files = new SevenZArchiveEntry[(int) numFiles];
        int i = 0;
    L4:
        if (i >= files.length) goto L6;
        files[i] = new SevenZArchiveEntry();
        i = i + 1;
        goto L4
    L6:
        BitSet isEmptyStream = null;
        BitSet isEmptyFile = null;
        BitSet isAnti = null;
    L7:
        int propertyType = getUnsignedByte(header);
        if (propertyType == 0) goto L9;
        long size = readUint64(header);
        switch(propertyType) {
            case 14: goto L137;
            case 15: goto L132;
            case 16: goto L127;
            case 17: goto L102;
            case 18: goto L90;
            case 19: goto L78;
            case 20: goto L65;
            case 21: goto L53;
            case 22: goto L42;
            case 23: goto L42;
            case 24: goto L52;
            case 25: goto L47;
            default: goto L42;
        };
    L53:
        BitSet attributesDefined = readAllOrBits(header, files.length);
        if (getUnsignedByte(header) != 0) goto L64;
        int i2 = 0;
    L57:
        if (i2 >= files.length) goto L62;
        files[i2].setHasWindowsAttributes(attributesDefined.get(i2));
        if (files[i2].getHasWindowsAttributes() == false) goto L61;
        files[i2].setWindowsAttributes(header.getInt());
    L61:
        i2 = i2 + 1;
        goto L57
    L62:
        long numFiles2 = numFiles;
        BitSet isEmptyStream2 = isEmptyStream;
        BitSet isEmptyFile2 = isEmptyFile;
    L120:
        isEmptyStream = isEmptyStream2;
        isEmptyFile = isEmptyFile2;
    L138:
        numFiles = numFiles2;
        goto L7
    L64:
        throw new IOException("Unimplemented");
    L65:
        BitSet timesDefined = readAllOrBits(header, files.length);
        if (getUnsignedByte(header) != 0) goto L77;
        int i3 = 0;
    L69:
        if (i3 >= files.length) goto L75;
        files[i3].setHasLastModifiedDate(timesDefined.get(i3));
        if (files[i3].getHasLastModifiedDate() == false) goto L74;
        files[i3].setLastModifiedDate(header.getLong());
    L74:
        i3 = i3 + 1;
        timesDefined = timesDefined;
        numFiles = numFiles;
        goto L69
    L75:
        numFiles2 = numFiles;
        isEmptyStream2 = isEmptyStream;
        isEmptyFile2 = isEmptyFile;
        goto L120
    L77:
        throw new IOException("Unimplemented");
    L78:
        numFiles2 = numFiles;
        BitSet timesDefined2 = readAllOrBits(header, files.length);
        if (getUnsignedByte(header) != 0) goto L89;
        int i4 = 0;
    L82:
        if (i4 >= files.length) goto L87;
        files[i4].setHasAccessDate(timesDefined2.get(i4));
        if (files[i4].getHasAccessDate() == false) goto L86;
        files[i4].setAccessDate(header.getLong());
    L86:
        i4 = i4 + 1;
        goto L82
    L87:
        isEmptyStream2 = isEmptyStream;
        isEmptyFile2 = isEmptyFile;
        goto L120
    L89:
        throw new IOException("Unimplemented");
    L90:
        numFiles2 = numFiles;
        BitSet timesDefined3 = readAllOrBits(header, files.length);
        if (getUnsignedByte(header) != 0) goto L101;
        int i5 = 0;
    L94:
        if (i5 >= files.length) goto L99;
        files[i5].setHasCreationDate(timesDefined3.get(i5));
        if (files[i5].getHasCreationDate() == false) goto L98;
        files[i5].setCreationDate(header.getLong());
    L98:
        i5 = i5 + 1;
        goto L94
    L99:
        isEmptyStream2 = isEmptyStream;
        isEmptyFile2 = isEmptyFile;
        goto L120
    L101:
        throw new IOException("Unimplemented");
    L102:
        numFiles2 = numFiles;
        int external = getUnsignedByte(header);
        if (external != 0) goto L126;
        if (((size - 1) & 1) != 0) goto L124;
        byte[] names = new byte[(int) (size - 1)];
        header.get(names);
        int nextFile = 0;
        int nextName = 0;
        int i6 = 0;
    L108:
        if (i6 >= names.length) goto L116;
        if (names[i6] != 0) goto L115;
        if (names[i6 + 1] != 0) goto L115;
        files[nextFile].setName(new String(names, nextName, i6 - nextName, CharsetNames.UTF_16LE));
        nextName = i6 + 2;
        nextFile = nextFile + 1;
    L115:
        i6 = i6 + 2;
        external = external;
        isEmptyStream = isEmptyStream;
        isEmptyFile = isEmptyFile;
        goto L108
    L116:
        isEmptyStream2 = isEmptyStream;
        isEmptyFile2 = isEmptyFile;
        if (nextName != names.length) goto L122;
        if (nextFile == files.length) goto L120;
    L122:
        throw new IOException("Error parsing file names");
    L124:
        throw new IOException("File names length invalid");
    L126:
        throw new IOException("Not implemented");
    L127:
        numFiles2 = numFiles;
        BitSet isEmptyStream3 = isEmptyStream;
        BitSet isEmptyFile3 = isEmptyFile;
        if (isEmptyStream3 == null) goto L131;
        BitSet isAnti2 = readBits(header, isEmptyStream3.cardinality());
        isAnti = isAnti2;
        isEmptyStream = isEmptyStream3;
        isEmptyFile = isEmptyFile3;
        goto L138
    L131:
        throw new IOException("Header format error: kEmptyStream must appear before kAnti");
    L132:
        numFiles2 = numFiles;
        BitSet isEmptyStream4 = isEmptyStream;
        if (isEmptyStream4 == null) goto L136;
        BitSet isEmptyFile4 = readBits(header, isEmptyStream4.cardinality());
        isEmptyFile = isEmptyFile4;
        isEmptyStream = isEmptyStream4;
        goto L138
    L136:
        throw new IOException("Header format error: kEmptyStream must appear before kEmptyFile");
    L137:
        numFiles2 = numFiles;
        BitSet isEmptyStream5 = readBits(header, files.length);
        isEmptyStream = isEmptyStream5;
        goto L138
    L42:
        if (skipBytesFully(header, size) < size) goto L45;
        numFiles2 = numFiles;
        isEmptyStream2 = isEmptyStream;
        isEmptyFile2 = isEmptyFile;
        goto L120
    L45:
        throw new IOException("Incomplete property of type " + propertyType);
    L47:
        if (skipBytesFully(header, size) < size) goto L50;
        numFiles2 = numFiles;
        isEmptyStream2 = isEmptyStream;
        isEmptyFile2 = isEmptyFile;
        goto L120
    L50:
        throw new IOException("Incomplete kDummy property");
    L52:
        throw new IOException("kStartPos is unsupported, please report");
    L9:
        int nonEmptyFileCounter = 0;
        int emptyFileCounter = 0;
        int i7 = 0;
    L11:
        if (i7 >= files.length) goto L37;
        SevenZArchiveEntry r14 = files[i7];
        if (isEmptyStream != null) goto L15;
    L18:
        boolean r10 = true;
    L19:
        r14.setHasStream(r10);
        if (files[i7].hasStream() == false) goto L22;
        files[i7].setDirectory(false);
        files[i7].setAntiItem(false);
        files[i7].setHasCrc(archive.subStreamsInfo.hasCrc.get(nonEmptyFileCounter));
        files[i7].setCrcValue(archive.subStreamsInfo.crcs[nonEmptyFileCounter]);
        files[i7].setSize(archive.subStreamsInfo.unpackSizes[nonEmptyFileCounter]);
        nonEmptyFileCounter = nonEmptyFileCounter + 1;
    L36:
        i7 = i7 + 1;
        goto L11
    L22:
        SevenZArchiveEntry r11 = files[i7];
        if (isEmptyFile != null) goto L25;
    L28:
        boolean r12 = true;
    L29:
        r11.setDirectory(r12);
        SevenZArchiveEntry r13 = files[i7];
        if (isAnti != null) goto L32;
    L34:
        boolean r15 = false;
    L35:
        r13.setAntiItem(r15);
        files[i7].setHasCrc(false);
        files[i7].setSize(0);
        emptyFileCounter = emptyFileCounter + 1;
        goto L36
    L32:
        if (isAnti.get(emptyFileCounter) == false) goto L34;
        r15 = true;
        goto L35
    L25:
        if (isEmptyFile.get(emptyFileCounter) == false) goto L28;
        r12 = false;
        goto L29
    L15:
        if (isEmptyStream.get(i7) == false) goto L18;
        r10 = false;
        goto L19
    L37:
        archive.files = files;
        calculateStreamMap(archive);
    }

    private void calculateStreamMap(Archive archive) throws IOException {
        StreamMap streamMap = new StreamMap();
        int nextFolderPackStreamIndex = 0;
        int numPackSizes = 0;
        if (archive.folders == null) goto L5;
        int numFolders = archive.folders.length;
    L6:
        streamMap.folderFirstPackStreamIndex = new int[numFolders];
        int i = 0;
    L7:
        if (i >= numFolders) goto L9;
        streamMap.folderFirstPackStreamIndex[i] = nextFolderPackStreamIndex;
        nextFolderPackStreamIndex = nextFolderPackStreamIndex + archive.folders[i].packedStreams.length;
        i = i + 1;
        goto L7
    L9:
        long nextPackStreamOffset = 0;
        if (archive.packSizes == null) goto L12;
        numPackSizes = archive.packSizes.length;
    L12:
        streamMap.packStreamOffsets = new long[numPackSizes];
        int i2 = 0;
    L13:
        if (i2 >= numPackSizes) goto L15;
        streamMap.packStreamOffsets[i2] = nextPackStreamOffset;
        nextPackStreamOffset = nextPackStreamOffset + archive.packSizes[i2];
        i2 = i2 + 1;
        goto L13
    L15:
        streamMap.folderFirstFileIndex = new int[numFolders];
        streamMap.fileFolderIndex = new int[archive.files.length];
        int nextFolderIndex = 0;
        int nextFolderUnpackStreamIndex = 0;
        int i3 = 0;
    L17:
        if (i3 >= archive.files.length) goto L42;
        if (archive.files[i3].hasStream() == true) goto L23;
        if (nextFolderUnpackStreamIndex != 0) goto L23;
        streamMap.fileFolderIndex[i3] = -1;
    L41:
        i3 = i3 + 1;
    L23:
        if (nextFolderUnpackStreamIndex == 0) goto L25;
    L35:
        streamMap.fileFolderIndex[i3] = nextFolderIndex;
        if (archive.files[i3].hasStream() == false) goto L41;
        nextFolderUnpackStreamIndex = nextFolderUnpackStreamIndex + 1;
        if (nextFolderUnpackStreamIndex < archive.folders[nextFolderIndex].numUnpackSubStreams) goto L41;
        nextFolderIndex = nextFolderIndex + 1;
        nextFolderUnpackStreamIndex = 0;
    L25:
        if (nextFolderIndex >= archive.folders.length) goto L31;
        streamMap.folderFirstFileIndex[nextFolderIndex] = i3;
        if (archive.folders[nextFolderIndex].numUnpackSubStreams > 0) goto L31;
        nextFolderIndex = nextFolderIndex + 1;
    L31:
        if (nextFolderIndex < archive.folders.length) goto L35;
        throw new IOException("Too few folders in archive");
    L42:
        archive.streamMap = streamMap;
        return;
    L5:
        numFolders = 0;
        goto L6
    }

    private void buildDecodingStream() throws IOException {
        int folderIndex = this.archive.streamMap.fileFolderIndex[this.currentEntryIndex];
        if (folderIndex >= 0) goto L6;
        this.deferredBlockStreams.clear();
        return;
    L6:
        SevenZArchiveEntry file = this.archive.files[this.currentEntryIndex];
        if (this.currentFolderIndex != folderIndex) goto L9;
        file.setContentMethods(this.archive.files[this.currentEntryIndex - 1].getContentMethods());
        SevenZFile r3 = this;
    L13:
        InputStream fileStream = new BoundedInputStream(r3.currentFolderInputStream, file.getSize());
        if (file.getHasCrc() == false) goto L16;
        fileStream = new CRC32VerifyingInputStream(fileStream, file.getSize(), file.getCrcValue());
    L16:
        r3.deferredBlockStreams.add(fileStream);
        return;
    L9:
        this.currentFolderIndex = folderIndex;
        this.deferredBlockStreams.clear();
        if (this.currentFolderInputStream == null) goto L12;
        this.currentFolderInputStream.close();
        this.currentFolderInputStream = null;
    L12:
        Folder folder = this.archive.folders[folderIndex];
        int firstPackStreamIndex = this.archive.streamMap.folderFirstPackStreamIndex[folderIndex];
        long folderOffset = this.archive.streamMap.packStreamOffsets[firstPackStreamIndex] + (this.archive.packPos + 32);
        r3 = this;
        r3.currentFolderInputStream = r3.buildDecoderStack(folder, folderOffset, firstPackStreamIndex, file);
        goto L13
    }

    private InputStream buildDecoderStack(Folder folder, long folderOffset, int firstPackStreamIndex, SevenZArchiveEntry entry) throws IOException {
        this.channel.position(folderOffset);
        final BufferedInputStream r1 = new BufferedInputStream(new BoundedSeekableByteChannelInputStream(this.channel, this.archive.packSizes[firstPackStreamIndex]));
        InputStream inputStreamStack = new AnonymousClass1(this, r1);
        LinkedList<SevenZMethodConfiguration> methods = new LinkedList();
        Iterator<Coder> r2 = folder.getOrderedCoders().iterator();
        InputStream inputStreamStack2 = inputStreamStack;
    L4:
        if (r2.hasNext() == false) goto L12;
        Coder coder = r2.next();
        if (coder.numInStreams != 1) goto L11;
        if (coder.numOutStreams != 1) goto L11;
        SevenZMethod method = SevenZMethod.byId(coder.decompressionMethodId);
        inputStreamStack2 = Coders.addDecoder(this.fileName, inputStreamStack2, folder.getUnpackSizeForCoder(coder), coder, this.password);
        methods.addFirst(new SevenZMethodConfiguration(method, Coders.findByMethod(method).getOptionsFromCoder(coder, inputStreamStack2)));
    L11:
        throw new IOException("Multi input/output stream coders are not yet supported");
    L12:
        entry.setContentMethods(methods);
        if (folder.hasCrc == true) goto L15;
        return inputStreamStack2;
    L15:
        return new CRC32VerifyingInputStream(inputStreamStack2, folder.getUnpackSize(), folder.crc);
    }

    public int read() throws IOException {
        int b = getCurrentStream().read();
        if (b < 0) goto L5;
        this.uncompressedBytesReadFromCurrentEntry++;
    L5:
        return b;
    }

    private InputStream getCurrentStream() throws IOException {
        if (this.archive.files[this.currentEntryIndex].getSize() != 0) goto L7;
        return new ByteArrayInputStream(new byte[0]);
    L7:
        if (this.deferredBlockStreams.isEmpty() == true) goto L25;
    L9:
        if (this.deferredBlockStreams.size() <= 1) goto L23;
        InputStream stream = this.deferredBlockStreams.remove(0);
        IOUtils.skip(stream, Long.MAX_VALUE);     // Catch: Throwable -> L15
        if (stream == null) goto L14;
        stream.close();
    L14:
        this.compressedBytesReadFromCurrentEntry = 0;
    L15:
        th = move-exception;
        if (stream != null) goto L28;
    L21:
        throw th;
    L28:
        stream.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);
        goto L21
    L23:
        return this.deferredBlockStreams.get(0);
    L25:
        throw new IllegalStateException("No current 7z entry (call getNextEntry() first).");
    }

    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int cnt = getCurrentStream().read(b, off, len);
        if (cnt <= 0) goto L5;
        this.uncompressedBytesReadFromCurrentEntry += (long) cnt;
    L5:
        return cnt;
    }

    public InputStreamStatistics getStatisticsForCurrentEntry() {
        return new AnonymousClass2(this);
    }

    private static long readUint64(ByteBuffer in) throws IOException {
        long firstByte = getUnsignedByte(in);
        int mask = 128;
        long value = 0;
        int i = 0;
    L4:
        if (i >= 8) goto L11;
        if ((((long) mask) & firstByte) == 0) goto L8;
        long nextByte = getUnsignedByte(in);
        value = value | (nextByte << (i * 8));
        mask = mask >>> 1;
        i = i + 1;
        goto L4
    L8:
        return ((((long) (mask - 1)) & firstByte) << (i * 8)) | value;
    L11:
        return value;
    }

    private static int getUnsignedByte(ByteBuffer buf) {
        return buf.get() & CecDeviceType.INACTIVE;
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= sevenZSignature.length) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= sevenZSignature.length) goto L12;
        if (signature[i] != sevenZSignature[i]) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private static long skipBytesFully(ByteBuffer input, long bytesToSkip) throws IOException {
        if (bytesToSkip >= 1) goto L6;
        return 0;
    L6:
        int current = input.position();
        int maxSkip = input.remaining();
        if (maxSkip >= bytesToSkip) goto L9;
        bytesToSkip = maxSkip;
    L9:
        input.position(((int) bytesToSkip) + current);
        return bytesToSkip;
    }

    private void readFully(ByteBuffer buf) throws IOException {
        buf.rewind();
        IOUtils.readFully(this.channel, buf);
        buf.flip();
    }

    public String toString() {
        return this.archive.toString();
    }

    private static byte[] utf16Decode(char[] chars) throws IOException {
        if (chars != null) goto L5;
        return null;
    L5:
        ByteBuffer encoded = PASSWORD_ENCODER.encode(CharBuffer.wrap(chars));
        if (encoded.hasArray() == true) goto L8;
        byte[] e = new byte[encoded.remaining()];
        encoded.get(e);
        return e;
    L8:
        return encoded.array();
    }
}
