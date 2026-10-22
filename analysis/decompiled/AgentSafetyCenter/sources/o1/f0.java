package o1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public kc.z f9021c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f9022f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h0 f9023g;

    /* renamed from: h, reason: collision with root package name */
    public int f9024h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(h0 h0Var, pb.a aVar) {
        super(aVar);
        this.f9023g = h0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f9022f = obj;
        this.f9024h |= Integer.MIN_VALUE;
        return this.f9023g.d(0L, null, this);
    }
}
