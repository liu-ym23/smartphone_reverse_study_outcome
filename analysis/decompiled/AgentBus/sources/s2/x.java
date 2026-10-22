package s2;

/* loaded from: classes.dex */
public final class x extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q7.t f9453f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f9454g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ z f9455h;

    /* renamed from: i, reason: collision with root package name */
    public int f9456i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(z zVar, i7.c cVar) {
        super(cVar);
        this.f9455h = zVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9454g = obj;
        this.f9456i |= Integer.MIN_VALUE;
        return this.f9455h.g(null, false, this);
    }
}
