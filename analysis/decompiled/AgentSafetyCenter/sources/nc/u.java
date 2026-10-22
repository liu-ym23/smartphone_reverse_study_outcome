package nc;

/* loaded from: classes.dex */
public final class u extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public g0.f f8930c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f8931f;

    /* renamed from: g, reason: collision with root package name */
    public int f8932g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g0.f f8933h;
    public Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(g0.f fVar, nb.c cVar) {
        super(cVar);
        this.f8933h = fVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8931f = obj;
        this.f8932g |= Integer.MIN_VALUE;
        return this.f8933h.emit(null, this);
    }
}
