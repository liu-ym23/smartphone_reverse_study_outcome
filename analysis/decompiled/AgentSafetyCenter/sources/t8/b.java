package t8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f13210a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13211b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13212c;

    /* renamed from: d, reason: collision with root package name */
    public final a f13213d;

    /* renamed from: e, reason: collision with root package name */
    public final String f13214e;

    /* renamed from: f, reason: collision with root package name */
    public final String f13215f;

    /* renamed from: g, reason: collision with root package name */
    public final long f13216g;

    public b(String str, String str2, String str3, a aVar, String str4, String str5, long j10) {
        str3.getClass();
        aVar.getClass();
        this.f13210a = str;
        this.f13211b = str2;
        this.f13212c = str3;
        this.f13213d = aVar;
        this.f13214e = str4;
        this.f13215f = str5;
        this.f13216g = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return yb.k.a(this.f13210a, bVar.f13210a) && yb.k.a(this.f13211b, bVar.f13211b) && yb.k.a(this.f13212c, bVar.f13212c) && this.f13213d == bVar.f13213d && yb.k.a(this.f13214e, bVar.f13214e) && yb.k.a(this.f13215f, bVar.f13215f) && this.f13216g == bVar.f13216g;
    }

    public final int hashCode() {
        int iHashCode = (this.f13213d.hashCode() + androidx.activity.b.d(androidx.activity.b.d(this.f13210a.hashCode() * 31, 31, this.f13211b), 31, this.f13212c)) * 31;
        String str = this.f13214e;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f13215f;
        return Long.hashCode(this.f13216g) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbP = androidx.activity.b.p("DeleteReceipt(stepId=", this.f13210a, ", originalPath=", this.f13211b, ", normalizedPath=");
        sbP.append(this.f13212c);
        sbP.append(", deleteMethod=");
        sbP.append(this.f13213d);
        sbP.append(", trashUri=");
        androidx.activity.b.u(sbP, this.f13214e, ", trashRealPath=", this.f13215f, ", deletedAtMs=");
        sbP.append(this.f13216g);
        sbP.append(")");
        return sbP.toString();
    }
}
