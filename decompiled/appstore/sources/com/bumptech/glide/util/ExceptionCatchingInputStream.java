package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionCatchingInputStream extends InputStream {
    private static final Queue<ExceptionCatchingInputStream> QUEUE = null;
    private IOException exception;
    private InputStream wrapped;

    static {
        QUEUE = Util.createQueue(0);
    }

    public ExceptionCatchingInputStream() {
    }

    public static void clearQueue() {
    L2:
        Queue<ExceptionCatchingInputStream> r10 = QUEUE;
        if (r10.isEmpty() == true) goto L5;
        r10.remove();
        goto L2
    }

    @NonNull
    public static ExceptionCatchingInputStream obtain(@NonNull InputStream r10) {
        Queue<ExceptionCatchingInputStream> r11 = QUEUE;
        monitor-enter(r11);
        ExceptionCatchingInputStream r12 = r11.poll();     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        r12 = new ExceptionCatchingInputStream();
    L8:
        r12.setInputStream(r10);
        return r12;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.wrapped.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.wrapped.close();
    }

    @Nullable
    public IOException getException() {
        return this.exception;
    }

    @Override // java.io.InputStream
    public void mark(int r10) {
        this.wrapped.mark(r10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] r10) {
        return this.wrapped.read(r10);
    L4:
        e = move-exception;
        this.exception = e;
        return -1;
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        Queue<ExceptionCatchingInputStream> r10 = QUEUE;
        monitor-enter(r10);
        r10.offer(this);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
        this.wrapped.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setInputStream(@NonNull InputStream r10) {
        this.wrapped = r10;
    }

    @Override // java.io.InputStream
    public long skip(long r10) {
        return this.wrapped.skip(r10);
    L4:
        e = move-exception;
        this.exception = e;
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        return this.wrapped.read(r10, r11, r12);
    L4:
        e = move-exception;
        this.exception = e;
        return -1;
    }

    @Override // java.io.InputStream
    public int read() {
        return this.wrapped.read();
    L4:
        e = move-exception;
        this.exception = e;
        return -1;
    }
}
