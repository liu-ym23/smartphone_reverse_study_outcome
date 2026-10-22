package q5;

/* loaded from: classes.dex */
public final class m extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q f8722f;

    /* renamed from: g, reason: collision with root package name */
    public String f8723g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8724h;

    /* renamed from: i, reason: collision with root package name */
    public long f8725i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f8726j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ q f8727k;

    /* renamed from: l, reason: collision with root package name */
    public int f8728l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(q qVar, i7.c cVar) {
        super(cVar);
        this.f8727k = qVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8726j = obj;
        this.f8728l |= Integer.MIN_VALUE;
        return this.f8727k.j(null, this);
    }
}
