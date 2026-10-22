package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends w0.l implements u1.w {

    /* renamed from: s, reason: collision with root package name */
    public float f14995s;

    /* renamed from: t, reason: collision with root package name */
    public float f14996t;

    /* renamed from: u, reason: collision with root package name */
    public float f14997u;

    /* renamed from: v, reason: collision with root package name */
    public float f14998v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f14999w;

    @Override // u1.w
    public final s1.g0 f(u1.o0 o0Var, s1.e0 e0Var, long j10) {
        int iE0 = o0Var.e0(this.f14997u) + o0Var.e0(this.f14995s);
        int iE02 = o0Var.e0(this.f14998v) + o0Var.e0(this.f14996t);
        s1.o0 o0VarQ = e0Var.q(o2.b.h(j10, -iE0, -iE02));
        return o0Var.Y(o2.b.f(o0VarQ.f11277c + iE0, j10), o2.b.e(o0VarQ.f11278f + iE02, j10), kb.t.f7405c, new b.g(this, o0VarQ, o0Var, 9));
    }
}
