package y5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public l f15914c;

    /* renamed from: f, reason: collision with root package name */
    public w5.g f15915f;

    /* renamed from: g, reason: collision with root package name */
    public Object f15916g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f15917h;
    public final /* synthetic */ l i;

    /* renamed from: j, reason: collision with root package name */
    public int f15918j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, pb.c cVar) {
        super(cVar);
        this.i = lVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15917h = obj;
        this.f15918j |= Integer.MIN_VALUE;
        return this.i.a(this);
    }
}
