package d6;

/* loaded from: classes.dex */
public final class n extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1891a;

    /* renamed from: b, reason: collision with root package name */
    public int f1892b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f1893c;
    public p d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k kVar, f5.c cVar) {
        super(cVar);
        this.f1893c = kVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f1891a = obj;
        this.f1892b |= Integer.MIN_VALUE;
        return this.f1893c.collect(null, this);
    }
}
