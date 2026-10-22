package g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public k f4146c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4147f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k f4148g;

    /* renamed from: h, reason: collision with root package name */
    public int f4149h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(k kVar, pb.c cVar) {
        super(cVar);
        this.f4148g = kVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f4147f = obj;
        this.f4149h |= Integer.MIN_VALUE;
        return this.f4148g.a(this);
    }
}
