package d5;

/* loaded from: classes.dex */
public final class j extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f2878f;

    /* renamed from: g, reason: collision with root package name */
    public int f2879g;

    /* renamed from: h, reason: collision with root package name */
    public la.k f2880h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ k f2881i;

    /* renamed from: j, reason: collision with root package name */
    public e f2882j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, g7.d dVar) {
        super(dVar);
        this.f2881i = kVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f2878f = obj;
        this.f2879g |= Integer.MIN_VALUE;
        return this.f2881i.emit(null, this);
    }
}
