package d5;

/* loaded from: classes.dex */
public final class x extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public z f2918f;

    /* renamed from: g, reason: collision with root package name */
    public c6.l f2919g;

    /* renamed from: h, reason: collision with root package name */
    public int f2920h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f2921i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z f2922j;

    /* renamed from: k, reason: collision with root package name */
    public int f2923k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(z zVar, i7.c cVar) {
        super(cVar);
        this.f2922j = zVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f2921i = obj;
        this.f2923k |= Integer.MIN_VALUE;
        return z.j(this.f2922j, this);
    }
}
