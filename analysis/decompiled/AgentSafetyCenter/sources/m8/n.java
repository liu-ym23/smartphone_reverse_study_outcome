package m8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f8463c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f8464f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0 f8465g;

    /* renamed from: h, reason: collision with root package name */
    public int f8466h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k0 k0Var, pb.c cVar) {
        super(cVar);
        this.f8465g = k0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8464f = obj;
        this.f8466h |= Integer.MIN_VALUE;
        return this.f8465g.p(0L, 0L, null, null, this);
    }
}
