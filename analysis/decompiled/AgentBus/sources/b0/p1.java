package b0;

/* loaded from: classes.dex */
public final class p1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public p7.k f1302f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1303g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q1 f1304h;

    /* renamed from: i, reason: collision with root package name */
    public int f1305i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(q1 q1Var, i7.c cVar) {
        super(cVar);
        this.f1304h = q1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1303g = obj;
        this.f1305i |= Integer.MIN_VALUE;
        return this.f1304h.K(null, this);
    }
}
