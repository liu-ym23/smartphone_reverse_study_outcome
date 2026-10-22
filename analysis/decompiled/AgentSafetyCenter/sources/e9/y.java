package e9;

import com.stepos.agentsafetycenter.R;
import h0.b1;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k0.y0;
import s8.c2;
import s8.d2;
import s8.e2;
import s8.g1;
import s8.j3;
import s8.p3;
import s8.x0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends yb.l implements xb.r {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3736c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f3737f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3738g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f3739h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(List list, Object obj, Object obj2, Object obj3, int i) {
        super(4);
        this.f3736c = i;
        this.f3737f = list;
        this.f3738g = obj;
        this.f3739h = obj2;
        this.i = obj3;
    }

    @Override // xb.r
    public final Object c(Object obj, Object obj2, Object obj3, Object obj4) {
        k0.s sVar;
        Object obj5;
        String strN;
        k0.s sVar2;
        int i = this.f3736c;
        jb.v vVar = jb.v.f6774a;
        y0 y0Var = k0.m.f6974a;
        Object obj6 = this.f3739h;
        List list = this.f3737f;
        Object obj7 = this.f3738g;
        switch (i) {
            case 0:
                x.b bVar = (x.b) obj;
                int iIntValue = ((Number) obj2).intValue();
                k0.s sVar3 = (k0.s) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                h hVar = (h) obj6;
                kc.t tVar = (kc.t) obj7;
                int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (sVar3.f(bVar) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i3 |= sVar3.d(iIntValue) ? 32 : 16;
                }
                if ((i3 & 147) != 146 || !sVar3.B()) {
                    if (list.get(iIntValue) == null) {
                        sVar3.X(-1740955249);
                        w0.j jVar = w0.j.f15113c;
                        w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
                        w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar3, 0);
                        int iHashCode = Long.hashCode(sVar3.T);
                        s0.g gVarL = sVar3.l();
                        w0.m mVarM = t.o.m(sVar3, mVarB);
                        u1.j.f13840e.getClass();
                        u1.z zVar = u1.i.f13833b;
                        sVar3.b0();
                        if (sVar3.S) {
                            sVar3.k(zVar);
                        } else {
                            sVar3.l0();
                        }
                        k0.z.B(vVarA, sVar3, u1.i.f13836e);
                        k0.z.B(gVarL, sVar3, u1.i.f13835d);
                        u1.h hVar2 = u1.i.f13837f;
                        if (sVar3.S || !yb.k.a(sVar3.M(), Integer.valueOf(iHashCode))) {
                            k0.a.y(iHashCode, sVar3, iHashCode, hVar2);
                        }
                        k0.z.B(mVarM, sVar3, u1.i.f13834c);
                        if (iIntValue > 0) {
                            sVar3.X(523577500);
                            b1.d(androidx.compose.foundation.layout.b.h(jVar, 16, 0.0f, 2), 0.0f, d1.f0.c(4281084974L), sVar3, 390, 2);
                            sVar = sVar3;
                        } else {
                            k0.s sVar4 = sVar3;
                            sVar4.X(514304160);
                            sVar = sVar4;
                        }
                        sVar.q(false);
                        boolean zH = sVar.h(tVar) | sVar.h(hVar) | sVar.f(null);
                        Object objM = sVar.M();
                        Object obj8 = objM;
                        if (zH || objM == y0Var) {
                            w wVar = new w(0);
                            wVar.f3732f = tVar;
                            wVar.f3733g = hVar;
                            VarHandle.storeStoreFence();
                            sVar.i0(wVar);
                            obj8 = wVar;
                        }
                        b.a((xb.l) obj8, sVar, 0);
                        sVar.q(true);
                        sVar.q(false);
                        break;
                    } else {
                        od.f.j();
                        break;
                    }
                } else {
                    sVar3.S();
                    break;
                }
                break;
            default:
                x.b bVar2 = (x.b) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                k0.s sVar5 = (k0.s) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                xb.p pVar = (xb.p) this.i;
                s8.t tVar2 = (s8.t) obj7;
                int i10 = (iIntValue4 & 6) == 0 ? iIntValue4 | (sVar5.f(bVar2) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i10 |= sVar5.d(iIntValue3) ? 32 : 16;
                }
                if ((i10 & 147) != 146 || !sVar5.B()) {
                    e2 e2Var = (e2) list.get(iIntValue3);
                    sVar5.X(2106769735);
                    if (e2Var instanceof d2) {
                        sVar5.X(2106810034);
                        d2 d2Var = (d2) e2Var;
                        s8.s.b(d2Var.f11544b, t2.a.p(R.string.action_list_intercepts_under_date, new Object[]{Integer.valueOf(d2Var.f11545c)}, sVar5), sVar5, 0);
                        sVar5.q(false);
                        sVar2 = sVar5;
                    } else if (!(e2Var instanceof c2)) {
                        sVar5.X(-2010249668);
                        sVar5.q(false);
                        g5.f.a();
                        break;
                    } else {
                        sVar5.X(2107202711);
                        j3 j3Var = ((c2) e2Var).f11502a;
                        j3 j3VarD = x0.d(tVar2.f11967e, j3Var);
                        List list2 = j3Var.f11702e;
                        if (j3VarD == null) {
                            j3VarD = j3Var;
                        }
                        Iterator it = list2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object next = it.next();
                                if (((p3) next).f11881g) {
                                    obj5 = next;
                                }
                            } else {
                                obj5 = null;
                            }
                        }
                        p3 p3Var = (p3) obj5;
                        if (p3Var == null || (strN = x0.n(p3Var, j3VarD, tVar2)) == null) {
                            ArrayList arrayList = new ArrayList();
                            for (Object obj9 : list2) {
                                if (((p3) obj9).f11880f) {
                                    arrayList.add(obj9);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size = arrayList.size();
                            int i11 = 0;
                            while (i11 < size) {
                                Object obj10 = arrayList.get(i11);
                                i11++;
                                String strN2 = x0.n((p3) obj10, j3VarD, tVar2);
                                if (strN2 != null) {
                                    arrayList2.add(strN2);
                                }
                            }
                            strN = (String) kb.l.x0(kb.l.L0(kb.l.N0(arrayList2)));
                        }
                        s8.t tVar3 = (s8.t) obj7;
                        Set set = (Set) obj6;
                        s0.c cVar = g1.f11615a;
                        boolean zF = sVar5.f(pVar) | sVar5.h(j3VarD) | sVar5.f(strN);
                        Object objM2 = sVar5.M();
                        Object obj11 = objM2;
                        if (zF || objM2 == y0Var) {
                            s8.o oVar = new s8.o(0);
                            oVar.f11829f = pVar;
                            oVar.f11830g = j3VarD;
                            oVar.f11831h = strN;
                            VarHandle.storeStoreFence();
                            sVar5.i0(oVar);
                            obj11 = oVar;
                        }
                        s8.s.g(tVar3, j3Var, set, cVar, true, false, null, null, (xb.a) obj11, sVar5, 224256, 192);
                        sVar2 = sVar5;
                        sVar2.q(false);
                    }
                    sVar2.q(false);
                    break;
                } else {
                    sVar5.S();
                    break;
                }
                break;
        }
        return null;
    }
}
