package y5;

import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f11670a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11671b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11672c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11673d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11674e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11675f;

    /* renamed from: g, reason: collision with root package name */
    public final String f11676g;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f11670a = str;
        this.f11671b = str2;
        this.f11672c = str3;
        this.f11673d = str4;
        this.f11674e = str5;
        this.f11675f = str6;
        this.f11676g = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a(this.f11670a, bVar.f11670a) && k.a(this.f11671b, bVar.f11671b) && k.a(this.f11672c, bVar.f11672c) && k.a(this.f11673d, bVar.f11673d) && k.a(this.f11674e, bVar.f11674e) && k.a(this.f11675f, bVar.f11675f) && k.a(this.f11676g, bVar.f11676g);
    }

    public final int hashCode() {
        int iG = x.g(this.f11674e, x.g(this.f11673d, x.g(this.f11672c, x.g(this.f11671b, this.f11670a.hashCode() * 31, 31), 31), 31), 31);
        String str = this.f11675f;
        int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f11676g;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("CallToolEvent(requestId=", this.f11670a, ", callId=", this.f11671b, ", toolId=");
        x.w(sbP, this.f11672c, ", toolName=", this.f11673d, ", params=");
        x.w(sbP, this.f11674e, ", traceId=", this.f11675f, ", sessionId=");
        return a1.a.m(sbP, this.f11676g, ")");
    }
}
