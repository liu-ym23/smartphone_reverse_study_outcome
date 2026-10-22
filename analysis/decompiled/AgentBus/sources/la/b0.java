package la;

/* loaded from: classes.dex */
public final class b0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5908f;

    /* renamed from: g, reason: collision with root package name */
    public int f5909g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g f5910h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(g gVar, g7.d dVar) {
        super(dVar);
        this.f5910h = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5908f = obj;
        this.f5909g |= Integer.MIN_VALUE;
        return this.f5910h.emit(null, this);
    }
}
