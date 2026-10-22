package o;

/* loaded from: classes.dex */
public final class a extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7006f;

    /* renamed from: g, reason: collision with root package name */
    public int f7007g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f7008h;

    /* renamed from: i, reason: collision with root package name */
    public Object f7009i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f7010j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f7011k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, long j2, Object obj2, g7.d dVar, int i2) {
        super(2, dVar);
        this.f7006f = i2;
        this.f7010j = obj;
        this.f7008h = j2;
        this.f7011k = obj2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f7006f) {
            case 0:
                return new a((r) this.f7010j, this.f7008h, (q.i) this.f7011k, dVar, 0);
            default:
                a aVar = new a((p.y0) this.f7010j, this.f7008h, (q7.s) this.f7011k, dVar, 1);
                aVar.f7009i = obj;
                return aVar;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f7006f) {
            case 0:
                return ((a) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            default:
                return ((a) create((p.w0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a0  */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8, types: [n0.l] */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
