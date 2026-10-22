package org.apache.http.impl.io;

import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class EmptyInputStream extends InputStream {
    public static final EmptyInputStream INSTANCE = null;

    static {
        INSTANCE = new EmptyInputStream();
    }

    private EmptyInputStream() {
    }

    @Override // java.io.InputStream
    public int available() {
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public void mark(int r10) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }

    @Override // java.io.InputStream
    public void reset() {
    }

    @Override // java.io.InputStream
    public long skip(long r10) {
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] r10) {
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        return -1;
    }
}
