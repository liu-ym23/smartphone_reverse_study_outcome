package o;

/* loaded from: classes.dex */
public final class e extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public g f7036f;

    /* renamed from: g, reason: collision with root package name */
    public long f7037g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7038h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g f7039i;

    /* renamed from: j, reason: collision with root package name */
    public int f7040j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, i7.c cVar) {
        super(cVar);
        this.f7039i = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7038h = obj;
        this.f7040j |= Integer.MIN_VALUE;
        return this.f7039i.a(0L, null, this);
    }
}
