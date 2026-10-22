package o4;

/* loaded from: classes.dex */
public final class y2 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7706f;

    /* renamed from: g, reason: collision with root package name */
    public int f7707g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b3 f7708h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y2(b3 b3Var, g7.d dVar, int i2) {
        super(2, dVar);
        this.f7706f = i2;
        this.f7708h = b3Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f7706f) {
            case 0:
                return new y2(this.f7708h, dVar, 0);
            case 1:
                return new y2(this.f7708h, dVar, 1);
            case 2:
                return new y2(this.f7708h, dVar, 2);
            default:
                return new y2(this.f7708h, dVar, 3);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f7706f) {
            case 0:
                ((y2) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
                break;
        }
        return ((y2) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f7706f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f7707g;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                    throw new a4.u();
                }
                w7.e0.N(obj);
                b3 b3Var = this.f7708h;
                la.j0 j0Var = b3Var.f7286c.B;
                a6.q qVar = new a6.q(5, b3Var);
                this.f7707g = 1;
                j0Var.x(qVar, this);
                return aVar;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f7707g;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                    return c7.r.f1986a;
                }
                w7.e0.N(obj);
                b3 b3Var2 = this.f7708h;
                String str = b3Var2.f7284a;
                la.f0 f0Var = b3Var2.f7296m;
                k5.q qVar2 = b3Var2.f7290g;
                this.f7707g = 1;
                a.l(str, f0Var, qVar2, this);
                return aVar2;
            case 2:
                h7.a aVar3 = h7.a.f4212f;
                int i11 = this.f7707g;
                c7.r rVar = c7.r.f1986a;
                if (i11 == 0) {
                    w7.e0.N(obj);
                    this.f7707g = 1;
                    this.f7708h.b(this);
                    if (rVar == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return rVar;
            default:
                h7.a aVar4 = h7.a.f4212f;
                int i12 = this.f7707g;
                c7.r rVar2 = c7.r.f1986a;
                if (i12 == 0) {
                    w7.e0.N(obj);
                    this.f7707g = 1;
                    this.f7708h.b(this);
                    if (rVar2 == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    w7.e0.N(obj);
                }
                return rVar2;
        }
    }
}
