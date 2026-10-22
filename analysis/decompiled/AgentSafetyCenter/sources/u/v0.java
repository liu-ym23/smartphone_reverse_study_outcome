package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public yb.t f13595c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f13596f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ z0 f13597g;

    /* renamed from: h, reason: collision with root package name */
    public int f13598h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(z0 z0Var, pb.c cVar) {
        super(cVar);
        this.f13597g = z0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f13596f = obj;
        this.f13598h |= Integer.MIN_VALUE;
        return this.f13597g.b(0L, this);
    }
}
