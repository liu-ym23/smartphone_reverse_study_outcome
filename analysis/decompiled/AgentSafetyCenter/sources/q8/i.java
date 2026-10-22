package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f10121a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10122b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10123c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10124d;

    /* renamed from: e, reason: collision with root package name */
    public final long f10125e;

    public i(long j10, String str, int i, int i3, long j11) {
        str.getClass();
        this.f10121a = j10;
        this.f10122b = str;
        this.f10123c = i;
        this.f10124d = i3;
        this.f10125e = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f10121a == iVar.f10121a && yb.k.a(this.f10122b, iVar.f10122b) && this.f10123c == iVar.f10123c && this.f10124d == iVar.f10124d && this.f10125e == iVar.f10125e;
    }

    public final int hashCode() {
        return Long.hashCode(this.f10125e) + s.f.b(this.f10124d, s.f.b(this.f10123c, androidx.activity.b.d(Long.hashCode(this.f10121a) * 31, 31, this.f10122b), 31), 31);
    }

    public final String toString() {
        return "DashboardDayEntity(dayStartMillis=" + this.f10121a + ", resultJson=" + this.f10122b + ", opsCount=" + this.f10123c + ", risksCount=" + this.f10124d + ", syncedAtMillis=" + this.f10125e + ")";
    }
}
