package m4;

/* loaded from: classes.dex */
public final class u extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public x f6336f;

    /* renamed from: g, reason: collision with root package name */
    public String f6337g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6338h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x f6339i;

    /* renamed from: j, reason: collision with root package name */
    public int f6340j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(x xVar, i7.c cVar) {
        super(cVar);
        this.f6339i = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6338h = obj;
        this.f6340j |= Integer.MIN_VALUE;
        return this.f6339i.v(null, null, false, this);
    }
}
