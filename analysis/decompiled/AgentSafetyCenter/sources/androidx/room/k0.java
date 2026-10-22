package androidx.room;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public m f1565c;

    /* renamed from: f, reason: collision with root package name */
    public String f1566f;

    /* renamed from: g, reason: collision with root package name */
    public String[] f1567g;

    /* renamed from: h, reason: collision with root package name */
    public int f1568h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f1569j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ n0 f1570k;

    /* renamed from: l, reason: collision with root package name */
    public int f1571l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(n0 n0Var, pb.c cVar) {
        super(cVar);
        this.f1570k = n0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f1569j = obj;
        this.f1571l |= Integer.MIN_VALUE;
        return n0.d(this.f1570k, null, 0, this);
    }
}
