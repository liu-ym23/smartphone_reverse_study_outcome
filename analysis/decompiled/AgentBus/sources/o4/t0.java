package o4;

/* loaded from: classes.dex */
public final class t0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public f1 f7567f;

    /* renamed from: g, reason: collision with root package name */
    public String f7568g;

    /* renamed from: h, reason: collision with root package name */
    public f f7569h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f7570i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ f1 f7571j;

    /* renamed from: k, reason: collision with root package name */
    public int f7572k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(f1 f1Var, i7.c cVar) {
        super(cVar);
        this.f7571j = f1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7570i = obj;
        this.f7572k |= Integer.MIN_VALUE;
        return f1.a(this.f7571j, null, this);
    }
}
