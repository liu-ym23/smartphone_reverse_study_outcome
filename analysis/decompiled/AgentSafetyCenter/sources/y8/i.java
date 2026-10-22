package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f15971c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g9.b0 f15972f;

    /* renamed from: g, reason: collision with root package name */
    public int f15973g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g9.b0 b0Var, pb.c cVar) {
        super(cVar);
        this.f15972f = b0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f15971c = obj;
        this.f15973g |= Integer.MIN_VALUE;
        Object objE = this.f15972f.e(null, 0L, this);
        return objE == ob.a.f9351c ? objE : jb.i.a(objE);
    }
}
