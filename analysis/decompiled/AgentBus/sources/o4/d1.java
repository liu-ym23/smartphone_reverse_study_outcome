package o4;

/* loaded from: classes.dex */
public final class d1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7327f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f1 f7328g;

    /* renamed from: h, reason: collision with root package name */
    public int f7329h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(f1 f1Var, i7.c cVar) {
        super(cVar);
        this.f7328g = f1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7327f = obj;
        this.f7329h |= Integer.MIN_VALUE;
        return this.f7328g.r(null, null, this);
    }
}
