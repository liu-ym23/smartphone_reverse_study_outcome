package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class BoundedInputStream extends InputStream {
    private long bytesRemaining;
    private final InputStream in;

    public BoundedInputStream(InputStream in, long size) {
        this.in = in;
        this.bytesRemaining = size;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bytesRemaining <= 0) goto L6;
        this.bytesRemaining--;
        return this.in.read();
    L6:
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.bytesRemaining != 0) goto L6;
        return -1;
    L6:
        int bytesToRead = len;
        if (bytesToRead <= this.bytesRemaining) goto L9;
        bytesToRead = (int) this.bytesRemaining;
    L9:
        int bytesRead = this.in.read(b, off, bytesToRead);
        if (bytesRead < 0) goto L12;
        this.bytesRemaining -= (long) bytesRead;
    L12:
        return bytesRead;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
