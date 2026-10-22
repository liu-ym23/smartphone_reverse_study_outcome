package o;

/* loaded from: classes.dex */
public final class d extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7031f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ r f7032g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(r rVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f7031f = i2;
        this.f7032g = rVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f7031f) {
            case 0:
                return new d(this.f7032g, dVar, 0);
            default:
                return new d(this.f7032g, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f7031f) {
            case 0:
                d dVar2 = (d) create(b0Var, dVar);
                c7.r rVar = c7.r.f1986a;
                dVar2.invokeSuspend(rVar);
                return rVar;
            default:
                d dVar3 = (d) create(b0Var, dVar);
                c7.r rVar2 = c7.r.f1986a;
                dVar3.invokeSuspend(rVar2);
                return rVar2;
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        int i2 = this.f7031f;
        c7.r rVar = c7.r.f1986a;
        g7.d dVar = null;
        r rVar2 = this.f7032g;
        switch (i2) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                w7.e0.N(obj);
                if (rVar2.E == null) {
                    q.f fVar = new q.f();
                    q.i iVar = rVar2.f7118v;
                    if (iVar != null) {
                        ia.d0.s(rVar2.Z(), null, null, new a5.b(iVar, fVar, dVar, 16), 3);
                    }
                    rVar2.E = fVar;
                    break;
                }
                break;
            default:
                h7.a aVar2 = h7.a.f4212f;
                w7.e0.N(obj);
                q.f fVar2 = rVar2.E;
                if (fVar2 != null) {
                    q.g gVar = new q.g(fVar2);
                    q.i iVar2 = rVar2.f7118v;
                    if (iVar2 != null) {
                        ia.d0.s(rVar2.Z(), null, null, new a5.b(iVar2, gVar, dVar, 17), 3);
                    }
                    rVar2.E = null;
                    break;
                }
                break;
        }
        return rVar;
    }
}
