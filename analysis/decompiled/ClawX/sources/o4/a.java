package o4;

/* loaded from: classes.dex */
public final class a extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4306a;

    /* renamed from: b, reason: collision with root package name */
    public int f4307b;

    /* renamed from: c, reason: collision with root package name */
    public d6.c f4308c;
    public final /* synthetic */ b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, f5.c cVar) {
        super(cVar);
        this.d = bVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f4306a = obj;
        this.f4307b |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
