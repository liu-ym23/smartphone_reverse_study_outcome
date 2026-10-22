package n;

/* loaded from: classes.dex */
public final class y0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6764f = 1;

    /* renamed from: g, reason: collision with root package name */
    public int f6765g;

    /* renamed from: h, reason: collision with root package name */
    public float f6766h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f6767i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6768j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(c1.o oVar, float f10, h hVar, g7.d dVar) {
        super(2, dVar);
        this.f6767i = oVar;
        this.f6766h = f10;
        this.f6768j = hVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6764f) {
            case 0:
                y0 y0Var = new y0((b1) this.f6768j, dVar);
                y0Var.f6767i = obj;
                return y0Var;
            default:
                return new y0((c1.o) this.f6767i, this.f6766h, (h) this.f6768j, dVar);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f6764f) {
        }
        return ((y0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        float fG;
        ia.b0 b0Var;
        switch (this.f6764f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f6765g;
                if (i2 == 0) {
                    w7.e0.N(obj);
                    ia.b0 b0Var2 = (ia.b0) this.f6767i;
                    fG = d.g(b0Var2.k());
                    b0Var = b0Var2;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fG = this.f6766h;
                    b0Var = (ia.b0) this.f6767i;
                    w7.e0.N(obj);
                }
                while (ia.d0.q(b0Var)) {
                    x0 x0Var = new x0((b1) this.f6768j, fG);
                    this.f6767i = b0Var;
                    this.f6766h = fG;
                    this.f6765g = 1;
                    if (b0.b.l(getContext()).K(x0Var, this) == aVar) {
                        return aVar;
                    }
                }
                return c7.r.f1986a;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f6765g;
                if (i10 == 0) {
                    w7.e0.N(obj);
                    c cVar = (c) ((c1.o) this.f6767i).f1835c;
                    Float f10 = new Float(this.f6766h);
                    h hVar = (h) this.f6768j;
                    this.f6765g = 1;
                    if (c.b(cVar, f10, hVar, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return c7.r.f1986a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(b1 b1Var, g7.d dVar) {
        super(2, dVar);
        this.f6768j = b1Var;
    }
}
