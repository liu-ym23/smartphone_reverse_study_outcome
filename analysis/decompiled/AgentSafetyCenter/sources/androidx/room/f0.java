package androidx.room;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public g0 f1531c;

    /* renamed from: f, reason: collision with root package name */
    public int[] f1532f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1533g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g0 f1534h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(g0 g0Var, nb.c cVar) {
        super(cVar);
        this.f1534h = g0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f1533g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f1534h.emit(null, this);
    }
}
