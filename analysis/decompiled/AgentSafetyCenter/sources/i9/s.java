package i9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f5901c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5902f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b0 f5903g;

    /* renamed from: h, reason: collision with root package name */
    public int f5904h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(b0 b0Var, pb.c cVar) {
        super(cVar);
        this.f5903g = b0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f5902f = obj;
        this.f5904h |= Integer.MIN_VALUE;
        return this.f5903g.j(null, this);
    }
}
