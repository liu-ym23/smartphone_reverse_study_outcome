package e9;

import androidx.compose.foundation.layout.FillElement;
import com.stepos.agentsafetycenter.R;
import g9.f1;
import g9.o1;
import g9.p0;
import java.lang.invoke.VarHandle;
import k0.c1;
import k0.y0;
import s8.l2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3699c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ kc.t f3700f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ xb.a f3701g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ c1 f3702h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f3703j;

    public /* synthetic */ o(int i) {
        this.f3699c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        jb.v vVar;
        Object obj3;
        Object obj4;
        int i = this.f3699c;
        jb.v vVar2 = jb.v.f6774a;
        y0 y0Var = k0.m.f6974a;
        switch (i) {
            case 0:
                kc.t tVar = this.f3700f;
                h hVar = (h) this.i;
                xb.a aVar = this.f3701g;
                c1 c1Var = this.f3702h;
                c1 c1Var2 = (c1) this.f3703j;
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
                    s1.f0 f0VarE = w.p.e(w0.b.f15089c, false);
                    int iHashCode = Long.hashCode(sVar.T);
                    s0.g gVarL = sVar.l();
                    w0.m mVarM = t.o.m(sVar, fillElement);
                    u1.j.f13840e.getClass();
                    u1.z zVar = u1.i.f13833b;
                    sVar.b0();
                    if (sVar.S) {
                        sVar.k(zVar);
                    } else {
                        sVar.l0();
                    }
                    k0.z.B(f0VarE, sVar, u1.i.f13836e);
                    k0.z.B(gVarL, sVar, u1.i.f13835d);
                    u1.h hVar2 = u1.i.f13837f;
                    if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                        k0.a.y(iHashCode, sVar, iHashCode, hVar2);
                    }
                    k0.z.B(mVarM, sVar, u1.i.f13834c);
                    boolean zBooleanValue = ((Boolean) c1Var.getValue()).booleanValue();
                    String strO = t2.a.o(R.string.operate_phone_disable_master_title, sVar);
                    String strO2 = t2.a.o(R.string.operate_phone_disable_master_body, sVar);
                    String strO3 = t2.a.o(R.string.operate_phone_disable_master_confirm, sVar);
                    String strO4 = t2.a.o(R.string.operate_phone_disable_master_keep, sVar);
                    boolean zH = sVar.h(tVar) | sVar.h(hVar);
                    Object objM = sVar.M();
                    if (zH || objM == y0Var) {
                        r rVar = new r(0);
                        rVar.f3717f = tVar;
                        rVar.f3718g = c1Var;
                        rVar.f3719h = hVar;
                        VarHandle.storeStoreFence();
                        sVar.i0(rVar);
                        obj3 = rVar;
                    } else {
                        obj3 = objM;
                    }
                    xb.a aVar2 = (xb.a) obj3;
                    Object objM2 = sVar.M();
                    if (objM2 == y0Var) {
                        vVar = vVar2;
                        s sVar2 = new s(0);
                        sVar2.f3721f = c1Var;
                        VarHandle.storeStoreFence();
                        sVar.i0(sVar2);
                        obj4 = sVar2;
                    } else {
                        vVar = vVar2;
                        obj4 = objM2;
                    }
                    g0.a(zBooleanValue, strO, strO2, strO3, strO4, aVar2, (xb.a) obj4, aVar, fillElement, sVar, 920125440);
                    if (c1Var2.getValue() != null) {
                        od.f.j();
                        return null;
                    }
                    String strO5 = t2.a.o(R.string.operate_phone_disable_app_title, sVar);
                    String strO6 = t2.a.o(R.string.operate_phone_disable_app_body, sVar);
                    String strO7 = t2.a.o(R.string.operate_phone_disable_app_cancel, sVar);
                    String strO8 = t2.a.o(R.string.operate_phone_disable_app_confirm, sVar);
                    Object objM3 = sVar.M();
                    Object obj5 = objM3;
                    if (objM3 == y0Var) {
                        s sVar3 = new s(1);
                        sVar3.f3721f = c1Var2;
                        VarHandle.storeStoreFence();
                        sVar.i0(sVar3);
                        obj5 = sVar3;
                    }
                    xb.a aVar3 = (xb.a) obj5;
                    boolean zH2 = sVar.h(tVar) | sVar.f(null) | sVar.h(hVar);
                    Object objM4 = sVar.M();
                    Object obj6 = objM4;
                    if (zH2 || objM4 == y0Var) {
                        s sVar4 = new s(2);
                        sVar4.f3721f = c1Var2;
                        VarHandle.storeStoreFence();
                        sVar.i0(sVar4);
                        obj6 = sVar4;
                    }
                    g0.a(false, strO5, strO6, strO7, strO8, aVar3, (xb.a) obj6, aVar, fillElement, sVar, 918749184);
                    sVar.q(true);
                } else {
                    vVar = vVar2;
                    sVar.S();
                }
                return vVar;
            default:
                f1 f1Var = (f1) this.i;
                kc.t tVar2 = this.f3700f;
                p0 p0Var = (p0) this.f3703j;
                xb.a aVar4 = this.f3701g;
                c1 c1Var3 = this.f3702h;
                k0.s sVar5 = (k0.s) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (sVar5.P(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    o1 o1Var = (o1) c1Var3.getValue();
                    boolean zH3 = sVar5.h(f1Var) | sVar5.h(tVar2) | sVar5.h(p0Var);
                    Object objM5 = sVar5.M();
                    Object obj7 = objM5;
                    if (zH3 || objM5 == y0Var) {
                        j9.v vVar3 = new j9.v(3);
                        vVar3.f6723f = f1Var;
                        vVar3.f6725h = tVar2;
                        vVar3.i = p0Var;
                        vVar3.f6724g = c1Var3;
                        VarHandle.storeStoreFence();
                        sVar5.i0(vVar3);
                        obj7 = vVar3;
                    }
                    l2.b(o1Var, (xb.p) obj7, aVar4, sVar5, 0);
                } else {
                    sVar5.S();
                }
                return vVar2;
        }
    }
}
