package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    public String f4615a;

    /* renamed from: b, reason: collision with root package name */
    public u0 f4616b;

    /* renamed from: c, reason: collision with root package name */
    public String f4617c;

    /* renamed from: d, reason: collision with root package name */
    public z0 f4618d;

    /* renamed from: e, reason: collision with root package name */
    public z0 f4619e;

    /* renamed from: f, reason: collision with root package name */
    public s0 f4620f;

    /* renamed from: g, reason: collision with root package name */
    public long f4621g;

    /* renamed from: h, reason: collision with root package name */
    public String f4622h;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f4615a.equals(t0Var.f4615a) && this.f4616b == t0Var.f4616b && yb.k.a(this.f4617c, t0Var.f4617c) && this.f4618d == t0Var.f4618d && this.f4619e == t0Var.f4619e && this.f4620f == t0Var.f4620f && this.f4621g == t0Var.f4621g && this.f4622h.equals(t0Var.f4622h);
    }

    public final int hashCode() {
        int iD = androidx.activity.b.d((this.f4616b.hashCode() + (this.f4615a.hashCode() * 31)) * 31, 31, this.f4617c);
        z0 z0Var = this.f4618d;
        int iHashCode = (iD + (z0Var == null ? 0 : z0Var.hashCode())) * 31;
        z0 z0Var2 = this.f4619e;
        return this.f4622h.hashCode() + k0.a.i(this.f4621g, (this.f4620f.hashCode() + ((iHashCode + (z0Var2 != null ? z0Var2.hashCode() : 0)) * 31)) * 31, 31);
    }

    public final String toString() {
        return "PermissionEvent(eventId=" + this.f4615a + ", eventType=" + this.f4616b + ", permissionKey=" + this.f4617c + ", fromOption=" + this.f4618d + ", toOption=" + this.f4619e + ", templateType=" + this.f4620f + ", timestampMs=" + this.f4621g + ", source=" + this.f4622h + ")";
    }
}
