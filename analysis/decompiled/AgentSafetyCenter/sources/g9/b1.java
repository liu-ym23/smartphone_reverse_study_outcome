package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b1 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4411c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d1 f4412f;

    /* renamed from: g, reason: collision with root package name */
    public int f4413g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(d1 d1Var, pb.c cVar) {
        super(cVar);
        this.f4412f = d1Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f4411c = obj;
        this.f4413g |= Integer.MIN_VALUE;
        return this.f4412f.a(this);
    }
}
