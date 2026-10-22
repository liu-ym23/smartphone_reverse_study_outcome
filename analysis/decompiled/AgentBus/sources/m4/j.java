package m4;

/* loaded from: classes.dex */
public final class j extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6227f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f6228g;

    /* renamed from: h, reason: collision with root package name */
    public int f6229h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(x xVar, i7.c cVar) {
        super(cVar);
        this.f6228g = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6227f = obj;
        this.f6229h |= Integer.MIN_VALUE;
        return this.f6228g.g(null, this);
    }
}
