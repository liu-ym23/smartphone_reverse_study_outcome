package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public t0 f13614c;

    /* renamed from: f, reason: collision with root package name */
    public o f13615f;

    /* renamed from: g, reason: collision with root package name */
    public v.b f13616g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f13617h;
    public final /* synthetic */ t0 i;

    /* renamed from: j, reason: collision with root package name */
    public int f13618j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(t0 t0Var, pb.c cVar) {
        super(cVar);
        this.i = t0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f13617h = obj;
        this.f13618j |= Integer.MIN_VALUE;
        return t0.F0(this.i, null, this);
    }
}
