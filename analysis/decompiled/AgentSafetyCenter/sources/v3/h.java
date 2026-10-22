package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f14642c;

    /* renamed from: f, reason: collision with root package name */
    public Object f14643f;

    /* renamed from: g, reason: collision with root package name */
    public Object f14644g;

    /* renamed from: h, reason: collision with root package name */
    public yb.u f14645h;
    public z i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f14646j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ i f14647k;

    /* renamed from: l, reason: collision with root package name */
    public int f14648l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, pb.c cVar) {
        super(cVar);
        this.f14647k = iVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14646j = obj;
        this.f14648l |= Integer.MIN_VALUE;
        return this.f14647k.a(null, this);
    }
}
