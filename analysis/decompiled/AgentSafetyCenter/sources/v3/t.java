package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public z f14720c;

    /* renamed from: f, reason: collision with root package name */
    public q0 f14721f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14722g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f14723h;
    public final /* synthetic */ z i;

    /* renamed from: j, reason: collision with root package name */
    public int f14724j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(z zVar, nb.c cVar) {
        super(cVar);
        this.i = zVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14723h = obj;
        this.f14724j |= Integer.MIN_VALUE;
        return z.e(this.i, false, this);
    }
}
