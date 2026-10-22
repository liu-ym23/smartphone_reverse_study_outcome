package o4;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f7543a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7544b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7545c;

    /* renamed from: d, reason: collision with root package name */
    public String f7546d;

    /* renamed from: e, reason: collision with root package name */
    public Map f7547e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f7548f = null;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f7549g = null;

    public s(String str, String str2, String str3, Map map) {
        this.f7543a = str;
        this.f7544b = str2;
        this.f7545c = map;
        this.f7546d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f7543a.equals(sVar.f7543a) && this.f7544b.equals(sVar.f7544b) && this.f7545c.equals(sVar.f7545c) && this.f7546d.equals(sVar.f7546d) && q7.k.a(this.f7547e, sVar.f7547e) && q7.k.a(this.f7548f, sVar.f7548f) && q7.k.a(this.f7549g, sVar.f7549g);
    }

    public final int hashCode() {
        int iG = m.x.g(this.f7546d, (this.f7545c.hashCode() + m.x.g(this.f7544b, this.f7543a.hashCode() * 31, 31)) * 31, 31);
        Map map = this.f7547e;
        int iHashCode = (iG + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.f7548f;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        HashMap map2 = this.f7549g;
        return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
    }

    public final String toString() {
        String str = this.f7546d;
        Map map = this.f7547e;
        String str2 = this.f7548f;
        HashMap map2 = this.f7549g;
        StringBuilder sbP = a1.a.p("ToolCallState(id=", this.f7543a, ", name=", this.f7544b, ", arguments=");
        sbP.append(this.f7545c);
        sbP.append(", status=");
        sbP.append(str);
        sbP.append(", result=");
        sbP.append(map);
        sbP.append(", errorMessage=");
        sbP.append(str2);
        sbP.append(", update=");
        sbP.append(map2);
        sbP.append(")");
        return sbP.toString();
    }
}
