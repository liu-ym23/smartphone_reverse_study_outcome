package o4;

/* loaded from: classes.dex */
public final class v0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7661f;

    /* renamed from: g, reason: collision with root package name */
    public int f7662g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ia.r f7663h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v0(ia.r rVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f7661f = i2;
        this.f7663h = rVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f7661f) {
            case 0:
                return new v0(this.f7663h, dVar, 0);
            case 1:
                return new v0(this.f7663h, dVar, 1);
            default:
                return new v0(this.f7663h, dVar, 2);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f7661f) {
        }
        return ((v0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f7661f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f7662g;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                    return obj;
                }
                w7.e0.N(obj);
                this.f7662g = 1;
                Object objA = ((ia.s) this.f7663h).A(this);
                return objA == aVar ? aVar : objA;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f7662g;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                    return obj;
                }
                w7.e0.N(obj);
                this.f7662g = 1;
                Object objA2 = ((ia.s) this.f7663h).A(this);
                return objA2 == aVar2 ? aVar2 : objA2;
            default:
                h7.a aVar3 = h7.a.f4212f;
                int i11 = this.f7662g;
                if (i11 != 0) {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                    return obj;
                }
                w7.e0.N(obj);
                this.f7662g = 1;
                Object objA3 = ((ia.s) this.f7663h).A(this);
                return objA3 == aVar3 ? aVar3 : objA3;
        }
    }
}
