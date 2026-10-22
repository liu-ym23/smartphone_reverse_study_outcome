package e2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f3419a;

    /* renamed from: b, reason: collision with root package name */
    public int f3420b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3421c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3419a == cVar.f3419a && this.f3420b == cVar.f3420b && this.f3421c == cVar.f3421c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f3421c) + s.f.b(this.f3420b, Integer.hashCode(this.f3419a) * 31, 31);
    }

    public final String toString() {
        return "BidiRun(start=" + this.f3419a + ", end=" + this.f3420b + ", isRtl=" + this.f3421c + ')';
    }
}
