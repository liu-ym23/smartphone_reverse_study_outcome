package m4;

/* loaded from: classes.dex */
public final class t extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public w0 f6331f;

    /* renamed from: g, reason: collision with root package name */
    public a6.l f6332g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6333h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x f6334i;

    /* renamed from: j, reason: collision with root package name */
    public int f6335j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(x xVar, i7.c cVar) {
        super(cVar);
        this.f6334i = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6333h = obj;
        this.f6335j |= Integer.MIN_VALUE;
        return this.f6334i.u(null, null, this);
    }
}
