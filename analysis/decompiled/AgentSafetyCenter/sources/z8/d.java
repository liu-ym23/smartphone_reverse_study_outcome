package z8;

import s8.p3;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public p3 f16496a;

    /* renamed from: b, reason: collision with root package name */
    public String f16497b;

    /* renamed from: c, reason: collision with root package name */
    public a f16498c;

    /* renamed from: d, reason: collision with root package name */
    public String f16499d;

    /* renamed from: e, reason: collision with root package name */
    public String f16500e;

    /* renamed from: f, reason: collision with root package name */
    public String f16501f;

    /* renamed from: g, reason: collision with root package name */
    public String f16502g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f16496a.equals(dVar.f16496a) && k.a(this.f16497b, dVar.f16497b) && this.f16498c == dVar.f16498c && this.f16499d.equals(dVar.f16499d) && k.a(this.f16500e, dVar.f16500e) && k.a(this.f16501f, dVar.f16501f) && k.a(this.f16502g, dVar.f16502g);
    }

    public final int hashCode() {
        int iHashCode = this.f16496a.hashCode() * 31;
        String str = this.f16497b;
        int iD = androidx.activity.b.d((this.f16498c.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31, 31, this.f16499d);
        String str2 = this.f16500e;
        return this.f16502g.hashCode() + androidx.activity.b.d((iD + (str2 != null ? str2.hashCode() : 0)) * 31, 31, this.f16501f);
    }

    public final String toString() {
        p3 p3Var = this.f16496a;
        String str = this.f16497b;
        a aVar = this.f16498c;
        String str2 = this.f16499d;
        String str3 = this.f16500e;
        String str4 = this.f16501f;
        String str5 = this.f16502g;
        StringBuilder sb2 = new StringBuilder("ParsedStepLine(line=");
        sb2.append(p3Var);
        sb2.append(", severity=");
        sb2.append(str);
        sb2.append(", interceptionStatus=");
        sb2.append(aVar);
        sb2.append(", why=");
        sb2.append(str2);
        sb2.append(", messageId=");
        androidx.activity.b.u(sb2, str3, ", stepIdTrim=", str4, ", whenIso=");
        return androidx.activity.b.n(sb2, str5, ")");
    }
}
