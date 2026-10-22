package r3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f10435a;

    /* renamed from: b, reason: collision with root package name */
    public int f10436b;

    /* renamed from: c, reason: collision with root package name */
    public float f10437c;

    /* renamed from: d, reason: collision with root package name */
    public float f10438d;

    /* renamed from: e, reason: collision with root package name */
    public long f10439e;

    /* renamed from: f, reason: collision with root package name */
    public long f10440f;

    /* renamed from: g, reason: collision with root package name */
    public long f10441g;

    /* renamed from: h, reason: collision with root package name */
    public float f10442h;
    public int i;

    public final float a(long j10) {
        if (j10 < this.f10439e) {
            return 0.0f;
        }
        long j11 = this.f10441g;
        if (j11 < 0 || j10 < j11) {
            return c.b((j10 - r0) / this.f10435a, 0.0f, 1.0f) * 0.5f;
        }
        float f5 = this.f10442h;
        return (c.b((j10 - j11) / this.i, 0.0f, 1.0f) * f5) + (1.0f - f5);
    }
}
