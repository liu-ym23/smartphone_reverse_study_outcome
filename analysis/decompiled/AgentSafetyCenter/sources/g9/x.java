package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4645c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b0 f4646f;

    /* renamed from: g, reason: collision with root package name */
    public int f4647g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(b0 b0Var, pb.c cVar) {
        super(cVar);
        this.f4646f = b0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f4645c = obj;
        this.f4647g |= Integer.MIN_VALUE;
        Object objC = b0.c(this.f4646f, null, null, this);
        return objC == ob.a.f9351c ? objC : jb.i.a(objC);
    }
}
