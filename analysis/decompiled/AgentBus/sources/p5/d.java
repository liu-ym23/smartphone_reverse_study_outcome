package p5;

/* loaded from: classes.dex */
public final class d extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public nb.f f8428f;

    /* renamed from: g, reason: collision with root package name */
    public d5.m f8429g;

    /* renamed from: h, reason: collision with root package name */
    public p7.k f8430h;

    /* renamed from: i, reason: collision with root package name */
    public long f8431i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f8432j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ nb.f f8433k;

    /* renamed from: l, reason: collision with root package name */
    public int f8434l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(nb.f fVar, i7.c cVar) {
        super(cVar);
        this.f8433k = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8432j = obj;
        this.f8434l |= Integer.MIN_VALUE;
        return this.f8433k.a(null, 0L, false, null, this);
    }
}
