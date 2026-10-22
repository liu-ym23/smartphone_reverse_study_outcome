package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f10130c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10131f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f10132g;

    /* renamed from: h, reason: collision with root package name */
    public int f10133h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(t tVar, pb.c cVar) {
        super(cVar);
        this.f10132g = tVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f10131f = obj;
        this.f10133h |= Integer.MIN_VALUE;
        return this.f10132g.a(0L, this);
    }
}
