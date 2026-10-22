package org.apache.commons.compress.compressors.snappy;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.hardware.tv.mediaquality.ParameterName;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public class FramedSnappyCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    static final int COMPRESSED_CHUNK_TYPE = 0;
    static final long MASK_OFFSET = 2726488792L;
    private static final int MAX_SKIPPABLE_TYPE = 253;
    private static final int MAX_UNSKIPPABLE_TYPE = 127;
    private static final int MIN_UNSKIPPABLE_TYPE = 2;
    private static final int PADDING_CHUNK_TYPE = 254;
    private static final int STREAM_IDENTIFIER_TYPE = 255;
    static final byte[] SZ_SIGNATURE = null;
    private static final int UNCOMPRESSED_CHUNK_TYPE = 1;
    private final int blockSize;
    private final PureJavaCrc32C checksum;
    private final CountingInputStream countingStream;
    private SnappyCompressorInputStream currentCompressedChunk;
    private final FramedSnappyDialect dialect;
    private boolean endReached;
    private long expectedChecksum;
    private final PushbackInputStream in;
    private boolean inUncompressedChunk;
    private final byte[] oneByte;
    private final ByteUtils.ByteSupplier supplier;
    private int uncompressedBytesRemaining;
    private long unreadBytes;

    static /* synthetic */ int access$000(FramedSnappyCompressorInputStream x0) throws IOException {
        return x0.readOneByte();
    }

    static {
        SZ_SIGNATURE = new byte[]{-1, 6, 0, 0, 115, ParameterName.COLOR_TUNER_LUMINANCE_FLESH, 97, ParameterName.BASS, 112, ParameterName.DTS_DRC};
    }

    public FramedSnappyCompressorInputStream(InputStream in) throws IOException {
        this(in, FramedSnappyDialect.STANDARD);
    }

    public FramedSnappyCompressorInputStream(InputStream in, FramedSnappyDialect dialect) throws IOException {
        this(in, 32768, dialect);
    }

    public FramedSnappyCompressorInputStream(InputStream in, int blockSize, FramedSnappyDialect dialect) throws IOException {
        this.oneByte = new byte[1];
        this.expectedChecksum = -1;
        this.checksum = new PureJavaCrc32C();
        this.supplier = new AnonymousClass1(this);
        this.countingStream = new CountingInputStream(in);
        this.in = new PushbackInputStream(this.countingStream, 1);
        this.blockSize = blockSize;
        this.dialect = dialect;
        if (dialect.hasStreamIdentifier() == false) goto L6;
        readStreamIdentifier();
        return;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) != (-1)) goto L6;
        return -1;
    L6:
        return this.oneByte[0] & CecDeviceType.INACTIVE;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    L6:
        th = move-exception;
        this.in.close();
        throw th;
    L3:
        if (this.currentCompressedChunk == null) goto L8;
        this.currentCompressedChunk.close();     // Catch: Throwable -> L6
        this.currentCompressedChunk = null;     // Catch: Throwable -> L6
    L8:
        this.in.close();
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int read = readOnce(b, off, len);
        if (read != (-1)) goto L9;
        readNextBlock();
        if (this.endReached == false) goto L8;
        return -1;
    L8:
        return readOnce(b, off, len);
    L9:
        return read;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.inUncompressedChunk == false) goto L7;
        return Math.min(this.uncompressedBytesRemaining, this.in.available());
    L7:
        if (this.currentCompressedChunk != null) goto L9;
        return 0;
    L9:
        return this.currentCompressedChunk.available();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.countingStream.getBytesRead() - this.unreadBytes;
    }

    private int readOnce(byte[] b, int off, int len) throws IOException {
        int read = -1;
        if (this.inUncompressedChunk == false) goto L12;
        int amount = Math.min(this.uncompressedBytesRemaining, len);
        if (amount != 0) goto L7;
        return -1;
    L7:
        read = this.in.read(b, off, amount);
        if (read == (-1)) goto L17;
        this.uncompressedBytesRemaining -= read;
        count(read);
    L17:
        if (read <= 0) goto L19;
        this.checksum.update(b, off, read);
    L19:
        return read;
    L12:
        if (this.currentCompressedChunk == null) goto L17;
        long before = this.currentCompressedChunk.getBytesRead();
        read = this.currentCompressedChunk.read(b, off, len);
        if (read != (-1)) goto L16;
        this.currentCompressedChunk.close();
        this.currentCompressedChunk = null;
        goto L17
    L16:
        count(this.currentCompressedChunk.getBytesRead() - before);
        goto L17
    }

    private void readNextBlock() throws IOException {
        verifyLastChecksumAndReset();
        this.inUncompressedChunk = false;
        int type = readOneByte();
        if (type != (-1)) goto L6;
        this.endReached = true;
        return;
    L6:
        if (type != 255) goto L9;
        this.in.unread(type);
        this.unreadBytes++;
        pushedBackBytes(1);
        readStreamIdentifier();
        readNextBlock();
        return;
    L9:
        if (type != 254) goto L11;
    L35:
        skipBlock();
        readNextBlock();
        return;
    L11:
        if (type <= 127) goto L16;
        if (type <= MAX_SKIPPABLE_TYPE) goto L35;
    L16:
        if (type < 2) goto L21;
        if (type > 127) goto L21;
        throw new IOException("unskippable chunk with type " + type + " (hex " + Integer.toHexString(type) + ") detected.");
    L21:
        if (type != 1) goto L23;
        this.inUncompressedChunk = true;
        this.uncompressedBytesRemaining = readSize() - 4;
        this.expectedChecksum = unmask(readCrc());
        return;
    L23:
        if (type != 0) goto L34;
        boolean expectChecksum = this.dialect.usesChecksumWithCompressedChunks();
        long r2 = readSize();
        if (expectChecksum == false) goto L27;
        long r4 = 4;
    L28:
        long size = r2 - r4;
        if (expectChecksum == false) goto L31;
        this.expectedChecksum = unmask(readCrc());
    L32:
        this.currentCompressedChunk = new SnappyCompressorInputStream(new BoundedInputStream(this.in, size), this.blockSize);
        count(this.currentCompressedChunk.getBytesRead());
        return;
    L31:
        this.expectedChecksum = -1;
        goto L32
    L27:
        r4 = 0;
        goto L28
    L34:
        throw new IOException("unknown chunk type " + type + " detected.");
    }

    private long readCrc() throws IOException {
        byte[] b = new byte[4];
        int read = IOUtils.readFully(this.in, b);
        count(read);
        if (read != 4) goto L7;
        return ByteUtils.fromLittleEndian(b);
    L7:
        throw new IOException("premature end of stream");
    }

    static long unmask(long x) {
        long x2 = (x - MASK_OFFSET) & 4294967295L;
        return 4294967295L & ((x2 >> 17) | (x2 << 15));
    }

    private int readSize() throws IOException {
        return (int) ByteUtils.fromLittleEndian(this.supplier, 3);
    }

    private void skipBlock() throws IOException {
        int size = readSize();
        long read = IOUtils.skip(this.in, size);
        count(read);
        if (read != size) goto L6;
        return;
    L6:
        throw new IOException("premature end of stream");
    }

    private void readStreamIdentifier() throws IOException {
        byte[] b = new byte[10];
        int read = IOUtils.readFully(this.in, b);
        count(read);
        if (10 != read) goto L8;
        if (matches(b, 10) == false) goto L8;
        return;
    L8:
        throw new IOException("Not a framed Snappy stream");
    }

    private int readOneByte() throws IOException {
        int b = this.in.read();
        if (b == (-1)) goto L6;
        count(1);
        return b & 255;
    L6:
        return -1;
    }

    private void verifyLastChecksumAndReset() throws IOException {
        if (this.expectedChecksum >= 0) goto L5;
    L9:
        this.expectedChecksum = -1;
        this.checksum.reset();
        return;
    L5:
        if (this.expectedChecksum == this.checksum.getValue()) goto L9;
        throw new IOException("Checksum verification failed");
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= SZ_SIGNATURE.length) goto L5;
        return false;
    L5:
        byte[] shortenedSig = signature;
        if (signature.length <= SZ_SIGNATURE.length) goto L9;
        shortenedSig = new byte[SZ_SIGNATURE.length];
        System.arraycopy(signature, 0, shortenedSig, 0, SZ_SIGNATURE.length);
    L9:
        return Arrays.equals(shortenedSig, SZ_SIGNATURE);
    }
}
