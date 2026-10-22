package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public s f8910c;

    /* renamed from: f, reason: collision with root package name */
    public Object f8911f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8912g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s f8913h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, nb.c cVar) {
        super(cVar);
        this.f8913h = sVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8912g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f8913h.emit(null, this);
    }
}
