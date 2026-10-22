package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public f f12960c;

    /* renamed from: f, reason: collision with root package name */
    public long f12961f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f12962g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f12963h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, pb.c cVar) {
        super(cVar);
        this.f12963h = fVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f12962g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f12963h.a(0L, null, this);
    }
}
