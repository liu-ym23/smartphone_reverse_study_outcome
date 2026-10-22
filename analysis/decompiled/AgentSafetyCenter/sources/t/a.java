package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public boolean f12931c;

    /* renamed from: f, reason: collision with root package name */
    public int f12932f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f12933g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ u.i0 f12934h;
    public final /* synthetic */ long i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ v.k f12935j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d f12936k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(u.i0 i0Var, long j10, v.k kVar, d dVar, nb.c cVar) {
        super(2, cVar);
        this.f12934h = i0Var;
        this.i = j10;
        this.f12935j = kVar;
        this.f12936k = dVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        a aVar = new a(this.f12934h, this.i, this.f12935j, this.f12936k, cVar);
        aVar.f12933g = obj;
        return aVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((a) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ba, code lost:
    
        if (r15.a(r2, r18) != r1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d7, code lost:
    
        if (r15.a(r3, r18) == r1) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object, java.util.concurrent.CancellationException] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v5, types: [v.m] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kc.x0] */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
