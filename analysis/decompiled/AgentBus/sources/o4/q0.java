package o4;

/* loaded from: classes.dex */
public final class q0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7518f;

    /* renamed from: g, reason: collision with root package name */
    public int f7519g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f1 f7520h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q0(f1 f1Var, g7.d dVar, int i2) {
        super(2, dVar);
        this.f7518f = i2;
        this.f7520h = f1Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f7518f) {
            case 0:
                return new q0(this.f7520h, dVar, 0);
            case 1:
                return new q0(this.f7520h, dVar, 1);
            case 2:
                return new q0(this.f7520h, dVar, 2);
            case 3:
                return new q0(this.f7520h, dVar, 3);
            default:
                return new q0(this.f7520h, dVar, 4);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f7518f) {
        }
        return ((q0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f7518f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f7519g;
                if (i2 == 0) {
                    w7.e0.N(obj);
                    this.f7519g = 1;
                    if (f1.c(this.f7520h, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return c7.r.f1986a;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f7519g;
                if (i10 == 0) {
                    w7.e0.N(obj);
                    ka.g gVar = this.f7520h.f7349f;
                    this.f7519g = 1;
                    if (gVar.c(this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return c7.r.f1986a;
            case 2:
                h7.a aVar3 = h7.a.f4212f;
                int i11 = this.f7519g;
                if (i11 == 0) {
                    w7.e0.N(obj);
                    ka.g gVar2 = this.f7520h.f7349f;
                    this.f7519g = 1;
                    if (gVar2.c(this) == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return c7.r.f1986a;
            case 3:
                h7.a aVar4 = h7.a.f4212f;
                int i12 = this.f7519g;
                if (i12 == 0) {
                    w7.e0.N(obj);
                    ka.g gVar3 = this.f7520h.f7349f;
                    this.f7519g = 1;
                    if (gVar3.c(this) == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return c7.r.f1986a;
            default:
                h7.a aVar5 = h7.a.f4212f;
                int i13 = this.f7519g;
                if (i13 == 0) {
                    w7.e0.N(obj);
                    ka.g gVar4 = this.f7520h.f7349f;
                    this.f7519g = 1;
                    if (gVar4.c(this) == aVar5) {
                        return aVar5;
                    }
                } else {
                    if (i13 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return c7.r.f1986a;
        }
    }
}
