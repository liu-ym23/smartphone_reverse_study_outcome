package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public oc.u f8814c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f8815f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ l5.j f8816g;

    /* renamed from: h, reason: collision with root package name */
    public int f8817h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(l5.j jVar, nb.c cVar) {
        super(cVar);
        this.f8816g = jVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8815f = obj;
        this.f8817h |= Integer.MIN_VALUE;
        return this.f8816g.collect(null, this);
    }
}
