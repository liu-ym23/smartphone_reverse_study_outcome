package m8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8398c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k0 f8399f;

    /* renamed from: g, reason: collision with root package name */
    public int f8400g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(k0 k0Var, pb.c cVar) {
        super(cVar);
        this.f8399f = k0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8398c = obj;
        this.f8400g |= Integer.MIN_VALUE;
        return k0.l(this.f8399f, this);
    }
}
