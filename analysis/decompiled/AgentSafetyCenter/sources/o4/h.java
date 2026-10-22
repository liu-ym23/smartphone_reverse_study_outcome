package o4;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public i f9180c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f9181f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i f9182g;

    /* renamed from: h, reason: collision with root package name */
    public int f9183h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, pb.c cVar) {
        super(cVar);
        this.f9182g = iVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f9181f = obj;
        this.f9183h |= Integer.MIN_VALUE;
        return this.f9182g.a(this);
    }
}
