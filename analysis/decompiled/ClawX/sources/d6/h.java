package d6;

/* loaded from: classes.dex */
public final class h extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1870a;

    /* renamed from: b, reason: collision with root package name */
    public int f1871b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f1872c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public c f1873e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, f5.c cVar) {
        super(cVar);
        this.f1872c = iVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f1870a = obj;
        this.f1871b |= Integer.MIN_VALUE;
        return this.f1872c.collect(null, this);
    }
}
