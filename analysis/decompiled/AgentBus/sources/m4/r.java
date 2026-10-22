package m4;

/* loaded from: classes.dex */
public final class r extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6323f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f6324g;

    /* renamed from: h, reason: collision with root package name */
    public int f6325h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(x xVar, i7.c cVar) {
        super(cVar);
        this.f6324g = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6323f = obj;
        this.f6325h |= Integer.MIN_VALUE;
        return this.f6324g.r(null, this);
    }
}
