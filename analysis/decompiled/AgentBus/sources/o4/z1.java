package o4;

/* loaded from: classes.dex */
public final class z1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7717a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7718b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7719c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7720d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7721e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7722f;

    /* renamed from: g, reason: collision with root package name */
    public final String f7723g;

    /* renamed from: h, reason: collision with root package name */
    public final String f7724h;

    /* renamed from: i, reason: collision with root package name */
    public final String f7725i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f7726j;

    public z1(String str, String str2, String str3, int i2, boolean z4, String str4, String str5, String str6, String str7, boolean z10) {
        q7.k.e(str, "stableId");
        q7.k.e(str2, "name");
        q7.k.e(str3, "host");
        this.f7717a = str;
        this.f7718b = str2;
        this.f7719c = str3;
        this.f7720d = i2;
        this.f7721e = z4;
        this.f7722f = str4;
        this.f7723g = str5;
        this.f7724h = str6;
        this.f7725i = str7;
        this.f7726j = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z1)) {
            return false;
        }
        z1 z1Var = (z1) obj;
        return q7.k.a(this.f7717a, z1Var.f7717a) && q7.k.a(this.f7718b, z1Var.f7718b) && q7.k.a(this.f7719c, z1Var.f7719c) && this.f7720d == z1Var.f7720d && this.f7721e == z1Var.f7721e && q7.k.a(this.f7722f, z1Var.f7722f) && q7.k.a(this.f7723g, z1Var.f7723g) && q7.k.a(this.f7724h, z1Var.f7724h) && q7.k.a(this.f7725i, z1Var.f7725i) && this.f7726j == z1Var.f7726j;
    }

    public final int hashCode() {
        int iE = m.x.e(n.f.b(this.f7720d, m.x.g(this.f7719c, m.x.g(this.f7718b, this.f7717a.hashCode() * 31, 31), 31), 31), 31, this.f7721e);
        String str = this.f7722f;
        int iHashCode = (iE + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f7723g;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f7724h;
        return Boolean.hashCode(this.f7726j) + m.x.g(this.f7725i, (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("OpenClawGatewayEndpoint(stableId=", this.f7717a, ", name=", this.f7718b, ", host=");
        sbP.append(this.f7719c);
        sbP.append(", port=");
        sbP.append(this.f7720d);
        sbP.append(", tlsEnabled=");
        sbP.append(this.f7721e);
        sbP.append(", tlsFingerprintSha256=");
        sbP.append(this.f7722f);
        sbP.append(", lanHost=");
        m.x.w(sbP, this.f7723g, ", tailnetDns=", this.f7724h, ", path=");
        sbP.append(this.f7725i);
        sbP.append(", isCloud=");
        sbP.append(this.f7726j);
        sbP.append(")");
        return sbP.toString();
    }

    public /* synthetic */ z1(String str, String str2, String str3, int i2, boolean z4, String str4, String str5, int i10) {
        this(str, str2, str3, i2, z4, str4, (i10 & 64) != 0 ? null : str5, null, "", false);
    }
}
