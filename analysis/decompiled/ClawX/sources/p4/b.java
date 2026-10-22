package p4;

/* loaded from: classes.dex */
public final class b extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4730a;

    /* renamed from: b, reason: collision with root package name */
    public int f4731b;

    /* renamed from: c, reason: collision with root package name */
    public d6.c f4732c;
    public final /* synthetic */ o4.b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(o4.b bVar, f5.c cVar) {
        super(cVar);
        this.d = bVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f4730a = obj;
        this.f4731b |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
