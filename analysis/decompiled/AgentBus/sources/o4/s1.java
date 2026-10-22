package o4;

/* loaded from: classes.dex */
public final class s1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7559f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t1 f7560g;

    /* renamed from: h, reason: collision with root package name */
    public int f7561h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(t1 t1Var, i7.c cVar) {
        super(cVar);
        this.f7560g = t1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7559f = obj;
        this.f7561h |= Integer.MIN_VALUE;
        return this.f7560g.l(0L, this);
    }
}
