package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public w f15941c;

    /* renamed from: f, reason: collision with root package name */
    public long f15942f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f15943g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p5.m f15944h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(p5.m mVar, pb.c cVar) {
        super(cVar);
        this.f15944h = mVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15943g = obj;
        this.i |= Integer.MIN_VALUE;
        Object objU = this.f15944h.U(null, this);
        return objU == ob.a.f9351c ? objU : jb.i.a(objU);
    }
}
