package z1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f16167c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f16168f;

    /* renamed from: g, reason: collision with root package name */
    public int f16169g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, pb.c cVar) {
        super(cVar);
        this.f16168f = hVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f16167c = obj;
        this.f16169g |= Integer.MIN_VALUE;
        return this.f16168f.a(0.0f, this);
    }
}
