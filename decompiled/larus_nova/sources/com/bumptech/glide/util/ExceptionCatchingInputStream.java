package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes39.dex */
public class ExceptionCatchingInputStream extends InputStream {
    private static final Queue<ExceptionCatchingInputStream> QUEUE = null;
    private IOException exception;
    private InputStream wrapped;

    static {
        QUEUE = Util.createQueue(0);
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        Queue<ExceptionCatchingInputStream> r100 = QUEUE;
        monitor-enter(r100);
        r100.offer(this);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
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

    public static void clearQueue() {
    L2:
        Queue<ExceptionCatchingInputStream> r100 = QUEUE;
        if (r100.isEmpty() == true) goto L5;
        r100.remove();
        goto L2
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.wrapped.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.wrapped.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.wrapped.read();
    L4:
        e = move-exception;
        this.exception = e;
        return -1;
    }

    public ExceptionCatchingInputStream() {
    }

    public IOException getException() {
        return this.exception;
    }

    public static ExceptionCatchingInputStream obtain(InputStream r100) {
        Queue<ExceptionCatchingInputStream> r101 = QUEUE;
        monitor-enter(r101);
        ExceptionCatchingInputStream r102 = r101.poll();     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        if (r102 != null) goto L8;
        r102 = new ExceptionCatchingInputStream();
    L8:
        r102.setInputStream(r100);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public void mark(int r100) {
        this.wrapped.mark(r100);
    }

    @Override // java.io.InputStream
    public int read(byte[] r100) {
        return this.wrapped.read(r100);
    L4:
        e = move-exception;
        this.exception = e;
        return -1;
    }

    public void setInputStream(InputStream r100) {
        this.wrapped = r100;
    }

    @Override // java.io.InputStream
    public long skip(long r100) {
        return this.wrapped.skip(r100);
    L4:
        e = move-exception;
        this.exception = e;
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) {
        return this.wrapped.read(r100, r101, r102);
    L4:
        e = move-exception;
        this.exception = e;
        return -1;
    }
}
