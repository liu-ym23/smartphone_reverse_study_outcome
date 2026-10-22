package b0;

/* loaded from: classes.dex */
public final class f2 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1146f;

    /* renamed from: g, reason: collision with root package name */
    public int f1147g;

    /* renamed from: h, reason: collision with root package name */
    public Object f1148h;

    /* renamed from: i, reason: collision with root package name */
    public Object f1149i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1150j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f2(a7.d dVar, Class cls, p7.n nVar, g7.d dVar2) {
        super(2, dVar2);
        this.f1146f = 7;
        this.f1148h = dVar;
        this.f1149i = cls;
        this.f1150j = (i7.i) nVar;
    }

    /* JADX WARN: Type inference failed for: r8v14, types: [i7.i, p7.n] */
    /* JADX WARN: Type inference failed for: r8v27, types: [i7.i, p7.n] */
    /* JADX WARN: Type inference failed for: r8v30, types: [p7.a, q7.m] */
    /* JADX WARN: Type inference failed for: r8v34, types: [i7.i, p7.n] */
    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f1146f) {
            case 0:
                f2 f2Var = new f2((i2) this.f1149i, (c1) this.f1150j, dVar, 0);
                f2Var.f1148h = obj;
                return f2Var;
            case 1:
                f2 f2Var2 = new f2((p7.n) this.f1149i, (f1) this.f1150j, dVar, 1);
                f2Var2.f1148h = obj;
                return f2Var2;
            case 2:
                return new f2((d5.l) this.f1148h, (d5.m) this.f1149i, (p7.k) this.f1150j, dVar, 2);
            case 3:
                f2 f2Var3 = new f2((d5.z) this.f1149i, (c6.l) this.f1150j, dVar, 3);
                f2Var3.f1148h = obj;
                return f2Var3;
            case 4:
                f2 f2Var4 = new f2((String) this.f1149i, (i5.u) this.f1150j, dVar, 4);
                f2Var4.f1148h = obj;
                return f2Var4;
            case 5:
                return new f2((String) this.f1148h, (i5.u) this.f1149i, (String) this.f1150j, dVar, 5);
            case 6:
                return new f2((ka.g) this.f1150j, dVar, 6);
            case 7:
                return new f2((a7.d) this.f1148h, (Class) this.f1149i, (p7.n) this.f1150j, dVar);
            case 8:
                f2 f2Var5 = new f2((n.b1) this.f1149i, (f1) this.f1150j, dVar, 8);
                f2Var5.f1148h = obj;
                return f2Var5;
            case 9:
                f2 f2Var6 = new f2((la.k) this.f1149i, (ma.e) this.f1150j, dVar, 9);
                f2Var6.f1148h = obj;
                return f2Var6;
            case 10:
                return new f2((q.i) this.f1148h, (q.h) this.f1149i, (ia.p0) this.f1150j, dVar, 10);
            case 11:
                f2 f2Var7 = new f2((o4.t1) this.f1149i, (o4.f1) this.f1150j, dVar, 11);
                f2Var7.f1148h = obj;
                return f2Var7;
            case 12:
                f2 f2Var8 = new f2((a4.p) this.f1149i, (f2) this.f1150j, dVar, 12);
                f2Var8.f1148h = obj;
                return f2Var8;
            case 13:
                f2 f2Var9 = new f2((p.z) this.f1149i, (p.y0) this.f1150j, dVar, 13);
                f2Var9.f1148h = obj;
                return f2Var9;
            case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                f2 f2Var10 = new f2((p.y0) this.f1149i, (p7.n) this.f1150j, dVar);
                f2Var10.f1148h = obj;
                return f2Var10;
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return new f2((o.q) this.f1148h, (p.h0) this.f1149i, (c1.l) this.f1150j, dVar, 15);
            case 16:
                return new f2((s.d) this.f1148h, (i1.d1) this.f1149i, (p7.a) this.f1150j, dVar);
            case 17:
                f2 f2Var11 = new f2((s2.z) this.f1150j, dVar, 17);
                f2Var11.f1148h = obj;
                return f2Var11;
            case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                f2 f2Var12 = new f2((s2.z) this.f1149i, (p7.n) this.f1150j, dVar);
                f2Var12.f1148h = obj;
                return f2Var12;
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                return new f2((String) this.f1148h, (String) this.f1149i, (v4.k) this.f1150j, dVar, 19);
            case 20:
                f2 f2Var13 = new f2((v4.p) this.f1149i, (c6.l) this.f1150j, dVar, 20);
                f2Var13.f1148h = obj;
                return f2Var13;
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                return new f2((f1) this.f1148h, (f1) this.f1149i, (f1) this.f1150j, dVar, 21);
            case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                return new f2((x.j) this.f1148h, (x.c) this.f1149i, (q.k) this.f1150j, dVar, 22);
            case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                f2 f2Var14 = new f2((q.i) this.f1149i, (x.a) this.f1150j, dVar, 23);
                f2Var14.f1148h = obj;
                return f2Var14;
            default:
                return new f2((x4.i) this.f1148h, (q7.v) this.f1149i, (Throwable) this.f1150j, dVar, 24);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1146f) {
        }
        return ((f2) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0772 A[Catch: all -> 0x0745, TryCatch #2 {all -> 0x0745, blocks: (B:359:0x073f, B:370:0x076a, B:372:0x0772, B:373:0x077f, B:380:0x078f, B:367:0x075d, B:382:0x0792, B:384:0x0797, B:385:0x0798, B:366:0x0758, B:374:0x0780, B:376:0x0786), top: B:507:0x0733, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0799  */
    /* JADX WARN: Type inference failed for: r11v23, types: [i7.i, p7.n] */
    /* JADX WARN: Type inference failed for: r1v107, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v75, types: [i7.i, p7.n] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v19, types: [ka.x] */
    /* JADX WARN: Type inference failed for: r2v21, types: [ka.g] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v23, types: [ka.x] */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r5v6, types: [i7.i, p7.n] */
    /* JADX WARN: Type inference failed for: r8v0, types: [g7.d] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.concurrent.CancellationException] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Throwable, java.util.concurrent.CancellationException] */
    /* JADX WARN: Type inference failed for: r8v9, types: [p7.a, q7.m] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:293:0x05a3 -> B:306:0x063e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:295:0x05b4 -> B:306:0x063e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:298:0x060d -> B:300:0x0610). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:368:0x0767 -> B:370:0x076a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x01ba -> B:517:0x01c1). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.f2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f2(Object obj, g7.d dVar, int i2) {
        super(2, dVar);
        this.f1146f = i2;
        this.f1150j = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f2(Object obj, Object obj2, g7.d dVar, int i2) {
        super(2, dVar);
        this.f1146f = i2;
        this.f1149i = obj;
        this.f1150j = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f2(Object obj, Object obj2, Object obj3, g7.d dVar, int i2) {
        super(2, dVar);
        this.f1146f = i2;
        this.f1148h = obj;
        this.f1149i = obj2;
        this.f1150j = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f2(p.y0 y0Var, p7.n nVar, g7.d dVar) {
        super(2, dVar);
        this.f1146f = 14;
        this.f1149i = y0Var;
        this.f1150j = (i7.i) nVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f2(s.d dVar, i1.d1 d1Var, p7.a aVar, g7.d dVar2) {
        super(2, dVar2);
        this.f1146f = 16;
        this.f1148h = dVar;
        this.f1149i = d1Var;
        this.f1150j = (q7.m) aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f2(s2.z zVar, p7.n nVar, g7.d dVar) {
        super(2, dVar);
        this.f1146f = 18;
        this.f1149i = zVar;
        this.f1150j = (i7.i) nVar;
    }
}
