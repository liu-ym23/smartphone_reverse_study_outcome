package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f14683c;

    /* renamed from: f, reason: collision with root package name */
    public int f14684f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ u5.j f14685g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(u5.j jVar, nb.c cVar) {
        super(cVar);
        this.f14685g = jVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14683c = obj;
        this.f14684f |= Integer.MIN_VALUE;
        return this.f14685g.emit(null, this);
    }
}
