package y6;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f11691f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i f11692g;

    /* renamed from: h, reason: collision with root package name */
    public int f11693h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(i iVar, i7.c cVar) {
        super(cVar);
        this.f11692g = iVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11691f = obj;
        this.f11693h |= Integer.MIN_VALUE;
        return this.f11692g.a(this);
    }
}
