package o4;

/* loaded from: classes.dex */
public final class k1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t1 f7424f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7425g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t1 f7426h;

    /* renamed from: i, reason: collision with root package name */
    public int f7427i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(t1 t1Var, i7.c cVar) {
        super(cVar);
        this.f7426h = t1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7425g = obj;
        this.f7427i |= Integer.MIN_VALUE;
        return t1.b(this.f7426h, this);
    }
}
