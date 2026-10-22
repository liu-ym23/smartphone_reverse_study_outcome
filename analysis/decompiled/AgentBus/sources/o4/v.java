package o4;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final String f7657a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7658b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7659c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7660d;

    public v(String str, String str2, String str3, int i2, String str4) {
        str4 = (i2 & 128) != 0 ? "android" : str4;
        q7.k.e(str, "id");
        q7.k.e(str4, "platform");
        this.f7657a = str;
        this.f7658b = str2;
        this.f7659c = str3;
        this.f7660d = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return q7.k.a(this.f7657a, vVar.f7657a) && q7.k.a(this.f7658b, vVar.f7658b) && this.f7659c.equals(vVar.f7659c) && this.f7660d.equals(vVar.f7660d);
    }

    public final int hashCode() {
        int iHashCode = this.f7657a.hashCode() * 31;
        String str = this.f7658b;
        return this.f7660d.hashCode() + m.x.g(this.f7659c, (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + 46670518) * 31, 923521);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("OpenClawClientInfo(id=", this.f7657a, ", displayName=", this.f7658b, ", version=1.0.1, mode=");
        sbP.append(this.f7659c);
        sbP.append(", instanceId=null, deviceFamily=null, modelIdentifier=null, platform=");
        sbP.append(this.f7660d);
        sbP.append(")");
        return sbP.toString();
    }
}
