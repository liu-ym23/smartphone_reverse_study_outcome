package m4;

/* loaded from: classes.dex */
public final class l0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q0 f6253f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6254g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q0 f6255h;

    /* renamed from: i, reason: collision with root package name */
    public int f6256i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(q0 q0Var, g7.d dVar) {
        super(dVar);
        this.f6255h = q0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6254g = obj;
        this.f6256i |= Integer.MIN_VALUE;
        return this.f6255h.j(null, this);
    }
}
