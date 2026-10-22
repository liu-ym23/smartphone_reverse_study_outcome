package a6;

/* loaded from: classes.dex */
public final class t extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public u f371f;

    /* renamed from: g, reason: collision with root package name */
    public String f372g;

    /* renamed from: h, reason: collision with root package name */
    public String f373h;

    /* renamed from: i, reason: collision with root package name */
    public String f374i;

    /* renamed from: j, reason: collision with root package name */
    public s9.d f375j;

    /* renamed from: k, reason: collision with root package name */
    public String f376k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f377l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ u f378m;

    /* renamed from: n, reason: collision with root package name */
    public int f379n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, i7.c cVar) {
        super(cVar);
        this.f378m = uVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f377l = obj;
        this.f379n |= Integer.MIN_VALUE;
        return this.f378m.a(null, this);
    }
}
