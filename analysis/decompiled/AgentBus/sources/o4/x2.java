package o4;

/* loaded from: classes.dex */
public final class x2 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7685f;

    /* renamed from: g, reason: collision with root package name */
    public int f7686g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ la.g f7687h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x2(la.g gVar, g7.d dVar) {
        super(dVar);
        this.f7687h = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7685f = obj;
        this.f7686g |= Integer.MIN_VALUE;
        return this.f7687h.emit(null, this);
    }
}
