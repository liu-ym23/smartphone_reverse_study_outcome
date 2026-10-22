package la;

/* loaded from: classes.dex */
public final class n extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5962f;

    /* renamed from: g, reason: collision with root package name */
    public int f5963g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ o f5964h;

    /* renamed from: i, reason: collision with root package name */
    public Object f5965i;

    /* renamed from: j, reason: collision with root package name */
    public k f5966j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, g7.d dVar) {
        super(dVar);
        this.f5964h = oVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5962f = obj;
        this.f5963g |= Integer.MIN_VALUE;
        return this.f5964h.x(null, this);
    }
}
