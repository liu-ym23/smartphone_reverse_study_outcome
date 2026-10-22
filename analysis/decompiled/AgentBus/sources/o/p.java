package o;

/* loaded from: classes.dex */
public final class p extends q7.m implements p7.o {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f7108g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p7.a f7109h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(boolean z4, p7.a aVar) {
        super(3);
        this.f7108g = z4;
        this.f7109h = aVar;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        q.i iVar;
        b0.p pVar = (b0.p) obj2;
        ((Number) obj3).intValue();
        pVar.S(-756081143);
        g0 g0Var = (g0) pVar.j(androidx.compose.foundation.c.f720a);
        if (g0Var instanceof m0) {
            pVar.S(617140216);
            pVar.q(false);
            iVar = null;
        } else {
            pVar.S(617248189);
            Object objJ = pVar.J();
            if (objJ == b0.k.f1229a) {
                objJ = new q.i();
                pVar.b0(objJ);
            }
            iVar = (q.i) objJ;
            pVar.q(false);
        }
        n0.m mVarB = androidx.compose.foundation.a.b(n0.j.f6796a, iVar, g0Var, this.f7108g, this.f7109h);
        pVar.q(false);
        return mVarB;
    }
}
