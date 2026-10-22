package W2;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f5730b;

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f5731c;

    /* renamed from: d, reason: collision with root package name */
    protected static final byte[] f5732d;

    /* renamed from: e, reason: collision with root package name */
    protected static final byte[] f5733e;

    /* renamed from: f, reason: collision with root package name */
    protected static final byte[] f5734f;

    /* renamed from: g, reason: collision with root package name */
    protected static final byte[] f5735g;

    /* renamed from: h, reason: collision with root package name */
    protected static final byte[] f5736h;

    /* renamed from: i, reason: collision with root package name */
    protected static final byte[] f5737i;

    /* renamed from: j, reason: collision with root package name */
    protected static final byte[] f5738j;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5739a;

    static {
        byte[] bArrA = b.a("----------------314159265358979323846");
        f5730b = bArrA;
        f5731c = bArrA;
        f5732d = b.a("\r\n");
        f5733e = b.a("\"");
        f5734f = b.a("--");
        f5735g = b.a("Content-Disposition: form-data; name=");
        f5736h = b.a("Content-Type: ");
        f5737i = b.a("; charset=");
        f5738j = b.a("Content-Transfer-Encoding: ");
    }

    public static void b(OutputStream outputStream, c[] cVarArr, byte[] bArr) throws IOException {
        if (cVarArr == null) {
            throw new IllegalArgumentException("Parts may not be null");
        }
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("partBoundary may not be empty");
        }
        for (int i5 = 0; i5 < cVarArr.length; i5++) {
            cVarArr[i5].c(bArr);
            cVarArr[i5].a(outputStream);
        }
        byte[] bArr2 = f5734f;
        outputStream.write(bArr2);
        outputStream.write(bArr);
        outputStream.write(bArr2);
        outputStream.write(f5732d);
    }

    public void a(OutputStream outputStream) throws IOException {
        n(outputStream);
        i(outputStream);
        e(outputStream);
        o(outputStream);
        m(outputStream);
        g(outputStream);
        j(outputStream);
    }

    void c(byte[] bArr) {
        this.f5739a = bArr;
    }

    public abstract String d();

    protected void e(OutputStream outputStream) throws IOException {
        String strF = f();
        if (strF != null) {
            outputStream.write(f5732d);
            outputStream.write(f5736h);
            outputStream.write(b.a(strF));
            String strD = d();
            if (strD != null) {
                outputStream.write(f5737i);
                outputStream.write(b.a(strD));
            }
        }
    }

    public abstract String f();

    protected abstract void g(OutputStream outputStream);

    public abstract String h();

    protected void i(OutputStream outputStream) throws IOException {
        outputStream.write(f5735g);
        byte[] bArr = f5733e;
        outputStream.write(bArr);
        outputStream.write(b.a(h()));
        outputStream.write(bArr);
    }

    protected void j(OutputStream outputStream) throws IOException {
        outputStream.write(f5732d);
    }

    protected byte[] k() {
        byte[] bArr = this.f5739a;
        return bArr == null ? f5731c : bArr;
    }

    public abstract String l();

    protected void m(OutputStream outputStream) throws IOException {
        byte[] bArr = f5732d;
        outputStream.write(bArr);
        outputStream.write(bArr);
    }

    protected void n(OutputStream outputStream) throws IOException {
        outputStream.write(f5734f);
        outputStream.write(k());
        outputStream.write(f5732d);
    }

    protected void o(OutputStream outputStream) throws IOException {
        String strL = l();
        if (strL != null) {
            outputStream.write(f5732d);
            outputStream.write(f5738j);
            outputStream.write(b.a(strL));
        }
    }

    public String toString() {
        return h();
    }
}
