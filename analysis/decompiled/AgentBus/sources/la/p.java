package la;

/* loaded from: classes.dex */
public final class p extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5971f;

    /* renamed from: g, reason: collision with root package name */
    public int f5972g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q6.b f5973h;

    /* renamed from: i, reason: collision with root package name */
    public q6.b f5974i;

    /* renamed from: j, reason: collision with root package name */
    public k f5975j;

    /* renamed from: k, reason: collision with root package name */
    public ma.r f5976k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q6.b bVar, g7.d dVar) {
        super(dVar);
        this.f5973h = bVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5971f = obj;
        this.f5972g |= Integer.MIN_VALUE;
        return this.f5973h.x(null, this);
    }
}
