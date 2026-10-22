package p;

/* loaded from: classes.dex */
public final class x extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public s0 f8201f;

    /* renamed from: g, reason: collision with root package name */
    public o f8202g;

    /* renamed from: h, reason: collision with root package name */
    public q.b f8203h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f8204i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ s0 f8205j;

    /* renamed from: k, reason: collision with root package name */
    public int f8206k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(s0 s0Var, i7.c cVar) {
        super(cVar);
        this.f8205j = s0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8204i = obj;
        this.f8206k |= Integer.MIN_VALUE;
        return s0.p0(this.f8205j, null, this);
    }
}
