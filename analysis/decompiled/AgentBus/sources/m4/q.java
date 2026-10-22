package m4;

/* loaded from: classes.dex */
public final class q extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public String f6307f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6308g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ x f6309h;

    /* renamed from: i, reason: collision with root package name */
    public int f6310i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(x xVar, i7.c cVar) {
        super(cVar);
        this.f6309h = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6308g = obj;
        this.f6310i |= Integer.MIN_VALUE;
        return this.f6309h.p(null, null, this);
    }
}
