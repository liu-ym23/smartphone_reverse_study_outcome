package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h1 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4473c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b0 f4474f;

    /* renamed from: g, reason: collision with root package name */
    public int f4475g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(b0 b0Var, pb.c cVar) {
        super(cVar);
        this.f4474f = b0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f4473c = obj;
        this.f4475g |= Integer.MIN_VALUE;
        Object objF = this.f4474f.f(null, this);
        return objF == ob.a.f9351c ? objF : jb.i.a(objF);
    }
}
