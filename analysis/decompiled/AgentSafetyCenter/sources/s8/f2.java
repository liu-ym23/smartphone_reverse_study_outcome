package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f11599a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11600b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11601c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11602d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11603e;

    public f2(String str, String str2, String str3, String str4, String str5) {
        str2.getClass();
        str3.getClass();
        this.f11599a = str;
        this.f11600b = str2;
        this.f11601c = str3;
        this.f11602d = str4;
        this.f11603e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        f2 f2Var = (f2) obj;
        return this.f11599a.equals(f2Var.f11599a) && yb.k.a(this.f11600b, f2Var.f11600b) && yb.k.a(this.f11601c, f2Var.f11601c) && yb.k.a(this.f11602d, f2Var.f11602d) && this.f11603e.equals(f2Var.f11603e);
    }

    public final int hashCode() {
        int iD = androidx.activity.b.d(androidx.activity.b.d(this.f11599a.hashCode() * 31, 31, this.f11600b), 31, this.f11601c);
        String str = this.f11602d;
        return this.f11603e.hashCode() + ((iD + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sbP = androidx.activity.b.p("InterceptedRow(rowKey=", this.f11599a, ", title=", this.f11600b, ", subtitle=");
        androidx.activity.b.u(sbP, this.f11601c, ", actorBadge=", this.f11602d, ", linkedTaskTitle=");
        return androidx.activity.b.n(sbP, this.f11603e, ")");
    }
}
