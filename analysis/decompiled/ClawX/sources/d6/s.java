package d6;

/* loaded from: classes.dex */
public final class s extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public p f1906a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1907b;

    /* renamed from: c, reason: collision with root package name */
    public int f1908c;
    public final /* synthetic */ p d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1909e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(p pVar, f5.c cVar) {
        super(cVar);
        this.d = pVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f1907b = obj;
        this.f1908c |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
