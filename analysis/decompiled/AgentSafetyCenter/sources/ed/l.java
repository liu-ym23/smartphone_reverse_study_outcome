package ed;

import java.lang.invoke.VarHandle;
import jb.v;
import p.j0;
import p.z;
import u.o1;
import u1.g1;
import u1.i0;
import v1.s1;
import x.r;
import y.m0;
import y.y;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3816c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3817f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3818g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f3819h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public l(z.d dVar, g1 g1Var, xb.a aVar) {
        super(0);
        this.f3816c = 5;
        this.f3817f = dVar;
        this.f3818g = g1Var;
        this.f3819h = (yb.l) aVar;
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [xb.a, yb.l] */
    @Override // xb.a
    public final Object invoke() {
        int i = this.f3816c;
        v vVar = v.f6774a;
        Object obj = this.f3819h;
        Object obj2 = this.f3818g;
        Object obj3 = this.f3817f;
        switch (i) {
            case 0:
                md.c cVar = ((ad.e) obj3).f467b;
                cVar.getClass();
                return cVar.a(((ad.a) obj).f428h.f562d, ((ad.m) obj2).a());
            case 1:
                i0 i0Var = (i0) obj;
                ((u) obj3).f16098c = ((t.h) obj2).f12989v.a(i0Var.f13838c.e(), i0Var.getLayoutDirection(), i0Var);
                return vVar;
            case 2:
                u.i iVar = (u.i) obj3;
                sa.c cVar2 = iVar.f13482v;
                while (true) {
                    m0.e eVar = (m0.e) cVar2.f12170f;
                    int i3 = eVar.f8160g;
                    if (i3 != 0) {
                        if (i3 == 0) {
                            g5.f.m("MutableVector is empty.");
                            return null;
                        }
                        c1.c cVar3 = (c1.c) ((u.h) eVar.f8158c[i3 - 1]).f13471a.invoke();
                        if (cVar3 == null ? true : iVar.D0(cVar3, iVar.f13486z)) {
                            ((u.h) eVar.k(eVar.f8160g - 1)).f13472b.resumeWith(vVar);
                        }
                    }
                }
                if (iVar.f13485y) {
                    c1.c cVarC0 = iVar.C0();
                    if (cVarC0 != null && iVar.D0(cVarC0, iVar.f13486z)) {
                        iVar.f13485y = false;
                    }
                }
                ((o1) obj2).f13545e = u.i.B0(iVar, (u.d) obj);
                return vVar;
            case 3:
                v1.a aVar = (v1.a) obj3;
                aVar.removeOnAttachStateChangeListener((ab.b) obj2);
                id.k.D(aVar).f11367a.remove((s1) obj);
                return vVar;
            case 4:
                x.f fVar = (x.f) ((k0.i0) obj3).getValue();
                r rVar = (r) obj2;
                ec.g gVar = (ec.g) ((y) rVar.f15482d.f3787e).getValue();
                b2.a aVar2 = new b2.a(7);
                b2.a aVar3 = fVar.f15407a;
                int i10 = gVar.f3758c;
                if (i10 < 0) {
                    od.f.e("negative nearestRange.first");
                    return null;
                }
                int iMin = Math.min(gVar.f3759f, aVar3.f1860b - 1);
                if (iMin < i10) {
                    z zVar = j0.f9585a;
                    zVar.getClass();
                    aVar2.f1861c = zVar;
                    aVar2.f1862d = new Object[0];
                    aVar2.f1860b = 0;
                } else {
                    int i11 = (iMin - i10) + 1;
                    aVar2.f1862d = new Object[i11];
                    aVar2.f1860b = i10;
                    z zVar2 = new z(i11);
                    m0 m0Var = new m0(i10, iMin, zVar2, aVar2);
                    m0.e eVar2 = (m0.e) aVar3.f1861c;
                    aVar3.e(i10);
                    aVar3.e(iMin);
                    if (iMin < i10) {
                        throw new IllegalArgumentException(("toIndex (" + iMin + ") should be not smaller than fromIndex (" + i10 + ')').toString());
                    }
                    int iB = t2.a.b(i10, eVar2);
                    int i12 = ((y.h) eVar2.f8158c[iB]).f15745a;
                    while (i12 <= iMin) {
                        y.h hVar = (y.h) eVar2.f8158c[iB];
                        m0Var.invoke(hVar);
                        i12 += hVar.f15746b;
                        iB++;
                    }
                    aVar2.f1861c = zVar2;
                }
                VarHandle.storeStoreFence();
                x.h hVar2 = new x.h();
                hVar2.f15412a = rVar;
                hVar2.f15413b = fVar;
                hVar2.f15414c = (x.b) obj;
                hVar2.f15415d = aVar2;
                VarHandle.storeStoreFence();
                return hVar2;
            default:
                z.d dVar = (z.d) obj3;
                c1.c cVarB0 = z.d.B0(dVar, (g1) obj2, (yb.l) obj);
                if (cVarB0 == null) {
                    return null;
                }
                u.i iVar2 = dVar.f16135s;
                if (!o2.k.b(iVar2.f13486z, 0L)) {
                    return cVarB0.e(iVar2.F0(cVarB0, iVar2.f13486z) ^ (-9223372034707292160L));
                }
                od.f.e("Expected BringIntoViewRequester to not be used before parents are placed.");
                return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(Object obj, Object obj2, Object obj3, int i) {
        super(0);
        this.f3816c = i;
        this.f3817f = obj;
        this.f3818g = obj2;
        this.f3819h = obj3;
    }
}
