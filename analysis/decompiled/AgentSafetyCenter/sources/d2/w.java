package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final v f3180a;

    public w(v vVar) {
        this.f3180a = vVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return yb.k.a(this.f3180a, ((w) obj).f3180a);
        }
        return false;
    }

    public final int hashCode() {
        v vVar = this.f3180a;
        if (vVar != null) {
            return vVar.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "PlatformTextStyle(spanStyle=null, paragraphSyle=" + this.f3180a + ')';
    }
}
