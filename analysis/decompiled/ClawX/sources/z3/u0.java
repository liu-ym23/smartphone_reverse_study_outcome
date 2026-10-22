package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u0 extends h5.i implements p5.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6512a;

    /* renamed from: b, reason: collision with root package name */
    public int f6513b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ v4.f f6514c;
    public final /* synthetic */ p5.q d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u0(p5.q qVar, f5.c cVar, int i8) {
        super(3, cVar);
        this.f6512a = i8;
        this.d = qVar;
    }

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        v4.f fVar = (v4.f) obj;
        switch (this.f6512a) {
            case 0:
                u0 u0Var = new u0(this.d, (f5.c) obj3, 0);
                u0Var.f6514c = fVar;
                return u0Var.invokeSuspend(b5.a0.f883a);
            case 1:
                u0 u0Var2 = new u0(this.d, (f5.c) obj3, 1);
                u0Var2.f6514c = fVar;
                return u0Var2.invokeSuspend(b5.a0.f883a);
            default:
                u0 u0Var3 = new u0(this.d, (f5.c) obj3, 2);
                u0Var3.f6514c = fVar;
                return u0Var3.invokeSuspend(b5.a0.f883a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c8  */
    /* JADX WARN: Type inference failed for: r14v0, types: [f5.c, java.lang.Object, z3.u0] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object, z3.u0] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.Object, z3.u0] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [p5.q] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [v4.f] */
    /* JADX WARN: Type inference failed for: r5v10, types: [v4.f] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [v4.f] */
    /* JADX WARN: Type inference failed for: r5v4, types: [v4.f] */
    /* JADX WARN: Type inference failed for: r5v5, types: [v4.f] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object, z3.w] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [v4.f] */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.u0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
