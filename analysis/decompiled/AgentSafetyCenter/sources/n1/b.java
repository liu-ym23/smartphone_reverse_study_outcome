package n1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8620c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f8621f;

    /* renamed from: g, reason: collision with root package name */
    public int f8622g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, pb.c cVar) {
        super(cVar);
        this.f8621f = dVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8620c = obj;
        this.f8622g |= Integer.MIN_VALUE;
        return this.f8621f.a(0L, 0L, this);
    }
}
