package e9;

import com.stepos.agentsafetycenter.MainActivity;
import h0.b1;
import h0.t1;
import java.lang.invoke.VarHandle;
import k0.c1;
import k0.y0;
import w.p0;
import w.r0;
import w.s0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3617c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3618f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f3619g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f3620h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f3621j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f3622k;

    public /* synthetic */ b0(int i) {
        this.f3617c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f3617c;
        jb.v vVar = jb.v.f6774a;
        y0 y0Var = k0.m.f6974a;
        int i3 = 0;
        switch (i) {
            case 0:
                String str = (String) this.f3618f;
                String str2 = (String) this.f3619g;
                String str3 = (String) this.f3620h;
                xb.a aVar = (xb.a) this.f3621j;
                String str4 = (String) this.i;
                xb.a aVar2 = (xb.a) this.f3622k;
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (!sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    sVar.S();
                    break;
                } else {
                    w0.j jVar = w0.j.f15113c;
                    float f5 = 20;
                    w0.m mVarB = androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), a0.e.c(f5, f5, 0.0f, 12)), j9.b0.f6644m, d1.f0.f2972a);
                    Object objM = sVar.M();
                    if (objM == y0Var) {
                        objM = t0.a.a();
                        sVar.i0(objM);
                    }
                    v.k kVar = (v.k) objM;
                    Object objM2 = sVar.M();
                    if (objM2 == y0Var) {
                        objM2 = new androidx.room.c(2);
                        sVar.i0(objM2);
                    }
                    w0.m mVarD = androidx.compose.foundation.a.d(mVarB, kVar, null, false, null, (xb.a) objM2, 28);
                    float f10 = 24;
                    float f11 = 12;
                    w0.m mVarL = t2.a.l(androidx.compose.foundation.layout.b.j(mVarD, 0.0f, f10, 0.0f, f11, 5));
                    w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar, 0);
                    int iHashCode = Long.hashCode(sVar.T);
                    s0.g gVarL = sVar.l();
                    w0.m mVarM = t.o.m(sVar, mVarL);
                    u1.j.f13840e.getClass();
                    u1.z zVar = u1.i.f13833b;
                    sVar.b0();
                    if (sVar.S) {
                        sVar.k(zVar);
                    } else {
                        sVar.l0();
                    }
                    u1.h hVar = u1.i.f13836e;
                    k0.z.B(vVarA, sVar, hVar);
                    u1.h hVar2 = u1.i.f13835d;
                    k0.z.B(gVarL, sVar, hVar2);
                    u1.h hVar3 = u1.i.f13837f;
                    if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                        k0.a.y(iHashCode, sVar, iHashCode, hVar3);
                    }
                    u1.h hVar4 = u1.i.f13834c;
                    k0.z.B(mVarM, sVar, hVar4);
                    t1.b(str, androidx.compose.foundation.layout.b.h(androidx.compose.foundation.layout.c.b(jVar, 1.0f), f10, 0.0f, 2), j9.b0.f6635c, com.stepos.statsrpk.h.t(17), g2.k.i, 0L, n2.k.a(3), 0L, 0, false, 0, 0, null, sVar, 200112, 0, 130512);
                    t1.b(str2, androidx.compose.foundation.layout.b.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), f10, f11), j9.b0.f6636d, com.stepos.statsrpk.h.t(14), null, 0L, n2.k.a(3), com.stepos.statsrpk.h.t(20), 0, false, 0, 0, null, sVar, 3504, 6, 129520);
                    w0.m mVarJ = androidx.compose.foundation.layout.b.j(androidx.compose.foundation.layout.b.h(androidx.compose.foundation.layout.c.b(jVar, 1.0f), 16, 0.0f, 2), 0.0f, 8, 0.0f, 0.0f, 13);
                    r0 r0VarA = p0.a(w.k.f14990a, w0.b.f15098o, sVar, 48);
                    int iHashCode2 = Long.hashCode(sVar.T);
                    s0.g gVarL2 = sVar.l();
                    w0.m mVarM2 = t.o.m(sVar, mVarJ);
                    sVar.b0();
                    if (sVar.S) {
                        sVar.k(zVar);
                    } else {
                        sVar.l0();
                    }
                    k0.z.B(r0VarA, sVar, hVar);
                    k0.z.B(gVarL2, sVar, hVar2);
                    if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode2))) {
                        k0.a.y(iHashCode2, sVar, iHashCode2, hVar3);
                    }
                    k0.z.B(mVarM2, sVar, hVar4);
                    g0.b(str3, false, aVar, s0.a(), sVar, 0);
                    g0.b(str4, true, aVar2, s0.a(), sVar, 0);
                    sVar.q(true);
                    sVar.q(true);
                    break;
                }
                break;
            default:
                kc.t tVar = (kc.t) this.f3618f;
                MainActivity mainActivity = (MainActivity) this.f3619g;
                c1 c1Var = (c1) this.f3620h;
                c1 c1Var2 = (c1) this.i;
                c1 c1Var3 = (c1) this.f3621j;
                c1 c1Var4 = (c1) this.f3622k;
                k0.s sVar2 = (k0.s) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                int i10 = MainActivity.f2491h;
                if (!sVar2.P(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    sVar2.S();
                    break;
                } else {
                    boolean zH = sVar2.h(tVar) | sVar2.h(mainActivity);
                    Object objM3 = sVar2.M();
                    Object obj3 = objM3;
                    if (zH || objM3 == y0Var) {
                        k8.o oVar = new k8.o(i3);
                        oVar.f7328f = tVar;
                        oVar.f7329g = c1Var;
                        oVar.f7332k = mainActivity;
                        oVar.f7330h = c1Var2;
                        oVar.i = c1Var3;
                        oVar.f7331j = c1Var4;
                        VarHandle.storeStoreFence();
                        sVar2.i0(oVar);
                        obj3 = oVar;
                    }
                    b1.e((xb.a) obj3, null, false, null, null, null, k8.e.f7291a, sVar2, 805306368, 510);
                    break;
                }
        }
        return vVar;
    }
}
