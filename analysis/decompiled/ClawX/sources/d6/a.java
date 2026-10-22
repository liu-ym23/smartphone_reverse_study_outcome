package d6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public e6.j f1851a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1852b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f1853c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar, f5.c cVar) {
        super(cVar);
        this.f1853c = eVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f1852b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.f1853c.collect(null, this);
    }
}
