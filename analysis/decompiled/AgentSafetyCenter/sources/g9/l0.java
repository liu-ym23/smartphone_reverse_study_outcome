package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public String f4519c;

    /* renamed from: f, reason: collision with root package name */
    public p f4520f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f4521g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p0 f4522h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(p0 p0Var, pb.c cVar) {
        super(cVar);
        this.f4522h = p0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f4521g = obj;
        this.i |= Integer.MIN_VALUE;
        Object objA = p0.a(this.f4522h, null, this);
        return objA == ob.a.f9351c ? objA : jb.i.a(objA);
    }
}
