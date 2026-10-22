package o4;

/* loaded from: classes.dex */
public final class i2 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t2 f7396f;

    /* renamed from: g, reason: collision with root package name */
    public String f7397g;

    /* renamed from: h, reason: collision with root package name */
    public a2 f7398h;

    /* renamed from: i, reason: collision with root package name */
    public int f7399i;

    /* renamed from: j, reason: collision with root package name */
    public int f7400j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f7401k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ t2 f7402l;

    /* renamed from: m, reason: collision with root package name */
    public int f7403m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i2(t2 t2Var, i7.c cVar) {
        super(cVar);
        this.f7402l = t2Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7401k = obj;
        this.f7403m |= Integer.MIN_VALUE;
        return this.f7402l.e(null, null, this);
    }
}
