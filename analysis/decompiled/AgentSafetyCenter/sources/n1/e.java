package n1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f8630c;

    /* renamed from: f, reason: collision with root package name */
    public long f8631f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8632g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g f8633h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, pb.c cVar) {
        super(cVar);
        this.f8633h = gVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8632g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f8633h.S(0L, 0L, this);
    }
}
