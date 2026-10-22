package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public c0 f3437a;

    /* renamed from: b, reason: collision with root package name */
    public v0 f3438b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3439c;
    public /* synthetic */ Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c0 f3440e;

    /* renamed from: f, reason: collision with root package name */
    public int f3441f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(c0 c0Var, f5.c cVar) {
        super(cVar);
        this.f3440e = c0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f3441f |= Integer.MIN_VALUE;
        return c0.e(this.f3440e, false, this);
    }
}
