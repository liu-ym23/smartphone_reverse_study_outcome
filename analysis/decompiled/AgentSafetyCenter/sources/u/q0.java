package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f13551c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f13552f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ l3.d f13553g;

    /* renamed from: h, reason: collision with root package name */
    public int f13554h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(l3.d dVar, pb.c cVar) {
        super(cVar);
        this.f13553g = dVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f13552f = obj;
        this.f13554h |= Integer.MIN_VALUE;
        return this.f13553g.S(0L, 0L, this);
    }
}
