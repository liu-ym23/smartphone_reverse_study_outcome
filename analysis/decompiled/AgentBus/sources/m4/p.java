package m4;

/* loaded from: classes.dex */
public final class p extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6293f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f6294g;

    /* renamed from: h, reason: collision with root package name */
    public int f6295h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(x xVar, i7.c cVar) {
        super(cVar);
        this.f6294g = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6293f = obj;
        this.f6295h |= Integer.MIN_VALUE;
        return this.f6294g.n(null, null, this);
    }
}
