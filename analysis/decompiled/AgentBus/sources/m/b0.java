package m;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f6042a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6043b;

    public b0(float f10, d2.c cVar) {
        this.f6042a = f10;
        float fC = cVar.c();
        float f11 = c0.f6046a;
        this.f6043b = fC * 386.0878f * 160.0f * 0.84f;
    }

    public final a0 a(float f10) {
        double dB = b(f10);
        double d6 = c0.f6046a;
        double d10 = d6 - 1.0d;
        return new a0(f10, (float) (Math.exp((d6 / d10) * dB) * this.f6042a * this.f6043b), (long) (Math.exp(dB / d10) * 1000.0d));
    }

    public final double b(float f10) {
        float[] fArr = b.f6041a;
        return Math.log((Math.abs(f10) * 0.35f) / (this.f6042a * this.f6043b));
    }
}
