package m4;

/* loaded from: classes.dex */
public final class n extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6264f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f6265g;

    /* renamed from: h, reason: collision with root package name */
    public int f6266h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(x xVar, i7.c cVar) {
        super(cVar);
        this.f6265g = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6264f = obj;
        this.f6266h |= Integer.MIN_VALUE;
        return this.f6265g.l(null, null, this);
    }
}
