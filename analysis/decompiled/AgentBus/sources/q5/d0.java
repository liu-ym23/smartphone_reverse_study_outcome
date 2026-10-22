package q5;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f8673a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8674b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8675c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8676d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8677e;

    public d0(String str, String str2, int i2) {
        this.f8673a = str;
        this.f8674b = str2;
        this.f8675c = i2;
        boolean Z = ga.r.Z(str, ".*", false);
        this.f8676d = Z;
        this.f8677e = Z ? ga.k.m0(str) : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f8673a.equals(d0Var.f8673a) && q7.k.a(this.f8674b, d0Var.f8674b) && this.f8675c == d0Var.f8675c;
    }

    public final int hashCode() {
        int iHashCode = this.f8673a.hashCode() * 31;
        String str = this.f8674b;
        return Integer.hashCode(this.f8675c) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("StaticRoute(pattern=", this.f8673a, ", targetVendor=", this.f8674b, ", priority=");
        sbP.append(this.f8675c);
        sbP.append(")");
        return sbP.toString();
    }
}
