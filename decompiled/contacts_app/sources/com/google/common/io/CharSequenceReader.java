package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class CharSequenceReader extends Reader {
    private int mark;
    private int pos;
    private CharSequence seq;

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    public CharSequenceReader(CharSequence r1) {
        this.seq = (CharSequence) Preconditions.checkNotNull(r1);
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

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer r6) throws IOException {
        monitor-enter(this);
        Preconditions.checkNotNull(r6);     // Catch: Throwable -> L14
        checkOpen();     // Catch: Throwable -> L14
        if (hasRemaining() == true) goto L8;
        monitor-exit(this);
        return -1;
    L8:
        int r0 = Math.min(r6.remaining(), remaining());     // Catch: Throwable -> L14
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L12;
        CharSequence r2 = this.seq;     // Catch: Throwable -> L14
        int r3 = this.pos;     // Catch: Throwable -> L14
        this.pos = r3 + 1;     // Catch: Throwable -> L14
        r6.put(r2.charAt(r3));     // Catch: Throwable -> L14
        r1 = r1 + 1;
        goto L9
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        monitor-enter(this);
        checkOpen();     // Catch: Throwable -> L10
        if (hasRemaining() == false) goto L7;
        CharSequence r0 = this.seq;     // Catch: Throwable -> L10
        int r1 = this.pos;     // Catch: Throwable -> L10
        this.pos = r1 + 1;     // Catch: Throwable -> L10
        int r2 = r0.charAt(r1);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r2;
    L7:
        r2 = -1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] r6, int r7, int r8) throws IOException {
        monitor-enter(this);
        int r0 = r7 + r8;
        Preconditions.checkPositionIndexes(r7, r0, r6.length);     // Catch: Throwable -> L15
        checkOpen();     // Catch: Throwable -> L15
        if (hasRemaining() == true) goto L9;
        monitor-exit(this);
        return -1;
    L9:
        int r9 = Math.min(r8, remaining());     // Catch: Throwable -> L15
        int r1 = 0;
    L10:
        if (r1 >= r9) goto L13;
        CharSequence r2 = this.seq;     // Catch: Throwable -> L15
        int r3 = this.pos;     // Catch: Throwable -> L15
        this.pos = r3 + 1;     // Catch: Throwable -> L15
        r6[r7 + r1] = r2.charAt(r3);     // Catch: Throwable -> L15
        r1 = r1 + 1;
        goto L10
    L13:
        monitor-exit(this);
        return r9;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Reader
    public synchronized long skip(long r6) throws IOException {
        monitor-enter(this);
        if (r6 < 0) goto L6;
        boolean r0 = true;
    L14:
        Preconditions.checkArgument(r0, "n (%s) may not be negative", new Object[]{Long.valueOf(r6)});     // Catch: Throwable -> L11
        checkOpen();     // Catch: Throwable -> L11
        int r7 = (int) Math.min(remaining(), r6);     // Catch: Throwable -> L11
        this.pos += r7;     // Catch: Throwable -> L11
        long r8 = r7;
        monitor-exit(this);
        return r8;
    L11:
        th = move-exception;
        throw th;
    L6:
        r0 = false;
        goto L14
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
    public synchronized void mark(int r5) throws IOException {
        monitor-enter(this);
        if (r5 < 0) goto L6;
        boolean r2 = true;
    L13:
        Preconditions.checkArgument(r2, "readAheadLimit (%s) may not be negative", new Object[]{Integer.valueOf(r5)});     // Catch: Throwable -> L10
        checkOpen();     // Catch: Throwable -> L10
        this.mark = this.pos;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    L6:
        r2 = false;
        goto L13
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
}
