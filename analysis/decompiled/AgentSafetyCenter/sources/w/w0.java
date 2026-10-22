package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w0 extends w0.l implements u1.w {

    /* renamed from: s, reason: collision with root package name */
    public float f15060s;

    /* renamed from: t, reason: collision with root package name */
    public float f15061t;

    @Override // u1.w
    public final s1.g0 f(u1.o0 o0Var, s1.e0 e0Var, long j10) {
        int iK;
        int iJ = 0;
        if (o2.f.b(this.f15060s, Float.NaN) || o2.a.k(j10) != 0) {
            iK = o2.a.k(j10);
        } else {
            iK = o0Var.e0(this.f15060s);
            int i = o2.a.i(j10);
            if (iK > i) {
                iK = i;
            }
            if (iK < 0) {
                iK = 0;
            }
        }
        int i3 = o2.a.i(j10);
        if (o2.f.b(this.f15061t, Float.NaN) || o2.a.j(j10) != 0) {
            iJ = o2.a.j(j10);
        } else {
            int iE0 = o0Var.e0(this.f15061t);
            int iH = o2.a.h(j10);
            if (iE0 > iH) {
                iE0 = iH;
            }
            if (iE0 >= 0) {
                iJ = iE0;
            }
        }
        s1.o0 o0VarQ = e0Var.q(o2.b.a(iK, i3, iJ, o2.a.h(j10)));
        return o0Var.Y(o0VarQ.f11277c, o0VarQ.f11278f, kb.t.f7405c, new a1.i(o0VarQ, 10));
    }
}
