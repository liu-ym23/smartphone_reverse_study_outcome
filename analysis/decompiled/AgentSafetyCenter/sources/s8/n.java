package s8;

import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends yb.l implements xb.r {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11808c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f11809f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f11810g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Set f11811h;
    public final /* synthetic */ s0.c i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ xb.l f11812j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ xb.p f11813k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(List list, t tVar, Set set, s0.c cVar, xb.l lVar, xb.p pVar, int i) {
        super(4);
        this.f11808c = i;
        this.f11809f = list;
        this.f11810g = tVar;
        this.f11811h = set;
        this.i = cVar;
        this.f11812j = lVar;
        this.f11813k = pVar;
    }

    @Override // xb.r
    public final Object c(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        k0.s sVar;
        int i3;
        k0.s sVar2;
        int i10 = this.f11808c;
        jb.v vVar = jb.v.f6774a;
        List list = this.f11809f;
        xb.l lVar = this.f11812j;
        k0.y0 y0Var = k0.m.f6974a;
        xb.p pVar = this.f11813k;
        switch (i10) {
            case 0:
                x.b bVar = (x.b) obj;
                int iIntValue = ((Number) obj2).intValue();
                k0.s sVar3 = (k0.s) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                if ((iIntValue2 & 6) == 0) {
                    i = iIntValue2 | (sVar3.f(bVar) ? 4 : 2);
                } else {
                    i = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i |= sVar3.d(iIntValue) ? 32 : 16;
                }
                if ((i & 147) != 146 || !sVar3.B()) {
                    a1 a1Var = (a1) list.get(iIntValue);
                    sVar3.X(-1013422465);
                    if (!(a1Var instanceof y0)) {
                        if (!(a1Var instanceof z0)) {
                            sVar3.X(-725427708);
                            sVar3.q(false);
                            g5.f.a();
                            break;
                        } else {
                            sVar3.X(-1012925102);
                            z0 z0Var = (z0) a1Var;
                            j3 j3Var = z0Var.f12163a;
                            int i11 = s.i(j3Var);
                            Integer numValueOf = i11 >= 2 ? Integer.valueOf(i11) : null;
                            boolean zF = sVar3.f(lVar) | sVar3.h(a1Var);
                            Object objM = sVar3.M();
                            Object obj5 = objM;
                            if (zF || objM == y0Var) {
                                hd.k kVar = new hd.k(1);
                                kVar.f5505f = lVar;
                                kVar.f5506g = z0Var;
                                VarHandle.storeStoreFence();
                                sVar3.i0(kVar);
                                obj5 = kVar;
                            }
                            xb.a aVar = (xb.a) obj5;
                            boolean zH = sVar3.h(a1Var) | sVar3.f(pVar);
                            Object objM2 = sVar3.M();
                            Object obj6 = objM2;
                            if (zH || objM2 == y0Var) {
                                hd.k kVar2 = new hd.k(2);
                                kVar2.f5505f = pVar;
                                kVar2.f5506g = z0Var;
                                VarHandle.storeStoreFence();
                                sVar3.i0(kVar2);
                                obj6 = kVar2;
                            }
                            s.g(this.f11810g, j3Var, this.f11811h, this.i, true, false, numValueOf, aVar, (xb.a) obj6, sVar3, 27648, 32);
                            sVar = sVar3;
                            sVar.q(false);
                        }
                    } else {
                        sVar3.X(-1013384708);
                        y0 y0Var2 = (y0) a1Var;
                        s.b(y0Var2.f12115b, t2.a.p(R.string.action_list_section_counts, new Object[]{Integer.valueOf(y0Var2.f12116c), Integer.valueOf(y0Var2.f12117d), Integer.valueOf(y0Var2.f12118e)}, sVar3), sVar3, 0);
                        sVar3.q(false);
                        sVar = sVar3;
                    }
                    sVar.q(false);
                    break;
                } else {
                    sVar3.S();
                    break;
                }
            default:
                x.b bVar2 = (x.b) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                k0.s sVar4 = (k0.s) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                if ((iIntValue4 & 6) == 0) {
                    i3 = iIntValue4 | (sVar4.f(bVar2) ? 4 : 2);
                } else {
                    i3 = iIntValue4;
                }
                if ((iIntValue4 & 48) == 0) {
                    i3 |= sVar4.d(iIntValue3) ? 32 : 16;
                }
                if ((i3 & 147) != 146 || !sVar4.B()) {
                    s3 s3Var = (s3) list.get(iIntValue3);
                    sVar4.X(-156889161);
                    if (!(s3Var instanceof q3)) {
                        if (!(s3Var instanceof r3)) {
                            sVar4.X(826223052);
                            sVar4.q(false);
                            g5.f.a();
                            break;
                        } else {
                            sVar4.X(-156617633);
                            r3 r3Var = (r3) s3Var;
                            j3 j3Var2 = r3Var.f11930a;
                            int i12 = s.i(j3Var2);
                            Integer numValueOf2 = i12 >= 2 ? Integer.valueOf(i12) : null;
                            boolean zF2 = sVar4.f(lVar) | sVar4.h(s3Var);
                            Object objM3 = sVar4.M();
                            Object obj7 = objM3;
                            if (zF2 || objM3 == y0Var) {
                                hd.k kVar3 = new hd.k(3);
                                kVar3.f5505f = lVar;
                                kVar3.f5506g = r3Var;
                                VarHandle.storeStoreFence();
                                sVar4.i0(kVar3);
                                obj7 = kVar3;
                            }
                            xb.a aVar2 = (xb.a) obj7;
                            boolean zF3 = sVar4.f(pVar);
                            t tVar = this.f11810g;
                            boolean zH2 = sVar4.h(s3Var) | zF3 | sVar4.h(tVar);
                            Object objM4 = sVar4.M();
                            Object obj8 = objM4;
                            if (zH2 || objM4 == y0Var) {
                                o oVar = new o(1);
                                oVar.f11829f = pVar;
                                oVar.f11830g = tVar;
                                oVar.f11831h = r3Var;
                                VarHandle.storeStoreFence();
                                sVar4.i0(oVar);
                                obj8 = oVar;
                            }
                            s.g(this.f11810g, j3Var2, this.f11811h, this.i, true, false, numValueOf2, aVar2, (xb.a) obj8, sVar4, 27648, 32);
                            sVar2 = sVar4;
                            sVar2.q(false);
                        }
                    } else {
                        sVar4.X(-156853543);
                        s.b(((q3) s3Var).f11910b, null, sVar4, 48);
                        sVar4.q(false);
                        sVar2 = sVar4;
                    }
                    sVar2.q(false);
                    break;
                } else {
                    sVar4.S();
                    break;
                }
                break;
        }
        return null;
    }
}
