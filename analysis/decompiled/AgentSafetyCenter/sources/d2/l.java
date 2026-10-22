package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends m {

    /* renamed from: a, reason: collision with root package name */
    public String f3137a;

    /* renamed from: b, reason: collision with root package name */
    public j0 f3138b;

    @Override // d2.m
    public final j0 a() {
        return this.f3138b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f3137a.equals(lVar.f3137a) && yb.k.a(this.f3138b, lVar.f3138b);
    }

    public final int hashCode() {
        int iHashCode = this.f3137a.hashCode() * 31;
        j0 j0Var = this.f3138b;
        return (iHashCode + (j0Var != null ? j0Var.hashCode() : 0)) * 31;
    }

    public final String toString() {
        return k0.a.s(new StringBuilder("LinkAnnotation.Url(url="), this.f3137a, ')');
    }
}
