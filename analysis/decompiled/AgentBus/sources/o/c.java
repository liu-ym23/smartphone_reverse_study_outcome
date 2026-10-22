package o;

/* loaded from: classes.dex */
public final class c extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7027f;

    /* renamed from: g, reason: collision with root package name */
    public int f7028g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ r f7029h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ q.k f7030i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(r rVar, q.k kVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f7027f = i2;
        this.f7029h = rVar;
        this.f7030i = kVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f7027f) {
            case 0:
                return new c(this.f7029h, this.f7030i, dVar, 0);
            default:
                return new c(this.f7029h, this.f7030i, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f7027f) {
        }
        return ((c) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f7027f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f7028g;
                if (i2 == 0) {
                    w7.e0.N(obj);
                    q.i iVar = this.f7029h.f7118v;
                    if (iVar != null) {
                        this.f7028g = 1;
                        if (iVar.a(this.f7030i, this) == aVar) {
                            return aVar;
                        }
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
                int i10 = this.f7028g;
                if (i10 == 0) {
                    w7.e0.N(obj);
                    q.i iVar2 = this.f7029h.f7118v;
                    if (iVar2 != null) {
                        q.l lVar = new q.l(this.f7030i);
                        this.f7028g = 1;
                        if (iVar2.a(lVar, this) == aVar2) {
                            return aVar2;
                        }
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
