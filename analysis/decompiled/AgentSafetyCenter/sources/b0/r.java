package b0;

import d2.e0;
import d2.j0;
import java.lang.invoke.VarHandle;
import k0.c1;
import k0.k1;
import k0.r2;
import s.c0;
import s1.y0;
import u.w0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1779c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1780f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1781g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1782h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(x xVar, d2.e eVar, c1 c1Var, c1 c1Var2, c1 c1Var3) {
        super(1);
        this.f1779c = 0;
        this.f1780f = eVar;
        this.f1781g = c1Var;
        this.f1782h = c1Var2;
        this.i = c1Var3;
    }

    /* JADX WARN: Type inference failed for: r14v11, types: [xb.l, yb.l] */
    @Override // xb.l
    public final Object invoke(Object obj) {
        j0 j0VarA;
        j0 j0VarA2;
        j0 j0VarA3;
        boolean z10;
        int i = this.f1779c;
        jb.v vVar = jb.v.f6774a;
        Object obj2 = this.i;
        Object obj3 = this.f1782h;
        Object obj4 = this.f1781g;
        Object obj5 = this.f1780f;
        switch (i) {
            case 0:
                p pVar = (p) obj;
                d2.e eVar = (d2.e) obj5;
                Object obj6 = eVar.f3077a;
                j0 j0VarA4 = ((d2.m) obj6).a();
                e0 e0VarC = null;
                e0 e0Var = j0VarA4 != null ? j0VarA4.f3128a : null;
                e0 e0VarC2 = (!((Boolean) ((c1) obj4).getValue()).booleanValue() || (j0VarA3 = ((d2.m) obj6).a()) == null) ? null : j0VarA3.f3129b;
                if (e0Var != null) {
                    e0VarC2 = e0Var.c(e0VarC2);
                }
                e0 e0VarC3 = (!((Boolean) ((c1) obj3).getValue()).booleanValue() || (j0VarA2 = ((d2.m) obj6).a()) == null) ? null : j0VarA2.f3130c;
                if (e0VarC2 != null) {
                    e0VarC3 = e0VarC2.c(e0VarC3);
                }
                if (((Boolean) ((c1) obj2).getValue()).booleanValue() && (j0VarA = ((d2.m) obj6).a()) != null) {
                    e0VarC = j0VarA.f3131d;
                }
                if (e0VarC3 != null) {
                    e0VarC = e0VarC3.c(e0VarC);
                }
                if (e0VarC != null) {
                    pVar.f1775a.a(e0VarC, eVar.f3078b, eVar.f3079c);
                }
                return vVar;
            case 1:
                s.g gVar = (s.g) obj;
                xb.l lVar = (xb.l) obj3;
                s.c cVar = (s.c) obj5;
                s.d.o(gVar, cVar.f10959c);
                k1 k1Var = gVar.f11009e;
                Object objA = s.c.a(cVar, k1Var.getValue());
                if (!yb.k.a(objA, k1Var.getValue())) {
                    cVar.f10959c.f11021f.setValue(objA);
                    ((s.i) obj4).f11021f.setValue(objA);
                    if (lVar != null) {
                        lVar.invoke(cVar);
                    }
                    gVar.a();
                    ((yb.q) obj2).f16094c = true;
                } else if (lVar != null) {
                    lVar.invoke(cVar);
                }
                return vVar;
            case 2:
                long jLongValue = ((Number) obj).longValue();
                kc.t tVar = (kc.t) obj2;
                yb.r rVar = (yb.r) obj3;
                s.e0 e0Var2 = (s.e0) obj5;
                r2 r2Var = (r2) ((c1) obj4).getValue();
                long jLongValue2 = r2Var != null ? ((Number) r2Var.getValue()).longValue() : jLongValue;
                long j10 = e0Var2.f10987c;
                m0.e eVar2 = e0Var2.f10985a;
                int i3 = 0;
                if (j10 == Long.MIN_VALUE || rVar.f16095c != s.d.k(tVar.n())) {
                    e0Var2.f10987c = jLongValue;
                    int i10 = eVar2.f8160g;
                    if (i10 > 0) {
                        Object[] objArr = eVar2.f8158c;
                        int i11 = 0;
                        do {
                            ((c0) objArr[i11]).f10971k = true;
                            i11++;
                        } while (i11 < i10);
                    }
                    rVar.f16095c = s.d.k(tVar.n());
                }
                float f5 = rVar.f16095c;
                if (f5 == 0.0f) {
                    int i12 = eVar2.f8160g;
                    if (i12 > 0) {
                        Object[] objArr2 = eVar2.f8158c;
                        do {
                            c0 c0Var = (c0) objArr2[i3];
                            c0Var.f10969h.setValue(c0Var.i.f11156c);
                            c0Var.f10971k = true;
                            i3++;
                        } while (i3 < i12);
                    }
                } else {
                    long j11 = (long) ((jLongValue2 - e0Var2.f10987c) / f5);
                    int i13 = eVar2.f8160g;
                    if (i13 > 0) {
                        Object[] objArr3 = eVar2.f8158c;
                        z10 = true;
                        int i14 = 0;
                        do {
                            c0 c0Var2 = (c0) objArr3[i14];
                            if (!c0Var2.f10970j) {
                                c0Var2.f10973m.f10986b.setValue(Boolean.FALSE);
                                if (c0Var2.f10971k) {
                                    c0Var2.f10971k = false;
                                    c0Var2.f10972l = j11;
                                }
                                long j12 = j11 - c0Var2.f10972l;
                                c0Var2.f10969h.setValue(c0Var2.i.f(j12));
                                c0Var2.f10970j = c0Var2.i.e(j12);
                            }
                            if (!c0Var2.f10970j) {
                                z10 = false;
                            }
                            i14++;
                        } while (i14 < i13);
                    } else {
                        z10 = true;
                    }
                    e0Var2.f10988d.setValue(Boolean.valueOf(!z10));
                }
                return vVar;
            case 3:
                s.g gVar2 = (s.g) obj;
                yb.r rVar2 = (yb.r) obj5;
                float fFloatValue = ((Number) gVar2.f11009e.getValue()).floatValue() - rVar2.f16095c;
                float fA = ((w0) obj4).a(fFloatValue);
                rVar2.f16095c = ((Number) gVar2.f11009e.getValue()).floatValue();
                ((yb.r) obj3).f16095c = ((Number) ((yb.l) gVar2.f11005a.f8777f).invoke(gVar2.f11010f)).floatValue();
                if (Math.abs(fFloatValue - fA) > 0.5f) {
                    gVar2.a();
                }
                ((u.k) obj2).getClass();
                return vVar;
            default:
                y.e0 e0Var3 = (y.e0) obj5;
                p5.m mVar = new p5.m(25);
                mVar.f9741f = (y.u) obj4;
                mVar.f9742g = (y0) obj3;
                mVar.f9743h = (y.b) obj2;
                VarHandle.storeStoreFence();
                e0Var3.f15737c = mVar;
                b.c cVar2 = new b.c(6);
                cVar2.f1687b = e0Var3;
                VarHandle.storeStoreFence();
                return cVar2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        super(1);
        this.f1779c = i;
        this.f1780f = obj;
        this.f1781g = obj2;
        this.f1782h = obj3;
        this.i = obj4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(c1 c1Var, s.e0 e0Var, yb.r rVar, kc.t tVar) {
        super(1);
        this.f1779c = 2;
        this.f1781g = c1Var;
        this.f1780f = e0Var;
        this.f1782h = rVar;
        this.i = tVar;
    }
}
