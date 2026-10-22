package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public p5.i f14679c;

    /* renamed from: f, reason: collision with root package name */
    public sc.a f14680f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f14681g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p5.i f14682h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(p5.i iVar, pb.c cVar) {
        super(cVar);
        this.f14682h = iVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14681g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f14682h.B(this);
    }
}
