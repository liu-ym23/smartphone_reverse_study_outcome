package q5;

/* loaded from: classes.dex */
public final class o extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q f8735f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8736g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q f8737h;

    /* renamed from: i, reason: collision with root package name */
    public int f8738i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, i7.c cVar) {
        super(cVar);
        this.f8737h = qVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8736g = obj;
        this.f8738i |= Integer.MIN_VALUE;
        return this.f8737h.l(null, null, null, null, false, this);
    }
}
