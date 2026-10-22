package m5;

/* loaded from: classes.dex */
public final class i extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public j f6408f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6409g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ j f6410h;

    /* renamed from: i, reason: collision with root package name */
    public int f6411i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, i7.c cVar) {
        super(cVar);
        this.f6410h = jVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6409g = obj;
        this.f6411i |= Integer.MIN_VALUE;
        return j.a(this.f6410h, this);
    }
}
