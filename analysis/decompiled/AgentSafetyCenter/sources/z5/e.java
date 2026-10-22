package z5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public f f16443c;

    /* renamed from: f, reason: collision with root package name */
    public h f16444f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f16445g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f16446h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, pb.c cVar) {
        super(cVar);
        this.f16446h = fVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f16445g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f16446h.d(null, this);
    }
}
