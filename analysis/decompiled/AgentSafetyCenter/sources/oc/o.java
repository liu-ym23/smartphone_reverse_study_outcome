package oc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public mc.i f9390c;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f9391f;

    /* renamed from: g, reason: collision with root package name */
    public int f9392g;

    /* renamed from: h, reason: collision with root package name */
    public int f9393h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f9394j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ nc.g[] f9395k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ xb.a f9396l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ pb.i f9397m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ nc.h f9398n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public o(nc.g[] gVarArr, xb.a aVar, xb.q qVar, nc.h hVar, nb.c cVar) {
        super(2, cVar);
        this.f9395k = gVarArr;
        this.f9396l = aVar;
        this.f9397m = (pb.i) qVar;
        this.f9398n = hVar;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pb.i, xb.q] */
    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        o oVar = new o(this.f9395k, this.f9396l, this.f9397m, this.f9398n, cVar);
        oVar.f9394j = obj;
        return oVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((o) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00db, code lost:
    
        if (r9 != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
    
        r13 = (java.lang.Object[]) r19.f9396l.invoke();
        r14 = r19.f9398n;
        r15 = r19.f9397m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e9, code lost:
    
        if (r13 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00eb, code lost:
    
        r19.f9394j = r10;
        r19.f9390c = r11;
        r19.f9391f = r3;
        r19.f9392g = r9;
        r19.f9393h = r12;
        r19.i = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fb, code lost:
    
        if (r15.invoke(r14, r10, r19) != r2) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fe, code lost:
    
        kb.k.k0(r10, r13, 0, 0, 14);
        r19.f9394j = r10;
        r19.f9390c = r11;
        r19.f9391f = r3;
        r19.f9392g = r9;
        r19.f9393h = r12;
        r19.i = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0113, code lost:
    
        if (r15.invoke(r14, r13, r19) != r2) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0098, code lost:
    
        if (r9 != 0) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:41:0x00db, B:35:0x00ca], limit reached: 50 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[LOOP:0: B:30:0x00ba->B:53:?, LOOP_START, PHI: r9 r13
      0x00ba: PHI (r9v3 int) = (r9v2 int), (r9v4 int) binds: [B:27:0x00b5, B:53:?] A[DONT_GENERATE, DONT_INLINE]
      0x00ba: PHI (r13v4 kb.v) = (r13v3 kb.v), (r13v10 kb.v) binds: [B:27:0x00b5, B:53:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r15v2, types: [pb.i, xb.q] */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00fb -> B:19:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0113 -> B:50:0x0116). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oc.o.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
