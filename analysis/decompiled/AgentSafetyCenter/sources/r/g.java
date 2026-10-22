package r;

import k0.y0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends yb.l implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u0.q f10279c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f10280f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n f10281g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s0.c f10282h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(u0.q qVar, Object obj, n nVar, s0.c cVar) {
        super(3);
        this.f10279c = qVar;
        this.f10280f = obj;
        this.f10281g = nVar;
        this.f10282h = cVar;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        s sVar = (s) obj;
        k0.s sVar2 = (k0.s) obj2;
        int iIntValue = ((Number) obj3).intValue();
        if ((iIntValue & 6) == 0) {
            iIntValue |= (iIntValue & 8) == 0 ? sVar2.f(sVar) : sVar2.h(sVar) ? 4 : 2;
        }
        if ((iIntValue & 19) == 18 && sVar2.B()) {
            sVar2.S();
        } else {
            u0.q qVar = this.f10279c;
            boolean zF = sVar2.f(qVar);
            Object obj4 = this.f10280f;
            boolean zH = zF | sVar2.h(obj4);
            n nVar = this.f10281g;
            boolean zH2 = zH | sVar2.h(nVar);
            Object objM = sVar2.M();
            y0 y0Var = k0.m.f6974a;
            if (zH2 || objM == y0Var) {
                objM = new b.g(qVar, obj4, nVar, 2);
                sVar2.i0(objM);
            }
            k0.z.d(sVar, (xb.l) objM, sVar2);
            p.f0 f0Var = nVar.f10321c;
            sVar.getClass();
            f0Var.m(obj4, ((t) sVar).f10342a);
            Object objM2 = sVar2.M();
            if (objM2 == y0Var) {
                objM2 = new k();
                sVar2.i0(objM2);
            }
            this.f10282h.c((k) objM2, obj4, sVar2, 0);
        }
        return jb.v.f6774a;
    }
}
