package mc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8557c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f8558f;

    /* renamed from: g, reason: collision with root package name */
    public int f8559g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, pb.c cVar) {
        super(cVar);
        this.f8558f = eVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8557c = obj;
        this.f8559g |= Integer.MIN_VALUE;
        Object objC = e.C(this.f8558f, this);
        return objC == ob.a.f9351c ? objC : l.a(objC);
    }
}
