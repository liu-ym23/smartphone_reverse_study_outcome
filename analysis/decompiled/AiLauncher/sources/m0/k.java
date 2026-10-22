package m0;

/* loaded from: classes.dex */
public class k implements m {

    /* renamed from: c, reason: collision with root package name */
    public double f37117c;

    /* renamed from: d, reason: collision with root package name */
    public double f37118d;

    /* renamed from: e, reason: collision with root package name */
    public double f37119e;

    /* renamed from: f, reason: collision with root package name */
    public float f37120f;

    /* renamed from: g, reason: collision with root package name */
    public float f37121g;

    /* renamed from: h, reason: collision with root package name */
    public float f37122h;

    /* renamed from: i, reason: collision with root package name */
    public float f37123i;

    /* renamed from: j, reason: collision with root package name */
    public float f37124j;

    /* renamed from: a, reason: collision with root package name */
    public double f37115a = 0.5d;

    /* renamed from: b, reason: collision with root package name */
    public boolean f37116b = false;

    /* renamed from: k, reason: collision with root package name */
    public int f37125k = 0;

    @Override // m0.m
    public float a() {
        return 0.0f;
    }

    @Override // m0.m
    public boolean b() {
        double d10 = this.f37121g - this.f37118d;
        double d11 = this.f37117c;
        double d12 = this.f37122h;
        return Math.sqrt((((d12 * d12) * ((double) this.f37123i)) + ((d11 * d10) * d10)) / d11) <= ((double) this.f37124j);
    }

    public final void c(double d10) {
        if (d10 <= 0.0d) {
            return;
        }
        double d11 = this.f37117c;
        double d12 = this.f37115a;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d11 / this.f37123i) * d10) * 4.0d)) + 1.0d);
        double d13 = d10 / iSqrt;
        int i10 = 0;
        while (i10 < iSqrt) {
            float f10 = this.f37121g;
            double d14 = this.f37118d;
            float f11 = this.f37122h;
            double d15 = d11;
            double d16 = ((-d11) * (f10 - d14)) - (f11 * d12);
            float f12 = this.f37123i;
            double d17 = d12;
            double d18 = f11 + (((d16 / f12) * d13) / 2.0d);
            double d19 = ((((-((f10 + ((d13 * d18) / 2.0d)) - d14)) * d15) - (d18 * d17)) / f12) * d13;
            double d20 = f11 + (d19 / 2.0d);
            float f13 = f11 + ((float) d19);
            this.f37122h = f13;
            float f14 = f10 + ((float) (d20 * d13));
            this.f37121g = f14;
            int i11 = this.f37125k;
            if (i11 > 0) {
                if (f14 < 0.0f && (i11 & 1) == 1) {
                    this.f37121g = -f14;
                    this.f37122h = -f13;
                }
                float f15 = this.f37121g;
                if (f15 > 1.0f && (i11 & 2) == 2) {
                    this.f37121g = 2.0f - f15;
                    this.f37122h = -this.f37122h;
                }
            }
            i10++;
            d11 = d15;
            d12 = d17;
        }
    }

    public void d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i10) {
        this.f37118d = f11;
        this.f37115a = f15;
        this.f37116b = false;
        this.f37121g = f10;
        this.f37119e = f12;
        this.f37117c = f14;
        this.f37123i = f13;
        this.f37124j = f16;
        this.f37125k = i10;
        this.f37120f = 0.0f;
    }

    @Override // m0.m
    public float getInterpolation(float f10) {
        c(f10 - this.f37120f);
        this.f37120f = f10;
        if (b()) {
            this.f37121g = (float) this.f37118d;
        }
        return this.f37121g;
    }
}
