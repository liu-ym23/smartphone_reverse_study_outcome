package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends m {

    /* renamed from: a, reason: collision with root package name */
    public String f3132a;

    /* renamed from: b, reason: collision with root package name */
    public j0 f3133b;

    @Override // d2.m
    public final j0 a() {
        return this.f3133b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f3132a.equals(kVar.f3132a) && yb.k.a(this.f3133b, kVar.f3133b);
    }

    public final int hashCode() {
        int iHashCode = this.f3132a.hashCode() * 31;
        j0 j0Var = this.f3133b;
        return (iHashCode + (j0Var != null ? j0Var.hashCode() : 0)) * 31;
    }

    public final String toString() {
        return k0.a.s(new StringBuilder("LinkAnnotation.Clickable(tag="), this.f3132a, ')');
    }
}
