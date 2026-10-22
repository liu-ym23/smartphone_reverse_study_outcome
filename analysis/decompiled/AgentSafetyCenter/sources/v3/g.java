package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public p5.i f14633c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f14634f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ p5.i f14635g;

    /* renamed from: h, reason: collision with root package name */
    public int f14636h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(p5.i iVar, pb.c cVar) {
        super(cVar);
        this.f14635g = iVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14634f = obj;
        this.f14636h |= Integer.MIN_VALUE;
        return this.f14635g.p(this);
    }
}
