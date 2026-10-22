package x;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public j f11010f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f11011g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ j f11012h;

    /* renamed from: i, reason: collision with root package name */
    public int f11013i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(j jVar, i7.c cVar) {
        super(cVar);
        this.f11012h = jVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11011g = obj;
        this.f11013i |= Integer.MIN_VALUE;
        return this.f11012h.a(this);
    }
}
