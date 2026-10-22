package o;

/* loaded from: classes.dex */
public final class q extends i7.i implements p7.o {

    /* renamed from: f, reason: collision with root package name */
    public int f7112f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ p.h0 f7113g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ long f7114h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ r f7115i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, g7.d dVar) {
        super(3, dVar);
        this.f7115i = rVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        Object objF;
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f7112f;
        c7.r rVar = c7.r.f1986a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            w7.e0.N(obj);
            return rVar;
        }
        w7.e0.N(obj);
        p.h0 h0Var = this.f7113g;
        long j2 = this.f7114h;
        r rVar2 = this.f7115i;
        if (rVar2.f7120x) {
            this.f7112f = 1;
            q.i iVar = rVar2.f7118v;
            if (iVar == null || (objF = ia.d0.f(new b(h0Var, j2, iVar, rVar2, null), this)) != aVar) {
                objF = rVar;
            }
            if (objF == aVar) {
                return aVar;
            }
        }
        return rVar;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        long j2 = ((t0.b) obj2).f9654a;
        q qVar = new q(this.f7115i, (g7.d) obj3);
        qVar.f7113g = (p.h0) obj;
        qVar.f7114h = j2;
        return qVar.invokeSuspend(c7.r.f1986a);
    }
}
