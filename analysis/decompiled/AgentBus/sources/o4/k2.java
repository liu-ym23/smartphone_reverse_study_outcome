package o4;

/* loaded from: classes.dex */
public final class k2 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t2 f7428f;

    /* renamed from: g, reason: collision with root package name */
    public String f7429g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7430h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ t2 f7431i;

    /* renamed from: j, reason: collision with root package name */
    public int f7432j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k2(t2 t2Var, i7.c cVar) {
        super(cVar);
        this.f7431i = t2Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7430h = obj;
        this.f7432j |= Integer.MIN_VALUE;
        return this.f7431i.h(null, null, this);
    }
}
