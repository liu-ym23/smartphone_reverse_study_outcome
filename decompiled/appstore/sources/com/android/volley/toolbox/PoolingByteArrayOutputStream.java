package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {
    private static final int DEFAULT_SIZE = 256;
    private final ByteArrayPool mPool;

    public PoolingByteArrayOutputStream(ByteArrayPool r10) {
        this(r10, 256);
    }

    private void expand(int r10) {
        int r11 = ((ByteArrayOutputStream) this).count;
        if ((r11 + r10) > ((ByteArrayOutputStream) this).buf.length) goto L5;
        return;
    L5:
        byte[] r12 = this.mPool.getBuf((r11 + r10) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, r12, 0, ((ByteArrayOutputStream) this).count);
        this.mPool.returnBuf(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = r12;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mPool.returnBuf(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.mPool.returnBuf(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] r10, int r11, int r12) {
        monitor-enter(this);
        expand(r12);     // Catch: Throwable -> L6
        super.write(r10, r11, r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public PoolingByteArrayOutputStream(ByteArrayPool r10, int r11) {
        this.mPool = r10;
        ((ByteArrayOutputStream) this).buf = r10.getBuf(Math.max(r11, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int r10) {
        monitor-enter(this);
        expand(1);     // Catch: Throwable -> L7
        super.write(r10);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
