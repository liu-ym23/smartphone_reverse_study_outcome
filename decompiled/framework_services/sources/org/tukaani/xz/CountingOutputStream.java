package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
class CountingOutputStream extends FinishableOutputStream {
    private final OutputStream out;
    private long size;

    public CountingOutputStream(OutputStream out) {
        this.size = 0;
        this.out = out;
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.out.write(b);
        if (this.size < 0) goto L6;
        this.size++;
        return;
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
        if (this.size < 0) goto L6;
        this.size += (long) len;
        return;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    public long getSize() {
        return this.size;
    }
}
