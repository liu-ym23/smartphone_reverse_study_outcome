package m4;

/* loaded from: classes.dex */
public final class w extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public a6.c f6359f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6360g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ x f6361h;

    /* renamed from: i, reason: collision with root package name */
    public int f6362i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(x xVar, i7.c cVar) {
        super(cVar);
        this.f6361h = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6360g = obj;
        this.f6362i |= Integer.MIN_VALUE;
        return this.f6361h.y(null, null, null, this);
    }
}
