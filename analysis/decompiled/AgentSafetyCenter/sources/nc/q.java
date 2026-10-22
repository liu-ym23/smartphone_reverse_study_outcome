package nc;

/* loaded from: classes.dex */
public final class q extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8904c;

    /* renamed from: f, reason: collision with root package name */
    public int f8905f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n f8906g;

    /* renamed from: h, reason: collision with root package name */
    public n f8907h;
    public h i;

    /* renamed from: j, reason: collision with root package name */
    public Throwable f8908j;

    /* renamed from: k, reason: collision with root package name */
    public long f8909k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(n nVar, nb.c cVar) {
        super(cVar);
        this.f8906g = nVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8904c = obj;
        this.f8905f |= Integer.MIN_VALUE;
        return this.f8906g.collect(null, this);
    }
}
