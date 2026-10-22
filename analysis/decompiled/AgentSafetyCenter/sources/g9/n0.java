package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4540c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p0 f4541f;

    /* renamed from: g, reason: collision with root package name */
    public int f4542g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(p0 p0Var, pb.c cVar) {
        super(cVar);
        this.f4541f = p0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f4540c = obj;
        this.f4542g |= Integer.MIN_VALUE;
        Object objD = this.f4541f.d(null, null, this);
        return objD == ob.a.f9351c ? objD : jb.i.a(objD);
    }
}
