package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class BufferedOutputStream extends OutputStream {
    private ArrayPool arrayPool;
    private byte[] buffer;
    private int index;
    private final OutputStream out;

    private void flushBuffer() throws IOException {
        int r100 = this.index;
        if (r100 <= 0) goto L6;
        this.out.write(this.buffer, 0, r100);
        this.index = 0;
        return;
    }

    private void maybeFlushBuffer() throws IOException {
        if (this.index != this.buffer.length) goto L6;
        flushBuffer();
        return;
    }

    private void release() {
        byte[] r100 = this.buffer;
        if (r100 == null) goto L6;
        this.arrayPool.put(r100);
        this.buffer = null;
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();     // Catch: Throwable -> L5
        this.out.close();
        release();
        return;
    L5:
        th = move-exception;
        this.out.close();
        throw th;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        byte[] r101 = this.buffer;
        int r102 = this.index;
        this.index = r102 + 1;
        r101[r102] = (byte) r100;
        maybeFlushBuffer();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100) throws IOException {
        write(r100, 0, r100.length);
    }

    public BufferedOutputStream(OutputStream r100, ArrayPool r101) {
        this(r100, r101, 65536);
    }

    public BufferedOutputStream(OutputStream r100, ArrayPool r101, int r102) {
        this.out = r100;
        this.arrayPool = r101;
        this.buffer = (byte[]) r101.get(r102, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        int r103 = 0;
    L3:
        int r104 = r102 - r103;
        int r105 = r101 + r103;
        int r106 = this.index;
        if (r106 == 0) goto L6;
    L9:
        int r107 = Math.min(r104, this.buffer.length - r106);
        System.arraycopy(r100, r105, this.buffer, this.index, r107);
        this.index += r107;
        r103 = r103 + r107;
        maybeFlushBuffer();
        if (r103 < r102) goto L3;
        return;
    L6:
        if (r104 < this.buffer.length) goto L9;
        this.out.write(r100, r105, r104);
    }
}
