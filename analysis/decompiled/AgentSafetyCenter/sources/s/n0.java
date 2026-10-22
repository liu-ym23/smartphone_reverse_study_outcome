package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public float f11057a;

    /* renamed from: b, reason: collision with root package name */
    public double f11058b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11059c;

    public final long a(float f5, float f10, long j10) {
        if (!this.f11059c) {
            if (this.f11057a == Float.MAX_VALUE) {
                od.f.e("Error: Final position of the spring must be set before the animation starts");
                return 0L;
            }
            this.f11059c = true;
        }
        float f11 = f5 - this.f11057a;
        double d7 = j10 / 1000.0d;
        double d10 = this.f11058b;
        double d11 = f11;
        double d12 = (d10 * d11) + f10;
        double d13 = (d12 * d7) + d11;
        double dExp = Math.exp((-d10) * d7) * d13;
        double dExp2 = Math.exp((-this.f11058b) * d7) * d13;
        double d14 = -this.f11058b;
        double dExp3 = (Math.exp(d14 * d7) * d12) + (dExp2 * d14);
        return (Float.floatToRawIntBits((float) dExp3) & 4294967295L) | (Float.floatToRawIntBits((float) (dExp + this.f11057a)) << 32);
    }
}
