package m5;

/* loaded from: classes.dex */
public final class m extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public h4.a f6435f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6436g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h4.a f6437h;

    /* renamed from: i, reason: collision with root package name */
    public int f6438i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(h4.a aVar, i7.c cVar) {
        super(cVar);
        this.f6437h = aVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6436g = obj;
        this.f6438i |= Integer.MIN_VALUE;
        return this.f6437h.k(this);
    }
}
