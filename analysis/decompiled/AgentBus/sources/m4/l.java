package m4;

/* loaded from: classes.dex */
public final class l extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public x f6248f;

    /* renamed from: g, reason: collision with root package name */
    public a6.a0 f6249g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6250h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x f6251i;

    /* renamed from: j, reason: collision with root package name */
    public int f6252j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(x xVar, i7.c cVar) {
        super(cVar);
        this.f6251i = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6250h = obj;
        this.f6252j |= Integer.MIN_VALUE;
        return this.f6251i.i(null, null, this);
    }
}
