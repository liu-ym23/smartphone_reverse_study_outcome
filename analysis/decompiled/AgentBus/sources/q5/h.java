package q5;

/* loaded from: classes.dex */
public final class h extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public la.g f8687f;

    /* renamed from: g, reason: collision with root package name */
    public c5.b f8688g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8689h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ la.g f8690i;

    /* renamed from: j, reason: collision with root package name */
    public int f8691j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(la.g gVar, g7.d dVar) {
        super(dVar);
        this.f8690i = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8689h = obj;
        this.f8691j |= Integer.MIN_VALUE;
        return this.f8690i.b(null, this);
    }
}
