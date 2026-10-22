package b1;

/* loaded from: classes.dex */
public final class c extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public long f1463f;

    /* renamed from: g, reason: collision with root package name */
    public long f1464g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f1465h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e f1466i;

    /* renamed from: j, reason: collision with root package name */
    public int f1467j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, i7.c cVar) {
        super(cVar);
        this.f1466i = eVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1465h = obj;
        this.f1467j |= Integer.MIN_VALUE;
        return this.f1466i.m0(0L, 0L, this);
    }
}
