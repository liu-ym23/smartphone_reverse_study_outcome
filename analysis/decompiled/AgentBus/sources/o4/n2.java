package o4;

/* loaded from: classes.dex */
public final class n2 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t2 f7474f;

    /* renamed from: g, reason: collision with root package name */
    public g f7475g;

    /* renamed from: h, reason: collision with root package name */
    public Exception f7476h;

    /* renamed from: i, reason: collision with root package name */
    public int f7477i;

    /* renamed from: j, reason: collision with root package name */
    public int f7478j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f7479k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ t2 f7480l;

    /* renamed from: m, reason: collision with root package name */
    public int f7481m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n2(t2 t2Var, i7.c cVar) {
        super(cVar);
        this.f7480l = t2Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7479k = obj;
        this.f7481m |= Integer.MIN_VALUE;
        return t2.c(this.f7480l, null, this);
    }
}
