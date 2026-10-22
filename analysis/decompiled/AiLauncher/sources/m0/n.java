package m0;

/* loaded from: classes.dex */
public class n implements m {

    /* renamed from: a, reason: collision with root package name */
    public float f37127a;

    /* renamed from: b, reason: collision with root package name */
    public float f37128b;

    /* renamed from: c, reason: collision with root package name */
    public float f37129c;

    /* renamed from: d, reason: collision with root package name */
    public float f37130d;

    /* renamed from: e, reason: collision with root package name */
    public float f37131e;

    /* renamed from: f, reason: collision with root package name */
    public float f37132f;

    /* renamed from: g, reason: collision with root package name */
    public float f37133g;

    /* renamed from: h, reason: collision with root package name */
    public float f37134h;

    /* renamed from: i, reason: collision with root package name */
    public float f37135i;

    /* renamed from: j, reason: collision with root package name */
    public int f37136j;

    /* renamed from: k, reason: collision with root package name */
    public String f37137k;

    /* renamed from: m, reason: collision with root package name */
    public float f37139m;

    /* renamed from: n, reason: collision with root package name */
    public float f37140n;

    /* renamed from: o, reason: collision with root package name */
    public float f37141o;

    /* renamed from: l, reason: collision with root package name */
    public boolean f37138l = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f37142p = false;

    @Override // m0.m
    public float a() {
        return this.f37138l ? -e(this.f37141o) : e(this.f37141o);
    }

    @Override // m0.m
    public boolean b() {
        return a() < 1.0E-5f && Math.abs(this.f37135i - this.f37140n) < 1.0E-5f;
    }

    public final float c(float f10) {
        this.f37142p = false;
        float f11 = this.f37130d;
        if (f10 <= f11) {
            float f12 = this.f37127a;
            return (f12 * f10) + ((((this.f37128b - f12) * f10) * f10) / (f11 * 2.0f));
        }
        int i10 = this.f37136j;
        if (i10 == 1) {
            return this.f37133g;
        }
        float f13 = f10 - f11;
        float f14 = this.f37131e;
        if (f13 < f14) {
            float f15 = this.f37133g;
            float f16 = this.f37128b;
            return f15 + (f16 * f13) + ((((this.f37129c - f16) * f13) * f13) / (f14 * 2.0f));
        }
        if (i10 == 2) {
            return this.f37134h;
        }
        float f17 = f13 - f14;
        float f18 = this.f37132f;
        if (f17 > f18) {
            this.f37142p = true;
            return this.f37135i;
        }
        float f19 = this.f37134h;
        float f20 = this.f37129c;
        return (f19 + (f20 * f17)) - (((f20 * f17) * f17) / (f18 * 2.0f));
    }

    public void d(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.f37142p = false;
        this.f37139m = f10;
        boolean z10 = f10 > f11;
        this.f37138l = z10;
        if (z10) {
            f(-f12, f10 - f11, f14, f15, f13);
        } else {
            f(f12, f11 - f10, f14, f15, f13);
        }
    }

    public float e(float f10) {
        float f11;
        float f12;
        float f13 = this.f37130d;
        if (f10 <= f13) {
            f11 = this.f37127a;
            f12 = this.f37128b;
        } else {
            int i10 = this.f37136j;
            if (i10 == 1) {
                return 0.0f;
            }
            f10 -= f13;
            f13 = this.f37131e;
            if (f10 >= f13) {
                if (i10 == 2) {
                    return 0.0f;
                }
                float f14 = f10 - f13;
                float f15 = this.f37132f;
                if (f14 >= f15) {
                    return 0.0f;
                }
                float f16 = this.f37129c;
                return f16 - ((f14 * f16) / f15);
            }
            f11 = this.f37128b;
            f12 = this.f37129c;
        }
        return f11 + (((f12 - f11) * f10) / f13);
    }

    public final void f(float f10, float f11, float f12, float f13, float f14) {
        this.f37142p = false;
        this.f37135i = f11;
        if (f10 == 0.0f) {
            f10 = 1.0E-4f;
        }
        float f15 = f10 / f12;
        float f16 = (f15 * f10) / 2.0f;
        if (f10 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f11 - ((((-f10) / f12) * f10) / 2.0f)) * f12);
            if (fSqrt < f13) {
                this.f37137k = "backward accelerate, decelerate";
                this.f37136j = 2;
                this.f37127a = f10;
                this.f37128b = fSqrt;
                this.f37129c = 0.0f;
                float f17 = (fSqrt - f10) / f12;
                this.f37130d = f17;
                this.f37131e = fSqrt / f12;
                this.f37133g = ((f10 + fSqrt) * f17) / 2.0f;
                this.f37134h = f11;
                this.f37135i = f11;
                return;
            }
            this.f37137k = "backward accelerate cruse decelerate";
            this.f37136j = 3;
            this.f37127a = f10;
            this.f37128b = f13;
            this.f37129c = f13;
            float f18 = (f13 - f10) / f12;
            this.f37130d = f18;
            float f19 = f13 / f12;
            this.f37132f = f19;
            float f20 = ((f10 + f13) * f18) / 2.0f;
            float f21 = (f19 * f13) / 2.0f;
            this.f37131e = ((f11 - f20) - f21) / f13;
            this.f37133g = f20;
            this.f37134h = f11 - f21;
            this.f37135i = f11;
            return;
        }
        if (f16 >= f11) {
            this.f37137k = "hard stop";
            this.f37136j = 1;
            this.f37127a = f10;
            this.f37128b = 0.0f;
            this.f37133g = f11;
            this.f37130d = (2.0f * f11) / f10;
            return;
        }
        float f22 = f11 - f16;
        float f23 = f22 / f10;
        if (f23 + f15 < f14) {
            this.f37137k = "cruse decelerate";
            this.f37136j = 2;
            this.f37127a = f10;
            this.f37128b = f10;
            this.f37129c = 0.0f;
            this.f37133g = f22;
            this.f37134h = f11;
            this.f37130d = f23;
            this.f37131e = f15;
            return;
        }
        float fSqrt2 = (float) Math.sqrt((f12 * f11) + ((f10 * f10) / 2.0f));
        float f24 = (fSqrt2 - f10) / f12;
        this.f37130d = f24;
        float f25 = fSqrt2 / f12;
        this.f37131e = f25;
        if (fSqrt2 < f13) {
            this.f37137k = "accelerate decelerate";
            this.f37136j = 2;
            this.f37127a = f10;
            this.f37128b = fSqrt2;
            this.f37129c = 0.0f;
            this.f37130d = f24;
            this.f37131e = f25;
            this.f37133g = ((f10 + fSqrt2) * f24) / 2.0f;
            this.f37134h = f11;
            return;
        }
        this.f37137k = "accelerate cruse decelerate";
        this.f37136j = 3;
        this.f37127a = f10;
        this.f37128b = f13;
        this.f37129c = f13;
        float f26 = (f13 - f10) / f12;
        this.f37130d = f26;
        float f27 = f13 / f12;
        this.f37132f = f27;
        float f28 = ((f10 + f13) * f26) / 2.0f;
        float f29 = (f27 * f13) / 2.0f;
        this.f37131e = ((f11 - f28) - f29) / f13;
        this.f37133g = f28;
        this.f37134h = f11 - f29;
        this.f37135i = f11;
    }

    @Override // m0.m
    public float getInterpolation(float f10) {
        float fC = c(f10);
        this.f37140n = fC;
        this.f37141o = f10;
        boolean z10 = this.f37138l;
        float f11 = this.f37139m;
        return z10 ? f11 - fC : f11 + fC;
    }
}
