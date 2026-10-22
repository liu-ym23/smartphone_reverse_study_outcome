package y4;

/* loaded from: classes.dex */
public final class s extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f11649f;

    /* renamed from: g, reason: collision with root package name */
    public int f11650g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s2.r f11651h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(s2.r rVar, g7.d dVar) {
        super(dVar);
        this.f11651h = rVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11649f = obj;
        this.f11650g |= Integer.MIN_VALUE;
        return this.f11651h.emit(null, this);
    }
}
