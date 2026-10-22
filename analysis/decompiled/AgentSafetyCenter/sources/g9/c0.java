package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4418c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g0 f4419f;

    /* renamed from: g, reason: collision with root package name */
    public int f4420g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(g0 g0Var, pb.c cVar) {
        super(cVar);
        this.f4419f = g0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f4418c = obj;
        this.f4420g |= Integer.MIN_VALUE;
        return this.f4419f.a(this);
    }
}
