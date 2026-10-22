package a6;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f284a;

    /* renamed from: b, reason: collision with root package name */
    public final String f285b;

    /* renamed from: c, reason: collision with root package name */
    public final String f286c;

    /* renamed from: d, reason: collision with root package name */
    public final String f287d;

    /* renamed from: e, reason: collision with root package name */
    public final List f288e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f289f;

    /* renamed from: g, reason: collision with root package name */
    public final c0 f290g;

    /* renamed from: h, reason: collision with root package name */
    public final String f291h;

    /* renamed from: i, reason: collision with root package name */
    public final i f292i;

    /* renamed from: j, reason: collision with root package name */
    public final Long f293j;

    /* renamed from: k, reason: collision with root package name */
    public final Map f294k;

    public b0(String str, String str2, String str3, String str4, List list, boolean z4, c0 c0Var, String str5, i iVar, Long l6, Map map) {
        q7.k.e(str, "id");
        q7.k.e(str2, "name");
        q7.k.e(list, "tags");
        q7.k.e(c0Var, "type");
        q7.k.e(iVar, "source");
        this.f284a = str;
        this.f285b = str2;
        this.f286c = str3;
        this.f287d = str4;
        this.f288e = list;
        this.f289f = z4;
        this.f290g = c0Var;
        this.f291h = str5;
        this.f292i = iVar;
        this.f293j = l6;
        this.f294k = map;
    }

    public static b0 a(b0 b0Var, boolean z4, Long l6, int i2) {
        String str = b0Var.f284a;
        String str2 = b0Var.f285b;
        String str3 = b0Var.f286c;
        String str4 = b0Var.f287d;
        List list = b0Var.f288e;
        if ((i2 & 32) != 0) {
            z4 = b0Var.f289f;
        }
        boolean z10 = z4;
        c0 c0Var = b0Var.f290g;
        String str5 = b0Var.f291h;
        i iVar = b0Var.f292i;
        if ((i2 & 512) != 0) {
            l6 = b0Var.f293j;
        }
        Map map = b0Var.f294k;
        q7.k.e(str, "id");
        q7.k.e(str2, "name");
        q7.k.e(list, "tags");
        q7.k.e(c0Var, "type");
        q7.k.e(iVar, "source");
        q7.k.e(map, "metadata");
        return new b0(str, str2, str3, str4, list, z10, c0Var, str5, iVar, l6, map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return q7.k.a(this.f284a, b0Var.f284a) && q7.k.a(this.f285b, b0Var.f285b) && q7.k.a(this.f286c, b0Var.f286c) && q7.k.a(this.f287d, b0Var.f287d) && q7.k.a(this.f288e, b0Var.f288e) && this.f289f == b0Var.f289f && this.f290g == b0Var.f290g && q7.k.a(this.f291h, b0Var.f291h) && this.f292i == b0Var.f292i && q7.k.a(this.f293j, b0Var.f293j) && q7.k.a(this.f294k, b0Var.f294k);
    }

    public final int hashCode() {
        int iG = m.x.g(this.f285b, this.f284a.hashCode() * 31, 31);
        String str = this.f286c;
        int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f287d;
        int iHashCode2 = (this.f290g.hashCode() + m.x.e(m.x.h(this.f288e, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31), 31, this.f289f)) * 31;
        String str3 = this.f291h;
        int iHashCode3 = (this.f292i.hashCode() + ((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31;
        Long l6 = this.f293j;
        return this.f294k.hashCode() + ((iHashCode3 + (l6 != null ? l6.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("ToolSpec(id=", this.f284a, ", name=", this.f285b, ", description=");
        m.x.w(sbP, this.f286c, ", version=", this.f287d, ", tags=");
        sbP.append(this.f288e);
        sbP.append(", isEnabled=");
        sbP.append(this.f289f);
        sbP.append(", type=");
        sbP.append(this.f290g);
        sbP.append(", category=");
        sbP.append(this.f291h);
        sbP.append(", source=");
        sbP.append(this.f292i);
        sbP.append(", modifiedAtMs=");
        sbP.append(this.f293j);
        sbP.append(", metadata=");
        sbP.append(this.f294k);
        sbP.append(")");
        return sbP.toString();
    }

    public /* synthetic */ b0(String str, String str2, String str3, String str4, List list, boolean z4, c0 c0Var, String str5, i iVar, Long l6, int i2) {
        this(str, str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? d7.z.f2978f : list, (i2 & 32) != 0 ? true : z4, c0Var, (i2 & 128) != 0 ? null : str5, iVar, (i2 & 512) != 0 ? null : l6, d7.a0.f2944f);
    }
}
