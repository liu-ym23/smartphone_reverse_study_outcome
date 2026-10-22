package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public i f10147c;

    /* renamed from: f, reason: collision with root package name */
    public String f10148f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f10149g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t f10150h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(t tVar, pb.c cVar) {
        super(cVar);
        this.f10150h = tVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f10149g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f10150h.d(null, this);
    }
}
