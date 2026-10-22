package s;

import k0.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public m0.e f10985a;

    /* renamed from: b, reason: collision with root package name */
    public k0.k1 f10986b;

    /* renamed from: c, reason: collision with root package name */
    public long f10987c;

    /* renamed from: d, reason: collision with root package name */
    public k0.k1 f10988d;

    public final void a(int i, k0.s sVar) {
        sVar.Z(-318043801);
        if ((((sVar.h(this) ? 4 : 2) | i) & 3) == 2 && sVar.B()) {
            sVar.S();
        } else {
            Object objM = sVar.M();
            nb.c cVar = null;
            k0.y0 y0Var = k0.m.f6974a;
            if (objM == y0Var) {
                objM = k0.z.v(null);
                sVar.i0(objM);
            }
            k0.c1 c1Var = (k0.c1) objM;
            if (((Boolean) this.f10988d.getValue()).booleanValue() || ((Boolean) this.f10986b.getValue()).booleanValue()) {
                sVar.X(1719915818);
                boolean zH = sVar.h(this);
                Object objM2 = sVar.M();
                if (zH || objM2 == y0Var) {
                    objM2 = new androidx.lifecycle.i0(c1Var, this, cVar, 7);
                    sVar.i0(objM2);
                }
                k0.z.h(this, sVar, (xb.p) objM2);
                sVar.q(false);
            } else {
                sVar.X(1721436120);
                sVar.q(false);
            }
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.s(i, 2, this);
        }
    }
}
