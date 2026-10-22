package q4;

/* loaded from: classes.dex */
public final class f extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4851a;

    /* renamed from: b, reason: collision with root package name */
    public int f4852b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f4853c;
    public Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, f5.c cVar) {
        super(cVar);
        this.f4853c = gVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f4851a = obj;
        this.f4852b |= Integer.MIN_VALUE;
        return this.f4853c.emit(null, this);
    }
}
