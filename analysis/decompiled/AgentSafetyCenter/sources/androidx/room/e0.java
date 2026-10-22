package androidx.room;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f1520c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1521f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n0 f1522g;

    /* renamed from: h, reason: collision with root package name */
    public int f1523h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(n0 n0Var, pb.c cVar) {
        super(cVar);
        this.f1522g = n0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f1521f = obj;
        this.f1523h |= Integer.MIN_VALUE;
        return n0.a(this.f1522g, null, this);
    }
}
