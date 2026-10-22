package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h0 extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public j0 f3356a;

    /* renamed from: b, reason: collision with root package name */
    public e0 f3357b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3358c;
    public /* synthetic */ Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j0 f3359e;

    /* renamed from: f, reason: collision with root package name */
    public int f3360f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(j0 j0Var, h5.c cVar) {
        super(cVar);
        this.f3359e = j0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f3360f |= Integer.MIN_VALUE;
        return this.f3359e.a(null, this);
    }
}
