package n;

/* loaded from: classes.dex */
public final class y implements w {

    /* renamed from: a, reason: collision with root package name */
    public final int f6760a;

    /* renamed from: b, reason: collision with root package name */
    public final t f6761b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6762c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6763d = 0 * 1000000;

    public y(int i2, t tVar) {
        this.f6760a = i2;
        this.f6761b = tVar;
        this.f6762c = i2 * 1000000;
    }

    @Override // n.w
    public final float b(long j2, float f10, float f11, float f12) {
        float fL = this.f6760a == 0 ? 1.0f : nb.i.l(j2 - this.f6763d, 0L, this.f6762c) / this.f6762c;
        if (fL < 0.0f) {
            fL = 0.0f;
        }
        float fA = this.f6761b.a(fL <= 1.0f ? fL : 1.0f);
        q6.b bVar = g1.f6621a;
        return (f11 * fA) + ((1 - fA) * f10);
    }

    @Override // n.w
    public final float c(long j2, float f10, float f11, float f12) {
        long jL = nb.i.l(j2 - this.f6763d, 0L, this.f6762c);
        if (jL < 0) {
            return 0.0f;
        }
        if (jL == 0) {
            return f12;
        }
        return (b(jL, f10, f11, f12) - b(jL - 1000000, f10, f11, f12)) * 1000.0f;
    }

    @Override // n.w
    public final long d(float f10, float f11, float f12) {
        return this.f6760a * 1000000;
    }
}
