package h9;

import b0.p;
import c7.r;
import i1.c1;
import i1.d1;
import i1.f0;
import i1.m1;
import j1.q0;
import j1.t1;
import j1.y;
import p.s0;
import p7.n;
import r.c0;
import r.g0;
import r.i0;
import r.j0;
import u0.a0;

/* loaded from: classes.dex */
public final class b extends q7.m implements n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4231g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f4232h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f4233i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        super(2);
        this.f4231g = i2;
        this.f4232h = obj;
        this.f4233i = obj2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        int i2 = this.f4231g;
        boolean z4 = false;
        r rVar = r.f1986a;
        Object obj3 = this.f4233i;
        Object obj4 = this.f4232h;
        switch (i2) {
            case 0:
                f8.j jVar = (f8.j) obj2;
                if (q7.k.a((f8.j) obj, (f8.b) obj4) && q7.k.a(jVar, (f8.b) obj3)) {
                    z4 = true;
                }
                break;
            case 1:
                u0.l lVar = (u0.l) obj;
                x0.b bVar = (x0.b) obj2;
                d1 d1Var = (d1) obj4;
                f0 f0Var = d1Var.f4437t;
                if (!f0Var.C()) {
                    d1Var.M = true;
                    break;
                } else {
                    d1Var.J = lVar;
                    d1Var.I = bVar;
                    m1 snapshotObserver = ((y) i1.l.w(f0Var)).getSnapshotObserver();
                    a0 a0Var = d1.O;
                    snapshotObserver.a(d1Var, i1.d.f4422j, (c1) obj3);
                    d1Var.M = false;
                    break;
                }
            case 2:
                ((Number) obj2).intValue();
                q0.a((y) obj4, (n) obj3, (p) obj, b0.b.s(1));
                break;
            case 3:
                ((Number) obj2).intValue();
                n7.b.a((n0.m) obj4, (p7.k) obj3, (p) obj, b0.b.s(1));
                break;
            case 4:
                long j2 = ((t0.b) obj2).f9654a;
                ib.k.d((a7.a) obj4, (c1.l) obj);
                ka.g gVar = ((s0) obj3).f8181z;
                if (gVar != null) {
                    gVar.u(new p.n(j2));
                    break;
                }
                break;
            case 5:
                int iIntValue = ((Number) obj).intValue();
                p1.n nVar = (p1.n) obj2;
                p0.c cVar = (p0.c) obj3;
                if (!((t1) obj4).f5335b.b(nVar.f8318g)) {
                    cVar.k(iIntValue, nVar);
                    cVar.f8251m.u(rVar);
                    break;
                }
                break;
            default:
                p pVar = (p) obj;
                if ((((Number) obj2).intValue() & 3) != 2 || !pVar.z()) {
                    n0.m mVarC = androidx.compose.foundation.layout.a.c(androidx.compose.foundation.layout.a.a(y.b.f11355b, y.b.f11356c), (c0) obj4);
                    j0.d dVar = (j0.d) obj3;
                    i0 i0VarA = g0.a(r.i.f8868c, n0.b.f6782p, pVar, 54);
                    int iK = b0.b.k(pVar);
                    b0.t1 t1VarL = pVar.l();
                    n0.m mVarV = a.a.V(pVar, mVarC);
                    i1.h.f4488c.getClass();
                    i1.y yVar = i1.g.f4474b;
                    pVar.U();
                    if (pVar.P) {
                        pVar.k(yVar);
                    } else {
                        pVar.e0();
                    }
                    b0.b.q(pVar, i0VarA, i1.g.f4477e);
                    b0.b.q(pVar, t1VarL, i1.g.f4476d);
                    i1.f fVar = i1.g.f4478f;
                    if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK))) {
                        a1.a.r(iK, pVar, iK, fVar);
                    }
                    b0.b.q(pVar, mVarV, i1.g.f4475c);
                    dVar.j(j0.f8876a, pVar, 6);
                    pVar.q(true);
                    break;
                } else {
                    pVar.O();
                    break;
                }
                break;
        }
        return rVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, c7.c cVar, int i2, int i10) {
        super(2);
        this.f4231g = i10;
        this.f4232h = obj;
        this.f4233i = cVar;
    }
}
