package nc;

/* loaded from: classes.dex */
public final class x extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public g0.f f8941c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f8942f;

    /* renamed from: g, reason: collision with root package name */
    public int f8943g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g0.f f8944h;
    public Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(g0.f fVar, nb.c cVar) {
        super(cVar);
        this.f8944h = fVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8942f = obj;
        this.f8943g |= Integer.MIN_VALUE;
        return this.f8944h.emit(null, this);
    }
}
