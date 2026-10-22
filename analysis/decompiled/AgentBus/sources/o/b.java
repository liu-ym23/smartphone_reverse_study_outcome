package o;

/* loaded from: classes.dex */
public final class b extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public boolean f7016f;

    /* renamed from: g, reason: collision with root package name */
    public int f7017g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7018h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ p.h0 f7019i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f7020j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ q.i f7021k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ r f7022l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(p.h0 h0Var, long j2, q.i iVar, r rVar, g7.d dVar) {
        super(2, dVar);
        this.f7019i = h0Var;
        this.f7020j = j2;
        this.f7021k = iVar;
        this.f7022l = rVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        b bVar = new b(this.f7019i, this.f7020j, this.f7021k, this.f7022l, dVar);
        bVar.f7018h = obj;
        return bVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bb, code lost:
    
        if (r15.a(r2, r18) != r1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d8, code lost:
    
        if (r15.a(r3, r18) == r1) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object, java.util.concurrent.CancellationException] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v5, types: [q.k] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.b.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
