package o4;

/* loaded from: classes.dex */
public final class j2 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t2 f7412f;

    /* renamed from: g, reason: collision with root package name */
    public String f7413g;

    /* renamed from: h, reason: collision with root package name */
    public String f7414h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f7415i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ t2 f7416j;

    /* renamed from: k, reason: collision with root package name */
    public int f7417k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j2(t2 t2Var, i7.c cVar) {
        super(cVar);
        this.f7416j = t2Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7415i = obj;
        this.f7417k |= Integer.MIN_VALUE;
        return this.f7416j.g(null, null, this);
    }
}
