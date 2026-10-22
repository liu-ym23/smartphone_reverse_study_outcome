package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public e0 f3128a;

    /* renamed from: b, reason: collision with root package name */
    public e0 f3129b;

    /* renamed from: c, reason: collision with root package name */
    public e0 f3130c;

    /* renamed from: d, reason: collision with root package name */
    public e0 f3131d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return yb.k.a(this.f3128a, j0Var.f3128a) && yb.k.a(this.f3129b, j0Var.f3129b) && yb.k.a(this.f3130c, j0Var.f3130c) && yb.k.a(this.f3131d, j0Var.f3131d);
    }

    public final int hashCode() {
        e0 e0Var = this.f3128a;
        int iHashCode = (e0Var != null ? e0Var.hashCode() : 0) * 31;
        e0 e0Var2 = this.f3129b;
        int iHashCode2 = (iHashCode + (e0Var2 != null ? e0Var2.hashCode() : 0)) * 31;
        e0 e0Var3 = this.f3130c;
        int iHashCode3 = (iHashCode2 + (e0Var3 != null ? e0Var3.hashCode() : 0)) * 31;
        e0 e0Var4 = this.f3131d;
        return iHashCode3 + (e0Var4 != null ? e0Var4.hashCode() : 0);
    }
}
