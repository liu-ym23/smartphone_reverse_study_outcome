package p;

/* loaded from: classes.dex */
public final class a1 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8053f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h0 f8054g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(h0 h0Var, g7.d dVar, int i2) {
        super(2, dVar);
        this.f8053f = i2;
        this.f8054g = h0Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f8053f) {
            case 0:
                return new a1(this.f8054g, dVar, 0);
            default:
                return new a1(this.f8054g, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f8053f) {
            case 0:
                a1 a1Var = (a1) create(b0Var, dVar);
                c7.r rVar = c7.r.f1986a;
                a1Var.invokeSuspend(rVar);
                return rVar;
            default:
                a1 a1Var2 = (a1) create(b0Var, dVar);
                c7.r rVar2 = c7.r.f1986a;
                a1Var2.invokeSuspend(rVar2);
                return rVar2;
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        int i2 = this.f8053f;
        c7.r rVar = c7.r.f1986a;
        h0 h0Var = this.f8054g;
        switch (i2) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                w7.e0.N(obj);
                h0Var.f8115h = true;
                ra.a.unlock$default(h0Var.f8116i, null, 1, null);
                break;
            default:
                h7.a aVar2 = h7.a.f4212f;
                w7.e0.N(obj);
                h0Var.f8114g = true;
                ra.a.unlock$default(h0Var.f8116i, null, 1, null);
                break;
        }
        return rVar;
    }
}
