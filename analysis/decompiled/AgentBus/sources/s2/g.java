package s2;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public i5.f f9364f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f9365g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i5.f f9366h;

    /* renamed from: i, reason: collision with root package name */
    public int f9367i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(i5.f fVar, i7.c cVar) {
        super(cVar);
        this.f9366h = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9365g = obj;
        this.f9367i |= Integer.MIN_VALUE;
        return this.f9366h.E(this);
    }
}
