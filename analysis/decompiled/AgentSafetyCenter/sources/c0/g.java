package c0;

import d1.p;
import d2.h0;
import d2.i0;
import d2.l0;
import java.lang.invoke.VarHandle;
import java.util.List;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2137c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f2138f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(h hVar, int i) {
        super(1);
        this.f2137c = i;
        this.f2138f = hVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f2137c;
        i0 i0Var = null;
        h hVar = this.f2138f;
        switch (i) {
            case 0:
                List list = (List) obj;
                i0 i0Var2 = hVar.B0().f2117n;
                if (i0Var2 != null) {
                    h0 h0Var = i0Var2.f3122a;
                    i0 i0Var3 = new i0(new h0(h0Var.f3106a, l0.d(hVar.f2140t, p.f3024g, 0L, null, 0L, 0, 0L, 16777214), h0Var.f3108c, h0Var.f3109d, h0Var.f3110e, h0Var.f3111f, h0Var.f3112g, h0Var.f3113h, h0Var.i, h0Var.f3114j), i0Var2.f3123b, i0Var2.f3124c);
                    list.add(i0Var3);
                    i0Var = i0Var3;
                }
                break;
            case 1:
                d2.g gVar = (d2.g) obj;
                f fVar = hVar.G;
                if (fVar == null) {
                    d2.g gVar2 = hVar.f2139s;
                    f fVar2 = new f();
                    fVar2.f2133a = gVar2;
                    fVar2.f2134b = gVar;
                    fVar2.f2135c = false;
                    fVar2.f2136d = null;
                    VarHandle.storeStoreFence();
                    d dVar = new d(gVar, hVar.f2140t, hVar.f2141u, hVar.f2143w, hVar.f2144x, hVar.f2145y, hVar.f2146z, hVar.A);
                    dVar.a(hVar.B0().f2114k);
                    fVar2.f2136d = dVar;
                    hVar.G = fVar2;
                } else if (!yb.k.a(gVar, fVar.f2134b)) {
                    fVar.f2134b = gVar;
                    d dVar2 = fVar.f2136d;
                    if (dVar2 != null) {
                        l0 l0Var = hVar.f2140t;
                        g2.d dVar3 = hVar.f2141u;
                        int i3 = hVar.f2143w;
                        boolean z10 = hVar.f2144x;
                        int i10 = hVar.f2145y;
                        int i11 = hVar.f2146z;
                        List list2 = hVar.A;
                        dVar2.f2105a = gVar;
                        dVar2.f2106b = l0Var;
                        dVar2.f2107c = dVar3;
                        dVar2.f2108d = i3;
                        dVar2.f2109e = z10;
                        dVar2.f2110f = i10;
                        dVar2.f2111g = i11;
                        dVar2.f2112h = list2;
                        dVar2.f2115l = null;
                        dVar2.f2117n = null;
                    }
                }
                u1.f.n(hVar);
                u1.f.m(hVar);
                u1.f.l(hVar);
                break;
            default:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                f fVar3 = hVar.G;
                if (fVar3 != null) {
                    xb.l lVar = hVar.C;
                    if (lVar != null) {
                        lVar.invoke(fVar3);
                    }
                    f fVar4 = hVar.G;
                    if (fVar4 != null) {
                        fVar4.f2135c = zBooleanValue;
                    }
                    u1.f.n(hVar);
                    u1.f.m(hVar);
                    u1.f.l(hVar);
                    break;
                } else {
                    break;
                }
        }
        return Boolean.TRUE;
    }
}
