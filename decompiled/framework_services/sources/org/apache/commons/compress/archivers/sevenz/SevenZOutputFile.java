package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.CountingOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class SevenZOutputFile implements Closeable {
    private CountingOutputStream[] additionalCountingStreams;
    private final Map<SevenZArchiveEntry, long[]> additionalSizes;
    private final SeekableByteChannel channel;
    private final CRC32 compressedCrc32;
    private Iterable<? extends SevenZMethodConfiguration> contentMethods;
    private final CRC32 crc32;
    private CountingOutputStream currentOutputStream;
    private long fileBytesWritten;
    private final List<SevenZArchiveEntry> files;
    private boolean finished;
    private int numNonEmptyStreams;

    private class OutputStreamWrapper extends OutputStream {
        private static final int BUF_SIZE = 8192;
        private final ByteBuffer buffer;
        final /* synthetic */ SevenZOutputFile this$0;

        private OutputStreamWrapper(SevenZOutputFile r1) {
            this.this$0 = r1;
            this.buffer = ByteBuffer.allocate(8192);
        }

        /* synthetic */ OutputStreamWrapper(SevenZOutputFile x0, AnonymousClass1 x1) {
            this(x0);
        }

        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            this.buffer.clear();
            this.buffer.put((byte) b).flip();
            SevenZOutputFile.access$200(this.this$0).write(this.buffer);
            SevenZOutputFile.access$300(this.this$0).update(b);
            SevenZOutputFile.access$408(this.this$0);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b) throws IOException {
            write(b, 0, b.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b, int off, int len) throws IOException {
            if (len <= 8192) goto L5;
            SevenZOutputFile.access$200(this.this$0).write(ByteBuffer.wrap(b, off, len));
        L6:
            SevenZOutputFile.access$300(this.this$0).update(b, off, len);
            SevenZOutputFile.access$414(this.this$0, len);
            return;
        L5:
            this.buffer.clear();
            this.buffer.put(b, off, len).flip();
            SevenZOutputFile.access$200(this.this$0).write(this.buffer);
            goto L6
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    static /* synthetic */ CRC32 access$100(SevenZOutputFile x0) {
        return x0.crc32;
    }

    static /* synthetic */ SeekableByteChannel access$200(SevenZOutputFile x0) {
        return x0.channel;
    }

    static /* synthetic */ CRC32 access$300(SevenZOutputFile x0) {
        return x0.compressedCrc32;
    }

    static /* synthetic */ long access$408(SevenZOutputFile x0) {
        long r0 = x0.fileBytesWritten;
        x0.fileBytesWritten = 1 + r0;
        return r0;
    }

    static /* synthetic */ long access$414(SevenZOutputFile x0, long x1) {
        long r0 = x0.fileBytesWritten + x1;
        x0.fileBytesWritten = r0;
        return r0;
    }

    public SevenZOutputFile(File filename) throws IOException {
        this(Files.newByteChannel(filename.toPath(), EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING), new FileAttribute[0]));
    }

    public SevenZOutputFile(SeekableByteChannel channel) throws IOException {
        this.files = new ArrayList();
        this.numNonEmptyStreams = 0;
        this.crc32 = new CRC32();
        this.compressedCrc32 = new CRC32();
        this.fileBytesWritten = 0;
        this.finished = false;
        this.contentMethods = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.LZMA2));
        this.additionalSizes = new HashMap();
        this.channel = channel;
        channel.position(32);
    }

    public void setContentCompression(SevenZMethod method) {
        setContentMethods(Collections.singletonList(new SevenZMethodConfiguration(method)));
    }

    public void setContentMethods(Iterable<? extends SevenZMethodConfiguration> methods) {
        this.contentMethods = reverse(methods);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    L6:
        th = move-exception;
        this.channel.close();
        throw th;
    L3:
        if (this.finished == true) goto L8;
        finish();     // Catch: Throwable -> L6
    L8:
        this.channel.close();
    }

    public SevenZArchiveEntry createArchiveEntry(File inputFile, String entryName) throws IOException {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        entry.setDirectory(inputFile.isDirectory());
        entry.setName(entryName);
        entry.setLastModifiedDate(new Date(inputFile.lastModified()));
        return entry;
    }

    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        SevenZArchiveEntry entry = (SevenZArchiveEntry) archiveEntry;
        this.files.add(entry);
    }

    public void closeArchiveEntry() throws IOException {
        if (this.currentOutputStream == null) goto L5;
        this.currentOutputStream.flush();
        this.currentOutputStream.close();
    L5:
        SevenZArchiveEntry entry = this.files.get(this.files.size() - 1);
        if (this.fileBytesWritten <= 0) goto L14;
        entry.setHasStream(true);
        this.numNonEmptyStreams++;
        entry.setSize(this.currentOutputStream.getBytesWritten());
        entry.setCompressedSize(this.fileBytesWritten);
        entry.setCrcValue(this.crc32.getValue());
        entry.setCompressedCrcValue(this.compressedCrc32.getValue());
        entry.setHasCrc(true);
        if (this.additionalCountingStreams == null) goto L15;
        long[] sizes = new long[this.additionalCountingStreams.length];
        int i = 0;
    L11:
        if (i >= this.additionalCountingStreams.length) goto L13;
        sizes[i] = this.additionalCountingStreams[i].getBytesWritten();
        i = i + 1;
        goto L11
    L13:
        this.additionalSizes.put(entry, sizes);
    L15:
        this.currentOutputStream = null;
        this.additionalCountingStreams = null;
        this.crc32.reset();
        this.compressedCrc32.reset();
        this.fileBytesWritten = 0;
        return;
    L14:
        entry.setHasStream(false);
        entry.setSize(0);
        entry.setCompressedSize(0);
        entry.setHasCrc(false);
        goto L15
    }

    public void write(int b) throws IOException {
        getCurrentOutputStream().write(b);
    }

    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        if (len <= 0) goto L5;
        getCurrentOutputStream().write(b, off, len);
        return;
    }

    public void finish() throws IOException {
        if (this.finished == true) goto L7;
        this.finished = true;
        long headerPosition = this.channel.position();
        ByteArrayOutputStream headerBaos = new ByteArrayOutputStream();
        DataOutputStream header = new DataOutputStream(headerBaos);
        writeHeader(header);
        header.flush();
        byte[] headerBytes = headerBaos.toByteArray();
        this.channel.write(ByteBuffer.wrap(headerBytes));
        CRC32 crc32 = new CRC32();
        crc32.update(headerBytes);
        ByteBuffer bb = ByteBuffer.allocate(((((SevenZFile.sevenZSignature.length + 2) + 4) + 8) + 8) + 4).order(ByteOrder.LITTLE_ENDIAN);
        this.channel.position(0);
        bb.put(SevenZFile.sevenZSignature);
        bb.put((byte) 0).put((byte) 2);
        bb.putInt(0);
        bb.putLong(headerPosition - 32).putLong(((long) headerBytes.length) & 4294967295L).putInt((int) crc32.getValue());
        crc32.reset();
        crc32.update(bb.array(), SevenZFile.sevenZSignature.length + 6, 20);
        bb.putInt(SevenZFile.sevenZSignature.length + 2, (int) crc32.getValue());
        bb.flip();
        this.channel.write(bb);
        return;
    L7:
        throw new IOException("This archive has already been finished");
    }

    private OutputStream getCurrentOutputStream() throws IOException {
        if (this.currentOutputStream != null) goto L6;
        this.currentOutputStream = setupFileOutputStream();
    L6:
        return this.currentOutputStream;
    }

    private CountingOutputStream setupFileOutputStream() throws IOException {
        if (this.files.isEmpty() == true) goto L17;
        final OutputStream out = new OutputStreamWrapper(this, null);
        ArrayList<CountingOutputStream> moreStreams = new ArrayList();
        boolean first = true;
        Iterator<? extends SevenZMethodConfiguration> r3 = getContentMethods(this.files.get(this.files.size() - 1)).iterator();
    L6:
        if (r3.hasNext() == false) goto L12;
        SevenZMethodConfiguration m = r3.next();
        if (first == true) goto L10;
        CountingOutputStream cos = new CountingOutputStream(out);
        moreStreams.add(cos);
        out = cos;
    L10:
        out = Coders.addEncoder(out, m.getMethod(), m.getOptions());
        first = false;
        goto L6
    L12:
        if (moreStreams.isEmpty() == true) goto L15;
        this.additionalCountingStreams = (CountingOutputStream[]) moreStreams.toArray(new CountingOutputStream[moreStreams.size()]);
    L15:
        return new AnonymousClass1(this, out);
    L17:
        throw new IllegalStateException("No current 7z entry");
    }

    private Iterable<? extends SevenZMethodConfiguration> getContentMethods(SevenZArchiveEntry entry) {
        Iterable<? extends SevenZMethodConfiguration> ms = entry.getContentMethods();
        if (ms != null) goto L6;
        return this.contentMethods;
    L6:
        return ms;
    }

    private void writeHeader(DataOutput header) throws IOException {
        header.write(1);
        header.write(4);
        writeStreamsInfo(header);
        writeFilesInfo(header);
        header.write(0);
    }

    private void writeStreamsInfo(DataOutput header) throws IOException {
        if (this.numNonEmptyStreams <= 0) goto L5;
        writePackInfo(header);
        writeUnpackInfo(header);
    L5:
        writeSubStreamsInfo(header);
        header.write(0);
    }

    private void writePackInfo(DataOutput header) throws IOException {
        header.write(6);
        writeUint64(header, 0);
        writeUint64(header, ((long) this.numNonEmptyStreams) & 4294967295L);
        header.write(9);
        Iterator<SevenZArchiveEntry> r0 = this.files.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        SevenZArchiveEntry entry = r0.next();
        if (entry.hasStream() == false) goto L4;
        writeUint64(header, entry.getCompressedSize());
        goto L4
    L9:
        header.write(10);
        header.write(1);
        Iterator<SevenZArchiveEntry> r1 = this.files.iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        SevenZArchiveEntry entry2 = r1.next();
        if (entry2.hasStream() == false) goto L11;
        header.writeInt(Integer.reverseBytes((int) entry2.getCompressedCrcValue()));
        goto L11
    L16:
        header.write(0);
    }

    private void writeUnpackInfo(DataOutput header) throws IOException {
        header.write(7);
        header.write(11);
        writeUint64(header, this.numNonEmptyStreams);
        header.write(0);
        Iterator<SevenZArchiveEntry> r1 = this.files.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        SevenZArchiveEntry entry = r1.next();
        if (entry.hasStream() == false) goto L4;
        writeFolder(header, entry);
        goto L4
    L9:
        header.write(12);
        Iterator<SevenZArchiveEntry> r2 = this.files.iterator();
    L11:
        if (r2.hasNext() == false) goto L22;
        SevenZArchiveEntry entry2 = r2.next();
        if (entry2.hasStream() == false) goto L11;
        long[] moreSizes = this.additionalSizes.get(entry2);
        if (moreSizes == null) goto L20;
        int r4 = moreSizes.length;
        int r5 = 0;
    L18:
        if (r5 >= r4) goto L20;
        long s = moreSizes[r5];
        writeUint64(header, s);
        r5 = r5 + 1;
    L20:
        writeUint64(header, entry2.getSize());
        goto L11
    L22:
        header.write(10);
        header.write(1);
        Iterator<SevenZArchiveEntry> r3 = this.files.iterator();
    L24:
        if (r3.hasNext() == false) goto L29;
        SevenZArchiveEntry entry3 = r3.next();
        if (entry3.hasStream() == false) goto L24;
        header.writeInt(Integer.reverseBytes((int) entry3.getCrcValue()));
        goto L24
    L29:
        header.write(0);
    }

    private void writeFolder(DataOutput header, SevenZArchiveEntry entry) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int numCoders = 0;
        Iterator<? extends SevenZMethodConfiguration> r2 = getContentMethods(entry).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        SevenZMethodConfiguration m = r2.next();
        numCoders = numCoders + 1;
        writeSingleCodec(m, bos);
        goto L4
    L6:
        writeUint64(header, numCoders);
        header.write(bos.toByteArray());
        long i = 0;
    L8:
        if (i >= (numCoders - 1)) goto L11;
        writeUint64(header, i + 1);
        writeUint64(header, i);
        i = i + 1;
        goto L8
    }

    private void writeSingleCodec(SevenZMethodConfiguration m, OutputStream bos) throws IOException {
        byte[] id = m.getMethod().getId();
        byte[] properties = Coders.findByMethod(m.getMethod()).getOptionsAsProperties(m.getOptions());
        int codecFlags = id.length;
        if (properties.length <= 0) goto L5;
        codecFlags = codecFlags | 32;
    L5:
        bos.write(codecFlags);
        bos.write(id);
        if (properties.length <= 0) goto L9;
        bos.write(properties.length);
        bos.write(properties);
        return;
    }

    private void writeSubStreamsInfo(DataOutput header) throws IOException {
        header.write(8);
        header.write(0);
    }

    private void writeFilesInfo(DataOutput header) throws IOException {
        header.write(5);
        writeUint64(header, this.files.size());
        writeFileEmptyStreams(header);
        writeFileEmptyFiles(header);
        writeFileAntiItems(header);
        writeFileNames(header);
        writeFileCTimes(header);
        writeFileATimes(header);
        writeFileMTimes(header);
        writeFileWindowsAttributes(header);
        header.write(0);
    }

    private void writeFileEmptyStreams(DataOutput header) throws IOException {
        boolean hasEmptyStreams = false;
        Iterator<SevenZArchiveEntry> r1 = this.files.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        SevenZArchiveEntry entry = r1.next();
        if (entry.hasStream() == true) goto L4;
        hasEmptyStreams = true;
    L9:
        if (hasEmptyStreams == false) goto L20;
        header.write(14);
        BitSet emptyStreams = new BitSet(this.files.size());
        int i = 0;
    L12:
        if (i >= this.files.size()) goto L14;
        emptyStreams.set(i, !this.files.get(i).hasStream());
        i = i + 1;
        goto L12
    L14:
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        writeBits(out, emptyStreams, this.files.size());
        out.flush();
        byte[] contents = baos.toByteArray();
        writeUint64(header, contents.length);
        header.write(contents);
        return;
    }

    private void writeFileEmptyFiles(DataOutput header) throws IOException {
        boolean hasEmptyFiles = false;
        int emptyStreamCounter = 0;
        BitSet emptyFiles = new BitSet(0);
        Iterator<SevenZArchiveEntry> r3 = this.files.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        SevenZArchiveEntry file1 = r3.next();
        if (file1.hasStream() == true) goto L4;
        boolean isDir = file1.isDirectory();
        emptyFiles.set(emptyStreamCounter, !isDir);
        hasEmptyFiles = hasEmptyFiles | (!isDir);
        emptyStreamCounter = emptyStreamCounter + 1;
        goto L4
    L9:
        if (hasEmptyFiles == false) goto L17;
        header.write(15);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        writeBits(out, emptyFiles, emptyStreamCounter);
        out.flush();
        byte[] contents = baos.toByteArray();
        writeUint64(header, contents.length);
        header.write(contents);
        return;
    }

    private void writeFileAntiItems(DataOutput header) throws IOException {
        boolean hasAntiItems = false;
        BitSet antiItems = new BitSet(0);
        int antiItemCounter = 0;
        Iterator<SevenZArchiveEntry> r3 = this.files.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        SevenZArchiveEntry file1 = r3.next();
        if (file1.hasStream() == true) goto L4;
        boolean isAnti = file1.isAntiItem();
        antiItems.set(antiItemCounter, isAnti);
        hasAntiItems = hasAntiItems | isAnti;
        antiItemCounter = antiItemCounter + 1;
        goto L4
    L9:
        if (hasAntiItems == false) goto L17;
        header.write(16);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        writeBits(out, antiItems, antiItemCounter);
        out.flush();
        byte[] contents = baos.toByteArray();
        writeUint64(header, contents.length);
        header.write(contents);
        return;
    }

    private void writeFileNames(DataOutput header) throws IOException {
        header.write(17);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        out.write(0);
        Iterator<SevenZArchiveEntry> r3 = this.files.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        SevenZArchiveEntry entry = r3.next();
        out.write(entry.getName().getBytes(CharsetNames.UTF_16LE));
        out.writeShort(0);
        goto L4
    L6:
        out.flush();
        byte[] contents = baos.toByteArray();
        writeUint64(header, contents.length);
        header.write(contents);
    }

    private void writeFileCTimes(DataOutput header) throws IOException {
        int numCreationDates = 0;
        Iterator<SevenZArchiveEntry> r1 = this.files.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().getHasCreationDate() == false) goto L4;
        numCreationDates = numCreationDates + 1;
        goto L4
    L9:
        if (numCreationDates <= 0) goto L38;
        header.write(18);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        if (numCreationDates == this.files.size()) goto L17;
        out.write(0);
        BitSet cTimes = new BitSet(this.files.size());
        int i = 0;
    L14:
        if (i >= this.files.size()) goto L16;
        cTimes.set(i, this.files.get(i).getHasCreationDate());
        i = i + 1;
        goto L14
    L16:
        writeBits(out, cTimes, this.files.size());
    L18:
        out.write(0);
        Iterator<SevenZArchiveEntry> r3 = this.files.iterator();
    L20:
        if (r3.hasNext() == false) goto L25;
        SevenZArchiveEntry entry = r3.next();
        if (entry.getHasCreationDate() == false) goto L20;
        out.writeLong(Long.reverseBytes(SevenZArchiveEntry.javaTimeToNtfsTime(entry.getCreationDate())));
        goto L20
    L25:
        out.flush();
        byte[] contents = baos.toByteArray();
        writeUint64(header, contents.length);
        header.write(contents);
        return;
    L17:
        out.write(1);
        goto L18
    }

    private void writeFileATimes(DataOutput header) throws IOException {
        int numAccessDates = 0;
        Iterator<SevenZArchiveEntry> r1 = this.files.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().getHasAccessDate() == false) goto L4;
        numAccessDates = numAccessDates + 1;
        goto L4
    L9:
        if (numAccessDates <= 0) goto L38;
        header.write(19);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        if (numAccessDates == this.files.size()) goto L17;
        out.write(0);
        BitSet aTimes = new BitSet(this.files.size());
        int i = 0;
    L14:
        if (i >= this.files.size()) goto L16;
        aTimes.set(i, this.files.get(i).getHasAccessDate());
        i = i + 1;
        goto L14
    L16:
        writeBits(out, aTimes, this.files.size());
    L18:
        out.write(0);
        Iterator<SevenZArchiveEntry> r3 = this.files.iterator();
    L20:
        if (r3.hasNext() == false) goto L25;
        SevenZArchiveEntry entry = r3.next();
        if (entry.getHasAccessDate() == false) goto L20;
        out.writeLong(Long.reverseBytes(SevenZArchiveEntry.javaTimeToNtfsTime(entry.getAccessDate())));
        goto L20
    L25:
        out.flush();
        byte[] contents = baos.toByteArray();
        writeUint64(header, contents.length);
        header.write(contents);
        return;
    L17:
        out.write(1);
        goto L18
    }

    private void writeFileMTimes(DataOutput header) throws IOException {
        int numLastModifiedDates = 0;
        Iterator<SevenZArchiveEntry> r1 = this.files.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().getHasLastModifiedDate() == false) goto L4;
        numLastModifiedDates = numLastModifiedDates + 1;
        goto L4
    L9:
        if (numLastModifiedDates <= 0) goto L38;
        header.write(20);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        if (numLastModifiedDates == this.files.size()) goto L17;
        out.write(0);
        BitSet mTimes = new BitSet(this.files.size());
        int i = 0;
    L14:
        if (i >= this.files.size()) goto L16;
        mTimes.set(i, this.files.get(i).getHasLastModifiedDate());
        i = i + 1;
        goto L14
    L16:
        writeBits(out, mTimes, this.files.size());
    L18:
        out.write(0);
        Iterator<SevenZArchiveEntry> r3 = this.files.iterator();
    L20:
        if (r3.hasNext() == false) goto L25;
        SevenZArchiveEntry entry = r3.next();
        if (entry.getHasLastModifiedDate() == false) goto L20;
        out.writeLong(Long.reverseBytes(SevenZArchiveEntry.javaTimeToNtfsTime(entry.getLastModifiedDate())));
        goto L20
    L25:
        out.flush();
        byte[] contents = baos.toByteArray();
        writeUint64(header, contents.length);
        header.write(contents);
        return;
    L17:
        out.write(1);
        goto L18
    }

    private void writeFileWindowsAttributes(DataOutput header) throws IOException {
        int numWindowsAttributes = 0;
        Iterator<SevenZArchiveEntry> r1 = this.files.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().getHasWindowsAttributes() == false) goto L4;
        numWindowsAttributes = numWindowsAttributes + 1;
        goto L4
    L9:
        if (numWindowsAttributes <= 0) goto L38;
        header.write(21);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        if (numWindowsAttributes == this.files.size()) goto L17;
        out.write(0);
        BitSet attributes = new BitSet(this.files.size());
        int i = 0;
    L14:
        if (i >= this.files.size()) goto L16;
        attributes.set(i, this.files.get(i).getHasWindowsAttributes());
        i = i + 1;
        goto L14
    L16:
        writeBits(out, attributes, this.files.size());
    L18:
        out.write(0);
        Iterator<SevenZArchiveEntry> r3 = this.files.iterator();
    L20:
        if (r3.hasNext() == false) goto L25;
        SevenZArchiveEntry entry = r3.next();
        if (entry.getHasWindowsAttributes() == false) goto L20;
        out.writeInt(Integer.reverseBytes(entry.getWindowsAttributes()));
        goto L20
    L25:
        out.flush();
        byte[] contents = baos.toByteArray();
        writeUint64(header, contents.length);
        header.write(contents);
        return;
    L17:
        out.write(1);
        goto L18
    }

    private void writeUint64(DataOutput header, long value) throws IOException {
        int firstByte = 0;
        int mask = 128;
        int i = 0;
    L4:
        if (i >= 8) goto L9;
        if (value < (1 << ((i + 1) * 7))) goto L7;
        firstByte = firstByte | mask;
        mask = mask >>> 1;
        i = i + 1;
        goto L4
    L7:
        firstByte = (int) (((long) firstByte) | (value >>> (i * 8)));
    L9:
        header.write(firstByte);
    L10:
        if (i <= 0) goto L12;
        header.write((int) (255 & value));
        value = value >>> 8;
        i = i - 1;
        goto L10
    }

    private void writeBits(DataOutput r5, BitSet r6, int r7) throws IOException {
        int r0 = 0;
        int r1 = 7;
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L9;
        r0 = r0 | ((r6.get(r2) ? 1 : 0) << r1);
        r1 = r1 - 1;
        if (r1 >= 0) goto L7;
        r5.write(r0);
        r1 = 7;
        r0 = 0;
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        if (r1 == 7) goto L15;
        r5.write(r0);
        return;
    }

    private static <T> Iterable<T> reverse(Iterable<T> i) {
        LinkedList<T> l = new LinkedList();
        Iterator<T> r1 = i.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        T t = r1.next();
        l.addFirst(t);
        goto L4
    L6:
        return l;
    }
}
