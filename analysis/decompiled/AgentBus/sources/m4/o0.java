package m4;

/* loaded from: classes.dex */
public final class o0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6282f;

    /* renamed from: g, reason: collision with root package name */
    public q0 f6283g;

    /* renamed from: h, reason: collision with root package name */
    public String f6284h;

    /* renamed from: i, reason: collision with root package name */
    public q0 f6285i;

    /* renamed from: j, reason: collision with root package name */
    public String f6286j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6287k;

    /* renamed from: l, reason: collision with root package name */
    public int f6288l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ q0 f6289m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f6290n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ a6.w f6291o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ boolean f6292p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o0(q0 q0Var, String str, a6.w wVar, boolean z4, g7.d dVar, int i2) {
        super(2, dVar);
        this.f6282f = i2;
        this.f6289m = q0Var;
        this.f6290n = str;
        this.f6291o = wVar;
        this.f6292p = z4;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6282f) {
            case 0:
                return new o0(this.f6289m, this.f6290n, this.f6291o, this.f6292p, dVar, 0);
            default:
                return new o0(this.f6289m, this.f6290n, this.f6291o, this.f6292p, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f6282f) {
        }
        return ((o0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x021a  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r40) {
        /*
            Method dump skipped, instructions count: 1070
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.o0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
