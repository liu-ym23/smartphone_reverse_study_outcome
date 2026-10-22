package j1;

import b0.t2;

/* loaded from: classes.dex */
public final class q1 implements n0.o {

    /* renamed from: f, reason: collision with root package name */
    public final b0.k1 f5304f = new b0.k1(1.0f);

    @Override // n0.o
    public final float H() {
        b0.k1 k1Var = this.f5304f;
        return ((t2) l0.m.t(k1Var.f1230g, k1Var)).f1375c;
    }

    @Override // g7.l
    public final g7.l Q(g7.l lVar) {
        return n0.n.plus(this, lVar);
    }

    @Override // g7.l
    public final g7.j o(g7.k kVar) {
        return n0.n.get(this, kVar);
    }

    @Override // g7.l
    public final Object r(Object obj, p7.n nVar) {
        return n0.n.fold(this, obj, nVar);
    }

    @Override // g7.l
    public final g7.l z(g7.k kVar) {
        return n0.n.minusKey(this, kVar);
    }
}
