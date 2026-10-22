package p4;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public d f9699c;

    /* renamed from: f, reason: collision with root package name */
    public z4.c f9700f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f9701g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d f9702h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, pb.c cVar) {
        super(cVar);
        this.f9702h = dVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f9701g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f9702h.e(null, null, this);
    }
}
