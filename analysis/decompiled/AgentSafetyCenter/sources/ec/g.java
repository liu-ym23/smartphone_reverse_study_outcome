package ec;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends f implements d {

    /* renamed from: h, reason: collision with root package name */
    public static final g f3761h = new g(1, 0, 1);

    @Override // ec.d
    public final Comparable a() {
        return Integer.valueOf(this.f3758c);
    }

    @Override // ec.d
    public final Comparable b() {
        return Integer.valueOf(this.f3759f);
    }

    @Override // ec.f
    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        if (isEmpty() && ((g) obj).isEmpty()) {
            return true;
        }
        g gVar = (g) obj;
        return this.f3758c == gVar.f3758c && this.f3759f == gVar.f3759f;
    }

    @Override // ec.f
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f3758c * 31) + this.f3759f;
    }

    @Override // ec.f
    public final boolean isEmpty() {
        return this.f3758c > this.f3759f;
    }

    @Override // ec.f
    public final String toString() {
        return this.f3758c + ".." + this.f3759f;
    }
}
