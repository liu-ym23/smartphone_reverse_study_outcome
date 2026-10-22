package p0;

/* loaded from: classes.dex */
public final class b extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public ka.b f8240f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8241g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f8242h;

    /* renamed from: i, reason: collision with root package name */
    public int f8243i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, i7.c cVar2) {
        super(cVar2);
        this.f8242h = cVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8241g = obj;
        this.f8243i |= Integer.MIN_VALUE;
        return this.f8242h.c(this);
    }
}
