package v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public p.v f14593c;

    /* renamed from: f, reason: collision with root package name */
    public mc.b f14594f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f14595g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a0 f14596h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(a0 a0Var, pb.c cVar) {
        super(cVar);
        this.f14596h = a0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14595g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f14596h.c(this);
    }
}
