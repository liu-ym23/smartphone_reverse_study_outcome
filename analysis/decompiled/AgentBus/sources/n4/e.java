package n4;

/* loaded from: classes.dex */
public final class e extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public String f6853f;

    /* renamed from: g, reason: collision with root package name */
    public ka.b f6854g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6855h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ q6.b f6856i;

    /* renamed from: j, reason: collision with root package name */
    public int f6857j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(q6.b bVar, i7.c cVar) {
        super(cVar);
        this.f6856i = bVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6855h = obj;
        this.f6857j |= Integer.MIN_VALUE;
        return q6.b.w0(this.f6856i, null, null, this);
    }
}
