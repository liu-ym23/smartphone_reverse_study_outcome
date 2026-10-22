package m4;

/* loaded from: classes.dex */
public final class v extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public x f6349f;

    /* renamed from: g, reason: collision with root package name */
    public a6.d0 f6350g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6351h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x f6352i;

    /* renamed from: j, reason: collision with root package name */
    public int f6353j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(x xVar, i7.c cVar) {
        super(cVar);
        this.f6352i = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6351h = obj;
        this.f6353j |= Integer.MIN_VALUE;
        return this.f6352i.x(null, null, this);
    }
}
