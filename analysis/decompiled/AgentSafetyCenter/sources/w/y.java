package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends t.c1 {

    /* renamed from: a, reason: collision with root package name */
    public a f15066a;

    @Override // t.c1
    public final int c(int i, o2.l lVar, s1.o0 o0Var, int i3) {
        int iH = o0Var.H(this.f15066a.f14948a);
        if (iH == Integer.MIN_VALUE) {
            return 0;
        }
        int i10 = i3 - iH;
        return lVar == o2.l.f9124f ? i - i10 : i10;
    }

    @Override // t.c1
    public final Integer d(s1.o0 o0Var) {
        return Integer.valueOf(o0Var.H(this.f15066a.f14948a));
    }
}
