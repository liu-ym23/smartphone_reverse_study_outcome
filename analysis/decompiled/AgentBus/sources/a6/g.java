package a6;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f314a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f315b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f316c;

    /* renamed from: d, reason: collision with root package name */
    public final String f317d;

    /* renamed from: e, reason: collision with root package name */
    public final String f318e;

    public g(boolean z4, boolean z10, Long l6, String str, String str2) {
        this.f314a = z4;
        this.f315b = z10;
        this.f316c = l6;
        this.f317d = str;
        this.f318e = str2;
    }

    public final Long a() {
        return this.f316c;
    }

    public final boolean b() {
        return this.f315b;
    }

    public final String c() {
        return this.f317d;
    }

    public final String d() {
        return this.f318e;
    }

    public final boolean e() {
        return this.f314a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f314a == gVar.f314a && this.f315b == gVar.f315b && q7.k.a(this.f316c, gVar.f316c) && q7.k.a(this.f317d, gVar.f317d) && q7.k.a(this.f318e, gVar.f318e);
    }

    public final int hashCode() {
        int iE = m.x.e(Boolean.hashCode(this.f314a) * 31, 31, this.f315b);
        Long l6 = this.f316c;
        int iHashCode = (iE + (l6 == null ? 0 : l6.hashCode())) * 31;
        String str = this.f317d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f318e;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("GatewayStatus(isReady=");
        sb2.append(this.f314a);
        sb2.append(", processAlive=");
        sb2.append(this.f315b);
        sb2.append(", pid=");
        sb2.append(this.f316c);
        sb2.append(", vendor=");
        sb2.append(this.f317d);
        sb2.append(", version=");
        return a1.a.m(sb2, this.f318e, ")");
    }
}
