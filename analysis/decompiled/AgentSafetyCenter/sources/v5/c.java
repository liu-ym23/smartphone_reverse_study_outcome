package v5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f14775c;

    /* renamed from: f, reason: collision with root package name */
    public sc.h f14776f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f14777g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d f14778h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, pb.c cVar) {
        super(cVar);
        this.f14778h = dVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14777g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f14778h.a(this);
    }
}
