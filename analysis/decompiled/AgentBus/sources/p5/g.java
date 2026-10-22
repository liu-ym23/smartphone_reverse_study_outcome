package p5;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public h f8449f;

    /* renamed from: g, reason: collision with root package name */
    public i5.p f8450g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8451h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ h f8452i;

    /* renamed from: j, reason: collision with root package name */
    public int f8453j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, i7.c cVar) {
        super(cVar);
        this.f8452i = hVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8451h = obj;
        this.f8453j |= Integer.MIN_VALUE;
        return this.f8452i.b(null, this);
    }
}
