package m4;

/* loaded from: classes.dex */
public final class j0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q0 f6230f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6231g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q0 f6232h;

    /* renamed from: i, reason: collision with root package name */
    public int f6233i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(q0 q0Var, i7.c cVar) {
        super(cVar);
        this.f6232h = q0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6231g = obj;
        this.f6233i |= Integer.MIN_VALUE;
        return q0.R(this.f6232h, this);
    }
}
