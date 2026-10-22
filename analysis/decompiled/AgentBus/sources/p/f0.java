package p;

/* loaded from: classes.dex */
public final class f0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public h0 f8092f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8093g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h0 f8094h;

    /* renamed from: i, reason: collision with root package name */
    public int f8095i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(h0 h0Var, i7.c cVar) {
        super(cVar);
        this.f8094h = h0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8093g = obj;
        this.f8095i |= Integer.MIN_VALUE;
        return this.f8094h.a(this);
    }
}
