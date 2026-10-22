package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public xb.a f15945c;

    /* renamed from: f, reason: collision with root package name */
    public long f15946f;

    /* renamed from: g, reason: collision with root package name */
    public long f15947g;

    /* renamed from: h, reason: collision with root package name */
    public long f15948h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f15949j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d f15950k;

    /* renamed from: l, reason: collision with root package name */
    public int f15951l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, pb.c cVar) {
        super(cVar);
        this.f15950k = dVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15949j = obj;
        this.f15951l |= Integer.MIN_VALUE;
        return this.f15950k.a(null, 0L, 0L, this);
    }
}
