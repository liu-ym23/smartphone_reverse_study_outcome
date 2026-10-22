package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class BufferedOutputStream extends OutputStream {
    private ArrayPool arrayPool;
    private byte[] buffer;
    private int index;

    @NonNull
    private final OutputStream out;

    public BufferedOutputStream(@NonNull OutputStream r10, @NonNull ArrayPool r11) {
        this(r10, r11, 65536);
    }

    private void flushBuffer() throws IOException {
        int r10 = this.index;
        if (r10 <= 0) goto L6;
        this.out.write(this.buffer, 0, r10);
        this.index = 0;
        return;
    }

    private void maybeFlushBuffer() throws IOException {
        if (this.index != this.buffer.length) goto L6;
        flushBuffer();
        return;
    }

    private void release() {
        byte[] r10 = this.buffer;
        if (r10 == null) goto L6;
        this.arrayPool.put(r10);
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
    public void write(int r10) throws IOException {
        byte[] r11 = this.buffer;
        int r12 = this.index;
        this.index = r12 + 1;
        r11[r12] = (byte) r10;
        maybeFlushBuffer();
    }

    @VisibleForTesting
    public BufferedOutputStream(@NonNull OutputStream r10, ArrayPool r11, int r12) {
        this.out = r10;
        this.arrayPool = r11;
        this.buffer = (byte[]) r11.get(r12, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] r10) throws IOException {
        write(r10, 0, r10.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] r10, int r11, int r12) throws IOException {
        int r13 = 0;
    L3:
        int r14 = r12 - r13;
        int r15 = r11 + r13;
        int r16 = this.index;
        if (r16 == 0) goto L6;
    L9:
        int r17 = Math.min(r14, this.buffer.length - r16);
        System.arraycopy(r10, r15, this.buffer, this.index, r17);
        this.index += r17;
        r13 = r13 + r17;
        maybeFlushBuffer();
        if (r13 < r12) goto L3;
        return;
    L6:
        if (r14 < this.buffer.length) goto L9;
        this.out.write(r10, r15, r14);
    }
}
