package a5;

import m.x;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f251a;

    /* renamed from: b, reason: collision with root package name */
    public final String f252b;

    /* renamed from: c, reason: collision with root package name */
    public final String f253c;

    /* renamed from: d, reason: collision with root package name */
    public final String f254d;

    /* renamed from: e, reason: collision with root package name */
    public final String f255e;

    /* renamed from: f, reason: collision with root package name */
    public final String f256f;

    /* renamed from: g, reason: collision with root package name */
    public final long f257g;

    /* renamed from: h, reason: collision with root package name */
    public final long f258h;

    public i(String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f251a = str;
        this.f252b = str2;
        this.f253c = str3;
        this.f254d = str4;
        this.f255e = str5;
        this.f256f = str6;
        this.f257g = j2;
        this.f258h = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return q7.k.a(this.f251a, iVar.f251a) && q7.k.a(this.f252b, iVar.f252b) && q7.k.a(this.f253c, iVar.f253c) && q7.k.a(this.f254d, iVar.f254d) && q7.k.a(this.f255e, iVar.f255e) && q7.k.a(this.f256f, iVar.f256f) && this.f257g == iVar.f257g && this.f258h == iVar.f258h;
    }

    public final int hashCode() {
        int iG = x.g(this.f254d, x.g(this.f253c, x.g(this.f252b, this.f251a.hashCode() * 31, 31), 31), 31);
        String str = this.f255e;
        int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f256f;
        return Long.hashCode(this.f258h) + x.f(this.f257g, (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("PushInvokeContext(upstreamId=", this.f251a, ", pushCallId=", this.f252b, ", toolName=");
        x.w(sbP, this.f253c, ", toolId=", this.f254d, ", sessionId=");
        x.w(sbP, this.f255e, ", traceId=", this.f256f, ", timeoutMs=");
        sbP.append(this.f257g);
        sbP.append(", createdAtMs=");
        sbP.append(this.f258h);
        sbP.append(")");
        return sbP.toString();
    }
}
