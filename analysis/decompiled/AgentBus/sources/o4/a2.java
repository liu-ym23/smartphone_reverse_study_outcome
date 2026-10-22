package o4;

/* loaded from: classes.dex */
public final class a2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7267a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7268b;

    /* renamed from: c, reason: collision with root package name */
    public final c5.b f7269c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7270d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7271e;

    /* renamed from: f, reason: collision with root package name */
    public final long f7272f;

    public /* synthetic */ a2(String str, String str2, c5.b bVar, String str3, long j2, int i2) {
        this(str, str2, (i2 & 4) != 0 ? null : bVar, (i2 & 8) != 0 ? null : str3, false, j2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a2)) {
            return false;
        }
        a2 a2Var = (a2) obj;
        return q7.k.a(this.f7267a, a2Var.f7267a) && q7.k.a(this.f7268b, a2Var.f7268b) && q7.k.a(this.f7269c, a2Var.f7269c) && q7.k.a(this.f7270d, a2Var.f7270d) && this.f7271e == a2Var.f7271e && this.f7272f == a2Var.f7272f;
    }

    public final int hashCode() {
        int iG = m.x.g(this.f7268b, this.f7267a.hashCode() * 31, 31);
        c5.b bVar = this.f7269c;
        int iHashCode = (iG + (bVar == null ? 0 : bVar.hashCode())) * 31;
        String str = this.f7270d;
        return Long.hashCode(this.f7272f) + m.x.e((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.f7271e);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("Entry(frameId=", this.f7267a, ", sessionKey=", this.f7268b, ", frame=");
        sbP.append(this.f7269c);
        sbP.append(", connectionId=");
        sbP.append(this.f7270d);
        sbP.append(", sent=");
        sbP.append(this.f7271e);
        sbP.append(", createdAtMs=");
        sbP.append(this.f7272f);
        sbP.append(")");
        return sbP.toString();
    }

    public a2(String str, String str2, c5.b bVar, String str3, boolean z4, long j2) {
        q7.k.e(str, "frameId");
        q7.k.e(str2, "sessionKey");
        this.f7267a = str;
        this.f7268b = str2;
        this.f7269c = bVar;
        this.f7270d = str3;
        this.f7271e = z4;
        this.f7272f = j2;
    }
}
