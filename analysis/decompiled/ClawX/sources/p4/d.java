package p4;

/* loaded from: classes.dex */
public final class d extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4738a;

    /* renamed from: b, reason: collision with root package name */
    public int f4739b;

    /* renamed from: c, reason: collision with root package name */
    public d6.c f4740c;
    public final /* synthetic */ e d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, f5.c cVar) {
        super(cVar);
        this.d = eVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f4738a = obj;
        this.f4739b |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
