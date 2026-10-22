package a6;

import java.util.Map;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f319a;

    /* renamed from: b, reason: collision with root package name */
    public final String f320b;

    /* renamed from: c, reason: collision with root package name */
    public final String f321c;

    /* renamed from: d, reason: collision with root package name */
    public final i f322d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f323e;

    /* renamed from: f, reason: collision with root package name */
    public final String f324f;

    public h(String str, String str2, String str3, i iVar, Map map, String str4) {
        q7.k.e(iVar, "source");
        this.f319a = str;
        this.f320b = str2;
        this.f321c = str3;
        this.f322d = iVar;
        this.f323e = map;
        this.f324f = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return q7.k.a(this.f319a, hVar.f319a) && q7.k.a(this.f320b, hVar.f320b) && q7.k.a(this.f321c, hVar.f321c) && this.f322d == hVar.f322d && q7.k.a(this.f323e, hVar.f323e) && q7.k.a(this.f324f, hVar.f324f);
    }

    public final int hashCode() {
        int iHashCode = (this.f323e.hashCode() + ((this.f322d.hashCode() + m.x.g(this.f321c, m.x.g(this.f320b, this.f319a.hashCode() * 31, 31), 31)) * 31)) * 31;
        String str = this.f324f;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("InstallRequest(id=", this.f319a, ", version=", this.f320b, ", blobRef=");
        sbP.append(this.f321c);
        sbP.append(", source=");
        sbP.append(this.f322d);
        sbP.append(", extras=");
        sbP.append(this.f323e);
        sbP.append(", catalogDescription=");
        sbP.append(this.f324f);
        sbP.append(")");
        return sbP.toString();
    }
}
