package p;

/* loaded from: classes.dex */
public final class o0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public long f8144f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8145g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ o4.d0 f8146h;

    /* renamed from: i, reason: collision with root package name */
    public int f8147i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(o4.d0 d0Var, i7.c cVar) {
        super(cVar);
        this.f8146h = d0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8145g = obj;
        this.f8147i |= Integer.MIN_VALUE;
        return this.f8146h.P(0L, 0L, this);
    }
}
