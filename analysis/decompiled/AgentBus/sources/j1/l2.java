package j1;

/* loaded from: classes.dex */
public final class l2 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5246f;

    /* renamed from: g, reason: collision with root package name */
    public int f5247g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n2 f5248h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l2(n2 n2Var, g7.d dVar, int i2) {
        super(2, dVar);
        this.f5246f = i2;
        this.f5248h = n2Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f5246f) {
            case 0:
                return new l2(this.f5248h, dVar, 0);
            default:
                return new l2(this.f5248h, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f5246f) {
        }
        return ((l2) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f5246f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f5247g;
                c7.r rVar = c7.r.f1986a;
                if (i2 == 0) {
                    w7.e0.N(obj);
                    y yVar = this.f5248h.f5283f;
                    this.f5247g = 1;
                    Object objD = yVar.f5390x.d(this);
                    if (objD != aVar) {
                        objD = rVar;
                    }
                    if (objD == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return rVar;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f5247g;
                c7.r rVar2 = c7.r.f1986a;
                if (i10 == 0) {
                    w7.e0.N(obj);
                    y yVar2 = this.f5248h.f5283f;
                    this.f5247g = 1;
                    Object objC = yVar2.f5392y.c(this);
                    if (objC != aVar2) {
                        objC = rVar2;
                    }
                    if (objC == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return rVar2;
        }
    }
}
