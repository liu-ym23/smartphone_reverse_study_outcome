package o4;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f7369a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7370b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7371c;

    public g(String str, String str2, String str3) {
        q7.k.e(str, "runId");
        this.f7369a = str;
        this.f7370b = str2;
        this.f7371c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return q7.k.a(this.f7369a, gVar.f7369a) && q7.k.a(this.f7370b, gVar.f7370b) && q7.k.a(this.f7371c, gVar.f7371c);
    }

    public final int hashCode() {
        return this.f7371c.hashCode() + m.x.g(this.f7370b, this.f7369a.hashCode() * 31, 31);
    }

    public final String toString() {
        return a1.a.m(a1.a.p("ActiveStreamingRun(runId=", this.f7369a, ", sessionKey=", this.f7370b, ", cachedText="), this.f7371c, ")");
    }
}
