package s8;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9542g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f9543h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(f fVar, int i2) {
        super(0);
        this.f9542g = i2;
        this.f9543h = fVar;
    }

    @Override // p7.a
    public final Object c() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        switch (this.f9542g) {
            case 0:
                f fVar = this.f9543h;
                ArrayList arrayListB = fVar.f9546b.b();
                ArrayList arrayList = new ArrayList();
                Iterator it = arrayListB.iterator();
                while (it.hasNext()) {
                    v8.a aVar = (v8.a) it.next();
                    e9.f fVar2 = ((l8.f) aVar).f5867a;
                    if (fVar2 == null) {
                        fVar2 = o8.x.f7859b;
                    }
                    j9.g gVarC = fVar.c(aVar);
                    c7.j jVar = gVarC != null ? new c7.j(fVar2, gVarC) : null;
                    if (jVar != null) {
                        arrayList.add(jVar);
                    }
                }
                return d7.e0.Z(arrayList);
            case 1:
                return l8.d.a(nb.i.t(nb.i.p(this.f9543h.f9546b.f5865a))).b();
            default:
                f fVar3 = this.f9543h;
                e9.c cVarA = fVar3.a();
                l8.e eVar = fVar3.f9546b;
                a3.b bVar = fVar3.f9545a;
                if (cVarA == null) {
                    return x9.i.c(x9.h.J, eVar.toString());
                }
                r8.a aVar2 = (r8.a) bVar.f162f;
                r8.a aVar3 = (r8.a) bVar.f162f;
                f8.e eVarC = e8.e.c(cVarA, aVar2.f9016o.n());
                if (eVarC == null) {
                    l8.o oVar = new l8.o(nb.i.t(nb.i.p(eVar.f5865a)));
                    o4.d0 d0Var = aVar3.f9012k;
                    d0Var.getClass();
                    a7.d dVar = (a7.d) d0Var.f7326g;
                    if (dVar == null) {
                        q7.k.j("resolver");
                        throw null;
                    }
                    eVarC = dVar.H(oVar);
                    if (eVarC == null) {
                        eVarC = f8.v.f(aVar3.f9016o, e9.b.j(cVarA), aVar3.f9005d.c().f9058l);
                    }
                }
                return eVarC.k();
        }
    }
}
