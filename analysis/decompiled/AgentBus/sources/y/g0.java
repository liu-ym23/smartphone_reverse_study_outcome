package y;

import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.semantics.AppendedSemanticsElement;
import b0.t1;
import j1.g1;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class g0 extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n0.m f11403g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ u0.c0 f11404h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f11405i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ float f11406j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ float f11407k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ j0.d f11408l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(n0.m mVar, u0.c0 c0Var, long j2, float f10, float f11, j0.d dVar) {
        super(2);
        this.f11403g = mVar;
        this.f11404h = c0Var;
        this.f11405i = j2;
        this.f11406j = f10;
        this.f11407k = f11;
        this.f11408l = dVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0.p pVar = (b0.p) obj;
        int iIntValue = ((Number) obj2).intValue() & 3;
        c7.r rVar = c7.r.f1986a;
        if (iIntValue == 2 && pVar.z()) {
            pVar.O();
            return rVar;
        }
        n0.m mVarB = i0.b(this.f11403g, this.f11404h, i0.c(this.f11405i, this.f11406j, pVar), null, ((d2.c) pVar.j(g1.f5174h)).o(this.f11407k));
        e eVar = e.f11380j;
        AtomicInteger atomicInteger = p1.j.f8308a;
        n0.m mVarC = mVarB.c(new AppendedSemanticsElement(eVar, false));
        h5.c cVar = new h5.c(2, null, 7);
        c1.f fVar = c1.t.f1840a;
        n0.m mVarC2 = mVarC.c(new SuspendPointerInputElement(rVar, null, new c1.s(cVar), 6));
        n0.e eVar2 = n0.b.f6772f;
        Object oVar = (g1.p) r.l.f8885a.get(eVar2);
        if (oVar == null) {
            oVar = new r.o(eVar2, true);
        }
        int iHashCode = Long.hashCode(pVar.Q);
        t1 t1VarL = pVar.l();
        n0.m mVarV = a.a.V(pVar, mVarC2);
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
        i1.f fVar2 = i1.g.f4478f;
        if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iHashCode))) {
            a1.a.r(iHashCode, pVar, iHashCode, fVar2);
        }
        b0.b.q(pVar, mVarV, i1.g.f4475c);
        this.f11408l.invoke(pVar, 0);
        pVar.q(true);
        return rVar;
    }
}
