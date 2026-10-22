package w6;

/* loaded from: classes.dex */
public final class r extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public String f10818f;

    /* renamed from: g, reason: collision with root package name */
    public String f10819g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f10820h;

    /* renamed from: i, reason: collision with root package name */
    public String f10821i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f10822j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ x f10823k;

    /* renamed from: l, reason: collision with root package name */
    public int f10824l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(x xVar, g7.d dVar) {
        super(dVar);
        this.f10823k = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10822j = obj;
        this.f10824l |= Integer.MIN_VALUE;
        return this.f10823k.a(null, null, null, false, false, this);
    }
}
