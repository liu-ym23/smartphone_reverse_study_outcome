package p;

/* loaded from: classes.dex */
public final class g0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public h0 f8101f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8102g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h0 f8103h;

    /* renamed from: i, reason: collision with root package name */
    public int f8104i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(h0 h0Var, i7.c cVar) {
        super(cVar);
        this.f8103h = h0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8102g = obj;
        this.f8104i |= Integer.MIN_VALUE;
        return this.f8103h.b(this);
    }
}
