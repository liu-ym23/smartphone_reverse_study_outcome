package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public g0 f14627c;

    /* renamed from: f, reason: collision with root package name */
    public Object f14628f;

    /* renamed from: g, reason: collision with root package name */
    public Object f14629g;

    /* renamed from: h, reason: collision with root package name */
    public i0 f14630h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ g0 f14631j;

    /* renamed from: k, reason: collision with root package name */
    public int f14632k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(g0 g0Var, pb.c cVar) {
        super(cVar);
        this.f14631j = g0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.f14632k |= Integer.MIN_VALUE;
        return this.f14631j.b(null, this);
    }
}
