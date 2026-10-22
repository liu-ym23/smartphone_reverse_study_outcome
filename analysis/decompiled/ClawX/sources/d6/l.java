package d6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public m f1884a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1885b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1886c;
    public final /* synthetic */ m d;

    /* renamed from: e, reason: collision with root package name */
    public int f1887e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, f5.c cVar) {
        super(cVar);
        this.d = mVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f1886c = obj;
        this.f1887e |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
