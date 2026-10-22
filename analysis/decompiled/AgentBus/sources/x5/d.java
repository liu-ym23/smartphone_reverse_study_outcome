package x5;

/* loaded from: classes.dex */
public final class d extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f11233f;

    /* renamed from: g, reason: collision with root package name */
    public String f11234g;

    /* renamed from: h, reason: collision with root package name */
    public ra.d f11235h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f11236i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e f11237j;

    /* renamed from: k, reason: collision with root package name */
    public int f11238k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, i7.c cVar) {
        super(cVar);
        this.f11237j = eVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11236i = obj;
        this.f11238k |= Integer.MIN_VALUE;
        return this.f11237j.b(null, null, this);
    }
}
