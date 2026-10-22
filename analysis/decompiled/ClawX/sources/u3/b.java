package u3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public w4.a f5627a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f5628b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f5629c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, h5.c cVar2) {
        super(cVar2);
        this.f5629c = cVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f5628b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.f5629c.a(null, this);
    }
}
