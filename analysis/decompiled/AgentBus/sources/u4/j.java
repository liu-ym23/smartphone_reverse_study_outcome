package u4;

/* loaded from: classes.dex */
public final class j extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public k f10081f;

    /* renamed from: g, reason: collision with root package name */
    public String f10082g;

    /* renamed from: h, reason: collision with root package name */
    public String f10083h;

    /* renamed from: i, reason: collision with root package name */
    public String f10084i;

    /* renamed from: j, reason: collision with root package name */
    public String f10085j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f10086k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k f10087l;

    /* renamed from: m, reason: collision with root package name */
    public int f10088m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, i7.c cVar) {
        super(cVar);
        this.f10087l = kVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10086k = obj;
        this.f10088m |= Integer.MIN_VALUE;
        return this.f10087l.a(null, null, null, null, null, null, this);
    }
}
