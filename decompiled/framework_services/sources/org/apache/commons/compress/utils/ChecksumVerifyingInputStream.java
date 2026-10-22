package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes3.dex */
public class ChecksumVerifyingInputStream extends InputStream {
    private long bytesRemaining;
    private final Checksum checksum;
    private final long expectedChecksum;
    private final InputStream in;

    public ChecksumVerifyingInputStream(Checksum checksum, InputStream in, long size, long expectedChecksum) {
        this.checksum = checksum;
        this.in = in;
        this.expectedChecksum = expectedChecksum;
        this.bytesRemaining = size;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bytesRemaining > 0) goto L6;
        return -1;
    L6:
        int ret = this.in.read();
        if (ret < 0) goto L10;
        this.checksum.update(ret);
        this.bytesRemaining--;
    L10:
        if (this.bytesRemaining == 0) goto L12;
    L16:
        return ret;
    L12:
        if (this.expectedChecksum == this.checksum.getValue()) goto L16;
        throw new IOException("Checksum verification failed");
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int ret = this.in.read(b, off, len);
        if (ret < 0) goto L6;
        this.checksum.update(b, off, ret);
        this.bytesRemaining -= (long) ret;
    L6:
        if (this.bytesRemaining <= 0) goto L8;
    L12:
        return ret;
    L8:
        if (this.expectedChecksum == this.checksum.getValue()) goto L12;
        throw new IOException("Checksum verification failed");
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (read() < 0) goto L6;
        return 1;
    L6:
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }
}
