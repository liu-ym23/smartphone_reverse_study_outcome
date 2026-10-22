package s2;

/* loaded from: classes.dex */
public final class f0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public ra.d f9359f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9360g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9361h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g0 f9362i;

    /* renamed from: j, reason: collision with root package name */
    public int f9363j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(g0 g0Var, i7.c cVar) {
        super(cVar);
        this.f9362i = g0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9361h = obj;
        this.f9363j |= Integer.MIN_VALUE;
        return this.f9362i.c(null, this);
    }
}
