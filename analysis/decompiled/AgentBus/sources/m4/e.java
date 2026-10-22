package m4;

/* loaded from: classes.dex */
public final class e extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6180f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f6181g;

    /* renamed from: h, reason: collision with root package name */
    public int f6182h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(x xVar, i7.c cVar) {
        super(cVar);
        this.f6181g = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6180f = obj;
        this.f6182h |= Integer.MIN_VALUE;
        return this.f6181g.a(null, null, this);
    }
}
