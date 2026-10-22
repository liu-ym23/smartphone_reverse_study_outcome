package y0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public mc.b f15850c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f15851f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d f15852g;

    /* renamed from: h, reason: collision with root package name */
    public int f15853h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, pb.c cVar) {
        super(cVar);
        this.f15852g = dVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15851f = obj;
        this.f15853h |= Integer.MIN_VALUE;
        return this.f15852g.a(this);
    }
}
