package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public w f15961c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f15962f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ qa.b f15963g;

    /* renamed from: h, reason: collision with root package name */
    public int f15964h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(qa.b bVar, pb.c cVar) {
        super(cVar);
        this.f15963g = bVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15962f = obj;
        this.f15964h |= Integer.MIN_VALUE;
        return this.f15963g.e(null, this);
    }
}
