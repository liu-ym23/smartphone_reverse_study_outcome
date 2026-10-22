package m8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8332c = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f8333f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0 f8334g;

    /* renamed from: h, reason: collision with root package name */
    public int f8335h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i, k0 k0Var, nb.c cVar) {
        super(2, cVar);
        this.f8334g = k0Var;
        this.f8335h = i;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8332c) {
            case 0:
                return new e(this.f8334g, cVar);
            default:
                return new e(this.f8335h, this.f8334g, cVar);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f8332c) {
        }
        return ((e) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f5, code lost:
    
        if (m8.k0.f(r2, r40) == r5) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01aa, code lost:
    
        if (m8.k0.l(r3, r40) != r5) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0220, code lost:
    
        if (m8.k0.l(r2, r40) != r5) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d7 A[PHI: r2
      0x00d7: PHI (r2v12 java.lang.Object) = (r2v11 java.lang.Object), (r2v20 java.lang.Object) binds: [B:35:0x00d3, B:25:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019f A[PHI: r2
      0x019f: PHI (r2v31 int) = (r2v29 int), (r2v32 int) binds: [B:51:0x019b, B:20:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0209  */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.e.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(k0 k0Var, nb.c cVar) {
        super(2, cVar);
        this.f8334g = k0Var;
    }
}
