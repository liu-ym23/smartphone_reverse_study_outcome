package y;

import androidx.compose.material3.MinimumInteractiveModifier;
import b0.c3;
import b0.t1;
import j1.g1;
import n.f1;

/* loaded from: classes.dex */
public final class h0 extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n0.m f11419g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ u0.c0 f11420h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f11421i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ float f11422j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ o.o f11423k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ q.i f11424l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f11425m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ p7.a f11426n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ float f11427o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ j0.d f11428p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(n0.m mVar, u0.c0 c0Var, long j2, float f10, o.o oVar, q.i iVar, boolean z4, p7.a aVar, float f11, j0.d dVar) {
        super(2);
        this.f11419g = mVar;
        this.f11420h = c0Var;
        this.f11421i = j2;
        this.f11422j = f10;
        this.f11423k = oVar;
        this.f11424l = iVar;
        this.f11425m = z4;
        this.f11426n = aVar;
        this.f11427o = f11;
        this.f11428p = dVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        o.g0 c0Var;
        b0.p pVar = (b0.p) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && pVar.z()) {
            pVar.O();
        } else {
            c3 c3Var = r.f11519a;
            n0.m mVarB = i0.b(this.f11419g.c(MinimumInteractiveModifier.f753a), this.f11420h, i0.c(this.f11421i, this.f11422j, pVar), this.f11423k, ((d2.c) pVar.j(g1.f5174h)).o(this.f11427o));
            c3 c3Var2 = b0.f11357a;
            long j2 = u0.m.f9916f;
            pVar.S(-1280632857);
            if (((Boolean) pVar.j(b0.f11357a)).booleanValue()) {
                f1 f1Var = x.o.f11044a;
                b0.f1 f1VarP = b0.b.p(new u0.m(j2), pVar);
                boolean zG = pVar.g(true) | pVar.c(Float.NaN);
                Object objJ = pVar.J();
                if (zG || objJ == b0.k.f1229a) {
                    objJ = new x.e(f1VarP);
                    pVar.b0(objJ);
                }
                c0Var = (x.e) objJ;
            } else {
                c0Var = (d2.f.a(Float.NaN, Float.NaN) && u0.m.c(j2, j2)) ? b0.f11359c : new c0(j2, true);
            }
            pVar.q(false);
            n0.m mVarB2 = androidx.compose.foundation.a.b(mVarB, this.f11424l, c0Var, this.f11425m, this.f11426n);
            n0.e eVar = n0.b.f6772f;
            Object oVar = (g1.p) r.l.f8885a.get(eVar);
            if (oVar == null) {
                oVar = new r.o(eVar, true);
            }
            int iHashCode = Long.hashCode(pVar.Q);
            t1 t1VarL = pVar.l();
            n0.m mVarV = a.a.V(pVar, mVarB2);
            i1.h.f4488c.getClass();
            i1.y yVar = i1.g.f4474b;
            pVar.U();
            if (pVar.P) {
                pVar.k(yVar);
            } else {
                pVar.e0();
            }
            b0.b.q(pVar, oVar, i1.g.f4477e);
            b0.b.q(pVar, t1VarL, i1.g.f4476d);
            i1.f fVar = i1.g.f4478f;
            if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iHashCode))) {
                a1.a.r(iHashCode, pVar, iHashCode, fVar);
            }
            b0.b.q(pVar, mVarV, i1.g.f4475c);
            this.f11428p.invoke(pVar, 0);
            pVar.q(true);
        }
        return c7.r.f1986a;
    }
}
