package u3;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final float f22888a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f22889b;

    /* renamed from: c, reason: collision with root package name */
    private final float f22890c;

    /* renamed from: d, reason: collision with root package name */
    private final float f22891d;

    /* renamed from: e, reason: collision with root package name */
    private final float f22892e;

    /* renamed from: f, reason: collision with root package name */
    private final float f22893f;

    /* renamed from: g, reason: collision with root package name */
    private final float f22894g;

    /* renamed from: h, reason: collision with root package name */
    private final float f22895h;

    /* renamed from: i, reason: collision with root package name */
    private final float f22896i;

    public e(float f5, float f6, float f7, float f8, float f9, float f10, boolean z5) {
        this.f22888a = f8;
        this.f22889b = z5;
        float fG = kotlin.ranges.l.g(f5 - f7, 0.0f, kotlin.ranges.l.a(f5, 0.0f));
        this.f22890c = fG;
        float fD = kotlin.ranges.l.d(kotlin.ranges.l.a(f10 * f5, f6), fG);
        this.f22891d = fD;
        float fA = kotlin.ranges.l.a(fG - fD, 0.0f);
        this.f22892e = fA;
        float fMin = Math.min(f8, 0.1f * fA);
        this.f22893f = fMin;
        float fMin2 = Math.min(f9 * f5, kotlin.ranges.l.a(fA - fMin, 0.0f) * 0.8f);
        this.f22894g = fMin2;
        this.f22895h = (fG - fMin) - fMin2;
        this.f22896i = f5;
    }

    public final float a(float f5) {
        if (this.f22889b) {
            return this.f22892e;
        }
        if (f5 > 1.0f) {
            return this.f22894g;
        }
        float f6 = this.f22892e;
        return f6 + ((this.f22894g - f6) * f5);
    }

    public final float b(float f5) {
        if (this.f22889b) {
            return 0.0f;
        }
        return this.f22893f * kotlin.ranges.l.g(f5, 0.0f, 1.0f);
    }

    public final float c(float f5) {
        if (this.f22889b) {
            float f6 = this.f22891d;
            return ((f5 - f6) * 2.0f) / kotlin.ranges.l.a(this.f22896i - f6, 1.0f);
        }
        float f7 = this.f22895h;
        if (f5 > f7) {
            return ((f5 - f7) / kotlin.ranges.l.a(this.f22896i - f7, 1.0f)) + 1.0f;
        }
        float f8 = this.f22891d;
        return (f5 - f8) / kotlin.ranges.l.a(f7 - f8, 1.0f);
    }

    public final float d(float f5) {
        float f6;
        float f7;
        if (this.f22889b) {
            f6 = this.f22891d;
            f7 = ((this.f22896i - f6) * f5) / 2.0f;
        } else {
            if (f5 > 1.0f) {
                float f8 = this.f22895h;
                return f8 + ((this.f22896i - f8) * (f5 - 1.0f));
            }
            f6 = this.f22891d;
            f7 = (this.f22895h - f6) * f5;
        }
        return f6 + f7;
    }

    public /* synthetic */ e(float f5, float f6, float f7, float f8, float f9, float f10, boolean z5, int i5, j4.g gVar) {
        this(f5, f6, f7, f8, f9, f10, (i5 & 64) != 0 ? false : z5);
    }
}
