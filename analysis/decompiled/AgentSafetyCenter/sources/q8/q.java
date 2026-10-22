package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f10162c;

    /* renamed from: f, reason: collision with root package name */
    public String f10163f;

    /* renamed from: g, reason: collision with root package name */
    public j f10164g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f10165h;
    public final /* synthetic */ t i;

    /* renamed from: j, reason: collision with root package name */
    public int f10166j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(t tVar, pb.c cVar) {
        super(cVar);
        this.i = tVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f10165h = obj;
        this.f10166j |= Integer.MIN_VALUE;
        return this.i.h(0L, null, null, this);
    }
}
