package i1;

/* loaded from: classes.dex */
public final class w extends n0 {

    /* renamed from: z, reason: collision with root package name */
    public final /* synthetic */ x f4625z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(x xVar) {
        super(xVar);
        this.f4625z = xVar;
    }

    @Override // i1.m0
    public final int S(g1.f fVar) {
        int iC = l.c(this, fVar);
        this.f4549y.h(iC, fVar);
        return iC;
    }

    @Override // g1.o
    public final g1.s b(long j2) {
        P(j2);
        new d2.a(j2);
        x xVar = this.f4625z;
        v vVar = xVar.S;
        d1 d1Var = xVar.f4438u;
        q7.k.b(d1Var);
        n0 n0VarX0 = d1Var.x0();
        q7.k.b(n0VarX0);
        n0.o0(this, vVar.G(this, n0VarX0, j2));
        return this;
    }
}
