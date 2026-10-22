package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: a, reason: collision with root package name */
    public n f11060a;

    /* renamed from: b, reason: collision with root package name */
    public v f11061b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return yb.k.a(this.f11060a, n1Var.f11060a) && yb.k.a(this.f11061b, n1Var.f11061b);
    }

    public final int hashCode() {
        return Integer.hashCode(0) + ((this.f11061b.hashCode() + (this.f11060a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "VectorizedKeyframeSpecElementInfo(vectorValue=" + this.f11060a + ", easing=" + this.f11061b + ", arcMode=ArcMode(value=0))";
    }
}
