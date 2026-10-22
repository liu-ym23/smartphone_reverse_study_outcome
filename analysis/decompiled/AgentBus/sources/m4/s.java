package m4;

/* loaded from: classes.dex */
public final class s extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public String f6327f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6328g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ x f6329h;

    /* renamed from: i, reason: collision with root package name */
    public int f6330i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(x xVar, i7.c cVar) {
        super(cVar);
        this.f6329h = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6328g = obj;
        this.f6330i |= Integer.MIN_VALUE;
        return this.f6329h.t(null, null, false, this);
    }
}
