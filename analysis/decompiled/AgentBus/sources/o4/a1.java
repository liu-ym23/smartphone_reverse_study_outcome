package o4;

/* loaded from: classes.dex */
public final class a1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public f1 f7262f;

    /* renamed from: g, reason: collision with root package name */
    public String f7263g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7264h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f1 f7265i;

    /* renamed from: j, reason: collision with root package name */
    public int f7266j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(f1 f1Var, i7.c cVar) {
        super(cVar);
        this.f7265i = f1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7264h = obj;
        this.f7266j |= Integer.MIN_VALUE;
        return f1.c(this.f7265i, this);
    }
}
