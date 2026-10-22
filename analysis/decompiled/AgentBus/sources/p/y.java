package p;

/* loaded from: classes.dex */
public final class y extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public s0 f8211f;

    /* renamed from: g, reason: collision with root package name */
    public p f8212g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8213h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ s0 f8214i;

    /* renamed from: j, reason: collision with root package name */
    public int f8215j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(s0 s0Var, i7.c cVar) {
        super(cVar);
        this.f8214i = s0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8213h = obj;
        this.f8215j |= Integer.MIN_VALUE;
        return s0.q0(this.f8214i, null, this);
    }
}
