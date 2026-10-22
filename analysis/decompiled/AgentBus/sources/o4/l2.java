package o4;

/* loaded from: classes.dex */
public final class l2 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t2 f7444f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7445g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t2 f7446h;

    /* renamed from: i, reason: collision with root package name */
    public int f7447i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2(t2 t2Var, g7.d dVar) {
        super(dVar);
        this.f7446h = t2Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7445g = obj;
        this.f7447i |= Integer.MIN_VALUE;
        return this.f7446h.k(this);
    }
}
