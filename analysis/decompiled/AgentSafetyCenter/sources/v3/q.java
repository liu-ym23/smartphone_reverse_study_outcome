package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f14704c;

    /* renamed from: f, reason: collision with root package name */
    public z f14705f;

    /* renamed from: g, reason: collision with root package name */
    public kc.l f14706g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f14707h;
    public final /* synthetic */ z i;

    /* renamed from: j, reason: collision with root package name */
    public int f14708j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(z zVar, pb.c cVar) {
        super(cVar);
        this.i = zVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14707h = obj;
        this.f14708j |= Integer.MIN_VALUE;
        return z.c(this.i, null, this);
    }
}
