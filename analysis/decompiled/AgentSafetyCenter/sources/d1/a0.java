package d1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends c0 {

    /* renamed from: a, reason: collision with root package name */
    public final c1.c f2957a;

    public a0(c1.c cVar) {
        this.f2957a = cVar;
    }

    @Override // d1.c0
    public final c1.c a() {
        return this.f2957a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a0) {
            return this.f2957a.equals(((a0) obj).f2957a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2957a.hashCode();
    }
}
