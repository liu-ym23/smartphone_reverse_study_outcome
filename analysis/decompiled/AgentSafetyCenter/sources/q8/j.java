package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final long f10126a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10127b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10128c;

    /* renamed from: d, reason: collision with root package name */
    public final long f10129d;

    public j(int i, int i3, long j10, long j11) {
        this.f10126a = j10;
        this.f10127b = i;
        this.f10128c = i3;
        this.f10129d = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f10126a == jVar.f10126a && this.f10127b == jVar.f10127b && this.f10128c == jVar.f10128c && this.f10129d == jVar.f10129d;
    }

    public final int hashCode() {
        return Long.hashCode(this.f10129d) + s.f.b(this.f10128c, s.f.b(this.f10127b, Long.hashCode(this.f10126a) * 31, 31), 31);
    }

    public final String toString() {
        return "DashboardDayMeta(dayStartMillis=" + this.f10126a + ", opsCount=" + this.f10127b + ", risksCount=" + this.f10128c + ", syncedAtMillis=" + this.f10129d + ")";
    }
}
