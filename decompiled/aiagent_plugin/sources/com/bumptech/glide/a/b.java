package com.bumptech.glide.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: StrictLineReader.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f3238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Charset f3239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f3240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3242e;

    static /* synthetic */ Charset a(b r0) {
        return r0.f3239b;
    }

    public b(InputStream r2, Charset r3) {
        this(r2, 8192, r3);
    }

    public b(InputStream r2, int r3, Charset r4) {
        if (r2 == null) goto L15;
        if (r4 == null) goto L15;
        if (r3 < 0) goto L13;
        if (r4.equals(c.f3244a) == false) goto L11;
        this.f3238a = r2;
        this.f3239b = r4;
        this.f3240c = new byte[r3];
        return;
    L11:
        throw new IllegalArgumentException("Unsupported encoding");
    L13:
        throw new IllegalArgumentException("capacity <= 0");
    L15:
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream r0 = this.f3238a;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f3240c == null) goto L7;
        this.f3240c = null;     // Catch: Throwable -> L9
        this.f3238a.close();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public String a() {
        InputStream r0 = this.f3238a;
        monitor-enter(r0);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (this.f3240c == null) goto L38;
        if (this.f3241d < this.f3242e) goto L9;
        c();     // Catch: Throwable -> L39
    L9:
        int r1 = this.f3241d;     // Catch: Throwable -> L39
    L11:
        if (r1 == this.f3242e) goto L24;
        byte[] r2 = this.f3240c;     // Catch: Throwable -> L39
        if (r2[r1] == 10) goto L15;
        r1 = r1 + 1;     // Catch: Throwable -> L39
        goto L11
    L15:
        if (r1 == this.f3241d) goto L19;
        int r3 = r1 - 1;     // Catch: Throwable -> L39
        if (r2[r3] != 13) goto L19;
    L20:
        byte[] r4 = this.f3240c;     // Catch: Throwable -> L39
        int r5 = this.f3241d;     // Catch: Throwable -> L39
        String r6 = new String(r4, r5, r3 - r5, this.f3239b.name());     // Catch: Throwable -> L39
        this.f3241d = r1 + 1;     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        return r6;
    L19:
        r3 = r1;
        goto L20
    L24:
        final int r7 = (this.f3242e - this.f3241d) + 80;     // Catch: Throwable -> L39
        ByteArrayOutputStream r8 = new AnonymousClass1(this, r7);     // Catch: Throwable -> L39
    L25:
        byte[] r9 = this.f3240c;     // Catch: Throwable -> L39
        int r10 = this.f3241d;     // Catch: Throwable -> L39
        r8.write(r9, r10, this.f3242e - r10);     // Catch: Throwable -> L39
        this.f3242e = -1;     // Catch: Throwable -> L39
        c();     // Catch: Throwable -> L39
        int r11 = this.f3241d;     // Catch: Throwable -> L39
    L27:
        if (r11 == this.f3242e) goto L25;
        byte[] r12 = this.f3240c;     // Catch: Throwable -> L39
        if (r12[r11] == 10) goto L30;
        r11 = r11 + 1;     // Catch: Throwable -> L39
        goto L27
    L30:
        int r13 = this.f3241d;     // Catch: Throwable -> L39
        if (r11 == r13) goto L33;
        r8.write(r12, r13, r11 - r13);     // Catch: Throwable -> L39
    L33:
        this.f3241d = r11 + 1;     // Catch: Throwable -> L39
        String r14 = r8.toString();     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        return r14;
    L38:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L39
    }

    public boolean b() {
        if (this.f3242e != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void c() {
        InputStream r0 = this.f3238a;
        byte[] r1 = this.f3240c;
        int r2 = r0.read(r1, 0, r1.length);
        if (r2 == (-1)) goto L7;
        this.f3241d = 0;
        this.f3242e = r2;
        return;
    L7:
        throw new EOFException();
    }
}
