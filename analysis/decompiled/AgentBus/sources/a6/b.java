package a6;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f275a;

    /* renamed from: b, reason: collision with root package name */
    public final String f276b;

    /* renamed from: c, reason: collision with root package name */
    public final String f277c;

    /* renamed from: d, reason: collision with root package name */
    public final String f278d;

    /* renamed from: e, reason: collision with root package name */
    public final String f279e;

    /* renamed from: f, reason: collision with root package name */
    public final List f280f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f281g;

    /* renamed from: h, reason: collision with root package name */
    public final String f282h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f283i;

    public b(String str, String str2, String str3, String str4, String str5, List list, boolean z4, String str6, Map map) {
        q7.k.e(str, "id");
        q7.k.e(str2, "channelId");
        q7.k.e(str3, "name");
        q7.k.e(list, "tags");
        q7.k.e(map, "metadata");
        this.f275a = str;
        this.f276b = str2;
        this.f277c = str3;
        this.f278d = str4;
        this.f279e = str5;
        this.f280f = list;
        this.f281g = z4;
        this.f282h = str6;
        this.f283i = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return q7.k.a(this.f275a, bVar.f275a) && q7.k.a(this.f276b, bVar.f276b) && q7.k.a(this.f277c, bVar.f277c) && q7.k.a(this.f278d, bVar.f278d) && q7.k.a(this.f279e, bVar.f279e) && q7.k.a(this.f280f, bVar.f280f) && this.f281g == bVar.f281g && q7.k.a(this.f282h, bVar.f282h) && q7.k.a(this.f283i, bVar.f283i);
    }

    public final int hashCode() {
        int iG = m.x.g(this.f277c, m.x.g(this.f276b, this.f275a.hashCode() * 31, 31), 31);
        String str = this.f278d;
        int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f279e;
        int iE = m.x.e(m.x.h(this.f280f, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31), 31, this.f281g);
        String str3 = this.f282h;
        return this.f283i.hashCode() + ((iE + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("ChannelSpec(id=", this.f275a, ", channelId=", this.f276b, ", name=");
        m.x.w(sbP, this.f277c, ", status=", this.f278d, ", version=");
        sbP.append(this.f279e);
        sbP.append(", tags=");
        sbP.append(this.f280f);
        sbP.append(", isEnabled=");
        sbP.append(this.f281g);
        sbP.append(", description=");
        sbP.append(this.f282h);
        sbP.append(", metadata=");
        sbP.append(this.f283i);
        sbP.append(")");
        return sbP.toString();
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, List list, boolean z4, String str6, int i2) {
        this(str, str2, str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? d7.z.f2978f : list, (i2 & 64) != 0 ? true : z4, (i2 & 128) != 0 ? null : str6, d7.a0.f2944f);
    }
}
