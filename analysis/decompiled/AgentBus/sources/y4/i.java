package y4;

/* loaded from: classes.dex */
public final class i extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f11579f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m f11580g;

    /* renamed from: h, reason: collision with root package name */
    public int f11581h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(m mVar, i7.c cVar) {
        super(cVar);
        this.f11580g = mVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11579f = obj;
        this.f11581h |= Integer.MIN_VALUE;
        return this.f11580g.b(null, null, this);
    }
}
