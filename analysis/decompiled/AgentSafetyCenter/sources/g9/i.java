package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public boolean f4476c;

    /* renamed from: f, reason: collision with root package name */
    public Object f4477f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f4478g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ad.z f4479h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ad.z zVar, pb.c cVar) {
        super(cVar);
        this.f4479h = zVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f4478g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f4479h.r(false, this);
    }
}
