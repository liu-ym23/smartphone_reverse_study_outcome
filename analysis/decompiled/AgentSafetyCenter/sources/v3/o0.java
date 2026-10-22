package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public sc.c f14694c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14695f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f14696g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p0 f14697h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(p0 p0Var, pb.c cVar) {
        super(cVar);
        this.f14697h = p0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14696g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f14697h.c(null, this);
    }
}
