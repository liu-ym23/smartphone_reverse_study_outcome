package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public i0 f13463c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f13464f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i0 f13465g;

    /* renamed from: h, reason: collision with root package name */
    public int f13466h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(i0 i0Var, pb.c cVar) {
        super(cVar);
        this.f13465g = i0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f13464f = obj;
        this.f13466h |= Integer.MIN_VALUE;
        return this.f13465g.b(this);
    }
}
