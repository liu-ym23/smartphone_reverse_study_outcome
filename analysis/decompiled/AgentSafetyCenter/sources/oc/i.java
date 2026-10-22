package oc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public j f9377c;

    /* renamed from: f, reason: collision with root package name */
    public Object f9378f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f9379g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ j f9380h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, nb.c cVar) {
        super(cVar);
        this.f9380h = jVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f9379g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f9380h.emit(null, this);
    }
}
