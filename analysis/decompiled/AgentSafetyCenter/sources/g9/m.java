package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4525c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a4.n f4526f;

    /* renamed from: g, reason: collision with root package name */
    public int f4527g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(a4.n nVar, pb.c cVar) {
        super(cVar);
        this.f4526f = nVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f4525c = obj;
        this.f4527g |= Integer.MIN_VALUE;
        return this.f4526f.b(this);
    }
}
