package nc;

/* loaded from: classes.dex */
public final class t extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8925c;

    /* renamed from: f, reason: collision with root package name */
    public int f8926f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n f8927g;

    /* renamed from: h, reason: collision with root package name */
    public g0.f f8928h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(n nVar, nb.c cVar) {
        super(cVar);
        this.f8927g = nVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8925c = obj;
        this.f8926f |= Integer.MIN_VALUE;
        return this.f8927g.collect(null, this);
    }
}
