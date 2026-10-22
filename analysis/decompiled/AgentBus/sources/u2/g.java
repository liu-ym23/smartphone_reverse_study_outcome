package u2;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public i f9977f;

    /* renamed from: g, reason: collision with root package name */
    public c f9978g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9979h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f9980i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ i f9981j;

    /* renamed from: k, reason: collision with root package name */
    public int f9982k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(i iVar, i7.c cVar) {
        super(cVar);
        this.f9981j = iVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9980i = obj;
        this.f9982k |= Integer.MIN_VALUE;
        return this.f9981j.a(null, this);
    }
}
