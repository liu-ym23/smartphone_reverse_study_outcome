package k4;

/* loaded from: classes.dex */
public final class a extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q6.b f5589f;

    /* renamed from: g, reason: collision with root package name */
    public String f5590g;

    /* renamed from: h, reason: collision with root package name */
    public String f5591h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f5592i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ q6.b f5593j;

    /* renamed from: k, reason: collision with root package name */
    public int f5594k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(q6.b bVar, i7.c cVar) {
        super(cVar);
        this.f5593j = bVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5592i = obj;
        this.f5594k |= Integer.MIN_VALUE;
        return this.f5593j.D0(null, this);
    }
}
