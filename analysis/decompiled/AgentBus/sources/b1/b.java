package b1;

/* loaded from: classes.dex */
public final class b extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1460f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i5.f f1461g;

    /* renamed from: h, reason: collision with root package name */
    public int f1462h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(i5.f fVar, i7.c cVar) {
        super(cVar);
        this.f1461g = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1460f = obj;
        this.f1462h |= Integer.MIN_VALUE;
        return this.f1461g.D(0L, this);
    }
}
