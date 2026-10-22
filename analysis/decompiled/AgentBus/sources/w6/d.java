package w6;

/* loaded from: classes.dex */
public final class d extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public p7.k f10786f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f10787g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f10788h;

    /* renamed from: i, reason: collision with root package name */
    public int f10789i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, g7.d dVar) {
        super(dVar);
        this.f10788h = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10787g = obj;
        this.f10789i |= Integer.MIN_VALUE;
        return this.f10788h.b(null, null, null, this);
    }
}
