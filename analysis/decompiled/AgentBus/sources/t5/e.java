package t5;

/* loaded from: classes.dex */
public final class e extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public f f9755f;

    /* renamed from: g, reason: collision with root package name */
    public c5.b f9756g;

    /* renamed from: h, reason: collision with root package name */
    public d5.e f9757h;

    /* renamed from: i, reason: collision with root package name */
    public Object f9758i;

    /* renamed from: j, reason: collision with root package name */
    public String f9759j;

    /* renamed from: k, reason: collision with root package name */
    public String f9760k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f9761l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ f f9762m;

    /* renamed from: n, reason: collision with root package name */
    public int f9763n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, i7.c cVar) {
        super(cVar);
        this.f9762m = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9761l = obj;
        this.f9763n |= Integer.MIN_VALUE;
        return this.f9762m.b(null, null, this);
    }
}
