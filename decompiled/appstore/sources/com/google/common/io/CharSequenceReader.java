package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class CharSequenceReader extends Reader {
    private int mark;
    private int pos;
    private CharSequence seq;

    public CharSequenceReader(CharSequence r10) {
        this.seq = (CharSequence) Preconditions.checkNotNull(r10);
    }

    private void checkOpen() throws IOException {
        if (this.seq == null) goto L6;
        return;
    L6:
        throw new IOException("reader closed");
    }

    private boolean hasRemaining() {
        if (remaining() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int remaining() {
        return this.seq.length() - this.pos;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        this.seq = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Reader
    public synchronized void mark(int r10) throws IOException {
        monitor-enter(this);
        if (r10 < 0) goto L5;
        boolean r11 = true;
    L12:
        Preconditions.checkArgument(r11, "readAheadLimit (%s) may not be negative", r10);     // Catch: Throwable -> L9
        checkOpen();     // Catch: Throwable -> L9
        this.mark = this.pos;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    L5:
        r11 = false;
        goto L12
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer r10) throws IOException {
        monitor-enter(this);
        Preconditions.checkNotNull(r10);     // Catch: Throwable -> L12
        checkOpen();     // Catch: Throwable -> L12
        if (hasRemaining() == true) goto L8;
        monitor-exit(this);
        return -1;
    L8:
        int r11 = Math.min(r10.remaining(), remaining());     // Catch: Throwable -> L12
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L14;
        CharSequence r13 = this.seq;     // Catch: Throwable -> L12
        int r14 = this.pos;     // Catch: Throwable -> L12
        this.pos = r14 + 1;     // Catch: Throwable -> L12
        r10.put(r13.charAt(r14));     // Catch: Throwable -> L12
        r12 = r12 + 1;
        goto L9
    L14:
        monitor-exit(this);
        return r11;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
        monitor-enter(this);
        checkOpen();     // Catch: Throwable -> L7
        monitor-exit(this);
        return true;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        monitor-enter(this);
        checkOpen();     // Catch: Throwable -> L6
        this.pos = this.mark;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Reader
    public synchronized long skip(long r10) throws IOException {
        monitor-enter(this);
        if (r10 < 0) goto L6;
        boolean r11 = true;
    L14:
        Preconditions.checkArgument(r11, "n (%s) may not be negative", r10);     // Catch: Throwable -> L11
        checkOpen();     // Catch: Throwable -> L11
        int r12 = (int) Math.min(remaining(), r10);     // Catch: Throwable -> L11
        this.pos += r12;     // Catch: Throwable -> L11
        long r13 = r12;
        monitor-exit(this);
        return r13;
    L11:
        th = move-exception;
        throw th;
    L6:
        r11 = false;
        goto L14
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        monitor-enter(this);
        checkOpen();     // Catch: Throwable -> L7
        if (hasRemaining() == false) goto L9;
        CharSequence r10 = this.seq;     // Catch: Throwable -> L7
        int r11 = this.pos;     // Catch: Throwable -> L7
        this.pos = r11 + 1;     // Catch: Throwable -> L7
        int r12 = r10.charAt(r11);     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r12;
    L9:
        r12 = -1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] r10, int r11, int r12) throws IOException {
        monitor-enter(this);
        int r13 = r11 + r12;
        Preconditions.checkPositionIndexes(r11, r13, r10.length);     // Catch: Throwable -> L13
        checkOpen();     // Catch: Throwable -> L13
        if (hasRemaining() == true) goto L9;
        monitor-exit(this);
        return -1;
    L9:
        int r14 = Math.min(r12, remaining());     // Catch: Throwable -> L13
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L15;
        CharSequence r16 = this.seq;     // Catch: Throwable -> L13
        int r17 = this.pos;     // Catch: Throwable -> L13
        this.pos = r17 + 1;     // Catch: Throwable -> L13
        r10[r11 + r15] = r16.charAt(r17);     // Catch: Throwable -> L13
        r15 = r15 + 1;
        goto L10
    L15:
        monitor-exit(this);
        return r14;
    L13:
        th = move-exception;
        throw th;
    }
}
