package la;

/* loaded from: classes.dex */
public final class a extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public ma.r f5894f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f5895g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a7.d f5896h;

    /* renamed from: i, reason: collision with root package name */
    public int f5897i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(a7.d dVar, g7.d dVar2) {
        super(dVar2);
        this.f5896h = dVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5895g = obj;
        this.f5897i |= Integer.MIN_VALUE;
        return this.f5896h.x(null, this);
    }
}
