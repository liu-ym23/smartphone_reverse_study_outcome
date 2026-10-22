package m4;

/* loaded from: classes.dex */
public final class v0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q6.b f6354f;

    /* renamed from: g, reason: collision with root package name */
    public c5.b f6355g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6356h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ q6.b f6357i;

    /* renamed from: j, reason: collision with root package name */
    public int f6358j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(q6.b bVar, i7.c cVar) {
        super(cVar);
        this.f6357i = bVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6356h = obj;
        this.f6358j |= Integer.MIN_VALUE;
        return this.f6357i.f(null, this);
    }
}
