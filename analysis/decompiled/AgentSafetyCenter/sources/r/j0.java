package r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final s.x f10308a;

    public j0(s.x xVar) {
        this.f10308a = xVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j0) {
            return Float.compare(0.0f, 0.0f) == 0 && yb.k.a(this.f10308a, ((j0) obj).f10308a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10308a.hashCode() + (Float.hashCode(0.0f) * 31);
    }

    public final String toString() {
        return "Fade(alpha=0.0, animationSpec=" + this.f10308a + ')';
    }
}
