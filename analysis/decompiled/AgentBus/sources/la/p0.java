package la;

/* loaded from: classes.dex */
public final class p0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5977f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f5978g;

    /* renamed from: h, reason: collision with root package name */
    public int f5979h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(g gVar, g7.d dVar) {
        super(dVar);
        this.f5978g = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5977f = obj;
        this.f5979h |= Integer.MIN_VALUE;
        return this.f5978g.a(0, this);
    }
}
