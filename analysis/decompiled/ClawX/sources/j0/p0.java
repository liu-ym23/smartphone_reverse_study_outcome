package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p0 extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public a1.w f3408a;

    /* renamed from: b, reason: collision with root package name */
    public i6.a f3409b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3410c;
    public final /* synthetic */ a1.w d;

    /* renamed from: e, reason: collision with root package name */
    public int f3411e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(a1.w wVar, h5.c cVar) {
        super(cVar);
        this.d = wVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3410c = obj;
        this.f3411e |= Integer.MIN_VALUE;
        return this.d.o(this);
    }
}
