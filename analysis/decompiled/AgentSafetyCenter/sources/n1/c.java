package n1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8623c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f8624f;

    /* renamed from: g, reason: collision with root package name */
    public int f8625g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, pb.c cVar) {
        super(cVar);
        this.f8624f = dVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8623c = obj;
        this.f8625g |= Integer.MIN_VALUE;
        return this.f8624f.b(0L, this);
    }
}
