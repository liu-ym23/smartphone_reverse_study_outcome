package w6;

/* loaded from: classes.dex */
public final class v extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f10839f;

    /* renamed from: g, reason: collision with root package name */
    public String f10840g;

    /* renamed from: h, reason: collision with root package name */
    public Object f10841h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f10842i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ x f10843j;

    /* renamed from: k, reason: collision with root package name */
    public int f10844k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(x xVar, i7.c cVar) {
        super(cVar);
        this.f10843j = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10842i = obj;
        this.f10844k |= Integer.MIN_VALUE;
        return this.f10843j.e(null, null, this);
    }
}
