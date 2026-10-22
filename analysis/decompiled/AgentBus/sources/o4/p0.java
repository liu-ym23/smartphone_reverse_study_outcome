package o4;

/* loaded from: classes.dex */
public final class p0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7502f;

    /* renamed from: g, reason: collision with root package name */
    public int f7503g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ia.s f7504h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p0(ia.s sVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f7502f = i2;
        this.f7504h = sVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f7502f) {
            case 0:
                return new p0(this.f7504h, dVar, 0);
            default:
                return new p0(this.f7504h, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f7502f) {
        }
        return ((p0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f7502f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f7503g;
                if (i2 == 0) {
                    w7.e0.N(obj);
                    this.f7503g = 1;
                    if (this.f7504h.A(this) == aVar) {
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
                int i10 = this.f7503g;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                    return obj;
                }
                w7.e0.N(obj);
                this.f7503g = 1;
                Object objA = this.f7504h.A(this);
                return objA == aVar2 ? aVar2 : objA;
        }
    }
}
