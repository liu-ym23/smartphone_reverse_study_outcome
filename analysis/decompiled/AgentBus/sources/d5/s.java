package d5;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final long f2899a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2900b;

    /* renamed from: c, reason: collision with root package name */
    public final double f2901c;

    public s(long j2, long j4, double d6) {
        this.f2899a = j2;
        this.f2900b = j4;
        this.f2901c = d6;
    }

    public final long a(int i2) {
        long j2 = this.f2899a;
        if (i2 <= 0) {
            return j2;
        }
        double d6 = j2;
        for (int i10 = 1; i10 < i2; i10++) {
            d6 *= this.f2901c;
        }
        double dMin = Math.min(d6, this.f2900b);
        return (long) ((Math.random() * 0.2d * dMin) + dMin);
    }
}
