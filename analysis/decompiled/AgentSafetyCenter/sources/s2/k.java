package s2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11354a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11355b;

    /* renamed from: c, reason: collision with root package name */
    public final n f11356c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11357d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11358e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11359f;

    public k() {
        n nVar = n.f11365c;
        this.f11354a = true;
        this.f11355b = true;
        this.f11356c = nVar;
        this.f11357d = true;
        this.f11358e = true;
        this.f11359f = "";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f11354a == kVar.f11354a && this.f11355b == kVar.f11355b && this.f11356c == kVar.f11356c && this.f11357d == kVar.f11357d && this.f11358e == kVar.f11358e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11358e) + k0.a.h((this.f11356c.hashCode() + k0.a.h(Boolean.hashCode(this.f11354a) * 31, 31, this.f11355b)) * 31, 31, this.f11357d);
    }
}
