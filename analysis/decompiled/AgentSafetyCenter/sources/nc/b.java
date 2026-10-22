package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public mc.r f8819c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f8820f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f8821g;

    /* renamed from: h, reason: collision with root package name */
    public int f8822h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, pb.c cVar2) {
        super(cVar2);
        this.f8821g = cVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8820f = obj;
        this.f8822h |= Integer.MIN_VALUE;
        return this.f8821g.b(null, this);
    }
}
