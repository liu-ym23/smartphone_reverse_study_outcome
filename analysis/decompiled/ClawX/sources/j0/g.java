package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public a1.w f3343a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3344b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a1.w f3345c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(a1.w wVar, h5.c cVar) {
        super(cVar);
        this.f3345c = wVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3344b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.f3345c.f(this);
    }
}
