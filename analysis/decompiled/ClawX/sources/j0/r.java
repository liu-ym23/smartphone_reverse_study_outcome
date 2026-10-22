package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public Object f3416a;

    /* renamed from: b, reason: collision with root package name */
    public c0 f3417b;

    /* renamed from: c, reason: collision with root package name */
    public a6.s f3418c;
    public /* synthetic */ Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c0 f3419e;

    /* renamed from: f, reason: collision with root package name */
    public int f3420f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(c0 c0Var, h5.c cVar) {
        super(cVar);
        this.f3419e = c0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f3420f |= Integer.MIN_VALUE;
        return c0.b(this.f3419e, null, this);
    }
}
