package m5;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public h f6396f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6397g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h f6398h;

    /* renamed from: i, reason: collision with root package name */
    public int f6399i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, i7.c cVar) {
        super(cVar);
        this.f6398h = hVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6397g = obj;
        this.f6399i |= Integer.MIN_VALUE;
        return h.a(this.f6398h, this);
    }
}
