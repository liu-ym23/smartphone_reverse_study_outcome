package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public e f8896c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f8897f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f8898g;

    /* renamed from: h, reason: collision with root package name */
    public int f8899h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(e eVar, nb.c cVar) {
        super(cVar);
        this.f8898g = eVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8897f = obj;
        this.f8899h |= Integer.MIN_VALUE;
        return this.f8898g.emit(null, this);
    }
}
