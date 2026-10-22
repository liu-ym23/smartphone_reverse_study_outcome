package org.apache.commons.compress.archivers.zip;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public class ZipFile implements Closeable {
    static final int BYTE_SHIFT = 8;
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final int CFH_LEN = 42;
    private static final long CFH_SIG = 0;
    private static final int HASH_SIZE = 509;
    private static final long LFH_OFFSET_FOR_FILENAME_LENGTH = 26;
    private static final int MAX_EOCD_SIZE = 65557;
    static final int MIN_EOCD_SIZE = 22;
    static final int NIBLET_MASK = 15;
    private static final byte[] ONE_ZERO_BYTE = null;
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int ZIP64_EOCDL_LENGTH = 20;
    private static final int ZIP64_EOCDL_LOCATOR_OFFSET = 8;
    private static final int ZIP64_EOCD_CFD_LOCATOR_OFFSET = 48;
    private final SeekableByteChannel archive;
    private final String archiveName;
    private final ByteBuffer cfhBbuf;
    private final byte[] cfhBuf;
    private volatile boolean closed;
    private final ByteBuffer dwordBbuf;
    private final byte[] dwordBuf;
    private final String encoding;
    private final List<ZipArchiveEntry> entries;
    private final Map<String, LinkedList<ZipArchiveEntry>> nameMap;
    private final Comparator<ZipArchiveEntry> offsetComparator;
    private final byte[] shortBuf;
    private final boolean useUnicodeExtraFields;
    private final ByteBuffer wordBbuf;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipFile$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = null;

        static {
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = new int[ZipMethod.values().length];
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.STORED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L95:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.UNSHRINKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L65:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.IMPLODING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L83:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.DEFLATED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L69:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.BZIP2.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L75:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.ENHANCED_DEFLATED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L97:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.AES_ENCRYPTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L79:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_1.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L87:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_2.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L61:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_3.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L89:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_4.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L67:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.JPEG.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L77:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.LZMA.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L91:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.PKWARE_IMPLODING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L44
        L81:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.PPMD.ordinal()] = 15;     // Catch: NoSuchFieldError -> L47
        L93:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.TOKENIZATION.ordinal()] = 16;     // Catch: NoSuchFieldError -> L50
        L63:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.UNKNOWN.ordinal()] = 17;     // Catch: NoSuchFieldError -> L53
        L85:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.WAVPACK.ordinal()] = 18;     // Catch: NoSuchFieldError -> L56
        L71:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.XZ.ordinal()] = 19;     // Catch: NoSuchFieldError -> L59
            return;
        }
    }

    private class BoundedFileChannelInputStream extends BoundedInputStream {
        private final FileChannel archive;
        final /* synthetic */ ZipFile this$0;

        BoundedFileChannelInputStream(ZipFile r3, long start, long remaining) {
            this.this$0 = r3;
            super(r3, start, remaining);
            this.archive = (FileChannel) ZipFile.access$300(r3);
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipFile.BoundedInputStream
        protected int read(long pos, ByteBuffer buf) throws IOException {
            int read = this.archive.read(buf, pos);
            buf.flip();
            return read;
        }
    }

    private class BoundedInputStream extends InputStream {
        private final long end;
        private long loc;
        private ByteBuffer singleByteBuffer;
        final /* synthetic */ ZipFile this$0;

        BoundedInputStream(ZipFile r3, long start, long remaining) {
            this.this$0 = r3;
            this.end = start + remaining;
            if (this.end < start) goto L7;
            this.loc = start;
            return;
        L7:
            throw new IllegalArgumentException("Invalid length of stream at offset=" + start + ", length=" + remaining);
        }

        @Override // java.io.InputStream
        public synchronized int read() throws IOException {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.loc < this.end) goto L10;
            monitor-exit(this);
            return -1;
        L10:
            if (this.singleByteBuffer != null) goto L14;
            this.singleByteBuffer = ByteBuffer.allocate(1);     // Catch: Throwable -> L12
        L15:
            int read = read(this.loc, this.singleByteBuffer);     // Catch: Throwable -> L12
            if (read >= 0) goto L19;
            monitor-exit(this);
            return read;
        L19:
            this.loc++;     // Catch: Throwable -> L12
            int r1 = this.singleByteBuffer.get() & CecDeviceType.INACTIVE;
            monitor-exit(this);
            return r1;
        L14:
            this.singleByteBuffer.rewind();     // Catch: Throwable -> L12
            goto L15
        }

        @Override // java.io.InputStream
        public synchronized int read(byte[] b, int off, int len) throws IOException {
            monitor-enter(this);
            if (len > 0) goto L28;
            monitor-exit(this);
            return 0;
        L28:
        L17:
            th = move-exception;
            throw th;
        L9:
            if (len > (this.end - this.loc)) goto L12;
        L19:
            ByteBuffer buf = ByteBuffer.wrap(b, off, len);     // Catch: Throwable -> L17
            int ret = read(this.loc, buf);     // Catch: Throwable -> L17
            if (ret <= 0) goto L24;
            this.loc += (long) ret;     // Catch: Throwable -> L17
            monitor-exit(this);
            return ret;
        L24:
            monitor-exit(this);
            return ret;
        L12:
            if (this.loc < this.end) goto L16;
            monitor-exit(this);
            return -1;
        L16:
            len = (int) (this.end - this.loc);     // Catch: Throwable -> L17
            goto L19
        }

        protected int read(long pos, ByteBuffer buf) throws IOException {
            SeekableByteChannel r0 = ZipFile.access$300(this.this$0);
            monitor-enter(r0);
            ZipFile.access$300(this.this$0).position(pos);     // Catch: Throwable -> L8
            int read = ZipFile.access$300(this.this$0).read(buf);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            buf.flip();
            return read;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private static class Entry extends ZipArchiveEntry {
        Entry() {
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry, java.util.zip.ZipEntry
        public int hashCode() {
            return ((super.hashCode() * 3) + ((int) getLocalHeaderOffset())) + ((int) (getLocalHeaderOffset() >> 32));
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry
        public boolean equals(Object other) {
            if (super.equals(other) == false) goto L11;
            Entry otherEntry = (Entry) other;
            if (getLocalHeaderOffset() == otherEntry.getLocalHeaderOffset()) goto L7;
            return false;
        L7:
            if (getDataOffset() != otherEntry.getDataOffset()) goto L13;
            return true;
        L13:
            return false;
        L11:
            return false;
        }
    }

    private static final class NameAndComment {
        private final byte[] comment;
        private final byte[] name;

        /* synthetic */ NameAndComment(byte[] x0, byte[] x1, AnonymousClass1 x2) {
            this(x0, x1);
        }

        static /* synthetic */ byte[] access$100(NameAndComment x0) {
            return x0.name;
        }

        static /* synthetic */ byte[] access$200(NameAndComment x0) {
            return x0.comment;
        }

        private NameAndComment(byte[] name, byte[] comment) {
            this.name = name;
            this.comment = comment;
        }
    }

    private static class StoredStatisticsStream extends CountingInputStream implements InputStreamStatistics {
        StoredStatisticsStream(InputStream in) {
            super(in);
        }

        @Override // org.apache.commons.compress.utils.InputStreamStatistics
        public long getCompressedCount() {
            return super.getBytesRead();
        }

        @Override // org.apache.commons.compress.utils.InputStreamStatistics
        public long getUncompressedCount() {
            return getCompressedCount();
        }
    }

    static /* synthetic */ SeekableByteChannel access$300(ZipFile x0) {
        return x0.archive;
    }

    static {
        ONE_ZERO_BYTE = new byte[1];
        CFH_SIG = ZipLong.getValue(ZipArchiveOutputStream.CFH_SIG);
    }

    public ZipFile(File f) throws IOException {
        this(f, "UTF8");
    }

    public ZipFile(String name) throws IOException {
        this(new File(name), "UTF8");
    }

    public ZipFile(String name, String encoding) throws IOException {
        this(new File(name), encoding, true);
    }

    public ZipFile(File f, String encoding) throws IOException {
        this(f, encoding, true);
    }

    public ZipFile(File f, String encoding, boolean useUnicodeExtraFields) throws IOException {
        this(Files.newByteChannel(f.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), f.getAbsolutePath(), encoding, useUnicodeExtraFields, true);
    }

    public ZipFile(SeekableByteChannel channel) throws IOException {
        this(channel, "unknown archive", "UTF8", true);
    }

    public ZipFile(SeekableByteChannel channel, String encoding) throws IOException {
        this(channel, "unknown archive", encoding, true);
    }

    public ZipFile(SeekableByteChannel channel, String archiveName, String encoding, boolean useUnicodeExtraFields) throws IOException {
        this(channel, archiveName, encoding, useUnicodeExtraFields, false);
    }

    private ZipFile(SeekableByteChannel channel, String archiveName, String encoding, boolean useUnicodeExtraFields, boolean closeOnError) throws IOException {
        this.entries = new LinkedList();
        this.nameMap = new HashMap(HASH_SIZE);
        this.closed = true;
        this.dwordBuf = new byte[8];
        this.wordBuf = new byte[4];
        this.cfhBuf = new byte[42];
        this.shortBuf = new byte[2];
        this.dwordBbuf = ByteBuffer.wrap(this.dwordBuf);
        this.wordBbuf = ByteBuffer.wrap(this.wordBuf);
        this.cfhBbuf = ByteBuffer.wrap(this.cfhBuf);
        this.offsetComparator = new AnonymousClass2(this);
        this.archiveName = archiveName;
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
        this.useUnicodeExtraFields = useUnicodeExtraFields;
        this.archive = channel;
        Map<ZipArchiveEntry, NameAndComment> entriesWithoutUTF8Flag = populateFromCentralDirectory();     // Catch: Throwable -> L9
        resolveLocalFileHeaderData(entriesWithoutUTF8Flag);     // Catch: Throwable -> L9
        this.closed = !true;
        if (1 != 0) goto L17;
        if (closeOnError == false) goto L18;
        IOUtils.closeQuietly(this.archive);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        th = move-exception;
        this.closed = !false;
        if (0 != 0) goto L14;
        if (closeOnError == false) goto L14;
        IOUtils.closeQuietly(this.archive);
    L14:
        throw th;
    }

    public String getEncoding() {
        return this.encoding;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.archive.close();
    }

    public static void closeQuietly(ZipFile zipfile) {
        IOUtils.closeQuietly(zipfile);
    }

    public Enumeration<ZipArchiveEntry> getEntries() {
        return Collections.enumeration(this.entries);
    }

    public Enumeration<ZipArchiveEntry> getEntriesInPhysicalOrder() {
        ZipArchiveEntry[] allEntries = (ZipArchiveEntry[]) this.entries.toArray(new ZipArchiveEntry[this.entries.size()]);
        Arrays.sort(allEntries, this.offsetComparator);
        return Collections.enumeration(Arrays.asList(allEntries));
    }

    public ZipArchiveEntry getEntry(String name) {
        LinkedList<ZipArchiveEntry> entriesOfThatName = this.nameMap.get(name);
        if (entriesOfThatName != null) goto L7;
        return null;
    L7:
        return entriesOfThatName.getFirst();
    }

    public Iterable<ZipArchiveEntry> getEntries(String name) {
        List<ZipArchiveEntry> entriesOfThatName = this.nameMap.get(name);
        if (entriesOfThatName == null) goto L6;
        return entriesOfThatName;
    L6:
        return Collections.emptyList();
    }

    public Iterable<ZipArchiveEntry> getEntriesInPhysicalOrder(String name) {
        ZipArchiveEntry[] entriesOfThatName = new ZipArchiveEntry[0];
        if (this.nameMap.containsKey(name) == false) goto L6;
        entriesOfThatName = (ZipArchiveEntry[]) this.nameMap.get(name).toArray(entriesOfThatName);
        Arrays.sort(entriesOfThatName, this.offsetComparator);
    L6:
        return Arrays.asList(entriesOfThatName);
    }

    public boolean canReadEntryData(ZipArchiveEntry ze) {
        return ZipUtil.canHandleEntryData(ze);
    }

    public InputStream getRawInputStream(ZipArchiveEntry ze) {
        if ((ze instanceof Entry) == true) goto L6;
        return null;
    L6:
        long start = ze.getDataOffset();
        return createBoundedInputStream(start, ze.getCompressedSize());
    }

    public void copyRawEntries(ZipArchiveOutputStream target, ZipArchiveEntryPredicate predicate) throws IOException {
        Enumeration<ZipArchiveEntry> src = getEntriesInPhysicalOrder();
    L4:
        if (src.hasMoreElements() == false) goto L9;
        ZipArchiveEntry entry = src.nextElement();
        if (predicate.test(entry) == false) goto L4;
        target.addRawArchiveEntry(entry, getRawInputStream(entry));
        goto L4
    }

    public InputStream getInputStream(ZipArchiveEntry ze) throws IOException {
        if ((ze instanceof Entry) == true) goto L6;
        return null;
    L6:
        ZipUtil.checkRequestedFeatures(ze);
        long start = ze.getDataOffset();
        InputStream is = new BufferedInputStream(createBoundedInputStream(start, ze.getCompressedSize()));
        switch(AnonymousClass3.$SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.getMethodByCode(ze.getMethod()).ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L11;
            default: goto L9;
        };
    L14:
        final Inflater inflater = new Inflater(true);
        final SequenceInputStream r5 = new SequenceInputStream(is, new ByteArrayInputStream(ONE_ZERO_BYTE));
        return new AnonymousClass1(this, r5, inflater, inflater);
    L9:
        throw new ZipException("Found unsupported compression method " + ze.getMethod());
    L11:
        return new Deflate64CompressorInputStream(is);
    L13:
        return new BZip2CompressorInputStream(is);
    L17:
        return new ExplodingInputStream(ze.getGeneralPurposeBit().getSlidingDictionarySize(), ze.getGeneralPurposeBit().getNumberOfShannonFanoTrees(), is);
    L19:
        return new UnshrinkingInputStream(is);
    L21:
        return new StoredStatisticsStream(is);
    }

    public String getUnixSymlink(ZipArchiveEntry entry) throws IOException {
        if (entry != null) goto L4;
        return null;
    L4:
        if (entry.isUnixSymlink() == false) goto L23;
        InputStream in = getInputStream(entry);
        String r1 = this.zipEncoding.decode(IOUtils.toByteArray(in));     // Catch: Throwable -> L10
        if (in == null) goto L9;
        in.close();
    L9:
        return r1;
    L10:
        th = move-exception;
        if (in != null) goto L19;
    L16:
        throw th;
    L19:
        in.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    L23:
        return null;
    }

    protected void finalize() throws Throwable {
    L6:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.closed == true) goto L8;
        System.err.println("Cleaning up unclosed ZipFile for archive " + this.archiveName);     // Catch: Throwable -> L6
        close();     // Catch: Throwable -> L6
    L8:
        super.finalize();
    }

    private Map<ZipArchiveEntry, NameAndComment> populateFromCentralDirectory() throws IOException {
        HashMap<ZipArchiveEntry, NameAndComment> noUTF8Flag = new HashMap();
        positionAtCentralDirectory();
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        long sig = ZipLong.getValue(this.wordBuf);
        if (sig == CFH_SIG) goto L10;
        if (startsWithLocalFileHeader() == false) goto L10;
        throw new IOException("central directory is empty, can't expand corrupt archive.");
    L10:
        if (sig != CFH_SIG) goto L12;
        readCentralDirectoryEntry(noUTF8Flag);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        sig = ZipLong.getValue(this.wordBuf);
        goto L10
    L12:
        return noUTF8Flag;
    }

    private void readCentralDirectoryEntry(Map<ZipArchiveEntry, NameAndComment> noUTF8Flag) throws IOException {
        this.cfhBbuf.rewind();
        IOUtils.readFully(this.archive, this.cfhBbuf);
        Entry ze = new Entry();
        int versionMadeBy = ZipShort.getValue(this.cfhBuf, 0);
        int off = 0 + 2;
        ze.setVersionMadeBy(versionMadeBy);
        ze.setPlatform((versionMadeBy >> 8) & 15);
        ze.setVersionRequired(ZipShort.getValue(this.cfhBuf, off));
        int off2 = off + 2;
        GeneralPurposeBit gpFlag = GeneralPurposeBit.parse(this.cfhBuf, off2);
        boolean hasUTF8Flag = gpFlag.usesUTF8ForNames();
        if (hasUTF8Flag == false) goto L5;
        ZipEncoding entryEncoding = ZipEncodingHelper.UTF8_ZIP_ENCODING;
    L6:
        if (hasUTF8Flag == false) goto L8;
        ze.setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
    L8:
        ze.setGeneralPurposeBit(gpFlag);
        ze.setRawFlag(ZipShort.getValue(this.cfhBuf, off2));
        int off3 = off2 + 2;
        ze.setMethod(ZipShort.getValue(this.cfhBuf, off3));
        int off4 = off3 + 2;
        long time = ZipUtil.dosToJavaTime(ZipLong.getValue(this.cfhBuf, off4));
        ze.setTime(time);
        int off5 = off4 + 4;
        ze.setCrc(ZipLong.getValue(this.cfhBuf, off5));
        int off6 = off5 + 4;
        ze.setCompressedSize(ZipLong.getValue(this.cfhBuf, off6));
        int off7 = off6 + 4;
        ze.setSize(ZipLong.getValue(this.cfhBuf, off7));
        int off8 = off7 + 4;
        int fileNameLen = ZipShort.getValue(this.cfhBuf, off8);
        int off9 = off8 + 2;
        int extraLen = ZipShort.getValue(this.cfhBuf, off9);
        int off10 = off9 + 2;
        int commentLen = ZipShort.getValue(this.cfhBuf, off10);
        int off11 = off10 + 2;
        int diskStart = ZipShort.getValue(this.cfhBuf, off11);
        int off12 = off11 + 2;
        ze.setInternalAttributes(ZipShort.getValue(this.cfhBuf, off12));
        int off13 = off12 + 2;
        ze.setExternalAttributes(ZipLong.getValue(this.cfhBuf, off13));
        byte[] fileName = new byte[fileNameLen];
        IOUtils.readFully(this.archive, ByteBuffer.wrap(fileName));
        ze.setName(entryEncoding.decode(fileName), fileName);
        byte[] r14 = this.cfhBuf;
        ze.setLocalHeaderOffset(ZipLong.getValue(r14, off13 + 4));
        this.entries.add(ze);
        byte[] cdExtraData = new byte[extraLen];
        IOUtils.readFully(this.archive, ByteBuffer.wrap(cdExtraData));
        ze.setCentralDirectoryExtra(cdExtraData);
        setSizesAndOffsetFromZip64Extra(ze, diskStart);
        byte[] comment = new byte[commentLen];
        IOUtils.readFully(this.archive, ByteBuffer.wrap(comment));
        ze.setComment(entryEncoding.decode(comment));
        if (hasUTF8Flag == true) goto L14;
        if (this.useUnicodeExtraFields == false) goto L14;
        noUTF8Flag.put(ze, new NameAndComment(fileName, comment, null));
        return;
    L14:
        return;
    L5:
        entryEncoding = this.zipEncoding;
        goto L6
    }

    private void setSizesAndOffsetFromZip64Extra(ZipArchiveEntry ze, int diskStart) throws IOException {
        Zip64ExtendedInformationExtraField z64 = (Zip64ExtendedInformationExtraField) ze.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (z64 == null) goto L31;
        boolean r2 = false;
        if (ze.getSize() != 4294967295L) goto L7;
        boolean hasUncompressedSize = true;
    L9:
        if (ze.getCompressedSize() != 4294967295L) goto L11;
        boolean hasCompressedSize = true;
    L13:
        if (ze.getLocalHeaderOffset() != 4294967295L) goto L15;
        boolean hasRelativeHeaderOffset = true;
    L17:
        if (diskStart != 65535) goto L19;
        r2 = true;
    L19:
        z64.reparseCentralDirectoryData(hasUncompressedSize, hasCompressedSize, hasRelativeHeaderOffset, r2);
        if (hasUncompressedSize == false) goto L22;
        ze.setSize(z64.getSize().getLongValue());
    L24:
        if (hasCompressedSize == false) goto L26;
        ze.setCompressedSize(z64.getCompressedSize().getLongValue());
    L28:
        if (hasRelativeHeaderOffset == false) goto L32;
        ze.setLocalHeaderOffset(z64.getRelativeHeaderOffset().getLongValue());
        return;
    L32:
        return;
    L26:
        if (hasUncompressedSize == false) goto L28;
        z64.setCompressedSize(new ZipEightByteInteger(ze.getCompressedSize()));
        goto L28
    L22:
        if (hasCompressedSize == false) goto L24;
        z64.setSize(new ZipEightByteInteger(ze.getSize()));
        goto L24
    L15:
        hasRelativeHeaderOffset = false;
        goto L17
    L11:
        hasCompressedSize = false;
        goto L13
    L7:
        hasUncompressedSize = false;
        goto L9
    }

    private void positionAtCentralDirectory() throws IOException {
        positionAtEndOfCentralDirectoryRecord();
        boolean found = false;
        if (this.archive.position() <= 20) goto L5;
        boolean searchedForZip64EOCD = true;
    L6:
        if (searchedForZip64EOCD == false) goto L8;
        this.archive.position(this.archive.position() - 20);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        found = Arrays.equals(ZipArchiveOutputStream.ZIP64_EOCD_LOC_SIG, this.wordBuf);
    L8:
        if (found == true) goto L12;
        if (searchedForZip64EOCD == false) goto L11;
        skipBytes(16);
    L11:
        positionAtCentralDirectory32();
        return;
    L12:
        positionAtCentralDirectory64();
        return;
    L5:
        searchedForZip64EOCD = false;
        goto L6
    }

    private void positionAtCentralDirectory64() throws IOException {
        skipBytes(4);
        this.dwordBbuf.rewind();
        IOUtils.readFully(this.archive, this.dwordBbuf);
        this.archive.position(ZipEightByteInteger.getLongValue(this.dwordBuf));
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        if (Arrays.equals(this.wordBuf, ZipArchiveOutputStream.ZIP64_EOCD_SIG) == false) goto L7;
        skipBytes(44);
        this.dwordBbuf.rewind();
        IOUtils.readFully(this.archive, this.dwordBbuf);
        this.archive.position(ZipEightByteInteger.getLongValue(this.dwordBuf));
        return;
    L7:
        throw new ZipException("archive's ZIP64 end of central directory locator is corrupt.");
    }

    private void positionAtCentralDirectory32() throws IOException {
        skipBytes(16);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        this.archive.position(ZipLong.getValue(this.wordBuf));
    }

    private void positionAtEndOfCentralDirectoryRecord() throws IOException {
        boolean found = tryToLocateSignature(22, 65557, ZipArchiveOutputStream.EOCD_SIG);
        if (found == false) goto L6;
        return;
    L6:
        throw new ZipException("archive is not a ZIP archive");
    }

    private boolean tryToLocateSignature(long minDistanceFromEnd, long maxDistanceFromEnd, byte[] sig) throws IOException {
        boolean found = false;
        long off = this.archive.size() - minDistanceFromEnd;
        long stopSearching = Math.max(0, this.archive.size() - maxDistanceFromEnd);
        if (off >= 0) goto L5;
    L19:
        if (found == false) goto L21;
        this.archive.position(off);
    L21:
        return found;
    L5:
        if (off < stopSearching) goto L19;
        this.archive.position(off);
        this.wordBbuf.rewind();     // Catch: EOFException -> L18
        IOUtils.readFully(this.archive, this.wordBbuf);     // Catch: EOFException -> L18
        this.wordBbuf.flip();     // Catch: EOFException -> L18
        int curr = this.wordBbuf.get();
        if (curr != sig[0]) goto L17;
        int curr2 = this.wordBbuf.get();
        if (curr2 != sig[1]) goto L17;
        int curr3 = this.wordBbuf.get();
        if (curr3 != sig[2]) goto L17;
        int curr4 = this.wordBbuf.get();
        if (curr4 != sig[3]) goto L17;
        found = true;
    L17:
        off = off - 1;
        goto L5
    }

    private void skipBytes(int count) throws IOException {
        long currentPosition = this.archive.position();
        long newPosition = ((long) count) + currentPosition;
        if (newPosition > this.archive.size()) goto L7;
        this.archive.position(newPosition);
        return;
    L7:
        throw new EOFException();
    }

    private void resolveLocalFileHeaderData(Map<ZipArchiveEntry, NameAndComment> entriesWithoutUTF8Flag) throws IOException {
        Iterator<ZipArchiveEntry> r0 = this.entries.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        ZipArchiveEntry zipArchiveEntry = r0.next();
        Entry ze = (Entry) zipArchiveEntry;
        long offset = ze.getLocalHeaderOffset();
        this.archive.position(offset + LFH_OFFSET_FOR_FILENAME_LENGTH);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        this.wordBbuf.flip();
        this.wordBbuf.get(this.shortBuf);
        int fileNameLen = ZipShort.getValue(this.shortBuf);
        this.wordBbuf.get(this.shortBuf);
        int extraFieldLen = ZipShort.getValue(this.shortBuf);
        skipBytes(fileNameLen);
        byte[] localExtraData = new byte[extraFieldLen];
        IOUtils.readFully(this.archive, ByteBuffer.wrap(localExtraData));
        ze.setExtra(localExtraData);
        ze.setDataOffset(((((LFH_OFFSET_FOR_FILENAME_LENGTH + offset) + 2) + 2) + ((long) fileNameLen)) + ((long) extraFieldLen));
        ze.setStreamContiguous(true);
        if (entriesWithoutUTF8Flag.containsKey(ze) == false) goto L8;
        NameAndComment nc = entriesWithoutUTF8Flag.get(ze);
        ZipUtil.setNameAndCommentFromExtraFields(ze, NameAndComment.access$100(nc), NameAndComment.access$200(nc));
    L8:
        String name = ze.getName();
        LinkedList<ZipArchiveEntry> entriesOfThatName = this.nameMap.get(name);
        if (entriesOfThatName != null) goto L11;
        entriesOfThatName = new LinkedList();
        this.nameMap.put(name, entriesOfThatName);
    L11:
        entriesOfThatName.addLast(ze);
        goto L4
    }

    private boolean startsWithLocalFileHeader() throws IOException {
        this.archive.position(0);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        return Arrays.equals(this.wordBuf, ZipArchiveOutputStream.LFH_SIG);
    }

    private BoundedInputStream createBoundedInputStream(long start, long remaining) {
        if ((this.archive instanceof FileChannel) == false) goto L6;
        return new BoundedFileChannelInputStream(this, start, remaining);
    L6:
        return new BoundedInputStream(this, start, remaining);
    }
}
