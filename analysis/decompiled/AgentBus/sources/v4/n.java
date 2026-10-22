package v4;

/* loaded from: classes.dex */
public final class n extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public c6.l f10477f;

    /* renamed from: g, reason: collision with root package name */
    public String f10478g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f10479h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ p f10480i;

    /* renamed from: j, reason: collision with root package name */
    public int f10481j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(p pVar, i7.c cVar) {
        super(cVar);
        this.f10480i = pVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10479h = obj;
        this.f10481j |= Integer.MIN_VALUE;
        return this.f10480i.b(null, null, null, this);
    }
}
