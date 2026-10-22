package m4;

/* loaded from: classes.dex */
public final class f extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6187f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f6188g;

    /* renamed from: h, reason: collision with root package name */
    public int f6189h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(x xVar, i7.c cVar) {
        super(cVar);
        this.f6188g = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6187f = obj;
        this.f6189h |= Integer.MIN_VALUE;
        return this.f6188g.c(null, this);
    }
}
