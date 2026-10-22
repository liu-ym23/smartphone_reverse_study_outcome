package m8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8474c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k0 f8475f;

    /* renamed from: g, reason: collision with root package name */
    public int f8476g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(k0 k0Var, nb.c cVar) {
        super(cVar);
        this.f8475f = k0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8474c = obj;
        this.f8476g |= Integer.MIN_VALUE;
        return this.f8475f.x(this);
    }
}
