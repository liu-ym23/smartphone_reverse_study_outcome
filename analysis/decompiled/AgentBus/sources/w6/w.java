package w6;

/* loaded from: classes.dex */
public final class w extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public x f10845f;

    /* renamed from: g, reason: collision with root package name */
    public String f10846g;

    /* renamed from: h, reason: collision with root package name */
    public String f10847h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f10848i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ x f10849j;

    /* renamed from: k, reason: collision with root package name */
    public int f10850k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(x xVar, g7.d dVar) {
        super(dVar);
        this.f10849j = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10848i = obj;
        this.f10850k |= Integer.MIN_VALUE;
        return this.f10849j.f(null, null, this);
    }
}
