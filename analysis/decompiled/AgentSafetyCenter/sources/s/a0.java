package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 implements y {

    /* renamed from: a, reason: collision with root package name */
    public int f10934a;

    /* renamed from: b, reason: collision with root package name */
    public int f10935b;

    /* renamed from: c, reason: collision with root package name */
    public v f10936c;

    /* renamed from: d, reason: collision with root package name */
    public long f10937d;

    /* renamed from: e, reason: collision with root package name */
    public long f10938e;

    @Override // s.y
    public final float b(long j10, float f5, float f10, float f11) {
        long jR = p5.f.r(j10 - this.f10938e, 0L, this.f10937d);
        if (jR < 0) {
            return 0.0f;
        }
        if (jR == 0) {
            return f11;
        }
        return (e(jR, f5, f10, f11) - e(jR - 1000000, f5, f10, f11)) * 1000.0f;
    }

    @Override // s.y
    public final long c(float f5, float f10, float f11) {
        return (this.f10935b + this.f10934a) * 1000000;
    }

    @Override // s.y
    public final float e(long j10, float f5, float f10, float f11) {
        float fR = this.f10934a == 0 ? 1.0f : p5.f.r(j10 - this.f10938e, 0L, this.f10937d) / this.f10937d;
        v vVar = this.f10936c;
        if (fR < 0.0f) {
            fR = 0.0f;
        }
        float fA = vVar.a(fR <= 1.0f ? fR : 1.0f);
        n6.a aVar = i1.f11026a;
        return (f10 * fA) + ((1 - fA) * f5);
    }
}
