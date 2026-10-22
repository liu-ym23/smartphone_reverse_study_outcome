package m4;

/* loaded from: classes.dex */
public final class o extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6279f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f6280g;

    /* renamed from: h, reason: collision with root package name */
    public int f6281h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(x xVar, i7.c cVar) {
        super(cVar);
        this.f6280g = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6279f = obj;
        this.f6281h |= Integer.MIN_VALUE;
        return this.f6280g.m(null, 0, null, this);
    }
}
