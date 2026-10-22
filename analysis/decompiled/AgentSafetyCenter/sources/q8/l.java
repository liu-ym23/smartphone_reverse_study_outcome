package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f10134c;

    /* renamed from: f, reason: collision with root package name */
    public long f10135f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f10136g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t f10137h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(t tVar, pb.c cVar) {
        super(cVar);
        this.f10137h = tVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f10136g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f10137h.b(0L, this);
    }
}
