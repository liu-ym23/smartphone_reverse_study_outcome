package s2;

/* loaded from: classes.dex */
public final class d0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public i5.f f9348f;

    /* renamed from: g, reason: collision with root package name */
    public ra.b f9349g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9350h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ i5.f f9351i;

    /* renamed from: j, reason: collision with root package name */
    public int f9352j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(i5.f fVar, i7.c cVar) {
        super(cVar);
        this.f9351i = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9350h = obj;
        this.f9352j |= Integer.MIN_VALUE;
        return this.f9351i.R(this);
    }
}
