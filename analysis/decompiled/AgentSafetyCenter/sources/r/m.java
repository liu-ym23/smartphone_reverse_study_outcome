package r;

import k0.c1;
import s.y0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements s1.r {

    /* renamed from: c, reason: collision with root package name */
    public y0 f10315c;

    /* renamed from: f, reason: collision with root package name */
    public c1 f10316f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ n f10317g;

    @Override // s1.r
    public final s1.g0 f(u1.o0 o0Var, s1.e0 e0Var, long j10) {
        s1.o0 o0VarQ = e0Var.q(j10);
        y0 y0Var = this.f10315c;
        n nVar = this.f10317g;
        long jB = o0Var.V() ? ac.a.b(o0VarQ.f11277c, o0VarQ.f11278f) : ((o2.k) y0Var.a(new b0.n(11, nVar, this), new a2.m(nVar, 10)).getValue()).f9122a;
        return o0Var.Y((int) (jB >> 32), (int) (4294967295L & jB), kb.t.f7405c, new e0(nVar, o0VarQ, jB));
    }
}
