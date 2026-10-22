package o4;

/* loaded from: classes.dex */
public final class o1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t1 f7492f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7493g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t1 f7494h;

    /* renamed from: i, reason: collision with root package name */
    public int f7495i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(t1 t1Var, i7.c cVar) {
        super(cVar);
        this.f7494h = t1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7493g = obj;
        this.f7495i |= Integer.MIN_VALUE;
        return this.f7494h.j(this);
    }
}
