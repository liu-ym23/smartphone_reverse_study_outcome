package com.google.common.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class CountingInputStream extends FilterInputStream {
    private long count;
    private long mark;

    public CountingInputStream(@Nullable InputStream r3) {
        super(r3);
        this.mark = -1;
    }

    public long getCount() {
        return this.count;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r0 = this.in.read();
        if (r0 == (-1)) goto L5;
        this.count++;
    L5:
        return r0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3, int r4, int r5) throws IOException {
        int r6 = this.in.read(r3, r4, r5);
        if (r6 == (-1)) goto L5;
        this.count += (long) r6;
    L5:
        return r6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r3) throws IOException {
        long r4 = this.in.skip(r3);
        this.count += r4;
        return r4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r3) {
        monitor-enter(this);
        this.in.mark(r3);     // Catch: Throwable -> L6
        this.mark = this.count;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.in.markSupported() == false) goto L13;
        if (this.mark == (-1)) goto L11;
        this.in.reset();     // Catch: Throwable -> L14
        this.count = this.mark;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        throw new IOException("Mark not set");     // Catch: Throwable -> L14
    L13:
        throw new IOException("Mark not supported");     // Catch: Throwable -> L14
    }
}
