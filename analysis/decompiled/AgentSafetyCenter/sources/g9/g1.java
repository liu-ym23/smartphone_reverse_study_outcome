package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    public String f4463a;

    /* renamed from: b, reason: collision with root package name */
    public long f4464b;

    /* renamed from: c, reason: collision with root package name */
    public t0 f4465c;

    /* renamed from: d, reason: collision with root package name */
    public m1 f4466d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return this.f4463a.equals(g1Var.f4463a) && this.f4464b == g1Var.f4464b && yb.k.a(this.f4465c, g1Var.f4465c) && yb.k.a(this.f4466d, g1Var.f4466d);
    }

    public final int hashCode() {
        int iHashCode = (this.f4465c.hashCode() + s.f.b(1, k0.a.i(this.f4464b, this.f4463a.hashCode() * 31, 31), 31)) * 31;
        m1 m1Var = this.f4466d;
        return iHashCode + (m1Var == null ? 0 : m1Var.hashCode());
    }

    public final String toString() {
        return "PermissionReport(reportId=" + this.f4463a + ", reportedAtMs=" + this.f4464b + ", schemaVersion=1, event=" + this.f4465c + ", snapshot=" + this.f4466d + ")";
    }
}
