package n;

import b0.o1;
import b0.z1;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final d0.e f6596a = new d0.e(new a0[16]);

    /* renamed from: b, reason: collision with root package name */
    public final o1 f6597b = b0.b.n(Boolean.FALSE);

    /* renamed from: c, reason: collision with root package name */
    public long f6598c = Long.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public final o1 f6599d = b0.b.n(Boolean.TRUE);

    public final void a(int i2, b0.p pVar) {
        pVar.T(-318043801);
        if ((((pVar.h(this) ? 4 : 2) | i2) & 3) == 2 && pVar.z()) {
            pVar.O();
        } else {
            Object objJ = pVar.J();
            b0.b1 b1Var = b0.k.f1229a;
            if (objJ == b1Var) {
                objJ = b0.b.n(null);
                pVar.b0(objJ);
            }
            b0.f1 f1Var = (b0.f1) objJ;
            if (((Boolean) this.f6599d.getValue()).booleanValue() || ((Boolean) this.f6597b.getValue()).booleanValue()) {
                pVar.S(1719915818);
                boolean zH = pVar.h(this);
                Object objJ2 = pVar.J();
                if (zH || objJ2 == b1Var) {
                    objJ2 = new la.a0(f1Var, this, null);
                    pVar.b0(objJ2);
                }
                b0.b.e(pVar, this, (p7.n) objJ2);
                pVar.q(false);
            } else {
                pVar.S(1721436120);
                pVar.q(false);
            }
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new j1.a(i2, 2, this);
        }
    }
}
