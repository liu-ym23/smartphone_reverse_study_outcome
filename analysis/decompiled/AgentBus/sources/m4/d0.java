package m4;

/* loaded from: classes.dex */
public final class d0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6172f;

    /* renamed from: g, reason: collision with root package name */
    public q0 f6173g;

    /* renamed from: h, reason: collision with root package name */
    public String f6174h;

    /* renamed from: i, reason: collision with root package name */
    public a6.w f6175i;

    /* renamed from: j, reason: collision with root package name */
    public q0 f6176j;

    /* renamed from: k, reason: collision with root package name */
    public int f6177k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ q0 f6178l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ a6.w f6179m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(q0 q0Var, a6.w wVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f6172f = i2;
        this.f6178l = q0Var;
        this.f6179m = wVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6172f) {
            case 0:
                return new d0(this.f6178l, this.f6179m, dVar, 0);
            default:
                return new d0(this.f6178l, this.f6179m, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f6172f) {
        }
        return ((d0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
    
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a0, code lost:
    
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011f, code lost:
    
        return m4.q0.N(r8, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0187  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.d0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
