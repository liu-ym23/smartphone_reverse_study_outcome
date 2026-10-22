package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public j f10151c;

    /* renamed from: f, reason: collision with root package name */
    public String f10152f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f10153g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t f10154h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(t tVar, pb.c cVar) {
        super(cVar);
        this.f10154h = tVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f10153g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f10154h.e(null, this);
    }
}
