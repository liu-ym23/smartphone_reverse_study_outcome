package j1;

/* loaded from: classes.dex */
public final class d0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public k.u f5119f;

    /* renamed from: g, reason: collision with root package name */
    public ka.b f5120g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f5121h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f0 f5122i;

    /* renamed from: j, reason: collision with root package name */
    public int f5123j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(f0 f0Var, i7.c cVar) {
        super(cVar);
        this.f5122i = f0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5121h = obj;
        this.f5123j |= Integer.MIN_VALUE;
        return this.f5122i.d(this);
    }
}
