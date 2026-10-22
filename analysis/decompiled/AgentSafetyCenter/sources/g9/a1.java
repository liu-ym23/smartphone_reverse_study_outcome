package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4403a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4404b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4405c;

    public a1(String str, String str2, long j10) {
        str.getClass();
        str2.getClass();
        this.f4403a = str;
        this.f4404b = str2;
        this.f4405c = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a1)) {
            return false;
        }
        a1 a1Var = (a1) obj;
        return yb.k.a(this.f4403a, a1Var.f4403a) && yb.k.a(this.f4404b, a1Var.f4404b) && this.f4405c == a1Var.f4405c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f4405c) + androidx.activity.b.d(this.f4403a.hashCode() * 31, 31, this.f4404b);
    }

    public final String toString() {
        StringBuilder sbP = androidx.activity.b.p("PermissionPendingUpdate(groupId=", this.f4403a, ", mode=", this.f4404b, ", updateTimeMs=");
        sbP.append(this.f4405c);
        sbP.append(")");
        return sbP.toString();
    }
}
