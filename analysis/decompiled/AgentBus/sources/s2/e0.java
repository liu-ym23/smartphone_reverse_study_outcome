package s2;

/* loaded from: classes.dex */
public final class e0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f9354f;

    /* renamed from: g, reason: collision with root package name */
    public ra.d f9355g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9356h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g0 f9357i;

    /* renamed from: j, reason: collision with root package name */
    public int f9358j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(g0 g0Var, i7.c cVar) {
        super(cVar);
        this.f9357i = g0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9356h = obj;
        this.f9358j |= Integer.MIN_VALUE;
        return this.f9357i.b(null, this);
    }
}
