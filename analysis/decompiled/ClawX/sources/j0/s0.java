package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s0 extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public i6.c f3429a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3430b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3431c;
    public final /* synthetic */ u0 d;

    /* renamed from: e, reason: collision with root package name */
    public int f3432e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(u0 u0Var, h5.c cVar) {
        super(cVar);
        this.d = u0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3431c = obj;
        this.f3432e |= Integer.MIN_VALUE;
        return this.d.c(null, this);
    }
}
