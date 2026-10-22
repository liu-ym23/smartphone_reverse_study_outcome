package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public z f14715c;

    /* renamed from: f, reason: collision with root package name */
    public int f14716f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f14717g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ z f14718h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(z zVar, pb.c cVar) {
        super(cVar);
        this.f14718h = zVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14717g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f14718h.h(this);
    }
}
