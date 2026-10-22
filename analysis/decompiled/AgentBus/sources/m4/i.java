package m4;

/* loaded from: classes.dex */
public final class i extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6223f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f6224g;

    /* renamed from: h, reason: collision with root package name */
    public int f6225h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(x xVar, i7.c cVar) {
        super(cVar);
        this.f6224g = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6223f = obj;
        this.f6225h |= Integer.MIN_VALUE;
        return this.f6224g.f(null, this);
    }
}
