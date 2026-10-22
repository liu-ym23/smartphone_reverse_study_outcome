package i9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public b f5894c;

    /* renamed from: f, reason: collision with root package name */
    public long f5895f;

    /* renamed from: g, reason: collision with root package name */
    public long f5896g;

    /* renamed from: h, reason: collision with root package name */
    public long f5897h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f5898j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ b0 f5899k;

    /* renamed from: l, reason: collision with root package name */
    public int f5900l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(b0 b0Var, pb.c cVar) {
        super(cVar);
        this.f5899k = b0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f5898j = obj;
        this.f5900l |= Integer.MIN_VALUE;
        return this.f5899k.i(this);
    }
}
