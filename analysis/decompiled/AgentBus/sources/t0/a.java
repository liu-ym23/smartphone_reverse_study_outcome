package t0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public float f9650a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f9651b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public float f9652c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f9653d = 0.0f;

    public final void a(float f10, float f11, float f12, float f13) {
        this.f9650a = Math.max(f10, this.f9650a);
        this.f9651b = Math.max(f11, this.f9651b);
        this.f9652c = Math.min(f12, this.f9652c);
        this.f9653d = Math.min(f13, this.f9653d);
    }

    public final boolean b() {
        return (this.f9650a >= this.f9652c) | (this.f9651b >= this.f9653d);
    }

    public final String toString() {
        return "MutableRect(" + n7.a.D(this.f9650a) + ", " + n7.a.D(this.f9651b) + ", " + n7.a.D(this.f9652c) + ", " + n7.a.D(this.f9653d) + ')';
    }
}
