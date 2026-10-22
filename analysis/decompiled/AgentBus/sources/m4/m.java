package m4;

/* loaded from: classes.dex */
public final class m extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f6257f;

    /* renamed from: g, reason: collision with root package name */
    public w0 f6258g;

    /* renamed from: h, reason: collision with root package name */
    public String f6259h;

    /* renamed from: i, reason: collision with root package name */
    public p7.k f6260i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f6261j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ x f6262k;

    /* renamed from: l, reason: collision with root package name */
    public int f6263l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(x xVar, i7.c cVar) {
        super(cVar);
        this.f6262k = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6261j = obj;
        this.f6263l |= Integer.MIN_VALUE;
        return this.f6262k.k(null, null, null, this);
    }
}
