package v4;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f5960a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f5961b;

    /* renamed from: c, reason: collision with root package name */
    public int f5962c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, f5.c cVar) {
        super(cVar);
        this.f5961b = bVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f5960a = obj;
        this.f5962c |= Integer.MIN_VALUE;
        return this.f5961b.f(this);
    }
}
