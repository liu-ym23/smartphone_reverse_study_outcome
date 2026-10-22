package o4;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final String f7688a;

    /* renamed from: b, reason: collision with root package name */
    public final List f7689b;

    /* renamed from: c, reason: collision with root package name */
    public final List f7690c;

    /* renamed from: d, reason: collision with root package name */
    public final List f7691d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f7692e;

    /* renamed from: f, reason: collision with root package name */
    public final v f7693f;

    /* renamed from: g, reason: collision with root package name */
    public final String f7694g;

    /* renamed from: h, reason: collision with root package name */
    public final String f7695h;

    public y(String str, List list, List list2, List list3, Map map, v vVar, String str2, String str3) {
        q7.k.e(str, "role");
        q7.k.e(list, "scopes");
        q7.k.e(list2, "caps");
        q7.k.e(list3, "commands");
        q7.k.e(map, "permissions");
        q7.k.e(vVar, "client");
        this.f7688a = str;
        this.f7689b = list;
        this.f7690c = list2;
        this.f7691d = list3;
        this.f7692e = map;
        this.f7693f = vVar;
        this.f7694g = str2;
        this.f7695h = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return q7.k.a(this.f7688a, yVar.f7688a) && q7.k.a(this.f7689b, yVar.f7689b) && q7.k.a(this.f7690c, yVar.f7690c) && q7.k.a(this.f7691d, yVar.f7691d) && q7.k.a(this.f7692e, yVar.f7692e) && q7.k.a(this.f7693f, yVar.f7693f) && q7.k.a(this.f7694g, yVar.f7694g) && q7.k.a(this.f7695h, yVar.f7695h);
    }

    public final int hashCode() {
        int iHashCode = (this.f7693f.hashCode() + ((this.f7692e.hashCode() + m.x.h(this.f7691d, m.x.h(this.f7690c, m.x.h(this.f7689b, this.f7688a.hashCode() * 31, 31), 31), 31)) * 31)) * 31;
        String str = this.f7694g;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f7695h;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "OpenClawConnectOptions(role=" + this.f7688a + ", scopes=" + this.f7689b + ", caps=" + this.f7690c + ", commands=" + this.f7691d + ", permissions=" + this.f7692e + ", client=" + this.f7693f + ", userAgent=" + this.f7694g + ", locale=" + this.f7695h + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ y(String str, List list, List list2, List list3, v vVar, int i2) {
        int i10 = i2 & 2;
        d7.z zVar = d7.z.f2978f;
        this(str, i10 != 0 ? zVar : list, list2, (i2 & 8) != 0 ? zVar : list3, d7.a0.f2944f, vVar, null, null);
    }
}
