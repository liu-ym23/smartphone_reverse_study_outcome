package s8;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11453c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ xb.l f11454f;

    public /* synthetic */ b(int i) {
        this.f11453c = i;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        u8.p pVar;
        int i = this.f11453c;
        jb.v vVar = jb.v.f6774a;
        k0.y0 y0Var = k0.m.f6974a;
        xb.l lVar = this.f11454f;
        p3 p3Var = (p3) obj;
        k0.s sVar = (k0.s) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        switch (i) {
            case 0:
                p3Var.getClass();
                if (x0.t(p3Var) || p3Var.f11882h == z8.g.f16512h || !x0.b(p3Var).isEmpty() || !p3Var.C.isEmpty()) {
                    sVar.X(1918028362);
                    boolean zF = sVar.f(lVar) | sVar.h(p3Var);
                    Object objM = sVar.M();
                    Object obj4 = objM;
                    if (zF || objM == y0Var) {
                        e eVar = new e(1);
                        eVar.f11553f = lVar;
                        eVar.f11554g = p3Var;
                        VarHandle.storeStoreFence();
                        sVar.i0(eVar);
                        obj4 = eVar;
                    }
                    o3.e(p3Var, (xb.a) obj4, sVar, iIntValue & 14);
                } else {
                    sVar.X(1905786400);
                }
                sVar.q(false);
                break;
            case 1:
                p3Var.getClass();
                if (x0.t(p3Var) || p3Var.f11882h == z8.g.f16512h || !x0.b(p3Var).isEmpty() || !p3Var.C.isEmpty()) {
                    sVar.X(-511527505);
                    boolean zF2 = sVar.f(lVar) | sVar.h(p3Var);
                    Object objM2 = sVar.M();
                    Object obj5 = objM2;
                    if (zF2 || objM2 == y0Var) {
                        e eVar2 = new e(0);
                        eVar2.f11553f = lVar;
                        eVar2.f11554g = p3Var;
                        VarHandle.storeStoreFence();
                        sVar.i0(eVar2);
                        obj5 = eVar2;
                    }
                    o3.e(p3Var, (xb.a) obj5, sVar, iIntValue & 14);
                } else {
                    sVar.X(-531100347);
                }
                sVar.q(false);
                break;
            default:
                p3Var.getClass();
                if (x0.t(p3Var) || p3Var.f11882h == z8.g.f16512h || !x0.b(p3Var).isEmpty() || !p3Var.C.isEmpty() || (pVar = p3Var.f11899z) == u8.p.f14244f || pVar == u8.p.f14245g) {
                    sVar.X(717514043);
                    boolean zF3 = sVar.f(lVar) | sVar.h(p3Var);
                    Object objM3 = sVar.M();
                    Object obj6 = objM3;
                    if (zF3 || objM3 == y0Var) {
                        e eVar3 = new e(2);
                        eVar3.f11553f = lVar;
                        eVar3.f11554g = p3Var;
                        VarHandle.storeStoreFence();
                        sVar.i0(eVar3);
                        obj6 = eVar3;
                    }
                    o3.e(p3Var, (xb.a) obj6, sVar, iIntValue & 14);
                } else {
                    sVar.X(708909993);
                }
                sVar.q(false);
                break;
        }
        return vVar;
    }
}
