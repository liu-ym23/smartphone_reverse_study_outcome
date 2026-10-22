package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends pb.i implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public Throwable f14727c;

    /* renamed from: f, reason: collision with root package name */
    public int f14728f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ z f14729g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(z zVar, nb.c cVar) {
        super(1, cVar);
        this.f14729g = zVar;
    }

    @Override // pb.a
    public final nb.c create(nb.c cVar) {
        return new u(this.f14729g, cVar);
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        return ((u) create((nb.c) obj)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        q0 l0Var;
        ob.a aVar = ob.a.f9351c;
        int i = this.f14728f;
        z zVar = this.f14729g;
        try {
        } catch (Throwable th2) {
            p0 p0VarG = zVar.g();
            this.f14727c = th2;
            this.f14728f = 2;
            Integer numA = p0VarG.a();
            if (numA != aVar) {
                obj = numA;
                th = th2;
            }
        }
        if (i == 0) {
            id.c.I(obj);
            this.f14728f = 1;
            obj = z.f(zVar, true, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                th = this.f14727c;
                id.c.I(obj);
                l0Var = new l0(th, ((Number) obj).intValue());
                return new jb.g(l0Var, Boolean.TRUE);
            }
            id.c.I(obj);
        }
        l0Var = (q0) obj;
        return new jb.g(l0Var, Boolean.TRUE);
    }
}
