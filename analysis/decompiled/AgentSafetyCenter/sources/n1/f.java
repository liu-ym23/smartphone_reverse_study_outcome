package n1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f8634c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f8635f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f8636g;

    /* renamed from: h, reason: collision with root package name */
    public int f8637h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, pb.c cVar) {
        super(cVar);
        this.f8636g = gVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8635f = obj;
        this.f8637h |= Integer.MIN_VALUE;
        return this.f8636g.v(0L, this);
    }
}
