package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public j0 f12980c;

    /* renamed from: f, reason: collision with root package name */
    public v.h f12981f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f12982g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ j0 f12983h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(j0 j0Var, pb.c cVar) {
        super(cVar);
        this.f12983h = j0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f12982g = obj;
        this.i |= Integer.MIN_VALUE;
        return j0.B0(this.f12983h, this);
    }
}
