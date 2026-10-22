package a9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final long f295a;

    /* renamed from: b, reason: collision with root package name */
    public final int f296b;

    /* renamed from: c, reason: collision with root package name */
    public final int f297c;

    /* renamed from: d, reason: collision with root package name */
    public final String f298d;

    public p(int i, int i3, long j10, String str) {
        str.getClass();
        this.f295a = j10;
        this.f296b = i;
        this.f297c = i3;
        this.f298d = str;
    }

    public static p a(p pVar, String str) {
        long j10 = pVar.f295a;
        int i = pVar.f296b;
        int i3 = pVar.f297c;
        str.getClass();
        return new p(i, i3, j10, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f295a == pVar.f295a && this.f296b == pVar.f296b && this.f297c == pVar.f297c && yb.k.a(this.f298d, pVar.f298d);
    }

    public final int hashCode() {
        return this.f298d.hashCode() + s.f.b(this.f297c, s.f.b(this.f296b, Long.hashCode(this.f295a) * 31, 31), 31);
    }

    public final String toString() {
        return "MediaInfo(id=" + this.f295a + ", mediaType=" + this.f296b + ", isTrashed=" + this.f297c + ", path=" + this.f298d + ")";
    }
}
