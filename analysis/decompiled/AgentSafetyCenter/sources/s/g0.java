package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public Float f11013a;

    /* renamed from: b, reason: collision with root package name */
    public v f11014b;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return yb.k.a(g0Var.f11013a, this.f11013a) && yb.k.a(g0Var.f11014b, this.f11014b);
    }

    public final int hashCode() {
        Float f5 = this.f11013a;
        return this.f11014b.hashCode() + f.b(0, (f5 != null ? f5.hashCode() : 0) * 31, 31);
    }
}
