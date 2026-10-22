package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 extends w0.l implements u1.w {

    /* renamed from: s, reason: collision with root package name */
    public int f14956s;

    /* renamed from: t, reason: collision with root package name */
    public float f14957t;

    @Override // u1.w
    public final s1.g0 f(u1.o0 o0Var, s1.e0 e0Var, long j10) {
        int iK;
        int i;
        int iJ;
        int iH;
        if (!o2.a.e(j10) || this.f14956s == 1) {
            iK = o2.a.k(j10);
            i = o2.a.i(j10);
        } else {
            iK = p5.f.q(Math.round(o2.a.i(j10) * this.f14957t), o2.a.k(j10), o2.a.i(j10));
            i = iK;
        }
        if (!o2.a.d(j10) || this.f14956s == 2) {
            iJ = o2.a.j(j10);
            iH = o2.a.h(j10);
        } else {
            iJ = p5.f.q(Math.round(o2.a.h(j10) * this.f14957t), o2.a.j(j10), o2.a.h(j10));
            iH = iJ;
        }
        s1.o0 o0VarQ = e0Var.q(o2.b.a(iK, i, iJ, iH));
        return o0Var.Y(o0VarQ.f11277c, o0VarQ.f11278f, kb.t.f7405c, new a1.i(o0VarQ, 8));
    }
}
