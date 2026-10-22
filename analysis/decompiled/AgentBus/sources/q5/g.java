package q5;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q f8682f;

    /* renamed from: g, reason: collision with root package name */
    public d5.e f8683g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8684h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ q f8685i;

    /* renamed from: j, reason: collision with root package name */
    public int f8686j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(q qVar, i7.c cVar) {
        super(cVar);
        this.f8685i = qVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8684h = obj;
        this.f8686j |= Integer.MIN_VALUE;
        return q.a(this.f8685i, null, this);
    }
}
