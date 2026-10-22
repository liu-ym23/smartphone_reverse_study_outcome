package n;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public float f6642a;

    /* renamed from: b, reason: collision with root package name */
    public double f6643b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6644c;

    public final long a(float f10, float f11, long j2) {
        if (!this.f6644c) {
            if (this.f6642a == Float.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            this.f6644c = true;
        }
        float f12 = f10 - this.f6642a;
        double d6 = j2 / 1000.0d;
        double d10 = this.f6643b;
        double d11 = f12;
        double d12 = (d10 * d11) + f11;
        double d13 = (d12 * d6) + d11;
        double dExp = Math.exp((-d10) * d6) * d13;
        double dExp2 = Math.exp((-this.f6643b) * d6) * d13;
        double d14 = -this.f6643b;
        double dExp3 = (Math.exp(d14 * d6) * d12) + (dExp2 * d14);
        return (Float.floatToRawIntBits((float) dExp3) & 4294967295L) | (Float.floatToRawIntBits((float) (dExp + this.f6642a)) << 32);
    }
}
