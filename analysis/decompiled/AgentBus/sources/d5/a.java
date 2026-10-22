package d5;

/* loaded from: classes.dex */
public final class a extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f2842f;

    /* renamed from: g, reason: collision with root package name */
    public c6.l f2843g;

    /* renamed from: h, reason: collision with root package name */
    public c5.d f2844h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f2845i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ c f2846j;

    /* renamed from: k, reason: collision with root package name */
    public int f2847k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, i7.c cVar2) {
        super(cVar2);
        this.f2846j = cVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f2845i = obj;
        this.f2847k |= Integer.MIN_VALUE;
        return this.f2846j.a(null, null, this);
    }
}
