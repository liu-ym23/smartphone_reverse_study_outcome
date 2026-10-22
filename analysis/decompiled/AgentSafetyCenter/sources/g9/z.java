package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4657c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b0 f4658f;

    /* renamed from: g, reason: collision with root package name */
    public int f4659g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(b0 b0Var, pb.c cVar) {
        super(cVar);
        this.f4658f = b0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f4657c = obj;
        this.f4659g |= Integer.MIN_VALUE;
        Object objG = this.f4658f.g(null, null, 0L, this);
        return objG == ob.a.f9351c ? objG : jb.i.a(objG);
    }
}
