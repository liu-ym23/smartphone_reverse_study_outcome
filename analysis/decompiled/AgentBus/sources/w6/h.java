package w6;

/* loaded from: classes.dex */
public final class h extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10798f;

    /* renamed from: g, reason: collision with root package name */
    public int f10799g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ la.g f10800h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(la.g gVar, g7.d dVar) {
        super(dVar);
        this.f10800h = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10798f = obj;
        this.f10799g |= Integer.MIN_VALUE;
        return this.f10800h.emit(null, this);
    }
}
