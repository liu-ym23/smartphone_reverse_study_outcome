package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class CountingInputStream extends FilterInputStream {
    private long count;
    private long mark;

    public CountingInputStream(InputStream r10) {
        super((InputStream) Preconditions.checkNotNull(r10));
        this.mark = -1;
    }

    public long getCount() {
        return this.count;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r10) {
        monitor-enter(this);
        ((FilterInputStream) this).in.mark(r10);     // Catch: Throwable -> L6
        this.mark = this.count;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r10 = ((FilterInputStream) this).in.read();
        if (r10 == (-1)) goto L5;
        this.count++;
    L5:
        return r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (((FilterInputStream) this).in.markSupported() == false) goto L15;
        if (this.mark == (-1)) goto L13;
        ((FilterInputStream) this).in.reset();     // Catch: Throwable -> L10
        this.count = this.mark;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L13:
        throw new IOException("Mark not set");     // Catch: Throwable -> L10
    L15:
        throw new IOException("Mark not supported");     // Catch: Throwable -> L10
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r10) throws IOException {
        long r11 = ((FilterInputStream) this).in.skip(r10);
        this.count += r11;
        return r11;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r10, int r11, int r12) throws IOException {
        int r13 = ((FilterInputStream) this).in.read(r10, r11, r12);
        if (r13 == (-1)) goto L5;
        this.count += (long) r13;
    L5:
        return r13;
    }
}
