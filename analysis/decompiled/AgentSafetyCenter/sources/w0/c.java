package w0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final float f15104a;

    public c(float f5) {
        this.f15104a = f5;
    }

    public final int a(int i, int i3, o2.l lVar) {
        float f5 = (i3 - i) / 2.0f;
        o2.l lVar2 = o2.l.f9123c;
        float f10 = this.f15104a;
        if (lVar != lVar2) {
            f10 *= -1;
        }
        return Math.round((1 + f10) * f5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Float.compare(this.f15104a, ((c) obj).f15104a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f15104a);
    }

    public final String toString() {
        return k0.a.q(new StringBuilder("Horizontal(bias="), this.f15104a, ')');
    }
}
