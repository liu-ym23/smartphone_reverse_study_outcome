package m4;

/* loaded from: classes.dex */
public final class c0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f6165f;

    /* renamed from: g, reason: collision with root package name */
    public Object f6166g;

    /* renamed from: h, reason: collision with root package name */
    public int f6167h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6168i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f6169j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ q0 f6170k;

    /* renamed from: l, reason: collision with root package name */
    public int f6171l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(q0 q0Var, g7.d dVar) {
        super(dVar);
        this.f6170k = q0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6169j = obj;
        this.f6171l |= Integer.MIN_VALUE;
        return this.f6170k.w(null, this);
    }
}
