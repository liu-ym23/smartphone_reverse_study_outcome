package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3400a;

    /* renamed from: b, reason: collision with root package name */
    public int f3401b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d6.q f3402c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(d6.q qVar, f5.c cVar) {
        super(cVar);
        this.f3402c = qVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3400a = obj;
        this.f3401b |= Integer.MIN_VALUE;
        return this.f3402c.emit(null, this);
    }
}
