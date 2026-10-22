package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 extends w0.l implements u1.k, u1.w {
    @Override // u1.w
    public final s1.g0 f(u1.o0 o0Var, s1.e0 e0Var, long j10) {
        float f5 = ((o2.f) u1.f.h(this, p0.f5101a)).f9114c;
        float f10 = 0;
        if (f5 < f10) {
            f5 = f10;
        }
        s1.o0 o0VarQ = e0Var.q(j10);
        boolean z10 = this.f15126r && !Float.isNaN(f5) && Float.compare(f5, f10) > 0;
        int iE0 = Float.isNaN(f5) ? 0 : o0Var.e0(f5);
        int iMax = o0VarQ.f11277c;
        if (z10) {
            iMax = Math.max(iMax, iE0);
        }
        int iMax2 = o0VarQ.f11278f;
        if (z10) {
            iMax2 = Math.max(iMax2, iE0);
        }
        return o0Var.Y(iMax, iMax2, kb.t.f7405c, new s0(iMax, o0VarQ, iMax2));
    }
}
