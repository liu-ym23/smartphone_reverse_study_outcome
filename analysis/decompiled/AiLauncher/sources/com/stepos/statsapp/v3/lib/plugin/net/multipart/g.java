package com.stepos.statsapp.v3.lib.plugin.net.multipart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: b, reason: collision with root package name */
    protected static final String f30868b = "----------------314159265358979323846";

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f30869c;

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f30870d;

    /* renamed from: e, reason: collision with root package name */
    protected static final String f30871e = "\r\n";

    /* renamed from: f, reason: collision with root package name */
    protected static final byte[] f30872f;

    /* renamed from: g, reason: collision with root package name */
    protected static final String f30873g = "\"";

    /* renamed from: h, reason: collision with root package name */
    protected static final byte[] f30874h;

    /* renamed from: i, reason: collision with root package name */
    protected static final String f30875i = "--";

    /* renamed from: j, reason: collision with root package name */
    protected static final byte[] f30876j;

    /* renamed from: k, reason: collision with root package name */
    protected static final String f30877k = "Content-Disposition: form-data; name=";

    /* renamed from: l, reason: collision with root package name */
    protected static final byte[] f30878l;

    /* renamed from: m, reason: collision with root package name */
    protected static final String f30879m = "Content-Type: ";

    /* renamed from: n, reason: collision with root package name */
    protected static final byte[] f30880n;

    /* renamed from: o, reason: collision with root package name */
    protected static final String f30881o = "; charset=";

    /* renamed from: p, reason: collision with root package name */
    protected static final byte[] f30882p;

    /* renamed from: q, reason: collision with root package name */
    protected static final String f30883q = "Content-Transfer-Encoding: ";

    /* renamed from: r, reason: collision with root package name */
    protected static final byte[] f30884r;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f30885a;

    static {
        byte[] bArrA = b.a(f30868b);
        f30869c = bArrA;
        f30870d = bArrA;
        f30872f = b.a("\r\n");
        f30874h = b.a(f30873g);
        f30876j = b.a(f30875i);
        f30878l = b.a(f30877k);
        f30880n = b.a(f30879m);
        f30882p = b.a("; charset=");
        f30884r = b.a(f30883q);
    }

    public static String a() {
        return f30868b;
    }

    public abstract String b();

    public void b(OutputStream outputStream) throws IOException {
        String strC = c();
        if (strC != null) {
            outputStream.write(f30872f);
            outputStream.write(f30880n);
            outputStream.write(b.a(strC));
            String strB = b();
            if (strB != null) {
                outputStream.write(f30882p);
                outputStream.write(b.a(strB));
            }
        }
    }

    public abstract String c();

    public abstract void c(OutputStream outputStream) throws IOException;

    public abstract String d();

    public void d(OutputStream outputStream) throws IOException {
        outputStream.write(f30878l);
        byte[] bArr = f30874h;
        outputStream.write(bArr);
        outputStream.write(b.a(d()));
        outputStream.write(bArr);
    }

    public byte[] e() {
        byte[] bArr = this.f30885a;
        return bArr == null ? f30870d : bArr;
    }

    public abstract String f();

    public void f(OutputStream outputStream) throws IOException {
        byte[] bArr = f30872f;
        outputStream.write(bArr);
        outputStream.write(bArr);
    }

    public boolean g() {
        return true;
    }

    public void h(OutputStream outputStream) throws IOException {
        String strF = f();
        if (strF != null) {
            outputStream.write(f30872f);
            outputStream.write(f30884r);
            outputStream.write(b.a(strF));
        }
    }

    public abstract long i() throws IOException;

    public String toString() {
        return d();
    }

    public void a(byte[] bArr) {
        this.f30885a = bArr;
    }

    public void g(OutputStream outputStream) throws IOException {
        outputStream.write(f30876j);
        outputStream.write(e());
        outputStream.write(f30872f);
    }

    public void a(OutputStream outputStream) throws IOException {
        g(outputStream);
        d(outputStream);
        b(outputStream);
        h(outputStream);
        f(outputStream);
        c(outputStream);
        e(outputStream);
    }

    public void e(OutputStream outputStream) throws IOException {
        outputStream.write(f30872f);
    }

    public long h() throws IOException {
        if (i() < 0) {
            return -1L;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        g(byteArrayOutputStream);
        d(byteArrayOutputStream);
        b(byteArrayOutputStream);
        h(byteArrayOutputStream);
        f(byteArrayOutputStream);
        e(byteArrayOutputStream);
        return byteArrayOutputStream.size() + i();
    }

    public static void a(OutputStream outputStream, g[] gVarArr) throws IOException {
        a(outputStream, gVarArr, f30870d);
    }

    public static void a(OutputStream outputStream, g[] gVarArr, byte[] bArr) throws IOException {
        if (gVarArr != null) {
            if (bArr != null && bArr.length != 0) {
                for (int i10 = 0; i10 < gVarArr.length; i10++) {
                    gVarArr[i10].a(bArr);
                    gVarArr[i10].a(outputStream);
                }
                byte[] bArr2 = f30876j;
                outputStream.write(bArr2);
                outputStream.write(bArr);
                outputStream.write(bArr2);
                outputStream.write(f30872f);
                return;
            }
            throw new IllegalArgumentException("partBoundary may not be empty");
        }
        throw new IllegalArgumentException("Parts may not be null");
    }

    public static long a(g[] gVarArr) throws IOException {
        return a(gVarArr, f30870d);
    }

    public static long a(g[] gVarArr, byte[] bArr) throws IOException {
        if (gVarArr != null) {
            long j10 = 0;
            for (int i10 = 0; i10 < gVarArr.length; i10++) {
                gVarArr[i10].a(bArr);
                long jH = gVarArr[i10].h();
                if (jH < 0) {
                    return -1L;
                }
                j10 += jH;
            }
            byte[] bArr2 = f30876j;
            return j10 + bArr2.length + bArr.length + bArr2.length + f30872f.length;
        }
        throw new IllegalArgumentException("Parts may not be null");
    }
}
