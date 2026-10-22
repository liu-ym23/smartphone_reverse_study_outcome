package q5;

import w7.e0;

/* loaded from: classes.dex */
public final class f extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8678f = 1;

    /* renamed from: g, reason: collision with root package name */
    public int f8679g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d5.e f8680h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ q f8681i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d5.e eVar, q qVar, g7.d dVar) {
        super(2, dVar);
        this.f8680h = eVar;
        this.f8681i = qVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f8678f) {
            case 0:
                return new f(this.f8681i, this.f8680h, dVar);
            default:
                return new f(this.f8680h, this.f8681i, dVar);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f8678f) {
        }
        return ((f) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f8678f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f8679g;
                if (i2 == 0) {
                    e0.N(obj);
                    this.f8679g = 1;
                    if (q.a(this.f8681i, this.f8680h, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return c7.r.f1986a;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f8679g;
                d5.e eVar = this.f8680h;
                try {
                    if (i10 == 0) {
                        e0.N(obj);
                        this.f8679g = 1;
                        Object objB = eVar.b(this);
                        this = objB;
                        if (objB == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e0.N(obj);
                        this = this;
                    }
                } catch (Throwable th) {
                    k5.s.warn$default(this.f8681i.f8755i, "Dispatcher", a1.a.k("broadcast target ", eVar.getId(), " close failed: ", th.getMessage()), null, 4, null);
                }
                return c7.r.f1986a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(q qVar, d5.e eVar, g7.d dVar) {
        super(2, dVar);
        this.f8681i = qVar;
        this.f8680h = eVar;
    }
}
