package io.ktor.utils.io;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g0 extends h5.i implements p5.p {

    /* renamed from: a, reason: collision with root package name */
    public Object f3193a;

    /* renamed from: b, reason: collision with root package name */
    public int f3194b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3195c;
    public final /* synthetic */ h5.i d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ m f3196e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g0(p5.p pVar, m mVar, f5.c cVar) {
        super(2, cVar);
        this.d = (h5.i) pVar;
        this.f3196e = mVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [h5.i, p5.p] */
    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        g0 g0Var = new g0(this.d, this.f3196e, cVar);
        g0Var.f3195c = obj;
        return g0Var;
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        return ((g0) create((a6.f0) obj, (f5.c) obj2)).invokeSuspend(b5.a0.f883a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c5, code lost:
    
        if (r3.h(r8) != r0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f9, code lost:
    
        if (r3.h(r8) != r0) goto L63;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[Catch: all -> 0x00a9, TRY_LEAVE, TryCatch #2 {all -> 0x00a9, blocks: (B:26:0x008b, B:28:0x0099), top: B:66:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc A[Catch: all -> 0x00c8, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00c8, blocks: (B:12:0x002c, B:44:0x00f0, B:35:0x00bc), top: B:64:0x0007 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r9v13, types: [h5.i, p5.p] */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.g0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
