package la;

/* loaded from: classes.dex */
public final class q extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public d5.k f5980f;

    /* renamed from: g, reason: collision with root package name */
    public Object f5981g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f5982h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ d5.k f5983i;

    /* renamed from: j, reason: collision with root package name */
    public int f5984j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(d5.k kVar, g7.d dVar) {
        super(dVar);
        this.f5983i = kVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5982h = obj;
        this.f5984j |= Integer.MIN_VALUE;
        return this.f5983i.emit(null, this);
    }
}
