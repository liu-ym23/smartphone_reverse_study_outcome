package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d1 extends w0.l implements u1.w {

    /* renamed from: s, reason: collision with root package name */
    public int f14964s;

    /* renamed from: t, reason: collision with root package name */
    public yb.l f14965t;

    @Override // u1.w
    public final s1.g0 f(u1.o0 o0Var, s1.e0 e0Var, long j10) {
        s1.o0 o0VarQ = e0Var.q(o2.b.a(this.f14964s != 1 ? 0 : o2.a.k(j10), o2.a.i(j10), this.f14964s == 2 ? o2.a.j(j10) : 0, o2.a.h(j10)));
        int iQ = p5.f.q(o0VarQ.f11277c, o2.a.k(j10), o2.a.i(j10));
        int iQ2 = p5.f.q(o0VarQ.f11278f, o2.a.j(j10), o2.a.h(j10));
        return o0Var.Y(iQ, iQ2, kb.t.f7405c, new q0(this, iQ, o0VarQ, iQ2, o0Var));
    }
}
