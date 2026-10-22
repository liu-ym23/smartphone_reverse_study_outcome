package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 extends w0.l implements u1.w {

    /* renamed from: s, reason: collision with root package name */
    public l0 f15009s;

    @Override // u1.w
    public final s1.g0 f(u1.o0 o0Var, s1.e0 e0Var, long j10) {
        float f5 = 0;
        if (Float.compare(this.f15009s.b(o0Var.getLayoutDirection()), f5) < 0 || Float.compare(this.f15009s.d(), f5) < 0 || Float.compare(this.f15009s.c(o0Var.getLayoutDirection()), f5) < 0 || Float.compare(this.f15009s.a(), f5) < 0) {
            g5.f.s("Padding must be non-negative");
            return null;
        }
        int iE0 = o0Var.e0(this.f15009s.c(o0Var.getLayoutDirection())) + o0Var.e0(this.f15009s.b(o0Var.getLayoutDirection()));
        int iE02 = o0Var.e0(this.f15009s.a()) + o0Var.e0(this.f15009s.d());
        s1.o0 o0VarQ = e0Var.q(o2.b.h(j10, -iE0, -iE02));
        return o0Var.Y(o2.b.f(o0VarQ.f11277c + iE0, j10), o2.b.e(o0VarQ.f11278f + iE02, j10), kb.t.f7405c, new b.g(o0VarQ, o0Var, this, 10));
    }
}
