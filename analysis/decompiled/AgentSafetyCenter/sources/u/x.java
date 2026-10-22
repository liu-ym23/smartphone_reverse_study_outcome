package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public t0 f13603c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f13604f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t0 f13605g;

    /* renamed from: h, reason: collision with root package name */
    public int f13606h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(t0 t0Var, pb.c cVar) {
        super(cVar);
        this.f13605g = t0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f13604f = obj;
        this.f13606h |= Integer.MIN_VALUE;
        return t0.E0(this.f13605g, this);
    }
}
