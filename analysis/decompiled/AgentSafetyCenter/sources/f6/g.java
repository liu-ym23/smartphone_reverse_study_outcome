package f6;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final g f3926c;

    /* renamed from: a, reason: collision with root package name */
    public final p5.f f3927a;

    /* renamed from: b, reason: collision with root package name */
    public final p5.f f3928b;

    static {
        b bVar = b.f3917c;
        f3926c = new g(bVar, bVar);
    }

    public g(p5.f fVar, p5.f fVar2) {
        this.f3927a = fVar;
        this.f3928b = fVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f3927a.equals(gVar.f3927a) && this.f3928b.equals(gVar.f3928b);
    }

    public final int hashCode() {
        return this.f3928b.hashCode() + (this.f3927a.hashCode() * 31);
    }

    public final String toString() {
        return "Size(width=" + this.f3927a + ", height=" + this.f3928b + ')';
    }
}
