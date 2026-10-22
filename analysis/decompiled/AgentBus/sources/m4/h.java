package m4;

/* loaded from: classes.dex */
public final class h extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public x f6207f;

    /* renamed from: g, reason: collision with root package name */
    public a6.h f6208g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6209h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x f6210i;

    /* renamed from: j, reason: collision with root package name */
    public int f6211j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(x xVar, i7.c cVar) {
        super(cVar);
        this.f6210i = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6209h = obj;
        this.f6211j |= Integer.MIN_VALUE;
        return this.f6210i.e(null, null, this);
    }
}
