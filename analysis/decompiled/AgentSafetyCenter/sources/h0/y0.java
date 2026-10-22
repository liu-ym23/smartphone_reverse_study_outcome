package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y0 extends yb.l implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public static final y0 f5243c = new y0(3);

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        s1.h0 h0Var = (s1.h0) obj;
        long j10 = ((o2.a) obj3).f9108a;
        int iE0 = h0Var.e0(z0.f5269a);
        int i = iE0 * 2;
        s1.o0 o0VarQ = ((s1.e0) obj2).q(o2.b.h(j10, 0, i));
        int i3 = o0VarQ.f11278f - i;
        return h0Var.Y(o0VarQ.f11277c, i3, kb.t.f7405c, new x0(o0VarQ, iE0));
    }
}
