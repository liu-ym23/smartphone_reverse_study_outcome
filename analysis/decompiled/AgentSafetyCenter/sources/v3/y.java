package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public yb.s f14748c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f14749f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ z f14750g;

    /* renamed from: h, reason: collision with root package name */
    public int f14751h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(z zVar, pb.c cVar) {
        super(cVar);
        this.f14750g = zVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14749f = obj;
        this.f14751h |= Integer.MIN_VALUE;
        return this.f14750g.j(null, false, this);
    }
}
