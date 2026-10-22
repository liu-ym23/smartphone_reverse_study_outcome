package y;

/* loaded from: classes.dex */
public final class c extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f11360f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n.c f11361g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f11362h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f11363i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ d f11364j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ q.h f11365k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(n.c cVar, float f10, boolean z4, d dVar, q.h hVar, g7.d dVar2) {
        super(2, dVar2);
        this.f11361g = cVar;
        this.f11362h = f10;
        this.f11363i = z4;
        this.f11364j = dVar;
        this.f11365k = hVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new c(this.f11361g, this.f11362h, this.f11363i, this.f11364j, this.f11365k, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ff A[RETURN] */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
