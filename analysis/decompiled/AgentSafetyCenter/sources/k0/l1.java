package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l1 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public xb.l f6969c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6970f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m1 f6971g;

    /* renamed from: h, reason: collision with root package name */
    public int f6972h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(m1 m1Var, pb.c cVar) {
        super(cVar);
        this.f6971g = m1Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f6970f = obj;
        this.f6972h |= Integer.MIN_VALUE;
        return this.f6971g.C(null, this);
    }
}
