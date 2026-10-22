package la;

/* loaded from: classes.dex */
public final class f extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5915f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f5916g;

    /* renamed from: h, reason: collision with root package name */
    public int f5917h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, g7.d dVar) {
        super(dVar);
        this.f5916g = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5915f = obj;
        this.f5917h |= Integer.MIN_VALUE;
        return this.f5916g.emit(null, this);
    }
}
