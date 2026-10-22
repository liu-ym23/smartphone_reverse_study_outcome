package s2;

/* loaded from: classes.dex */
public final class u extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9432f;

    /* renamed from: g, reason: collision with root package name */
    public int f9433g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ boolean f9434h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ z f9435i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f9436j;

    /* renamed from: k, reason: collision with root package name */
    public Object f9437k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(z zVar, int i2, g7.d dVar, int i10) {
        super(2, dVar);
        this.f9432f = i10;
        this.f9435i = zVar;
        this.f9436j = i2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f9432f) {
            case 0:
                u uVar = new u(this.f9435i, this.f9436j, dVar, 0);
                uVar.f9434h = ((Boolean) obj).booleanValue();
                return uVar;
            default:
                u uVar2 = new u(this.f9435i, this.f9436j, dVar, 1);
                uVar2.f9434h = ((Boolean) obj).booleanValue();
                return uVar2;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        int i2 = this.f9432f;
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        g7.d dVar = (g7.d) obj2;
        switch (i2) {
        }
        return ((u) create(bool, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.u.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
