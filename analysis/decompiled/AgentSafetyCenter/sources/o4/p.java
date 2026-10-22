package o4;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public q f9213c;

    /* renamed from: f, reason: collision with root package name */
    public String f9214f;

    /* renamed from: g, reason: collision with root package name */
    public xb.l f9215g;

    /* renamed from: h, reason: collision with root package name */
    public f f9216h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ q f9217j;

    /* renamed from: k, reason: collision with root package name */
    public int f9218k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, pb.c cVar) {
        super(cVar);
        this.f9217j = qVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.f9218k |= Integer.MIN_VALUE;
        return this.f9217j.d(null, null, this);
    }
}
