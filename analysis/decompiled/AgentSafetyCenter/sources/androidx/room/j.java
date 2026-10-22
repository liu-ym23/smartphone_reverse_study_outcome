package androidx.room;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1552c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k f1553f;

    /* renamed from: g, reason: collision with root package name */
    public int f1554g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, pb.c cVar) {
        super(cVar);
        this.f1553f = kVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f1552c = obj;
        this.f1554g |= Integer.MIN_VALUE;
        this.f1553f.a(null, this);
        return ob.a.f9351c;
    }
}
