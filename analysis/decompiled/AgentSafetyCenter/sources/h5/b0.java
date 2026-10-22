package h5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public d0 f5304c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5305f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d0 f5306g;

    /* renamed from: h, reason: collision with root package name */
    public int f5307h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(d0 d0Var, pb.c cVar) {
        super(cVar);
        this.f5306g = d0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f5305f = obj;
        this.f5307h |= Integer.MIN_VALUE;
        return d0.a(this.f5306g, this);
    }
}
