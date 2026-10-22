package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y0 implements a1 {

    /* renamed from: a, reason: collision with root package name */
    public long f12114a;

    /* renamed from: b, reason: collision with root package name */
    public String f12115b;

    /* renamed from: c, reason: collision with root package name */
    public int f12116c;

    /* renamed from: d, reason: collision with root package name */
    public int f12117d;

    /* renamed from: e, reason: collision with root package name */
    public int f12118e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return this.f12114a == y0Var.f12114a && this.f12115b.equals(y0Var.f12115b) && this.f12116c == y0Var.f12116c && this.f12117d == y0Var.f12117d && this.f12118e == y0Var.f12118e;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f12118e) + s.f.b(this.f12117d, s.f.b(this.f12116c, androidx.activity.b.d(Long.hashCode(this.f12114a) * 31, 31, this.f12115b), 31), 31);
    }

    public final String toString() {
        return "SectionHeader(dayMillis=" + this.f12114a + ", title=" + this.f12115b + ", taskCount=" + this.f12116c + ", opCount=" + this.f12117d + ", interceptCount=" + this.f12118e + ")";
    }
}
