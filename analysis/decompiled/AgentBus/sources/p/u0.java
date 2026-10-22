package p;

/* loaded from: classes.dex */
public final class u0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q7.u f8186f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8187g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ y0 f8188h;

    /* renamed from: i, reason: collision with root package name */
    public int f8189i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(y0 y0Var, i7.c cVar) {
        super(cVar);
        this.f8188h = y0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8187g = obj;
        this.f8189i |= Integer.MIN_VALUE;
        return this.f8188h.b(0L, this);
    }
}
