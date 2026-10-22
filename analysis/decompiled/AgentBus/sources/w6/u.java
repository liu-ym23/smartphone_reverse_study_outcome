package w6;

/* loaded from: classes.dex */
public final class u extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10836f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f10837g;

    /* renamed from: h, reason: collision with root package name */
    public int f10838h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(x xVar, g7.d dVar) {
        super(dVar);
        this.f10837g = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10836f = obj;
        this.f10838h |= Integer.MIN_VALUE;
        return this.f10837g.d(null, null, false, this);
    }
}
