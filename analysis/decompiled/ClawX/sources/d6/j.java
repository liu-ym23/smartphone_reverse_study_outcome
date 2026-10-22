package d6;

/* loaded from: classes.dex */
public final class j extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1876a;

    /* renamed from: b, reason: collision with root package name */
    public int f1877b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f1878c;
    public k d;

    /* renamed from: e, reason: collision with root package name */
    public c f1879e;

    /* renamed from: f, reason: collision with root package name */
    public e6.j f1880f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, f5.c cVar) {
        super(cVar);
        this.f1878c = kVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f1876a = obj;
        this.f1877b |= Integer.MIN_VALUE;
        return this.f1878c.collect(null, this);
    }
}
