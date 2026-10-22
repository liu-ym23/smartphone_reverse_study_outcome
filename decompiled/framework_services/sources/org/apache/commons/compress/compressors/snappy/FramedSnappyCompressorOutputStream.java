package org.apache.commons.compress.compressors.snappy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes3.dex */
public class FramedSnappyCompressorOutputStream extends CompressorOutputStream {
    private static final int MAX_COMPRESSED_BUFFER_SIZE = 65536;
    private final byte[] buffer;
    private final PureJavaCrc32C checksum;
    private final ByteUtils.ByteConsumer consumer;
    private int currentIndex;
    private final byte[] oneByte;
    private final OutputStream out;
    private final Parameters params;

    public FramedSnappyCompressorOutputStream(OutputStream out) throws IOException {
        this(out, SnappyCompressorOutputStream.createParameterBuilder(32768).build());
    }

    public FramedSnappyCompressorOutputStream(OutputStream out, Parameters params) throws IOException {
        this.checksum = new PureJavaCrc32C();
        this.oneByte = new byte[1];
        this.buffer = new byte[65536];
        this.currentIndex = 0;
        this.out = out;
        this.params = params;
        this.consumer = new ByteUtils.OutputStreamByteConsumer(out);
        out.write(FramedSnappyCompressorInputStream.SZ_SIGNATURE);
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.oneByte[0] = (byte) (b & 255);
        write(this.oneByte);
    }

    @Override // java.io.OutputStream
    public void write(byte[] data, int off, int len) throws IOException {
        if ((this.currentIndex + len) <= 65536) goto L7;
        flushBuffer();
    L5:
        if (len <= 65536) goto L7;
        System.arraycopy(data, off, this.buffer, 0, 65536);
        off = off + 65536;
        len = len - 65536;
        this.currentIndex = 65536;
        flushBuffer();
    L7:
        System.arraycopy(data, off, this.buffer, this.currentIndex, len);
        this.currentIndex += len;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        finish();     // Catch: Throwable -> L5
        this.out.close();
        return;
    L5:
        th = move-exception;
        this.out.close();
        throw th;
    }

    public void finish() throws IOException {
        if (this.currentIndex <= 0) goto L6;
        flushBuffer();
        return;
    }

    private void flushBuffer() throws IOException {
        this.out.write(0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream o = new SnappyCompressorOutputStream(baos, this.currentIndex, this.params);
        o.write(this.buffer, 0, this.currentIndex);     // Catch: Throwable -> L6
        o.close();
        byte[] b = baos.toByteArray();
        writeLittleEndian(3, ((long) b.length) + 4);
        writeCrc();
        this.out.write(b);
        this.currentIndex = 0;
        return;
    L6:
        th = move-exception;
        o.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private void writeLittleEndian(int numBytes, long num) throws IOException {
        ByteUtils.toLittleEndian(this.consumer, num, numBytes);
    }

    private void writeCrc() throws IOException {
        this.checksum.update(this.buffer, 0, this.currentIndex);
        writeLittleEndian(4, mask(this.checksum.getValue()));
        this.checksum.reset();
    }

    static long mask(long x) {
        return (((x >> 15) | (x << 17)) + 2726488792L) & 4294967295L;
    }
}
