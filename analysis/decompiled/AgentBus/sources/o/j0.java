package o;

/* loaded from: classes.dex */
public final class j0 extends q7.m implements p7.o {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g0 f7070g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q.i f7071h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(g0 g0Var, q.i iVar) {
        super(3);
        this.f7070g = g0Var;
        this.f7071h = iVar;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        b0.p pVar = (b0.p) obj2;
        ((Number) obj3).intValue();
        pVar.S(-353972293);
        h0 h0VarA = this.f7070g.a(this.f7071h, pVar);
        boolean zF = pVar.f(h0VarA);
        Object objJ = pVar.J();
        if (zF || objJ == b0.k.f1229a) {
            objJ = new k0(h0VarA);
            pVar.b0(objJ);
        }
        k0 k0Var = (k0) objJ;
        pVar.q(false);
        return k0Var;
    }
}
