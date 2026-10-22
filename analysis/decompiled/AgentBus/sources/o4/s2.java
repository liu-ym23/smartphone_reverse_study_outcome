package o4;

/* loaded from: classes.dex */
public final class s2 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t2 f7562f;

    /* renamed from: g, reason: collision with root package name */
    public a2 f7563g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7564h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ t2 f7565i;

    /* renamed from: j, reason: collision with root package name */
    public int f7566j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(t2 t2Var, i7.c cVar) {
        super(cVar);
        this.f7565i = t2Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7564h = obj;
        this.f7566j |= Integer.MIN_VALUE;
        return this.f7565i.s(null, this);
    }
}
