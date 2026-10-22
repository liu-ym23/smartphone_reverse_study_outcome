package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public t0 f13620c;

    /* renamed from: f, reason: collision with root package name */
    public p f13621f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f13622g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t0 f13623h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(t0 t0Var, pb.c cVar) {
        super(cVar);
        this.f13623h = t0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f13622g = obj;
        this.i |= Integer.MIN_VALUE;
        return t0.G0(this.f13623h, null, this);
    }
}
