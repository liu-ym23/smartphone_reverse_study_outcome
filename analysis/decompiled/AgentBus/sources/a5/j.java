package a5;

/* loaded from: classes.dex */
public final class j extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public k f259f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f260g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k f261h;

    /* renamed from: i, reason: collision with root package name */
    public int f262i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, i7.c cVar) {
        super(cVar);
        this.f261h = kVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f260g = obj;
        this.f262i |= Integer.MIN_VALUE;
        return this.f261h.i(null, this);
    }
}
