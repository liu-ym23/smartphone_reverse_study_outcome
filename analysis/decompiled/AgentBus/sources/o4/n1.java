package o4;

/* loaded from: classes.dex */
public final class n1 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t1 f7468f;

    /* renamed from: g, reason: collision with root package name */
    public f1 f7469g;

    /* renamed from: h, reason: collision with root package name */
    public String f7470h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f7471i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ t1 f7472j;

    /* renamed from: k, reason: collision with root package name */
    public int f7473k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(t1 t1Var, i7.c cVar) {
        super(cVar);
        this.f7472j = t1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7471i = obj;
        this.f7473k |= Integer.MIN_VALUE;
        return t1.c(this.f7472j, null, null, 0L, this);
    }
}
