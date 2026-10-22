package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public c0 f3404a;

    /* renamed from: b, reason: collision with root package name */
    public i6.c f3405b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3406c;
    public final /* synthetic */ c0 d;

    /* renamed from: e, reason: collision with root package name */
    public int f3407e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(c0 c0Var, h5.c cVar) {
        super(cVar);
        this.d = c0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3406c = obj;
        this.f3407e |= Integer.MIN_VALUE;
        return c0.a(this.d, this);
    }
}
