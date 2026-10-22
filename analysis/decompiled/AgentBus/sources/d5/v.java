package d5;

/* loaded from: classes.dex */
public final class v extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public z f2909f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f2910g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ z f2911h;

    /* renamed from: i, reason: collision with root package name */
    public int f2912i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(z zVar, i7.c cVar) {
        super(cVar);
        this.f2911h = zVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f2910g = obj;
        this.f2912i |= Integer.MIN_VALUE;
        return this.f2911h.b(this);
    }
}
