package o4;

/* loaded from: classes.dex */
public final class j1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t1 f7408f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7409g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t1 f7410h;

    /* renamed from: i, reason: collision with root package name */
    public int f7411i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(t1 t1Var, i7.c cVar) {
        super(cVar);
        this.f7410h = t1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7409g = obj;
        this.f7411i |= Integer.MIN_VALUE;
        return t1.a(this.f7410h, this);
    }
}
