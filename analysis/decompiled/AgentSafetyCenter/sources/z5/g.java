package z5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public h f16451c;

    /* renamed from: f, reason: collision with root package name */
    public f f16452f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f16453g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h f16454h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, pb.c cVar) {
        super(cVar);
        this.f16454h = hVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f16453g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f16454h.b(null, this);
    }
}
