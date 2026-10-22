package la;

/* loaded from: classes.dex */
public final class r extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5989f;

    /* renamed from: g, reason: collision with root package name */
    public int f5990g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q6.b f5991h;

    /* renamed from: i, reason: collision with root package name */
    public g f5992i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(q6.b bVar, g7.d dVar) {
        super(dVar);
        this.f5991h = bVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5989f = obj;
        this.f5990g |= Integer.MIN_VALUE;
        return this.f5991h.x(null, this);
    }
}
