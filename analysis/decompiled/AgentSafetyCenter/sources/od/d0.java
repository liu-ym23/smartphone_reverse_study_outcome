package od;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f9437a;

    /* renamed from: b, reason: collision with root package name */
    public int f9438b;

    /* renamed from: c, reason: collision with root package name */
    public int f9439c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9440d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9441e;

    /* renamed from: f, reason: collision with root package name */
    public d0 f9442f;

    /* renamed from: g, reason: collision with root package name */
    public d0 f9443g;

    public d0(byte[] bArr, int i, int i3, boolean z10) {
        bArr.getClass();
        this.f9437a = bArr;
        this.f9438b = i;
        this.f9439c = i3;
        this.f9440d = z10;
        this.f9441e = false;
    }

    public final d0 a() {
        d0 d0Var = this.f9442f;
        if (d0Var == this) {
            d0Var = null;
        }
        d0 d0Var2 = this.f9443g;
        d0Var2.getClass();
        d0Var2.f9442f = this.f9442f;
        d0 d0Var3 = this.f9442f;
        d0Var3.getClass();
        d0Var3.f9443g = this.f9443g;
        this.f9442f = null;
        this.f9443g = null;
        return d0Var;
    }

    public final void b(d0 d0Var) {
        d0Var.getClass();
        d0Var.f9443g = this;
        d0Var.f9442f = this.f9442f;
        d0 d0Var2 = this.f9442f;
        d0Var2.getClass();
        d0Var2.f9443g = d0Var;
        this.f9442f = d0Var;
    }

    public final d0 c() {
        this.f9440d = true;
        return new d0(this.f9437a, this.f9438b, this.f9439c, true);
    }

    public final void d(d0 d0Var, int i) {
        d0Var.getClass();
        byte[] bArr = d0Var.f9437a;
        if (!d0Var.f9441e) {
            f.e("only owner can write");
            return;
        }
        int i3 = d0Var.f9439c;
        int i10 = i3 + i;
        if (i10 > 8192) {
            if (d0Var.f9440d) {
                f.b();
                return;
            }
            int i11 = d0Var.f9438b;
            if (i10 - i11 > 8192) {
                f.b();
                return;
            } else {
                kb.k.g0(bArr, 0, i11, bArr, i3);
                d0Var.f9439c -= d0Var.f9438b;
                d0Var.f9438b = 0;
            }
        }
        int i12 = d0Var.f9439c;
        int i13 = this.f9438b;
        kb.k.g0(this.f9437a, i12, i13, bArr, i13 + i);
        d0Var.f9439c += i;
        this.f9438b += i;
    }

    public d0() {
        this.f9437a = new byte[8192];
        this.f9441e = true;
        this.f9440d = false;
    }
}
