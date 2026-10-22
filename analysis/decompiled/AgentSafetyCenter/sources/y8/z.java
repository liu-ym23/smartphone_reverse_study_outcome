package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f16023c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f16024f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ p5.m f16025g;

    /* renamed from: h, reason: collision with root package name */
    public int f16026h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(p5.m mVar, pb.c cVar) {
        super(cVar);
        this.f16025g = mVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f16024f = obj;
        this.f16026h |= Integer.MIN_VALUE;
        return this.f16025g.T(this);
    }
}
