package u5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f14087c;

    /* renamed from: f, reason: collision with root package name */
    public int f14088f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ j f14089g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(j jVar, nb.c cVar) {
        super(cVar);
        this.f14089g = jVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14087c = obj;
        this.f14088f |= Integer.MIN_VALUE;
        return this.f14089g.emit(null, this);
    }
}
