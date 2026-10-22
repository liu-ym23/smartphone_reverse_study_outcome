package o4;

/* loaded from: classes.dex */
public final class z0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public f1 f7711f;

    /* renamed from: g, reason: collision with root package name */
    public i0 f7712g;

    /* renamed from: h, reason: collision with root package name */
    public int f7713h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f7714i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ f1 f7715j;

    /* renamed from: k, reason: collision with root package name */
    public int f7716k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(f1 f1Var, i7.c cVar) {
        super(cVar);
        this.f7715j = f1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7714i = obj;
        this.f7716k |= Integer.MIN_VALUE;
        return f1.b(this.f7715j, this);
    }
}
