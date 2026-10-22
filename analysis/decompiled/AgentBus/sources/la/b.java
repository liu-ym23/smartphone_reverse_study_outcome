package la;

/* loaded from: classes.dex */
public final class b extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public ka.t f5904f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f5905g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f5906h;

    /* renamed from: i, reason: collision with root package name */
    public int f5907i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, i7.c cVar2) {
        super(cVar2);
        this.f5906h = cVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5905g = obj;
        this.f5907i |= Integer.MIN_VALUE;
        return this.f5906h.b(null, this);
    }
}
