package o4;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7419a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7420b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7421c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7422d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f7423e;

    public k0(String str, String str2, String str3, String str4, Long l6) {
        this.f7419a = str;
        this.f7420b = str2;
        this.f7421c = str3;
        this.f7422d = str4;
        this.f7423e = l6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return q7.k.a(this.f7419a, k0Var.f7419a) && q7.k.a(this.f7420b, k0Var.f7420b) && q7.k.a(this.f7421c, k0Var.f7421c) && q7.k.a(this.f7422d, k0Var.f7422d) && q7.k.a(this.f7423e, k0Var.f7423e);
    }

    public final int hashCode() {
        int iG = m.x.g(this.f7421c, m.x.g(this.f7420b, this.f7419a.hashCode() * 31, 31), 31);
        String str = this.f7422d;
        int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
        Long l6 = this.f7423e;
        return iHashCode + (l6 != null ? l6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("InvokeRequest(id=", this.f7419a, ", nodeId=", this.f7420b, ", command=");
        m.x.w(sbP, this.f7421c, ", paramsJson=", this.f7422d, ", timeoutMs=");
        sbP.append(this.f7423e);
        sbP.append(")");
        return sbP.toString();
    }
}
