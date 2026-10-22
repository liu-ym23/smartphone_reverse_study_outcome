package a6;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final String f341a;

    /* renamed from: b, reason: collision with root package name */
    public final String f342b;

    /* renamed from: c, reason: collision with root package name */
    public final String f343c;

    /* renamed from: d, reason: collision with root package name */
    public final String f344d;

    /* renamed from: e, reason: collision with root package name */
    public final String f345e;

    public l(String str, String str2, String str3, String str4, String str5) {
        this.f341a = str;
        this.f342b = str2;
        this.f343c = str3;
        this.f344d = str4;
        this.f345e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return q7.k.a(this.f341a, lVar.f341a) && q7.k.a(this.f342b, lVar.f342b) && q7.k.a(this.f343c, lVar.f343c) && q7.k.a(this.f344d, lVar.f344d) && q7.k.a(this.f345e, lVar.f345e);
    }

    public final int hashCode() {
        String str = this.f341a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f342b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f343c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f344d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f345e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("ModelConfigPatch(provider=", this.f341a, ", model=", this.f342b, ", baseUrl=");
        m.x.w(sbP, this.f343c, ", api=", this.f344d, ", apiKey=");
        return a1.a.m(sbP, this.f345e, ")");
    }
}
