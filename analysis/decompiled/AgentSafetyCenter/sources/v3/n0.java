package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f14686c;

    /* renamed from: f, reason: collision with root package name */
    public sc.c f14687f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f14688g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p0 f14689h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(p0 p0Var, pb.c cVar) {
        super(cVar);
        this.f14689h = p0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14688g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f14689h.b(null, this);
    }
}
