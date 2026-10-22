package i9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public boolean f5924c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5925f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5926g;

    /* renamed from: h, reason: collision with root package name */
    public long f5927h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b0 f5928j;

    /* renamed from: k, reason: collision with root package name */
    public int f5929k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, pb.c cVar) {
        super(cVar);
        this.f5928j = b0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.f5929k |= Integer.MIN_VALUE;
        return this.f5928j.p(false, this);
    }
}
