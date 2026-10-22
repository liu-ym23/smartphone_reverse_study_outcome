package b1;

/* loaded from: classes.dex */
public final class d extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public long f1468f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1469g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ e f1470h;

    /* renamed from: i, reason: collision with root package name */
    public int f1471i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, i7.c cVar) {
        super(cVar);
        this.f1470h = eVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1469g = obj;
        this.f1471i |= Integer.MIN_VALUE;
        return this.f1470h.o0(0L, this);
    }
}
