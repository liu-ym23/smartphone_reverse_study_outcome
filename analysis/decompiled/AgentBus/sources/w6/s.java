package w6;

/* loaded from: classes.dex */
public final class s extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f10825f;

    /* renamed from: g, reason: collision with root package name */
    public String f10826g;

    /* renamed from: h, reason: collision with root package name */
    public String f10827h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f10828i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ x f10829j;

    /* renamed from: k, reason: collision with root package name */
    public int f10830k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(x xVar, i7.c cVar) {
        super(cVar);
        this.f10829j = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10828i = obj;
        this.f10830k |= Integer.MIN_VALUE;
        return this.f10829j.b(null, null, this);
    }
}
