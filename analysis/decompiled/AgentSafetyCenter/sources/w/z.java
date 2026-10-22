package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends t.c1 {

    /* renamed from: a, reason: collision with root package name */
    public w0.c f15067a;

    @Override // t.c1
    public final int c(int i, o2.l lVar, s1.o0 o0Var, int i3) {
        return this.f15067a.a(0, i, lVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof z) && yb.k.a(this.f15067a, ((z) obj).f15067a);
    }

    public final int hashCode() {
        return Float.hashCode(this.f15067a.f15104a);
    }

    public final String toString() {
        return "HorizontalCrossAxisAlignment(horizontal=" + this.f15067a + ')';
    }
}
