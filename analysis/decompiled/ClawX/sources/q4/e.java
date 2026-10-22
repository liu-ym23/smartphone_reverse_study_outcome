package q4;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4848a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f4849b;

    /* renamed from: c, reason: collision with root package name */
    public int f4850c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(i iVar, h5.c cVar) {
        super(cVar);
        this.f4849b = iVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f4848a = obj;
        this.f4850c |= Integer.MIN_VALUE;
        return this.f4849b.b(null, null, null, this);
    }
}
