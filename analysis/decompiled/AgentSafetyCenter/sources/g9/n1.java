package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4543a;

    /* renamed from: b, reason: collision with root package name */
    public final z0 f4544b;

    /* renamed from: c, reason: collision with root package name */
    public final s0 f4545c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4546d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4547e;

    public n1(String str, z0 z0Var, s0 s0Var, boolean z10, long j10) {
        str.getClass();
        z0Var.getClass();
        this.f4543a = str;
        this.f4544b = z0Var;
        this.f4545c = s0Var;
        this.f4546d = z10;
        this.f4547e = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return yb.k.a(this.f4543a, n1Var.f4543a) && this.f4544b == n1Var.f4544b && this.f4545c == n1Var.f4545c && this.f4546d == n1Var.f4546d && this.f4547e == n1Var.f4547e;
    }

    public final int hashCode() {
        return Long.hashCode(this.f4547e) + k0.a.h((this.f4545c.hashCode() + ((this.f4544b.hashCode() + (this.f4543a.hashCode() * 31)) * 31)) * 31, 31, this.f4546d);
    }

    public final String toString() {
        return "PermissionSnapshotItem(permissionKey=" + this.f4543a + ", selectedOption=" + this.f4544b + ", templateType=" + this.f4545c + ", exposed=" + this.f4546d + ", lastUpdatedMs=" + this.f4547e + ")";
    }
}
