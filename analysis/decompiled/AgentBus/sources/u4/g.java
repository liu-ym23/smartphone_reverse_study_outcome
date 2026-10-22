package u4;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public h f10064f;

    /* renamed from: g, reason: collision with root package name */
    public ka.b f10065g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f10066h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ h f10067i;

    /* renamed from: j, reason: collision with root package name */
    public int f10068j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, i7.c cVar) {
        super(cVar);
        this.f10067i = hVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10066h = obj;
        this.f10068j |= Integer.MIN_VALUE;
        return h.a(this.f10067i, this);
    }
}
