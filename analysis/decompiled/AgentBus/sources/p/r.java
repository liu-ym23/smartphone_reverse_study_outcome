package p;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class r extends i7.h implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public Object f8156g;

    /* renamed from: h, reason: collision with root package name */
    public Serializable f8157h;

    /* renamed from: i, reason: collision with root package name */
    public c1.v f8158i;

    /* renamed from: j, reason: collision with root package name */
    public q7.u f8159j;

    /* renamed from: k, reason: collision with root package name */
    public gb.a f8160k;

    /* renamed from: l, reason: collision with root package name */
    public c1.l f8161l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8162m;

    /* renamed from: n, reason: collision with root package name */
    public float f8163n;

    /* renamed from: o, reason: collision with root package name */
    public int f8164o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f8165p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ t f8166q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ e0 f8167r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ u f8168s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ h9.b f8169t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ t f8170u;

    /* renamed from: v, reason: collision with root package name */
    public final /* synthetic */ g1.y f8171v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(t tVar, e0 e0Var, u uVar, h9.b bVar, t tVar2, g1.y yVar, g7.d dVar) {
        super(2, dVar);
        this.f8166q = tVar;
        this.f8167r = e0Var;
        this.f8168s = uVar;
        this.f8169t = bVar;
        this.f8170u = tVar2;
        this.f8171v = yVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        r rVar = new r(this.f8166q, this.f8167r, this.f8168s, this.f8169t, this.f8170u, this.f8171v, dVar);
        rVar.f8165p = obj;
        return rVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((r) create((c1.v) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x031d, code lost:
    
        if (r5 == r1) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0398, code lost:
    
        if ((r11 != null ? r11 == p.e0.f8081f ? t0.b.e(r8) : t0.b.d(r8) : t0.b.c(r8)) == 0.0f) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d4, code lost:
    
        if (r6 == r1) goto L128;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:49:0x016f, B:51:0x0179], limit reached: 174 */
    /* JADX WARN: Path cross not found for [B:54:0x0180, B:49:0x016f], limit reached: 174 */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013e A[PHI: r2 r3 r4 r5 r6 r7 r12 r13 r14
      0x013e: PHI (r2v12 float) = (r2v13 float), (r2v32 float) binds: [B:38:0x013a, B:14:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r3v2 p.e0) = (r3v47 p.e0), (r3v0 p.e0) binds: [B:38:0x013a, B:14:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r4v10 q7.u) = (r4v15 q7.u), (r4v43 q7.u) binds: [B:38:0x013a, B:14:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r5v4 c1.v) = (r5v7 c1.v), (r5v29 c1.v) binds: [B:38:0x013a, B:14:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r6v5 c1.v) = (r6v8 c1.v), (r6v19 c1.v) binds: [B:38:0x013a, B:14:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r7v6 java.lang.Object) = (r7v21 java.lang.Object), (r7v31 java.lang.Object) binds: [B:38:0x013a, B:14:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r12v3 c1.l) = (r12v6 c1.l), (r12v23 c1.l) binds: [B:38:0x013a, B:14:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r13v0 q7.u) = (r13v2 q7.u), (r13v13 q7.u) binds: [B:38:0x013a, B:14:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r14v0 gb.a) = (r14v1 gb.a), (r14v6 gb.a) binds: [B:38:0x013a, B:14:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ae  */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v16, types: [p7.n] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x029d -> B:13:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x031d -> B:129:0x0320). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00f1 -> B:110:0x02ab). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 981
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.r.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
