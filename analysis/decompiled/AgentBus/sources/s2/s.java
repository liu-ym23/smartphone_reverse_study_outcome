package s2;

/* loaded from: classes.dex */
public final class s extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public z f9421f;

    /* renamed from: g, reason: collision with root package name */
    public int f9422g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9423h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ z f9424i;

    /* renamed from: j, reason: collision with root package name */
    public int f9425j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(z zVar, i7.c cVar) {
        super(cVar);
        this.f9424i = zVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9423h = obj;
        this.f9425j |= Integer.MIN_VALUE;
        return this.f9424i.e(this);
    }
}
