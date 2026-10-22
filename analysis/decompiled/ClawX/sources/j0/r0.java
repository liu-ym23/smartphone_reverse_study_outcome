package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r0 extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public Object f3421a;

    /* renamed from: b, reason: collision with root package name */
    public i6.c f3422b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3423c;
    public final /* synthetic */ u0 d;

    /* renamed from: e, reason: collision with root package name */
    public int f3424e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(u0 u0Var, h5.c cVar) {
        super(cVar);
        this.d = u0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3423c = obj;
        this.f3424e |= Integer.MIN_VALUE;
        return this.d.b(null, this);
    }
}
