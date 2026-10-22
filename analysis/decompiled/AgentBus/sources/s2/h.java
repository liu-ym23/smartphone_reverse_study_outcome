package s2;

/* loaded from: classes.dex */
public final class h extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f9371f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9372g;

    /* renamed from: h, reason: collision with root package name */
    public Object f9373h;

    /* renamed from: i, reason: collision with root package name */
    public q7.v f9374i;

    /* renamed from: j, reason: collision with root package name */
    public z f9375j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f9376k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ i f9377l;

    /* renamed from: m, reason: collision with root package name */
    public int f9378m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, i7.c cVar) {
        super(cVar);
        this.f9377l = iVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9376k = obj;
        this.f9378m |= Integer.MIN_VALUE;
        return this.f9377l.a(null, this);
    }
}
