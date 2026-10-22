package mc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8560c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f8561f;

    /* renamed from: g, reason: collision with root package name */
    public int f8562g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, pb.c cVar) {
        super(cVar);
        this.f8561f = eVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8560c = obj;
        this.f8562g |= Integer.MIN_VALUE;
        Object objD = this.f8561f.D(null, 0, 0L, this);
        return objD == ob.a.f9351c ? objD : l.a(objD);
    }
}
