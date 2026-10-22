package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f15974c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g9.b0 f15975f;

    /* renamed from: g, reason: collision with root package name */
    public int f15976g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g9.b0 b0Var, pb.c cVar) {
        super(cVar);
        this.f15975f = b0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15974c = obj;
        this.f15976g |= Integer.MIN_VALUE;
        Object objB = g9.b0.b(this.f15975f, null, null, this);
        return objB == ob.a.f9351c ? objB : jb.i.a(objB);
    }
}
