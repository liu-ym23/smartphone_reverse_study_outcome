package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public z f14710c;

    /* renamed from: f, reason: collision with root package name */
    public sc.c f14711f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f14712g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ z f14713h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(z zVar, pb.c cVar) {
        super(cVar);
        this.f14713h = zVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14712g = obj;
        this.i |= Integer.MIN_VALUE;
        return z.d(this.f14713h, this);
    }
}
