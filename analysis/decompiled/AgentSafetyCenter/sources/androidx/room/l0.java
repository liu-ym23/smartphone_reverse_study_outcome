package androidx.room;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public p5.c f1572c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1573f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n0 f1574g;

    /* renamed from: h, reason: collision with root package name */
    public int f1575h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(n0 n0Var, pb.c cVar) {
        super(cVar);
        this.f1574g = n0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f1573f = obj;
        this.f1575h |= Integer.MIN_VALUE;
        return this.f1574g.f(this);
    }
}
