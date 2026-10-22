package p;

/* loaded from: classes.dex */
public final class q0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8153f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8154g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f8155h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q0(long j2, g7.d dVar, int i2) {
        super(2, dVar);
        this.f8153f = i2;
        this.f8155h = j2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f8153f) {
            case 0:
                q0 q0Var = new q0(this.f8155h, dVar, 0);
                q0Var.f8154g = obj;
                return q0Var;
            default:
                q0 q0Var2 = new q0(this.f8155h, dVar, 1);
                q0Var2.f8154g = obj;
                return q0Var2;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        w0 w0Var = (w0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f8153f) {
            case 0:
                q0 q0Var = (q0) create(w0Var, dVar);
                c7.r rVar = c7.r.f1986a;
                q0Var.invokeSuspend(rVar);
                return rVar;
            default:
                q0 q0Var2 = (q0) create(w0Var, dVar);
                c7.r rVar2 = c7.r.f1986a;
                q0Var2.invokeSuspend(rVar2);
                return rVar2;
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        int i2 = this.f8153f;
        c7.r rVar = c7.r.f1986a;
        long j2 = this.f8155h;
        switch (i2) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                w7.e0.N(obj);
                y0 y0Var = ((w0) this.f8154g).f8200a;
                y0.a(y0Var, y0Var.f8223h, j2, 1);
                break;
            default:
                h7.a aVar2 = h7.a.f4212f;
                w7.e0.N(obj);
                y0 y0Var2 = ((w0) this.f8154g).f8200a;
                y0.a(y0Var2, y0Var2.f8223h, j2, 1);
                break;
        }
        return rVar;
    }
}
