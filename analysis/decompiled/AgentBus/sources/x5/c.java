package x5;

/* loaded from: classes.dex */
public final class c extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public e f11227f;

    /* renamed from: g, reason: collision with root package name */
    public Object f11228g;

    /* renamed from: h, reason: collision with root package name */
    public ra.d f11229h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f11230i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e f11231j;

    /* renamed from: k, reason: collision with root package name */
    public int f11232k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, i7.c cVar) {
        super(cVar);
        this.f11231j = eVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11230i = obj;
        this.f11232k |= Integer.MIN_VALUE;
        return this.f11231j.a(null, this);
    }
}
