package s2;

/* loaded from: classes.dex */
public final class q extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f9416f;

    /* renamed from: g, reason: collision with root package name */
    public int f9417g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ r f9418h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, g7.d dVar) {
        super(dVar);
        this.f9418h = rVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9416f = obj;
        this.f9417g |= Integer.MIN_VALUE;
        return this.f9418h.emit(null, this);
    }
}
