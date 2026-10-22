package z5;

import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f11815a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11816b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11817c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11818d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11819e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11820f;

    public g(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f11815a = str;
        this.f11816b = str2;
        this.f11817c = str3;
        this.f11818d = str4;
        this.f11819e = str5;
        this.f11820f = str6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return k.a(this.f11815a, gVar.f11815a) && k.a(this.f11816b, gVar.f11816b) && k.a(this.f11817c, gVar.f11817c) && k.a(this.f11818d, gVar.f11818d) && k.a(this.f11819e, gVar.f11819e) && k.a(this.f11820f, gVar.f11820f);
    }

    public final int hashCode() {
        return this.f11820f.hashCode() + x.g(this.f11819e, x.g(this.f11818d, x.g(this.f11817c, x.g(this.f11816b, this.f11815a.hashCode() * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("NodeInvokeReportContext(traceId=", this.f11815a, ", sessionId=", this.f11816b, ", toolCallId=");
        x.w(sbP, this.f11817c, ", toolName=", this.f11818d, ", command=");
        sbP.append(this.f11819e);
        sbP.append(", paramsSummary=");
        sbP.append(this.f11820f);
        sbP.append(")");
        return sbP.toString();
    }
}
