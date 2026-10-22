package s2;

import ia.w1;

/* loaded from: classes.dex */
public final class o extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9406f;

    /* renamed from: g, reason: collision with root package name */
    public int f9407g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9408h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ z f9409i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(z zVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f9406f = i2;
        this.f9409i = zVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f9406f) {
            case 0:
                o oVar = new o(this.f9409i, dVar, 0);
                oVar.f9408h = obj;
                return oVar;
            default:
                o oVar2 = new o(this.f9409i, dVar, 1);
                oVar2.f9408h = obj;
                return oVar2;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f9406f) {
            case 0:
                return ((o) create((ka.t) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            default:
                return ((o) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f9406f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f9407g;
                if (i2 == 0) {
                    w7.e0.N(obj);
                    ka.t tVar = (ka.t) this.f9408h;
                    ia.c0 c0Var = ia.c0.f4927g;
                    z zVar = this.f9409i;
                    g7.d dVar = null;
                    w1 w1VarS = ia.d0.s(tVar, null, c0Var, new n(zVar, dVar, 0), 1);
                    int i10 = 22;
                    la.o oVar = new la.o(new q6.b(i10, new g3.b(w1VarS, dVar, 4), zVar.f9468j), new l(w1VarS, null));
                    a6.q qVar = new a6.q(8, tVar);
                    this.f9407g = 1;
                    if (oVar.x(qVar, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return c7.r.f1986a;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i11 = this.f9407g;
                if (i11 == 0) {
                    w7.e0.N(obj);
                    b0 b0Var = (b0) this.f9408h;
                    this.f9407g = 1;
                    if (z.a(this.f9409i, b0Var, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return c7.r.f1986a;
        }
    }
}
