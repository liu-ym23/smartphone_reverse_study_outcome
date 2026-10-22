package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8832c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f8833f;

    /* renamed from: g, reason: collision with root package name */
    public int f8834g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, nb.c cVar) {
        super(cVar);
        this.f8833f = eVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8832c = obj;
        this.f8834g |= Integer.MIN_VALUE;
        return this.f8833f.emit(null, this);
    }
}
