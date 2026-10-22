package o1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f9031c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h0 f9032f;

    /* renamed from: g, reason: collision with root package name */
    public int f9033g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(h0 h0Var, pb.a aVar) {
        super(aVar);
        this.f9032f = h0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f9031c = obj;
        this.f9033g |= Integer.MIN_VALUE;
        return this.f9032f.g(0L, null, this);
    }
}
