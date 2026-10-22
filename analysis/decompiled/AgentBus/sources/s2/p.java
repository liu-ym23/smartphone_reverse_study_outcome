package s2;

/* loaded from: classes.dex */
public final class p extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f9410f;

    /* renamed from: g, reason: collision with root package name */
    public z f9411g;

    /* renamed from: h, reason: collision with root package name */
    public ia.s f9412h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f9413i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z f9414j;

    /* renamed from: k, reason: collision with root package name */
    public int f9415k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(z zVar, i7.c cVar) {
        super(cVar);
        this.f9414j = zVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9413i = obj;
        this.f9415k |= Integer.MIN_VALUE;
        return z.a(this.f9414j, null, this);
    }
}
