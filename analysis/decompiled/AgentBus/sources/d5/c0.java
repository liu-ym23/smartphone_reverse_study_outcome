package d5;

/* loaded from: classes.dex */
public final class c0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public d0 f2859f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f2860g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d0 f2861h;

    /* renamed from: i, reason: collision with root package name */
    public int f2862i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(d0 d0Var, i7.c cVar) {
        super(cVar);
        this.f2861h = d0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f2860g = obj;
        this.f2862i |= Integer.MIN_VALUE;
        return this.f2861h.b(this);
    }
}
