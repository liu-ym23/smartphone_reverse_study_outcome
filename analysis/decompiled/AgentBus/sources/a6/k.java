package a6;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f336a;

    /* renamed from: b, reason: collision with root package name */
    public final String f337b;

    /* renamed from: c, reason: collision with root package name */
    public final String f338c;

    /* renamed from: d, reason: collision with root package name */
    public final String f339d;

    /* renamed from: e, reason: collision with root package name */
    public final String f340e;

    public /* synthetic */ k() {
        this("anthropic", "claude-opus-4-7", null, null, null);
    }

    public static k a(k kVar, String str, String str2, String str3, String str4, int i2) {
        if ((i2 & 1) != 0) {
            str = kVar.f336a;
        }
        String str5 = str;
        if ((i2 & 2) != 0) {
            str2 = kVar.f337b;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = kVar.f338c;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = kVar.f339d;
        }
        String str8 = str4;
        String str9 = (i2 & 16) != 0 ? kVar.f340e : null;
        kVar.getClass();
        q7.k.e(str5, "provider");
        q7.k.e(str6, "model");
        return new k(str5, str6, str7, str8, str9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return q7.k.a(this.f336a, kVar.f336a) && q7.k.a(this.f337b, kVar.f337b) && q7.k.a(this.f338c, kVar.f338c) && q7.k.a(this.f339d, kVar.f339d) && q7.k.a(this.f340e, kVar.f340e);
    }

    public final int hashCode() {
        int iG = m.x.g(this.f337b, this.f336a.hashCode() * 31, 31);
        String str = this.f338c;
        int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f339d;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f340e;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("ModelConfig(provider=", this.f336a, ", model=", this.f337b, ", baseUrl=");
        m.x.w(sbP, this.f338c, ", api=", this.f339d, ", apiKey=");
        return a1.a.m(sbP, this.f340e, ")");
    }

    public k(String str, String str2, String str3, String str4, String str5) {
        q7.k.e(str, "provider");
        q7.k.e(str2, "model");
        this.f336a = str;
        this.f337b = str2;
        this.f338c = str3;
        this.f339d = str4;
        this.f340e = str5;
    }
}
