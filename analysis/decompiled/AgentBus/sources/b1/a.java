package b1;

/* loaded from: classes.dex */
public final class a extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1457f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i5.f f1458g;

    /* renamed from: h, reason: collision with root package name */
    public int f1459h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(i5.f fVar, i7.c cVar) {
        super(cVar);
        this.f1458g = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1457f = obj;
        this.f1459h |= Integer.MIN_VALUE;
        return this.f1458g.C(0L, 0L, this);
    }
}
