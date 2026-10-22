package j9;

import androidx.compose.foundation.layout.FillElement;
import com.stepos.agentsafetycenter.R;
import d1.f0;
import h0.t1;
import java.lang.invoke.VarHandle;
import java.util.List;
import k0.c1;
import k0.y0;
import w.l0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ x.r f6653c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ List f6654f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ c1 f6655g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ xb.l f6656h;
    public /* synthetic */ c1 i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ c1 f6657j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ c1 f6658k;

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        k0.s sVar;
        x.r rVar = this.f6653c;
        List list = this.f6654f;
        c1 c1Var = this.f6655g;
        xb.l lVar = this.f6656h;
        c1 c1Var2 = this.i;
        c1 c1Var3 = this.f6657j;
        c1 c1Var4 = this.f6658k;
        l0 l0Var = (l0) obj;
        k0.s sVar2 = (k0.s) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        l0Var.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= sVar2.f(l0Var) ? 4 : 2;
        }
        if (sVar2.P(iIntValue & 1, (iIntValue & 19) != 18)) {
            FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
            w0.m mVarB = androidx.compose.foundation.a.b(androidx.compose.foundation.layout.b.e(fillElement, l0Var), b0.f6633a, f0.f2972a);
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar2, 0);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarB);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            u1.h hVar = u1.i.f13836e;
            k0.z.B(vVarA, sVar2, hVar);
            u1.h hVar2 = u1.i.f13835d;
            k0.z.B(gVarL, sVar2, hVar2);
            u1.h hVar3 = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar3);
            }
            u1.h hVar4 = u1.i.f13834c;
            k0.z.B(mVarM, sVar2, hVar4);
            String strO = t2.a.o(R.string.screen_perception_add_apps_subtitle, sVar2);
            float f5 = 8;
            w0.j jVar = w0.j.f15113c;
            t1.b(strO, androidx.compose.foundation.layout.b.g(jVar, 16, f5), b0.f6636d, com.stepos.statsrpk.h.t(14), null, 0L, null, com.stepos.statsrpk.h.t(20), 0, false, 0, 0, null, sVar2, 3504, 6, 130032);
            w0.m mVarB2 = androidx.compose.foundation.layout.c.b(w.w.a(), 1.0f);
            s1.f0 f0VarE = w.p.e(w0.b.f15089c, false);
            int iHashCode2 = Long.hashCode(sVar2.T);
            s0.g gVarL2 = sVar2.l();
            w0.m mVarM2 = t.o.m(sVar2, mVarB2);
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(f0VarE, sVar2, hVar);
            k0.z.B(gVarL2, sVar2, hVar2);
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode2))) {
                k0.a.y(iHashCode2, sVar2, iHashCode2, hVar3);
            }
            k0.z.B(mVarM2, sVar2, hVar4);
            w0.m mVarJ = androidx.compose.foundation.layout.b.j(fillElement, 0.0f, 0.0f, 32, 0.0f, 11);
            boolean zH = sVar2.h(list) | sVar2.f(c1Var);
            Object objM = sVar2.M();
            y0 y0Var = k0.m.f6974a;
            Object obj4 = objM;
            if (zH || objM == y0Var) {
                aa.j jVar2 = new aa.j(3);
                jVar2.f326f = list;
                jVar2.f327g = c1Var;
                jVar2.f328h = c1Var2;
                VarHandle.storeStoreFence();
                sVar2.i0(jVar2);
                obj4 = jVar2;
            }
            k0.s sVar3 = sVar2;
            t1.e.a(6, 252, sVar3, null, null, null, null, mVarJ, rVar, (xb.l) obj4, false);
            if (list.isEmpty()) {
                sVar3.X(-1086088718);
                sVar = sVar3;
            } else {
                sVar3.X(-1078222375);
                String str = (String) c1Var3.getValue();
                Object objM2 = sVar3.M();
                Object obj5 = objM2;
                if (objM2 == y0Var) {
                    e eVar = new e(0);
                    eVar.f6660f = c1Var4;
                    VarHandle.storeStoreFence();
                    sVar3.i0(eVar);
                    obj5 = eVar;
                }
                b0.b(str, lVar, (xb.l) obj5, androidx.compose.foundation.layout.b.j(androidx.compose.foundation.layout.a.f901a.a(jVar, w0.b.f15093j).d(androidx.compose.foundation.layout.c.f903b), 0.0f, f5, 2, f5, 1), sVar3, 384);
                sVar = sVar3;
            }
            sVar.q(false);
            sVar.q(true);
            sVar.q(true);
        } else {
            sVar2.S();
        }
        return jb.v.f6774a;
    }
}
