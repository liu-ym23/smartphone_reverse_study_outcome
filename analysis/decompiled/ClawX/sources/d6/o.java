package d6;

/* loaded from: classes.dex */
public final class o extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public p f1894a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1895b;

    /* renamed from: c, reason: collision with root package name */
    public int f1896c;
    public final /* synthetic */ p d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1897e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p pVar, f5.c cVar) {
        super(cVar);
        this.d = pVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f1895b = obj;
        this.f1896c |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
