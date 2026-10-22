package u;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public Object f13563f;

    /* renamed from: g, reason: collision with root package name */
    public Serializable f13564g;

    /* renamed from: h, reason: collision with root package name */
    public o1.h0 f13565h;
    public yb.t i;

    /* renamed from: j, reason: collision with root package name */
    public b8.r f13566j;

    /* renamed from: k, reason: collision with root package name */
    public o1.s f13567k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f13568l;

    /* renamed from: m, reason: collision with root package name */
    public float f13569m;

    /* renamed from: n, reason: collision with root package name */
    public int f13570n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f13571o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ v f13572p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ f0 f13573q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ w f13574r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ h0.k f13575s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ v f13576t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ b0.n f13577u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(v vVar, f0 f0Var, w wVar, h0.k kVar, v vVar2, b0.n nVar, nb.c cVar) {
        super(cVar);
        this.f13572p = vVar;
        this.f13573q = f0Var;
        this.f13574r = wVar;
        this.f13575s = kVar;
        this.f13576t = vVar2;
        this.f13577u = nVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        s sVar = new s(this.f13572p, this.f13573q, this.f13574r, this.f13575s, this.f13576t, this.f13577u, cVar);
        sVar.f13571o = obj;
        return sVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((s) create((o1.h0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0308, code lost:
    
        if (r5 == r1) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0383, code lost:
    
        if ((r11 != null ? r11 == u.f0.f13453c ? c1.b.f(r8) : c1.b.e(r8) : c1.b.d(r8)) == 0.0f) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d3, code lost:
    
        if (r6 == r1) goto L125;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:49:0x016e, B:51:0x0178], limit reached: 171 */
    /* JADX WARN: Path cross not found for [B:54:0x017f, B:49:0x016e], limit reached: 171 */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0168 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013d A[PHI: r2 r3 r4 r5 r6 r7 r12 r13 r14
      0x013d: PHI (r2v15 float) = (r2v16 float), (r2v33 float) binds: [B:38:0x0139, B:14:0x0060] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r3v3 u.f0) = (r3v50 u.f0), (r3v0 u.f0) binds: [B:38:0x0139, B:14:0x0060] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r4v7 yb.t) = (r4v12 yb.t), (r4v37 yb.t) binds: [B:38:0x0139, B:14:0x0060] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r5v4 o1.h0) = (r5v7 o1.h0), (r5v29 o1.h0) binds: [B:38:0x0139, B:14:0x0060] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r6v5 o1.h0) = (r6v8 o1.h0), (r6v21 o1.h0) binds: [B:38:0x0139, B:14:0x0060] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r7v1 java.lang.Object) = (r7v13 java.lang.Object), (r7v23 java.lang.Object) binds: [B:38:0x0139, B:14:0x0060] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r12v4 o1.s) = (r12v7 o1.s), (r12v24 o1.s) binds: [B:38:0x0139, B:14:0x0060] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r13v0 yb.t) = (r13v2 yb.t), (r13v13 yb.t) binds: [B:38:0x0139, B:14:0x0060] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r14v0 b8.r) = (r14v1 b8.r), (r14v6 b8.r) binds: [B:38:0x0139, B:14:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ad  */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v17, types: [xb.p] */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x0299 -> B:13:0x005d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:124:0x0308 -> B:126:0x030b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00f0 -> B:110:0x02a7). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 963
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.s.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
