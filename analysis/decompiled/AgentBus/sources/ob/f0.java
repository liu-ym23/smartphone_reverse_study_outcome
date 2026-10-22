package ob;

import fi.iki.elonen.NanoHTTPD;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7975a;

    /* renamed from: b, reason: collision with root package name */
    public int f7976b;

    /* renamed from: c, reason: collision with root package name */
    public int f7977c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7978d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7979e;

    /* renamed from: f, reason: collision with root package name */
    public f0 f7980f;

    /* renamed from: g, reason: collision with root package name */
    public f0 f7981g;

    public f0() {
        this.f7975a = new byte[NanoHTTPD.HTTPSession.BUFSIZE];
        this.f7979e = true;
        this.f7978d = false;
    }

    public final f0 a() {
        f0 f0Var = this.f7980f;
        if (f0Var == this) {
            f0Var = null;
        }
        f0 f0Var2 = this.f7981g;
        q7.k.b(f0Var2);
        f0Var2.f7980f = this.f7980f;
        f0 f0Var3 = this.f7980f;
        q7.k.b(f0Var3);
        f0Var3.f7981g = this.f7981g;
        this.f7980f = null;
        this.f7981g = null;
        return f0Var;
    }

    public final void b(f0 f0Var) {
        q7.k.e(f0Var, "segment");
        f0Var.f7981g = this;
        f0Var.f7980f = this.f7980f;
        f0 f0Var2 = this.f7980f;
        q7.k.b(f0Var2);
        f0Var2.f7981g = f0Var;
        this.f7980f = f0Var;
    }

    public final f0 c() {
        this.f7978d = true;
        return new f0(this.f7975a, this.f7976b, this.f7977c, true, false);
    }

    public final void d(f0 f0Var, int i2) {
        q7.k.e(f0Var, "sink");
        byte[] bArr = f0Var.f7975a;
        if (!f0Var.f7979e) {
            throw new IllegalStateException("only owner can write");
        }
        int i10 = f0Var.f7977c;
        int i11 = i10 + i2;
        if (i11 > 8192) {
            if (f0Var.f7978d) {
                throw new IllegalArgumentException();
            }
            int i12 = f0Var.f7976b;
            if (i11 - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            d7.n.V(0, i12, i10, bArr, bArr);
            f0Var.f7977c -= f0Var.f7976b;
            f0Var.f7976b = 0;
        }
        int i13 = f0Var.f7977c;
        int i14 = this.f7976b;
        d7.n.V(i13, i14, i14 + i2, this.f7975a, bArr);
        f0Var.f7977c += i2;
        this.f7976b += i2;
    }

    public f0(byte[] bArr, int i2, int i10, boolean z4, boolean z10) {
        q7.k.e(bArr, "data");
        this.f7975a = bArr;
        this.f7976b = i2;
        this.f7977c = i10;
        this.f7978d = z4;
        this.f7979e = z10;
    }
}
