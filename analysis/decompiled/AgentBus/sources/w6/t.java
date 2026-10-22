package w6;

/* loaded from: classes.dex */
public final class t extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f10831f;

    /* renamed from: g, reason: collision with root package name */
    public String f10832g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f10833h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x f10834i;

    /* renamed from: j, reason: collision with root package name */
    public int f10835j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(x xVar, g7.d dVar) {
        super(dVar);
        this.f10834i = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10833h = obj;
        this.f10835j |= Integer.MIN_VALUE;
        return this.f10834i.c(null, null, this);
    }
}
