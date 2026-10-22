package o1;

/* loaded from: classes.dex */
public final class a extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f7187f;

    /* renamed from: g, reason: collision with root package name */
    public d2.j f7188g;

    /* renamed from: h, reason: collision with root package name */
    public int f7189h;

    /* renamed from: i, reason: collision with root package name */
    public int f7190i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f7191j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d f7192k;

    /* renamed from: l, reason: collision with root package name */
    public int f7193l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d dVar, i7.c cVar) {
        super(cVar);
        this.f7192k = dVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7191j = obj;
        this.f7193l |= Integer.MIN_VALUE;
        return d.a(this.f7192k, null, null, this);
    }
}
