package o1;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7209f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f7210g;

    /* renamed from: h, reason: collision with root package name */
    public int f7211h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, i7.c cVar) {
        super(cVar);
        this.f7210g = hVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7209f = obj;
        this.f7211h |= Integer.MIN_VALUE;
        return this.f7210g.a(0.0f, this);
    }
}
