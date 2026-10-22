package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public z.b f13471a;

    /* renamed from: b, reason: collision with root package name */
    public kc.g f13472b;

    public final String toString() {
        kc.g gVar = this.f13472b;
        kc.s sVar = (kc.s) gVar.i.get(kc.s.f7477f);
        String str = sVar != null ? sVar.f7478c : null;
        StringBuilder sb2 = new StringBuilder("Request@");
        int iHashCode = hashCode();
        com.stepos.statsrpk.h.f(16);
        String string = Integer.toString(iHashCode, 16);
        string.getClass();
        sb2.append(string);
        sb2.append(str != null ? k0.a.C("[", str, "](") : "(");
        sb2.append("currentBounds()=");
        sb2.append(this.f13471a.invoke());
        sb2.append(", continuation=");
        sb2.append(gVar);
        sb2.append(')');
        return sb2.toString();
    }
}
