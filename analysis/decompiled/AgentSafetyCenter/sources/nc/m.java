package nc;

/* loaded from: classes.dex */
public final class m extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8878c;

    /* renamed from: f, reason: collision with root package name */
    public int f8879f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n f8880g;

    /* renamed from: h, reason: collision with root package name */
    public n f8881h;
    public h i;

    /* renamed from: j, reason: collision with root package name */
    public oc.u f8882j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, nb.c cVar) {
        super(cVar);
        this.f8880g = nVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8878c = obj;
        this.f8879f |= Integer.MIN_VALUE;
        return this.f8880g.collect(null, this);
    }
}
