package h5;

import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f4185a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4186b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4187c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4188d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4189e;

    /* renamed from: f, reason: collision with root package name */
    public final String f4190f;

    /* renamed from: g, reason: collision with root package name */
    public final String f4191g;

    /* renamed from: h, reason: collision with root package name */
    public final long f4192h;

    /* renamed from: i, reason: collision with root package name */
    public final e f4193i;

    public d(String str, String str2, String str3, String str4, long j2, String str5, String str6, long j4, e eVar) {
        k.e(str, "downstreamId");
        k.e(str2, "upstreamId");
        k.e(str3, "upstreamConnId");
        k.e(str4, "downstreamConnId");
        k.e(eVar, "state");
        this.f4185a = str;
        this.f4186b = str2;
        this.f4187c = str3;
        this.f4188d = str4;
        this.f4189e = j2;
        this.f4190f = str5;
        this.f4191g = str6;
        this.f4192h = j4;
        this.f4193i = eVar;
    }

    public static d a(d dVar, e eVar) {
        String str = dVar.f4185a;
        String str2 = dVar.f4186b;
        String str3 = dVar.f4187c;
        String str4 = dVar.f4188d;
        long j2 = dVar.f4189e;
        String str5 = dVar.f4190f;
        String str6 = dVar.f4191g;
        long j4 = dVar.f4192h;
        k.e(str, "downstreamId");
        k.e(str2, "upstreamId");
        k.e(str3, "upstreamConnId");
        k.e(str4, "downstreamConnId");
        k.e(eVar, "state");
        return new d(str, str2, str3, str4, j2, str5, str6, j4, eVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.a(this.f4185a, dVar.f4185a) && k.a(this.f4186b, dVar.f4186b) && k.a(this.f4187c, dVar.f4187c) && k.a(this.f4188d, dVar.f4188d) && this.f4189e == dVar.f4189e && k.a(this.f4190f, dVar.f4190f) && k.a(this.f4191g, dVar.f4191g) && this.f4192h == dVar.f4192h && this.f4193i == dVar.f4193i;
    }

    public final int hashCode() {
        int iF = x.f(this.f4189e, x.g(this.f4188d, x.g(this.f4187c, x.g(this.f4186b, this.f4185a.hashCode() * 31, 31), 31), 31), 31);
        String str = this.f4190f;
        int iHashCode = (iF + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f4191g;
        return this.f4193i.hashCode() + x.f(this.f4192h, (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("Mapping(downstreamId=", this.f4185a, ", upstreamId=", this.f4186b, ", upstreamConnId=");
        x.w(sbP, this.f4187c, ", downstreamConnId=", this.f4188d, ", timeoutMs=");
        sbP.append(this.f4189e);
        sbP.append(", command=");
        sbP.append(this.f4190f);
        sbP.append(", idempotencyKey=");
        sbP.append(this.f4191g);
        sbP.append(", createdAt=");
        sbP.append(this.f4192h);
        sbP.append(", state=");
        sbP.append(this.f4193i);
        sbP.append(")");
        return sbP.toString();
    }
}
