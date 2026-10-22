package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: s, reason: collision with root package name */
    public static float[] f11076s;

    /* renamed from: a, reason: collision with root package name */
    public float f11077a;

    /* renamed from: b, reason: collision with root package name */
    public float f11078b;

    /* renamed from: c, reason: collision with root package name */
    public float f11079c;

    /* renamed from: d, reason: collision with root package name */
    public float f11080d;

    /* renamed from: e, reason: collision with root package name */
    public float f11081e;

    /* renamed from: f, reason: collision with root package name */
    public float f11082f;

    /* renamed from: g, reason: collision with root package name */
    public float f11083g;

    /* renamed from: h, reason: collision with root package name */
    public float f11084h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float[] f11085j;

    /* renamed from: k, reason: collision with root package name */
    public float f11086k;

    /* renamed from: l, reason: collision with root package name */
    public float f11087l;

    /* renamed from: m, reason: collision with root package name */
    public float f11088m;

    /* renamed from: n, reason: collision with root package name */
    public float f11089n;

    /* renamed from: o, reason: collision with root package name */
    public float f11090o;

    /* renamed from: p, reason: collision with root package name */
    public float f11091p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11092q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11093r;

    public final float a() {
        float f5 = this.f11087l * this.i;
        float fHypot = this.f11091p / ((float) Math.hypot(f5, (-this.f11088m) * this.f11084h));
        return this.f11092q ? (-f5) * fHypot : f5 * fHypot;
    }

    public final float b() {
        float f5 = this.f11087l * this.i;
        float f10 = (-this.f11088m) * this.f11084h;
        float fHypot = this.f11091p / ((float) Math.hypot(f5, f10));
        return this.f11092q ? (-f10) * fHypot : f10 * fHypot;
    }

    public final void c(float f5) {
        float f10 = (this.f11092q ? this.f11078b - f5 : f5 - this.f11077a) * this.f11086k;
        float f11 = 0.0f;
        if (f10 > 0.0f) {
            f11 = 1.0f;
            if (f10 < 1.0f) {
                float[] fArr = this.f11085j;
                float length = f10 * (fArr.length - 1);
                int i = (int) length;
                float f12 = fArr[i];
                f11 = k0.a.f(fArr[i + 1], f12, length - i, f12);
            }
        }
        double d7 = f11 * 1.5707964f;
        this.f11084h = (float) Math.sin(d7);
        this.i = (float) Math.cos(d7);
    }
}
