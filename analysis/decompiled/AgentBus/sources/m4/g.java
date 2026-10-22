package m4;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6194f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f6195g;

    /* renamed from: h, reason: collision with root package name */
    public int f6196h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(x xVar, i7.c cVar) {
        super(cVar);
        this.f6195g = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6194f = obj;
        this.f6196h |= Integer.MIN_VALUE;
        return this.f6195g.d(null, this);
    }
}
