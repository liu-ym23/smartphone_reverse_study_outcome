package ma;

/* loaded from: classes.dex */
public final class i extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public j f6491f;

    /* renamed from: g, reason: collision with root package name */
    public Object f6492g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6493h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ j f6494i;

    /* renamed from: j, reason: collision with root package name */
    public int f6495j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, g7.d dVar) {
        super(dVar);
        this.f6494i = jVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6493h = obj;
        this.f6495j |= Integer.MIN_VALUE;
        return this.f6494i.emit(null, this);
    }
}
