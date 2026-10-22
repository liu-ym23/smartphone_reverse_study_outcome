package o4;

/* loaded from: classes.dex */
public final class m1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7449f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t1 f7450g;

    /* renamed from: h, reason: collision with root package name */
    public int f7451h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(t1 t1Var, i7.c cVar) {
        super(cVar);
        this.f7450g = t1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7449f = obj;
        this.f7451h |= Integer.MIN_VALUE;
        return this.f7450g.i(null, null, 0L, this);
    }
}
