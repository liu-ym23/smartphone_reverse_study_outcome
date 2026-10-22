package o4;

/* loaded from: classes.dex */
public final class b1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7280f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f1 f7281g;

    /* renamed from: h, reason: collision with root package name */
    public int f7282h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(f1 f1Var, i7.c cVar) {
        super(cVar);
        this.f7281g = f1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7280f = obj;
        this.f7282h |= Integer.MIN_VALUE;
        return f1.d(this.f7281g, null, null, null, null, this);
    }
}
