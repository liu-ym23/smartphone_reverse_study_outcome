package a6;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final String f389a;

    /* renamed from: b, reason: collision with root package name */
    public final String f390b;

    /* renamed from: c, reason: collision with root package name */
    public final String f391c;

    /* renamed from: d, reason: collision with root package name */
    public final String f392d;

    /* renamed from: e, reason: collision with root package name */
    public final List f393e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f394f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f395g;

    /* renamed from: h, reason: collision with root package name */
    public final i f396h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f397i;

    /* renamed from: j, reason: collision with root package name */
    public final Map f398j;

    public z(String str, String str2, String str3, String str4, List list, boolean z4, boolean z10, i iVar, Long l6, Map map) {
        q7.k.e(list, "tags");
        q7.k.e(iVar, "source");
        this.f389a = str;
        this.f390b = str2;
        this.f391c = str3;
        this.f392d = str4;
        this.f393e = list;
        this.f394f = z4;
        this.f395g = z10;
        this.f396h = iVar;
        this.f397i = l6;
        this.f398j = map;
    }

    public static z a(z zVar, boolean z4, Long l6, int i2) {
        String str = zVar.f389a;
        String str2 = zVar.f390b;
        String str3 = zVar.f391c;
        String str4 = zVar.f392d;
        List list = zVar.f393e;
        if ((i2 & 32) != 0) {
            z4 = zVar.f394f;
        }
        boolean z10 = z4;
        boolean z11 = zVar.f395g;
        i iVar = zVar.f396h;
        if ((i2 & 256) != 0) {
            l6 = zVar.f397i;
        }
        Map map = zVar.f398j;
        q7.k.e(str, "id");
        q7.k.e(str2, "name");
        q7.k.e(list, "tags");
        q7.k.e(iVar, "source");
        q7.k.e(map, "metadata");
        return new z(str, str2, str3, str4, list, z10, z11, iVar, l6, map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return q7.k.a(this.f389a, zVar.f389a) && q7.k.a(this.f390b, zVar.f390b) && q7.k.a(this.f391c, zVar.f391c) && q7.k.a(this.f392d, zVar.f392d) && q7.k.a(this.f393e, zVar.f393e) && this.f394f == zVar.f394f && this.f395g == zVar.f395g && this.f396h == zVar.f396h && q7.k.a(this.f397i, zVar.f397i) && q7.k.a(this.f398j, zVar.f398j);
    }

    public final int hashCode() {
        int iG = m.x.g(this.f390b, this.f389a.hashCode() * 31, 31);
        String str = this.f391c;
        int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f392d;
        int iHashCode2 = (this.f396h.hashCode() + m.x.e(m.x.e(m.x.h(this.f393e, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31), 31, this.f394f), 31, this.f395g)) * 31;
        Long l6 = this.f397i;
        return this.f398j.hashCode() + ((iHashCode2 + (l6 != null ? l6.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("SkillSpec(id=", this.f389a, ", name=", this.f390b, ", description=");
        m.x.w(sbP, this.f391c, ", version=", this.f392d, ", tags=");
        sbP.append(this.f393e);
        sbP.append(", isEnabled=");
        sbP.append(this.f394f);
        sbP.append(", hasSkillMd=");
        sbP.append(this.f395g);
        sbP.append(", source=");
        sbP.append(this.f396h);
        sbP.append(", modifiedAtMs=");
        sbP.append(this.f397i);
        sbP.append(", metadata=");
        sbP.append(this.f398j);
        sbP.append(")");
        return sbP.toString();
    }

    public /* synthetic */ z(String str, String str2, String str3, String str4, List list, boolean z4, boolean z10, i iVar, Long l6, int i2) {
        this(str, str2, (i2 & 4) != 0 ? null : str3, str4, (i2 & 16) != 0 ? d7.z.f2978f : list, (i2 & 32) != 0 ? true : z4, z10, iVar, l6, d7.a0.f2944f);
    }
}
