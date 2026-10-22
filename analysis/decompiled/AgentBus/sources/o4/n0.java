package o4;

/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7464a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7465b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7466c;

    /* renamed from: d, reason: collision with root package name */
    public final j0 f7467d;

    public n0(String str, boolean z4, String str2, j0 j0Var) {
        this.f7464a = str;
        this.f7465b = z4;
        this.f7466c = str2;
        this.f7467d = j0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return q7.k.a(this.f7464a, n0Var.f7464a) && this.f7465b == n0Var.f7465b && q7.k.a(this.f7466c, n0Var.f7466c) && q7.k.a(this.f7467d, n0Var.f7467d);
    }

    public final int hashCode() {
        int iE = m.x.e(this.f7464a.hashCode() * 31, 31, this.f7465b);
        String str = this.f7466c;
        int iHashCode = (iE + (str == null ? 0 : str.hashCode())) * 31;
        j0 j0Var = this.f7467d;
        return iHashCode + (j0Var != null ? j0Var.hashCode() : 0);
    }

    public final String toString() {
        return "RpcResponse(id=" + this.f7464a + ", ok=" + this.f7465b + ", payloadJson=" + this.f7466c + ", error=" + this.f7467d + ")";
    }
}
