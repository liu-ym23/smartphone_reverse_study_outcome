package r;

import java.lang.invoke.VarHandle;
import k0.k1;
import k0.y0;
import s.e1;
import s.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e1 f10291c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f10292f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ xb.l f10293g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n f10294h;
    public final /* synthetic */ u0.q i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ s0.c f10295j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e1 e1Var, Object obj, xb.l lVar, n nVar, u0.q qVar, s0.c cVar) {
        super(2);
        this.f10291c = e1Var;
        this.f10292f = obj;
        this.f10293g = lVar;
        this.f10294h = nVar;
        this.i = qVar;
        this.f10295j = cVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        k0.s sVar = (k0.s) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && sVar.B()) {
            sVar.S();
        } else {
            Object objM = sVar.M();
            xb.l lVar = this.f10293g;
            n nVar = this.f10294h;
            y0 y0Var = k0.m.f6974a;
            if (objM == y0Var) {
                objM = (v) lVar.invoke(nVar);
                sVar.i0(objM);
            }
            v vVar = (v) objM;
            e1 e1Var = this.f10291c;
            z0 z0VarF = e1Var.f();
            k1 k1Var = e1Var.f10992d;
            Object objC = z0VarF.c();
            Object obj3 = this.f10292f;
            boolean zG = sVar.g(yb.k.a(objC, obj3));
            Object objM2 = sVar.M();
            if (zG || objM2 == y0Var) {
                objM2 = yb.k.a(e1Var.f().c(), obj3) ? i0.f10304b : ((v) lVar.invoke(nVar)).f10345b;
                sVar.i0(objM2);
            }
            i0 i0Var = (i0) objM2;
            Object objM3 = sVar.M();
            Object obj4 = objM3;
            if (objM3 == y0Var) {
                boolean zA = yb.k.a(obj3, k1Var.getValue());
                l lVar2 = new l();
                lVar2.f10312c = k0.z.v(Boolean.valueOf(zA));
                VarHandle.storeStoreFence();
                sVar.i0(lVar2);
                obj4 = lVar2;
            }
            l lVar3 = (l) obj4;
            h0 h0Var = vVar.f10344a;
            boolean zH = sVar.h(vVar);
            Object objM4 = sVar.M();
            if (zH || objM4 == y0Var) {
                objM4 = new e(vVar, 0);
                sVar.i0(objM4);
            }
            w0.m mVarA = androidx.compose.ui.layout.a.a(w0.j.f15113c, (xb.q) objM4);
            lVar3.f10312c.setValue(Boolean.valueOf(yb.k.a(obj3, k1Var.getValue())));
            w0.m mVarD = mVarA.d(lVar3);
            boolean zH2 = sVar.h(obj3);
            Object objM5 = sVar.M();
            if (zH2 || objM5 == y0Var) {
                objM5 = new a2.m(obj3, 9);
                sVar.i0(objM5);
            }
            xb.l lVar4 = (xb.l) objM5;
            boolean zF = sVar.f(i0Var);
            Object objM6 = sVar.M();
            if (zF || objM6 == y0Var) {
                objM6 = new b0.s(i0Var, 1);
                sVar.i0(objM6);
            }
            androidx.compose.animation.a.a(e1Var, lVar4, mVarD, h0Var, i0Var, (xb.p) objM6, s0.h.d(-616195562, new g(this.i, obj3, nVar, this.f10295j), sVar), sVar, 12582912);
        }
        return jb.v.f6774a;
    }
}
