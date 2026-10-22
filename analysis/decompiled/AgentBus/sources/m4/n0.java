package m4;

/* loaded from: classes.dex */
public final class n0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6267f = 0;

    /* renamed from: g, reason: collision with root package name */
    public Object f6268g;

    /* renamed from: h, reason: collision with root package name */
    public String f6269h;

    /* renamed from: i, reason: collision with root package name */
    public q0 f6270i;

    /* renamed from: j, reason: collision with root package name */
    public String f6271j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6272k;

    /* renamed from: l, reason: collision with root package name */
    public int f6273l;

    /* renamed from: m, reason: collision with root package name */
    public Object f6274m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ q0 f6275n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f6276o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ a6.w f6277p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f6278q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(String str, q0 q0Var, a6.w wVar, boolean z4, g7.d dVar) {
        super(2, dVar);
        this.f6276o = str;
        this.f6275n = q0Var;
        this.f6277p = wVar;
        this.f6278q = z4;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6267f) {
            case 0:
                return new n0(this.f6276o, this.f6275n, this.f6277p, this.f6278q, dVar);
            default:
                n0 n0Var = new n0(this.f6275n, this.f6276o, this.f6277p, this.f6278q, dVar);
                n0Var.f6274m = obj;
                return n0Var;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f6267f) {
        }
        return ((n0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:130|(4:227|131|132|177)|182|(1:184)|185|(1:188)|189|221|190|194|(1:196)|197|(1:200)|201|(2:(1:(1:210)(1:211))(1:207)|208)|212) */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0480, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0481, code lost:
    
        r0 = w7.e0.n(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x027c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:250:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x021c A[Catch: all -> 0x0232, TryCatch #9 {all -> 0x0232, blocks: (B:90:0x0215, B:94:0x022f, B:93:0x021c, B:89:0x0211, B:86:0x01f8), top: B:235:0x01f8, inners: #7 }] */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r43) {
        /*
            Method dump skipped, instructions count: 1374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.n0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(q0 q0Var, String str, a6.w wVar, boolean z4, g7.d dVar) {
        super(2, dVar);
        this.f6275n = q0Var;
        this.f6276o = str;
        this.f6277p = wVar;
        this.f6278q = z4;
    }
}
