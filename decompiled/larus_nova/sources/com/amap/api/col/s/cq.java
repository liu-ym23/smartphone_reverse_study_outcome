package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes28.dex */
public final class cq implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f26467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputStream f26468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Charset f26469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f26470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f26471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f26472f;

    static {
        f26467a = Charset.forName("US-ASCII");
    }

    private void b() throws IOException {
        InputStream r100 = this.f26468b;
        byte[] r101 = this.f26470d;
        int r102 = r100.read(r101, 0, r101.length);
        if (r102 == (-1)) goto L7;
        this.f26471e = 0;
        this.f26472f = r102;
        return;
    L7:
        throw new EOFException();
    }

    public final String a() throws IOException {
        InputStream r100 = this.f26468b;
        monitor-enter(r100);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (this.f26470d == null) goto L38;
        if (this.f26471e < this.f26472f) goto L9;
        b();     // Catch: Throwable -> L39
    L9:
        int r101 = this.f26471e;     // Catch: Throwable -> L39
    L11:
        if (r101 == this.f26472f) goto L24;
        byte[] r102 = this.f26470d;     // Catch: Throwable -> L39
        if (r102[r101] == 10) goto L14;
        r101 = r101 + 1;     // Catch: Throwable -> L39
        goto L11
    L14:
        int r103 = this.f26471e;     // Catch: Throwable -> L39
        if (r101 == r103) goto L19;
        int r104 = r101 - 1;     // Catch: Throwable -> L39
        if (r102[r104] != 13) goto L19;
    L20:
        String r105 = new String(r102, r103, r104 - r103, this.f26469c.name());     // Catch: Throwable -> L39
        this.f26471e = r101 + 1;     // Catch: Throwable -> L39
        monitor-exit(r100);     // Catch: Throwable -> L39
        return r105;
    L19:
        r104 = r101;
        goto L20
    L24:
        final int r106 = (this.f26472f - this.f26471e) + 80;     // Catch: Throwable -> L39
        ByteArrayOutputStream r107 = new AnonymousClass1(this, r106);     // Catch: Throwable -> L39
    L25:
        byte[] r108 = this.f26470d;     // Catch: Throwable -> L39
        int r109 = this.f26471e;     // Catch: Throwable -> L39
        r107.write(r108, r109, this.f26472f - r109);     // Catch: Throwable -> L39
        this.f26472f = -1;     // Catch: Throwable -> L39
        b();     // Catch: Throwable -> L39
        int r110 = this.f26471e;     // Catch: Throwable -> L39
    L27:
        if (r110 == this.f26472f) goto L25;
        byte[] r111 = this.f26470d;     // Catch: Throwable -> L39
        if (r111[r110] == 10) goto L30;
        r110 = r110 + 1;     // Catch: Throwable -> L39
        goto L27
    L30:
        int r112 = this.f26471e;     // Catch: Throwable -> L39
        if (r110 == r112) goto L33;
        r107.write(r111, r112, r110 - r112);     // Catch: Throwable -> L39
    L33:
        this.f26471e = r110 + 1;     // Catch: Throwable -> L39
        String r113 = r107.toString();     // Catch: Throwable -> L39
        monitor-exit(r100);     // Catch: Throwable -> L39
        return r113;
    L38:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L39
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream r100 = this.f26468b;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f26470d == null) goto L7;
        this.f26470d = null;     // Catch: Throwable -> L9
        this.f26468b.close();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public static /* synthetic */ Charset a(cq r100) {
        return r100.f26469c;
    }

    public cq(InputStream r100, Charset r101) {
        this(r100, r101, (byte) 0);
    }

    private cq(InputStream r100, Charset r101, byte r102) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        if (r101.equals(f26467a) == false) goto L10;
        this.f26468b = r100;
        this.f26469c = r101;
        this.f26470d = new byte[8192];
        return;
    L10:
        throw new IllegalArgumentException("Unsupported encoding");
    L12:
        throw null;
    }
}
