package o4;

/* loaded from: classes.dex */
public final class l1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t1 f7437f;

    /* renamed from: g, reason: collision with root package name */
    public String f7438g;

    /* renamed from: h, reason: collision with root package name */
    public String f7439h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7440i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f7441j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ t1 f7442k;

    /* renamed from: l, reason: collision with root package name */
    public int f7443l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(t1 t1Var, i7.c cVar) {
        super(cVar);
        this.f7442k = t1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7441j = obj;
        this.f7443l |= Integer.MIN_VALUE;
        return this.f7442k.g(false, this);
    }
}
