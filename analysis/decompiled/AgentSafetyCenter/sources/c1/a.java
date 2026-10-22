package c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public float f2161a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f2162b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public float f2163c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f2164d = 0.0f;

    public final void a(float f5, float f10, float f11, float f12) {
        this.f2161a = Math.max(f5, this.f2161a);
        this.f2162b = Math.max(f10, this.f2162b);
        this.f2163c = Math.min(f11, this.f2163c);
        this.f2164d = Math.min(f12, this.f2164d);
    }

    public final boolean b() {
        return (this.f2161a >= this.f2163c) | (this.f2162b >= this.f2164d);
    }

    public final String toString() {
        return "MutableRect(" + id.c.L(this.f2161a) + ", " + id.c.L(this.f2162b) + ", " + id.c.L(this.f2163c) + ", " + id.c.L(this.f2164d) + ')';
    }
}
