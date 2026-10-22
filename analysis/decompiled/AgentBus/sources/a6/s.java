package a6;

/* loaded from: classes.dex */
public final class s implements k5.r {

    /* renamed from: a, reason: collision with root package name */
    public final String f366a;

    /* renamed from: b, reason: collision with root package name */
    public final String f367b;

    /* renamed from: c, reason: collision with root package name */
    public final String f368c;

    /* renamed from: d, reason: collision with root package name */
    public final long f369d;

    /* renamed from: e, reason: collision with root package name */
    public final long f370e;

    public s(String str, String str2, String str3, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f366a = str;
        this.f367b = str2;
        this.f368c = str3;
        this.f369d = j2;
        this.f370e = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return q7.k.a(this.f366a, sVar.f366a) && q7.k.a(this.f367b, sVar.f367b) && q7.k.a(this.f368c, sVar.f368c) && this.f369d == sVar.f369d && this.f370e == sVar.f370e;
    }

    public final int hashCode() {
        int iG = m.x.g(this.f367b, this.f366a.hashCode() * 31, 31);
        String str = this.f368c;
        return Long.hashCode(this.f370e) + m.x.f(this.f369d, (iG + (str == null ? 0 : str.hashCode())) * 31, 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("ResourceChanged(resource=", this.f366a, ", op=", this.f367b, ", id=");
        sbP.append(this.f368c);
        sbP.append(", revision=");
        sbP.append(this.f369d);
        sbP.append(", timestamp=");
        sbP.append(this.f370e);
        sbP.append(")");
        return sbP.toString();
    }
}
