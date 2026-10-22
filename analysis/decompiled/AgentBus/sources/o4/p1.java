package o4;

/* loaded from: classes.dex */
public final class p1 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7505f;

    /* renamed from: g, reason: collision with root package name */
    public int f7506g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t1 f7507h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f7508i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p1(t1 t1Var, long j2, g7.d dVar, int i2) {
        super(2, dVar);
        this.f7505f = i2;
        this.f7507h = t1Var;
        this.f7508i = j2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f7505f) {
            case 0:
                return new p1(this.f7507h, this.f7508i, dVar, 0);
            default:
                return new p1(this.f7507h, this.f7508i, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f7505f) {
        }
        return ((p1) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f7505f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f7506g;
                if (i2 == 0) {
                    w7.e0.N(obj);
                    t1 t1Var = this.f7507h;
                    f1 f1Var = t1Var.f7597y;
                    this.f7506g = 1;
                    if (t1.c(t1Var, f1Var, "node", this.f7508i, this) == aVar) {
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
                int i10 = this.f7506g;
                if (i10 == 0) {
                    w7.e0.N(obj);
                    t1 t1Var2 = this.f7507h;
                    f1 f1Var2 = t1Var2.f7596x;
                    this.f7506g = 1;
                    if (t1.c(t1Var2, f1Var2, "operator", this.f7508i, this) == aVar2) {
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
}
