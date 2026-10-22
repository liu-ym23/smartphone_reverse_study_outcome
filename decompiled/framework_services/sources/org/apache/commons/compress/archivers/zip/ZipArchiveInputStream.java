package org.apache.commons.compress.archivers.zip;

import android.hardware.tv.mediaquality.ParameterName;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public class ZipArchiveInputStream extends ArchiveInputStream implements InputStreamStatistics {
    private static final byte[] APK_SIGNING_BLOCK_MAGIC = null;
    private static final byte[] CFH = null;
    private static final int CFH_LEN = 46;
    private static final byte[] DD = null;
    private static final byte[] LFH = null;
    private static final int LFH_LEN = 30;
    private static final BigInteger LONG_MAX = null;
    private static final long TWO_EXP_32 = 4294967296L;
    private boolean allowStoredEntriesWithDataDescriptor;
    private final ByteBuffer buf;
    private boolean closed;
    private CurrentEntry current;
    final String encoding;
    private int entriesRead;
    private boolean hitCentralDirectory;
    private final InputStream in;
    private final Inflater inf;
    private ByteArrayInputStream lastStoredEntry;
    private final byte[] lfhBuf;
    private final byte[] shortBuf;
    private final byte[] skipBuf;
    private final byte[] twoDwordBuf;
    private long uncompressedCount;
    private final boolean useUnicodeExtraFields;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipArchiveInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = null;

        static {
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = new int[ZipMethod.values().length];
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.UNSHRINKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L22:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.IMPLODING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L18:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.BZIP2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L16:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.ENHANCED_DEFLATED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            return;
        }
    }

    private class BoundedInputStream extends InputStream {
        private final InputStream in;
        private final long max;
        private long pos;
        final /* synthetic */ ZipArchiveInputStream this$0;

        public BoundedInputStream(ZipArchiveInputStream r3, InputStream in, long size) {
            this.this$0 = r3;
            this.pos = 0;
            this.max = size;
            this.in = in;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.max >= 0) goto L5;
        L8:
            int result = this.in.read();
            this.pos++;
            ZipArchiveInputStream.access$800(this.this$0, 1);
            CurrentEntry.access$708(ZipArchiveInputStream.access$900(this.this$0));
            return result;
        L5:
            if (this.pos < this.max) goto L8;
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] b) throws IOException {
            return read(b, 0, b.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] b, int off, int len) throws IOException {
            if (this.max >= 0) goto L5;
        L7:
            long maxRead = len;
            if (this.max < 0) goto L10;
            maxRead = Math.min(maxRead, this.max - this.pos);
        L10:
            int bytesRead = this.in.read(b, off, (int) maxRead);
            if (bytesRead != (-1)) goto L13;
            return -1;
        L13:
            this.pos += (long) bytesRead;
            ZipArchiveInputStream.access$1000(this.this$0, bytesRead);
            CurrentEntry.access$714(ZipArchiveInputStream.access$900(this.this$0), bytesRead);
            return bytesRead;
        L5:
            if (this.pos < this.max) goto L7;
            return -1;
        }

        @Override // java.io.InputStream
        public long skip(long n) throws IOException {
            if (this.max < 0) goto L5;
            long toSkip = Math.min(n, this.max - this.pos);
        L6:
            long skippedBytes = IOUtils.skip(this.in, toSkip);
            this.pos += skippedBytes;
            return skippedBytes;
        L5:
            toSkip = n;
            goto L6
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (this.max < 0) goto L9;
            if (this.pos < this.max) goto L9;
            return 0;
        L9:
            return this.in.available();
        }
    }

    private static final class CurrentEntry {
        private long bytesRead;
        private long bytesReadFromStream;
        private final CRC32 crc;
        private final ZipArchiveEntry entry;
        private boolean hasDataDescriptor;
        private InputStream in;
        private boolean usesZip64;

        private CurrentEntry() {
            this.entry = new ZipArchiveEntry();
            this.crc = new CRC32();
        }

        /* synthetic */ CurrentEntry(AnonymousClass1 x0) {
            this();
        }

        static /* synthetic */ ZipArchiveEntry access$100(CurrentEntry x0) {
            return x0.entry;
        }

        static /* synthetic */ boolean access$200(CurrentEntry x0) {
            return x0.hasDataDescriptor;
        }

        static /* synthetic */ boolean access$202(CurrentEntry x0, boolean x1) {
            x0.hasDataDescriptor = x1;
            return x1;
        }

        static /* synthetic */ InputStream access$300(CurrentEntry x0) {
            return x0.in;
        }

        static /* synthetic */ InputStream access$302(CurrentEntry x0, InputStream x1) {
            x0.in = x1;
            return x1;
        }

        static /* synthetic */ boolean access$400(CurrentEntry x0) {
            return x0.usesZip64;
        }

        static /* synthetic */ boolean access$402(CurrentEntry x0, boolean x1) {
            x0.usesZip64 = x1;
            return x1;
        }

        static /* synthetic */ CRC32 access$500(CurrentEntry x0) {
            return x0.crc;
        }

        static /* synthetic */ long access$600(CurrentEntry x0) {
            return x0.bytesRead;
        }

        static /* synthetic */ long access$614(CurrentEntry x0, long x1) {
            long r0 = x0.bytesRead + x1;
            x0.bytesRead = r0;
            return r0;
        }

        static /* synthetic */ long access$700(CurrentEntry x0) {
            return x0.bytesReadFromStream;
        }

        static /* synthetic */ long access$708(CurrentEntry x0) {
            long r0 = x0.bytesReadFromStream;
            x0.bytesReadFromStream = 1 + r0;
            return r0;
        }

        static /* synthetic */ long access$714(CurrentEntry x0, long x1) {
            long r0 = x0.bytesReadFromStream + x1;
            x0.bytesReadFromStream = r0;
            return r0;
        }

        static /* synthetic */ long access$722(CurrentEntry x0, long x1) {
            long r0 = x0.bytesReadFromStream - x1;
            x0.bytesReadFromStream = r0;
            return r0;
        }
    }

    static /* synthetic */ void access$1000(ZipArchiveInputStream x0, int x1) {
        x0.count(x1);
    }

    static /* synthetic */ void access$800(ZipArchiveInputStream x0, int x1) {
        x0.count(x1);
    }

    static /* synthetic */ CurrentEntry access$900(ZipArchiveInputStream x0) {
        return x0.current;
    }

    public ZipArchiveInputStream(InputStream inputStream) {
        this(inputStream, "UTF8");
    }

    public ZipArchiveInputStream(InputStream inputStream, String encoding) {
        this(inputStream, encoding, true);
    }

    public ZipArchiveInputStream(InputStream inputStream, String encoding, boolean useUnicodeExtraFields) {
        this(inputStream, encoding, useUnicodeExtraFields, false);
    }

    public ZipArchiveInputStream(InputStream inputStream, String encoding, boolean useUnicodeExtraFields, boolean allowStoredEntriesWithDataDescriptor) {
        this.inf = new Inflater(true);
        this.buf = ByteBuffer.allocate(512);
        this.current = null;
        this.closed = false;
        this.hitCentralDirectory = false;
        this.lastStoredEntry = null;
        this.allowStoredEntriesWithDataDescriptor = false;
        this.uncompressedCount = 0;
        this.lfhBuf = new byte[30];
        this.skipBuf = new byte[1024];
        this.shortBuf = new byte[2];
        this.wordBuf = new byte[4];
        this.twoDwordBuf = new byte[16];
        this.entriesRead = 0;
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
        this.useUnicodeExtraFields = useUnicodeExtraFields;
        this.in = new PushbackInputStream(inputStream, this.buf.capacity());
        this.allowStoredEntriesWithDataDescriptor = allowStoredEntriesWithDataDescriptor;
        this.buf.limit(0);
    }

    public ZipArchiveEntry getNextZipEntry() throws IOException {
        this.uncompressedCount = 0;
        AnonymousClass1 r3 = null;
        if (this.closed == true) goto L75;
        if (this.hitCentralDirectory == false) goto L8;
        return null;
    L8:
        if (this.current == null) goto L10;
        closeEntry();
        boolean firstEntry = false;
    L11:
        long currentHeaderOffset = getBytesRead();
        if (firstEntry == true) goto L78;
        readFully(this.lfhBuf);     // Catch: EOFException -> L70
    L18:
        ZipLong sig = new ZipLong(this.lfhBuf);
        if (sig.equals(ZipLong.LFH_SIG) == false) goto L21;
        this.current = new CurrentEntry(r3);
        int versionMadeBy = ZipShort.getValue(this.lfhBuf, 4);
        int off = 4 + 2;
        CurrentEntry.access$100(this.current).setPlatform((versionMadeBy >> 8) & 15);
        GeneralPurposeBit gpFlag = GeneralPurposeBit.parse(this.lfhBuf, off);
        boolean hasUTF8Flag = gpFlag.usesUTF8ForNames();
        if (hasUTF8Flag == false) goto L34;
        ZipEncoding entryEncoding = ZipEncodingHelper.UTF8_ZIP_ENCODING;
    L35:
        CurrentEntry.access$202(this.current, gpFlag.usesDataDescriptor());
        CurrentEntry.access$100(this.current).setGeneralPurposeBit(gpFlag);
        int off2 = off + 2;
        CurrentEntry.access$100(this.current).setMethod(ZipShort.getValue(this.lfhBuf, off2));
        int off3 = off2 + 2;
        long time = ZipUtil.dosToJavaTime(ZipLong.getValue(this.lfhBuf, off3));
        CurrentEntry.access$100(this.current).setTime(time);
        int off4 = off3 + 4;
        ZipLong size = null;
        ZipLong cSize = null;
        if (CurrentEntry.access$200(this.current) == true) goto L38;
        CurrentEntry.access$100(this.current).setCrc(ZipLong.getValue(this.lfhBuf, off4));
        int off5 = off4 + 4;
        cSize = new ZipLong(this.lfhBuf, off5);
        int off6 = off5 + 4;
        size = new ZipLong(this.lfhBuf, off6);
        int off7 = off6 + 4;
    L39:
        int fileNameLen = ZipShort.getValue(this.lfhBuf, off7);
        int off8 = off7 + 2;
        int extraLen = ZipShort.getValue(this.lfhBuf, off8);
        int r6 = off8 + 2;
        byte[] fileName = new byte[fileNameLen];
        readFully(fileName);
        CurrentEntry.access$100(this.current).setName(entryEncoding.decode(fileName), fileName);
        if (hasUTF8Flag == false) goto L42;
        CurrentEntry.access$100(this.current).setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
    L42:
        byte[] extraData = new byte[extraLen];
        readFully(extraData);
        CurrentEntry.access$100(this.current).setExtra(extraData);
        if (hasUTF8Flag == true) goto L48;
        if (this.useUnicodeExtraFields == false) goto L48;
        ZipUtil.setNameAndCommentFromExtraFields(CurrentEntry.access$100(this.current), fileName, null);
    L48:
        processZip64Extra(size, cSize);
        CurrentEntry.access$100(this.current).setLocalHeaderOffset(currentHeaderOffset);
        CurrentEntry.access$100(this.current).setDataOffset(getBytesRead());
        CurrentEntry.access$100(this.current).setStreamContiguous(true);
        ZipMethod m = ZipMethod.getMethodByCode(CurrentEntry.access$100(this.current).getMethod());
        if (CurrentEntry.access$100(this.current).getCompressedSize() == (-1)) goto L66;
        if (ZipUtil.canHandleEntryData(CurrentEntry.access$100(this.current)) == false) goto L68;
        if (m == ZipMethod.STORED) goto L68;
        if (m == ZipMethod.DEFLATED) goto L68;
        InputStream bis = new BoundedInputStream(this, this.in, CurrentEntry.access$100(this.current).getCompressedSize());
        switch(AnonymousClass1.$SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[m.ordinal()]) {
            case 1: goto L62;
            case 2: goto L61;
            case 3: goto L60;
            case 4: goto L59;
            default: goto L68;
        };
    L59:
        CurrentEntry.access$302(this.current, new Deflate64CompressorInputStream(bis));
        goto L68
    L60:
        CurrentEntry.access$302(this.current, new BZip2CompressorInputStream(bis));
        goto L68
    L61:
        CurrentEntry.access$302(this.current, new ExplodingInputStream(CurrentEntry.access$100(this.current).getGeneralPurposeBit().getSlidingDictionarySize(), CurrentEntry.access$100(this.current).getGeneralPurposeBit().getNumberOfShannonFanoTrees(), bis));
        goto L68
    L62:
        CurrentEntry.access$302(this.current, new UnshrinkingInputStream(bis));
    L68:
        this.entriesRead++;
        return CurrentEntry.access$100(this.current);
    L66:
        if (m != ZipMethod.ENHANCED_DEFLATED) goto L68;
        CurrentEntry.access$302(this.current, new Deflate64CompressorInputStream(this.in));
        goto L68
    L38:
        off7 = off4 + 12;
        goto L39
    L34:
        entryEncoding = this.zipEncoding;
        goto L35
    L21:
        if (sig.equals(ZipLong.CFH_SIG) == false) goto L23;
    L29:
        this.hitCentralDirectory = true;
        skipRemainderOfArchive();
        return null;
    L23:
        if (sig.equals(ZipLong.AED_SIG) == true) goto L29;
        if (isApkSigningBlock(this.lfhBuf) == true) goto L29;
        throw new ZipException(String.format("Unexpected record signature: 0X%X", new Object[]{Long.valueOf(sig.getValue())}));
    L72:
        return null;
    L78:
        readFirstLocalFileHeader(this.lfhBuf);     // Catch: EOFException -> L15
    L81:
        return null;
    L10:
        firstEntry = true;
        goto L11
    L75:
        return null;
    }

    private void readFirstLocalFileHeader(byte[] lfh) throws IOException {
        readFully(lfh);
        ZipLong sig = new ZipLong(lfh);
        if (sig.equals(ZipLong.DD_SIG) == true) goto L9;
        if (sig.equals(ZipLong.SINGLE_SEGMENT_SPLIT_MARKER) == false) goto L10;
        byte[] missedLfhBytes = new byte[4];
        readFully(missedLfhBytes);
        System.arraycopy(lfh, 4, lfh, 0, 26);
        System.arraycopy(missedLfhBytes, 0, lfh, 26, 4);
        return;
    L10:
        return;
    L9:
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.SPLITTING);
    }

    private void processZip64Extra(ZipLong size, ZipLong cSize) {
        Zip64ExtendedInformationExtraField z64 = (Zip64ExtendedInformationExtraField) CurrentEntry.access$100(this.current).getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        CurrentEntry r1 = this.current;
        if (z64 == null) goto L5;
        boolean r2 = true;
    L6:
        CurrentEntry.access$402(r1, r2);
        if (CurrentEntry.access$200(this.current) == true) goto L16;
        if (z64 != null) goto L10;
    L14:
        CurrentEntry.access$100(this.current).setCompressedSize(cSize.getValue());
        CurrentEntry.access$100(this.current).setSize(size.getValue());
        return;
    L10:
        if (cSize.equals(ZipLong.ZIP64_MAGIC) == false) goto L12;
    L13:
        CurrentEntry.access$100(this.current).setCompressedSize(z64.getCompressedSize().getLongValue());
        CurrentEntry.access$100(this.current).setSize(z64.getSize().getLongValue());
        return;
    L12:
        if (size.equals(ZipLong.ZIP64_MAGIC) == false) goto L14;
    L16:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() throws IOException {
        return getNextZipEntry();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry ae) {
        if ((ae instanceof ZipArchiveEntry) == false) goto L13;
        ZipArchiveEntry ze = (ZipArchiveEntry) ae;
        if (ZipUtil.canHandleEntryData(ze) == true) goto L7;
        return false;
    L7:
        if (supportsDataDescriptorFor(ze) == true) goto L9;
        return false;
    L9:
        if (supportsCompressedSizeFor(ze) == false) goto L16;
        return true;
    L16:
        return false;
    L13:
        return false;
    }

    @Override // java.io.InputStream
    public int read(byte[] buffer, int offset, int length) throws IOException {
        if (this.closed == true) goto L46;
        if (this.current != null) goto L9;
        return -1;
    L9:
        if (offset > buffer.length) goto L44;
        if (length < 0) goto L44;
        if (offset < 0) goto L44;
        if ((buffer.length - offset) < length) goto L44;
        ZipUtil.checkRequestedFeatures(CurrentEntry.access$100(this.current));
        if (supportsDataDescriptorFor(CurrentEntry.access$100(this.current)) == false) goto L42;
        if (supportsCompressedSizeFor(CurrentEntry.access$100(this.current)) == false) goto L40;
        if (CurrentEntry.access$100(this.current).getMethod() != 0) goto L22;
        int read = readStored(buffer, offset, length);
    L36:
        if (read < 0) goto L38;
        CurrentEntry.access$500(this.current).update(buffer, offset, read);
        this.uncompressedCount += (long) read;
    L38:
        return read;
    L22:
        if (CurrentEntry.access$100(this.current).getMethod() != 8) goto L25;
        read = readDeflated(buffer, offset, length);
        goto L36
    L25:
        if (CurrentEntry.access$100(this.current).getMethod() != ZipMethod.UNSHRINKING.getCode()) goto L27;
    L35:
        read = CurrentEntry.access$300(this.current).read(buffer, offset, length);
        goto L36
    L27:
        if (CurrentEntry.access$100(this.current).getMethod() == ZipMethod.IMPLODING.getCode()) goto L35;
        if (CurrentEntry.access$100(this.current).getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) goto L35;
        if (CurrentEntry.access$100(this.current).getMethod() == ZipMethod.BZIP2.getCode()) goto L35;
        throw new UnsupportedZipFeatureException(ZipMethod.getMethodByCode(CurrentEntry.access$100(this.current).getMethod()), CurrentEntry.access$100(this.current));
    L40:
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.UNKNOWN_COMPRESSED_SIZE, CurrentEntry.access$100(this.current));
    L42:
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.DATA_DESCRIPTOR, CurrentEntry.access$100(this.current));
    L44:
        throw new ArrayIndexOutOfBoundsException();
    L46:
        throw new IOException("The stream is closed");
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        if (CurrentEntry.access$100(this.current).getMethod() != 0) goto L7;
        return CurrentEntry.access$600(this.current);
    L7:
        if (CurrentEntry.access$100(this.current).getMethod() != 8) goto L11;
        return getBytesInflated();
    L11:
        if (CurrentEntry.access$100(this.current).getMethod() != ZipMethod.UNSHRINKING.getCode()) goto L15;
        return ((UnshrinkingInputStream) CurrentEntry.access$300(this.current)).getCompressedCount();
    L15:
        if (CurrentEntry.access$100(this.current).getMethod() != ZipMethod.IMPLODING.getCode()) goto L19;
        return ((ExplodingInputStream) CurrentEntry.access$300(this.current)).getCompressedCount();
    L19:
        if (CurrentEntry.access$100(this.current).getMethod() != ZipMethod.ENHANCED_DEFLATED.getCode()) goto L23;
        return ((Deflate64CompressorInputStream) CurrentEntry.access$300(this.current)).getCompressedCount();
    L23:
        if (CurrentEntry.access$100(this.current).getMethod() == ZipMethod.BZIP2.getCode()) goto L25;
        return -1;
    L25:
        return ((BZip2CompressorInputStream) CurrentEntry.access$300(this.current)).getCompressedCount();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    private int readStored(byte[] buffer, int offset, int length) throws IOException {
        if (CurrentEntry.access$200(this.current) == true) goto L5;
        long csize = CurrentEntry.access$100(this.current).getSize();
        if (CurrentEntry.access$600(this.current) < csize) goto L13;
        return -1;
    L13:
        if (this.buf.position() < this.buf.limit()) goto L19;
        this.buf.position(0);
        int l = this.in.read(this.buf.array());
        if (l == (-1)) goto L17;
        this.buf.limit(l);
        count(l);
        CurrentEntry.access$714(this.current, l);
        goto L19
    L17:
        this.buf.limit(0);
        throw new IOException("Truncated ZIP file");
    L19:
        int toRead = Math.min(this.buf.remaining(), length);
        if ((csize - CurrentEntry.access$600(this.current)) >= toRead) goto L22;
        toRead = (int) (csize - CurrentEntry.access$600(this.current));
    L22:
        this.buf.get(buffer, offset, toRead);
        CurrentEntry.access$614(this.current, toRead);
        return toRead;
    L5:
        if (this.lastStoredEntry != null) goto L8;
        readStoredEntry();
    L8:
        return this.lastStoredEntry.read(buffer, offset, length);
    }

    private int readDeflated(byte[] buffer, int offset, int length) throws IOException {
        int read = readFromInflater(buffer, offset, length);
        if (read <= 0) goto L5;
    L15:
        return read;
    L5:
        if (this.inf.finished() == false) goto L8;
        return -1;
    L8:
        if (this.inf.needsDictionary() == true) goto L14;
        if (read != (-1)) goto L15;
        throw new IOException("Truncated ZIP file");
    L14:
        throw new ZipException("This archive needs a preset dictionary which is not supported by Commons Compress.");
    }

    private int readFromInflater(byte[] buffer, int offset, int length) throws IOException {
        int read = 0;
    L4:
        if (this.inf.needsInput() == false) goto L20;
        int l = fill();
        if (l <= 0) goto L9;
        CurrentEntry.access$714(this.current, this.buf.limit());
        goto L20
    L9:
        if (l != (-1)) goto L16;
        return -1;
    L16:
        return read;
    L20:
        read = this.inf.inflate(buffer, offset, length);     // Catch: DataFormatException -> L17
        if (read != 0) goto L16;
        if (this.inf.needsInput() == true) goto L4;
    L17:
        e = move-exception;
        throw ((IOException) new ZipException(e.getMessage()).initCause(e));
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == true) goto L10;
        this.closed = true;
        this.in.close();     // Catch: Throwable -> L7
        this.inf.end();
        return;
    L7:
        th = move-exception;
        this.inf.end();
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long value) throws IOException {
        if (value < 0) goto L17;
        long skipped = 0;
    L6:
        if (skipped >= value) goto L15;
        long rem = value - skipped;
        byte[] r4 = this.skipBuf;
        if (this.skipBuf.length <= rem) goto L10;
        long r5 = rem;
    L11:
        int x = read(r4, 0, (int) r5);
        if (x == (-1)) goto L13;
        skipped = skipped + ((long) x);
        goto L6
    L13:
        return skipped;
    L10:
        r5 = this.skipBuf.length;
        goto L11
    L15:
        return skipped;
    L17:
        throw new IllegalArgumentException();
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= ZipArchiveOutputStream.LFH_SIG.length) goto L6;
        return false;
    L6:
        if (checksig(signature, ZipArchiveOutputStream.LFH_SIG) == false) goto L8;
    L13:
        return true;
    L8:
        if (checksig(signature, ZipArchiveOutputStream.EOCD_SIG) == true) goto L13;
        if (checksig(signature, ZipArchiveOutputStream.DD_SIG) == true) goto L13;
        if (checksig(signature, ZipLong.SINGLE_SEGMENT_SPLIT_MARKER.getBytes()) == true) goto L13;
        return false;
    }

    private static boolean checksig(byte[] signature, byte[] expected) {
        int i = 0;
    L4:
        if (i >= expected.length) goto L10;
        if (signature[i] != expected[i]) goto L7;
        i = i + 1;
        goto L4
    L7:
        return false;
    L10:
        return true;
    }

    private void closeEntry() throws IOException {
        if (this.closed == true) goto L28;
        if (this.current != null) goto L8;
        return;
    L8:
        if (currentEntryHasOutstandingBytes() == false) goto L10;
        drainCurrentEntryData();
    L21:
        if (this.lastStoredEntry == null) goto L23;
    L25:
        this.inf.reset();
        this.buf.clear().flip();
        this.current = null;
        this.lastStoredEntry = null;
        return;
    L23:
        if (CurrentEntry.access$200(this.current) == false) goto L25;
        readDataDescriptor();
        goto L25
    L10:
        skip(Long.MAX_VALUE);
        if (CurrentEntry.access$100(this.current).getMethod() != 8) goto L13;
        long inB = getBytesInflated();
    L14:
        int diff = (int) (CurrentEntry.access$700(this.current) - inB);
        if (diff <= 0) goto L18;
        pushback(this.buf.array(), this.buf.limit() - diff, diff);
        CurrentEntry.access$722(this.current, diff);
    L18:
        if (currentEntryHasOutstandingBytes() == false) goto L21;
        drainCurrentEntryData();
        goto L21
    L13:
        inB = CurrentEntry.access$600(this.current);
        goto L14
    L28:
        throw new IOException("The stream is closed");
    }

    private boolean currentEntryHasOutstandingBytes() {
        if (CurrentEntry.access$700(this.current) <= CurrentEntry.access$100(this.current).getCompressedSize()) goto L5;
    L7:
        return false;
    L5:
        if (CurrentEntry.access$200(this.current) == true) goto L7;
        return true;
    }

    private void drainCurrentEntryData() throws IOException {
        long remaining = CurrentEntry.access$100(this.current).getCompressedSize() - CurrentEntry.access$700(this.current);
    L4:
        if (remaining <= 0) goto L10;
        long n = this.in.read(this.buf.array(), 0, (int) Math.min(this.buf.capacity(), remaining));
        if (n < 0) goto L9;
        count(n);
        remaining = remaining - n;
        goto L4
    L9:
        throw new EOFException("Truncated ZIP entry: " + ArchiveUtils.sanitize(CurrentEntry.access$100(this.current).getName()));
    }

    private long getBytesInflated() {
        long inB = this.inf.getBytesRead();
        if (CurrentEntry.access$700(this.current) >= TWO_EXP_32) goto L5;
    L7:
        return inB;
    L5:
        if ((inB + TWO_EXP_32) > CurrentEntry.access$700(this.current)) goto L7;
        inB = inB + TWO_EXP_32;
        goto L5
    }

    private int fill() throws IOException {
        if (this.closed == true) goto L9;
        int length = this.in.read(this.buf.array());
        if (length <= 0) goto L7;
        this.buf.limit(length);
        count(this.buf.limit());
        this.inf.setInput(this.buf.array(), 0, this.buf.limit());
    L7:
        return length;
    L9:
        throw new IOException("The stream is closed");
    }

    private void readFully(byte[] b) throws IOException {
        readFully(b, 0);
    }

    private void readFully(byte[] b, int off) throws IOException {
        int len = b.length - off;
        int count = IOUtils.readFully(this.in, b, off, len);
        count(count);
        if (count < len) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    private void readDataDescriptor() throws IOException {
        readFully(this.wordBuf);
        ZipLong val = new ZipLong(this.wordBuf);
        if (ZipLong.DD_SIG.equals(val) == false) goto L5;
        readFully(this.wordBuf);
        val = new ZipLong(this.wordBuf);
    L5:
        CurrentEntry.access$100(this.current).setCrc(val.getValue());
        readFully(this.twoDwordBuf);
        ZipLong potentialSig = new ZipLong(this.twoDwordBuf, 8);
        if (potentialSig.equals(ZipLong.CFH_SIG) == false) goto L8;
    L11:
        pushback(this.twoDwordBuf, 8, 8);
        CurrentEntry.access$100(this.current).setCompressedSize(ZipLong.getValue(this.twoDwordBuf));
        CurrentEntry.access$100(this.current).setSize(ZipLong.getValue(this.twoDwordBuf, 4));
        return;
    L8:
        if (potentialSig.equals(ZipLong.LFH_SIG) == true) goto L11;
        CurrentEntry.access$100(this.current).setCompressedSize(ZipEightByteInteger.getLongValue(this.twoDwordBuf));
        CurrentEntry.access$100(this.current).setSize(ZipEightByteInteger.getLongValue(this.twoDwordBuf, 8));
    }

    private boolean supportsDataDescriptorFor(ZipArchiveEntry entry) {
        if (entry.getGeneralPurposeBit().usesDataDescriptor() == true) goto L5;
    L14:
        return true;
    L5:
        if (this.allowStoredEntriesWithDataDescriptor == false) goto L9;
        if (entry.getMethod() == 0) goto L14;
    L9:
        if (entry.getMethod() == 8) goto L14;
        if (entry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) goto L14;
        return false;
    }

    private boolean supportsCompressedSizeFor(ZipArchiveEntry entry) {
        if (entry.getCompressedSize() == (-1)) goto L5;
    L16:
        return true;
    L5:
        if (entry.getMethod() == 8) goto L16;
        if (entry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) goto L16;
        if (entry.getGeneralPurposeBit().usesDataDescriptor() == true) goto L11;
    L15:
        return false;
    L11:
        if (this.allowStoredEntriesWithDataDescriptor == false) goto L15;
        if (entry.getMethod() != 0) goto L15;
        goto L15
    }

    private void readStoredEntry() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int off = 0;
        boolean done = false;
        if (CurrentEntry.access$400(this.current) == false) goto L5;
        int ddLen = 20;
    L6:
        if (done == true) goto L18;
        int r = this.in.read(this.buf.array(), off, 512 - off);
        if (r <= 0) goto L17;
        if ((r + off) < 4) goto L11;
        done = bufferContainsSignature(bos, off, r, ddLen);
        if (done == true) goto L6;
        off = cacheBytesRead(bos, off, r, ddLen);
        goto L6
    L11:
        off = off + r;
        goto L6
    L17:
        throw new IOException("Truncated ZIP file");
    L18:
        byte[] b = bos.toByteArray();
        this.lastStoredEntry = new ByteArrayInputStream(b);
        return;
    L5:
        ddLen = 12;
        goto L6
    }

    static {
        LFH = ZipLong.LFH_SIG.getBytes();
        CFH = ZipLong.CFH_SIG.getBytes();
        DD = ZipLong.DD_SIG.getBytes();
        APK_SIGNING_BLOCK_MAGIC = new byte[]{ParameterName.COLOR_TUNER_SATURATION_RED, ParameterName.BASS, 75, ParameterName.CVRR, 83, 105, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, ParameterName.CVRR, ParameterName.COLOR_TUNER_SATURATION_GREEN, 108, 111, 99, 107, ParameterName.CVRR, 52, 50};
        LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    }

    private boolean bufferContainsSignature(ByteArrayOutputStream bos, int offset, int lastRead, int expectedDDLen) throws IOException {
        boolean done = false;
        int readTooMuch = 0;
        int i = 0;
    L3:
        if (done == true) goto L27;
        if (i >= ((offset + lastRead) - 4)) goto L27;
        if (this.buf.array()[i] != LFH[0]) goto L26;
        if (this.buf.array()[i + 1] != LFH[1]) goto L26;
        if (this.buf.array()[i + 2] != LFH[2]) goto L15;
        if (this.buf.array()[i + 3] != LFH[3]) goto L15;
    L18:
        readTooMuch = ((offset + lastRead) - i) - expectedDDLen;
        done = true;
    L24:
        if (done == false) goto L26;
        pushback(this.buf.array(), (offset + lastRead) - readTooMuch, readTooMuch);
        bos.write(this.buf.array(), 0, i);
        readDataDescriptor();
    L15:
        if (this.buf.array()[i] != CFH[2]) goto L20;
        if (this.buf.array()[i + 3] == CFH[3]) goto L18;
    L20:
        if (this.buf.array()[i + 2] != DD[2]) goto L24;
        if (this.buf.array()[i + 3] != DD[3]) goto L24;
        readTooMuch = (offset + lastRead) - i;
        done = true;
    L26:
        i = i + 1;
    L27:
        return done;
    }

    private int cacheBytesRead(ByteArrayOutputStream bos, int offset, int lastRead, int expecteDDLen) {
        int cacheable = ((offset + lastRead) - expecteDDLen) - 3;
        if (cacheable <= 0) goto L6;
        bos.write(this.buf.array(), 0, cacheable);
        System.arraycopy(this.buf.array(), cacheable, this.buf.array(), 0, expecteDDLen + 3);
        return expecteDDLen + 3;
    L6:
        return offset + lastRead;
    }

    private void pushback(byte[] buf, int offset, int length) throws IOException {
        ((PushbackInputStream) this.in).unread(buf, offset, length);
        pushedBackBytes(length);
    }

    private void skipRemainderOfArchive() throws IOException {
        realSkip((((long) this.entriesRead) * 46) - 30);
        findEocdRecord();
        realSkip(16);
        readFully(this.shortBuf);
        realSkip(ZipShort.getValue(this.shortBuf));
    }

    private void findEocdRecord() throws IOException {
        int currentByte = -1;
        boolean skipReadCall = false;
    L4:
        if (skipReadCall == true) goto L7;
        int r3 = readOneByte();
        currentByte = r3;
        if (r3 > (-1)) goto L7;
        return;
    L7:
        skipReadCall = false;
        if (isFirstByteOfEocdSig(currentByte) == false) goto L4;
        currentByte = readOneByte();
        if (currentByte != ZipArchiveOutputStream.EOCD_SIG[1]) goto L12;
        currentByte = readOneByte();
        if (currentByte != ZipArchiveOutputStream.EOCD_SIG[2]) goto L17;
        currentByte = readOneByte();
        if (currentByte == (-1)) goto L44;
        if (currentByte == ZipArchiveOutputStream.EOCD_SIG[3]) goto L45;
        skipReadCall = isFirstByteOfEocdSig(currentByte);
        goto L4
    L45:
        return;
    L44:
        return;
    L17:
        if (currentByte == (-1)) goto L43;
        skipReadCall = isFirstByteOfEocdSig(currentByte);
        goto L4
    L43:
        return;
    L12:
        if (currentByte == (-1)) goto L42;
        skipReadCall = isFirstByteOfEocdSig(currentByte);
        goto L4
    }

    private void realSkip(long value) throws IOException {
        if (value < 0) goto L17;
        long skipped = 0;
    L6:
        if (skipped >= value) goto L15;
        long rem = value - skipped;
        InputStream r4 = this.in;
        byte[] r5 = this.skipBuf;
        if (this.skipBuf.length <= rem) goto L10;
        long r6 = rem;
    L11:
        int x = r4.read(r5, 0, (int) r6);
        if (x == (-1)) goto L13;
        count(x);
        skipped = skipped + ((long) x);
        goto L6
    L13:
        return;
    L10:
        r6 = this.skipBuf.length;
        goto L11
    L15:
        return;
    L17:
        throw new IllegalArgumentException();
    }

    private int readOneByte() throws IOException {
        int b = this.in.read();
        if (b == (-1)) goto L5;
        count(1);
    L5:
        return b;
    }

    private boolean isFirstByteOfEocdSig(int b) {
        if (b != ZipArchiveOutputStream.EOCD_SIG[0]) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isApkSigningBlock(byte[] suspectLocalFileHeader) throws IOException {
        BigInteger len = ZipEightByteInteger.getValue(suspectLocalFileHeader);
        BigInteger toSkip = len.add(BigInteger.valueOf(((long) (8 - suspectLocalFileHeader.length)) - ((long) APK_SIGNING_BLOCK_MAGIC.length)));
        byte[] magic = new byte[APK_SIGNING_BLOCK_MAGIC.length];
        if (toSkip.signum() >= 0) goto L15;
        int off = suspectLocalFileHeader.length + toSkip.intValue();     // Catch: EOFException -> L11
        if (off >= 8) goto L8;
        return false;
    L8:
        int bytesInBuffer = Math.abs(toSkip.intValue());     // Catch: EOFException -> L11
        System.arraycopy(suspectLocalFileHeader, off, magic, 0, Math.min(bytesInBuffer, magic.length));     // Catch: EOFException -> L11
        if (bytesInBuffer >= magic.length) goto L19;
        readFully(magic, bytesInBuffer);     // Catch: EOFException -> L11
    L19:
        return Arrays.equals(magic, APK_SIGNING_BLOCK_MAGIC);
    L15:
        if (toSkip.compareTo(LONG_MAX) <= 0) goto L17;
        realSkip(Long.MAX_VALUE);     // Catch: EOFException -> L11
        toSkip = toSkip.add(LONG_MAX.negate());     // Catch: EOFException -> L11
        goto L15
    L17:
        realSkip(toSkip.longValue());     // Catch: EOFException -> L11
        readFully(magic);     // Catch: EOFException -> L11
        goto L19
    L21:
        return false;
    }
}
