package com.bumptech.glide.f;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ContentLengthInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f3320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3321b;

    public static InputStream a(InputStream r1, long r2) {
        return new c(r1, r2);
    }

    private c(InputStream r1, long r2) {
        super(r1);
        this.f3320a = r2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        monitor-enter(this);
        int r0 = (int) Math.max(this.f3320a - ((long) this.f3321b), this.in.available());
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        monitor-enter(this);
        int r0 = super.read();     // Catch: Throwable -> L10
        if (r0 < 0) goto L6;
        int r1 = 1;
    L7:
        a(r1);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L6:
        r1 = -1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r1, int r2, int r3) {
        monitor-enter(this);
        int r4 = a(super.read(r1, r2, r3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    private int a(int r5) {
        if (r5 < 0) goto L5;
        this.f3321b += r5;
    L6:
        return r5;
    L5:
        if ((this.f3320a - ((long) this.f3321b)) <= 0) goto L6;
        throw new IOException("Failed to read all expected data, expected: " + this.f3320a + ", but read: " + this.f3321b);
    }
}
