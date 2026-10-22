package o4;

/* loaded from: classes.dex */
public final class e1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public f1 f7337f;

    /* renamed from: g, reason: collision with root package name */
    public String f7338g;

    /* renamed from: h, reason: collision with root package name */
    public g3 f7339h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f7340i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ f1 f7341j;

    /* renamed from: k, reason: collision with root package name */
    public int f7342k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(f1 f1Var, i7.c cVar) {
        super(cVar);
        this.f7341j = f1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7340i = obj;
        this.f7342k |= Integer.MIN_VALUE;
        return this.f7341j.s(null, null, this);
    }
}
