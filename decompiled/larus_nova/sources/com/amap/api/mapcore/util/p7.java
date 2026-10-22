package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes28.dex */
public final class p7 implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f27843f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f27844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Charset f27845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f27846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f27847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f27848e;

    public class a extends ByteArrayOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p7 f27849a;

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int r100 = ((ByteArrayOutputStream) this).count;
            if (r100 <= 0) goto L12;
            int r101 = r100 - 1;
            if (((ByteArrayOutputStream) this).buf[r101] != 13) goto L12;
            r100 = r101;
        L12:
            return new String(((ByteArrayOutputStream) this).buf, 0, r100, p7.a(this.f27849a).name());
        L9:
            e = move-exception;
            throw new AssertionError(e);
        }

        public a(p7 r100, int r101) {
            this.f27849a = r100;
            super(r101);
        }
    }

    static {
        f27843f = Charset.forName("US-ASCII");
    }

    private void b() throws IOException {
        InputStream r100 = this.f27844a;
        byte[] r101 = this.f27846c;
        int r102 = r100.read(r101, 0, r101.length);
        if (r102 == (-1)) goto L7;
        this.f27847d = 0;
        this.f27848e = r102;
        return;
    L7:
        throw new EOFException();
    }

    public final String a() throws IOException {
        InputStream r100 = this.f27844a;
        monitor-enter(r100);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (this.f27846c == null) goto L38;
        if (this.f27847d < this.f27848e) goto L9;
        b();     // Catch: Throwable -> L39
    L9:
        int r101 = this.f27847d;     // Catch: Throwable -> L39
    L11:
        if (r101 == this.f27848e) goto L24;
        byte[] r102 = this.f27846c;     // Catch: Throwable -> L39
        if (r102[r101] == 10) goto L14;
        r101 = r101 + 1;     // Catch: Throwable -> L39
        goto L11
    L14:
        int r103 = this.f27847d;     // Catch: Throwable -> L39
        if (r101 == r103) goto L19;
        int r104 = r101 - 1;     // Catch: Throwable -> L39
        if (r102[r104] != 13) goto L19;
    L20:
        String r105 = new String(r102, r103, r104 - r103, this.f27845b.name());     // Catch: Throwable -> L39
        this.f27847d = r101 + 1;     // Catch: Throwable -> L39
        monitor-exit(r100);     // Catch: Throwable -> L39
        return r105;
    L19:
        r104 = r101;
        goto L20
    L24:
        a r106 = new a(this, (this.f27848e - this.f27847d) + 80);     // Catch: Throwable -> L39
    L25:
        byte[] r107 = this.f27846c;     // Catch: Throwable -> L39
        int r108 = this.f27847d;     // Catch: Throwable -> L39
        r106.write(r107, r108, this.f27848e - r108);     // Catch: Throwable -> L39
        this.f27848e = -1;     // Catch: Throwable -> L39
        b();     // Catch: Throwable -> L39
        int r109 = this.f27847d;     // Catch: Throwable -> L39
    L27:
        if (r109 == this.f27848e) goto L25;
        byte[] r110 = this.f27846c;     // Catch: Throwable -> L39
        if (r110[r109] == 10) goto L30;
        r109 = r109 + 1;     // Catch: Throwable -> L39
        goto L27
    L30:
        int r111 = this.f27847d;     // Catch: Throwable -> L39
        if (r109 == r111) goto L33;
        r106.write(r110, r111, r109 - r111);     // Catch: Throwable -> L39
    L33:
        this.f27847d = r109 + 1;     // Catch: Throwable -> L39
        String r112 = r106.toString();     // Catch: Throwable -> L39
        monitor-exit(r100);     // Catch: Throwable -> L39
        return r112;
    L38:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L39
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream r100 = this.f27844a;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f27846c == null) goto L7;
        this.f27846c = null;     // Catch: Throwable -> L9
        this.f27844a.close();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public static /* synthetic */ Charset a(p7 r100) {
        return r100.f27845b;
    }

    public p7(InputStream r100, Charset r101) {
        this(r100, r101, (byte) 0);
    }

    private p7(InputStream r100, Charset r101, byte r102) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        if (r101.equals(f27843f) == false) goto L10;
        this.f27844a = r100;
        this.f27845b = r101;
        this.f27846c = new byte[8192];
        return;
    L10:
        throw new IllegalArgumentException("Unsupported encoding");
    L12:
        throw null;
    }
}
