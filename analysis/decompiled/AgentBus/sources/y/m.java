package y;

import n.f1;

/* loaded from: classes.dex */
public final class m extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11503g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n f11504h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(n nVar, int i2) {
        super(0);
        this.f11503g = i2;
        this.f11504h = nVar;
    }

    @Override // p7.a
    public final Object c() {
        int i2 = this.f11503g;
        n nVar = this.f11504h;
        switch (i2) {
            case 0:
                return a0.f11353a;
            default:
                if (((z) i1.l.h(nVar, b0.f11358b)) == null) {
                    x.p pVar = nVar.f11510z;
                    if (pVar != null) {
                        nVar.m0(pVar);
                    }
                } else if (nVar.f11510z == null) {
                    o4.d0 d0Var = new o4.d0(21, nVar);
                    m mVar = new m(nVar, 0);
                    q.i iVar = nVar.f11506v;
                    boolean z4 = nVar.f11507w;
                    float f10 = nVar.f11508x;
                    f1 f1Var = x.o.f11044a;
                    x.p cVar = x.s.f11056a ? new x.c(iVar, z4, f10, d0Var, mVar) : new x.b(iVar, z4, f10, d0Var, mVar);
                    nVar.l0(cVar);
                    nVar.f11510z = cVar;
                }
                return c7.r.f1986a;
        }
    }
}
