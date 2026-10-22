package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public s1.z0 f15045a;

    /* renamed from: b, reason: collision with root package name */
    public long f15046b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ androidx.compose.foundation.layout.a f15047c;

    public final float a() {
        s1.z0 z0Var = this.f15045a;
        long j10 = this.f15046b;
        if (o2.a.e(j10)) {
            return z0Var.J(o2.a.i(j10));
        }
        return Float.POSITIVE_INFINITY;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return yb.k.a(this.f15045a, tVar.f15045a) && o2.a.c(this.f15046b, tVar.f15046b);
    }

    public final int hashCode() {
        return Long.hashCode(this.f15046b) + (this.f15045a.hashCode() * 31);
    }

    public final String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.f15045a + ", constraints=" + ((Object) o2.a.m(this.f15046b)) + ')';
    }
}
