package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public int f13447f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f13448g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ nb.g f13449h;
    public final /* synthetic */ pb.h i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e0(nb.g gVar, xb.p pVar, nb.c cVar) {
        super(cVar);
        this.f13449h = gVar;
        this.i = (pb.h) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [pb.h, xb.p] */
    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        e0 e0Var = new e0(this.f13449h, this.i, cVar);
        e0Var.f13448g = obj;
        return e0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((e0) create((o1.h0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        if (r9 != r0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006b, code lost:
    
        if (r9 == r0) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, o1.h0] */
    /* JADX WARN: Type inference failed for: r1v7, types: [pb.h, xb.p] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0056 -> B:12:0x0027). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x006b -> B:12:0x0027). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            ob.a r0 = ob.a.f9351c
            int r1 = r8.f13447f
            nb.g r2 = r8.f13449h
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L33
            if (r1 == r5) goto L2b
            if (r1 == r4) goto L20
            if (r1 != r3) goto L19
            java.lang.Object r1 = r8.f13448g
            o1.h0 r1 = (o1.h0) r1
            id.c.I(r9)
            goto L27
        L19:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r8)
            r8 = 0
            return r8
        L20:
            java.lang.Object r1 = r8.f13448g
            o1.h0 r1 = (o1.h0) r1
            id.c.I(r9)     // Catch: java.util.concurrent.CancellationException -> L29
        L27:
            r9 = r1
            goto L3a
        L29:
            r9 = move-exception
            goto L5d
        L2b:
            java.lang.Object r1 = r8.f13448g
            o1.h0 r1 = (o1.h0) r1
            id.c.I(r9)     // Catch: java.util.concurrent.CancellationException -> L29
            goto L4e
        L33:
            id.c.I(r9)
            java.lang.Object r9 = r8.f13448g
            o1.h0 r9 = (o1.h0) r9
        L3a:
            boolean r1 = kc.w.s(r2)
            if (r1 == 0) goto L6f
            pb.h r1 = r8.i     // Catch: java.util.concurrent.CancellationException -> L59
            r8.f13448g = r9     // Catch: java.util.concurrent.CancellationException -> L59
            r8.f13447f = r5     // Catch: java.util.concurrent.CancellationException -> L59
            java.lang.Object r1 = r1.invoke(r9, r8)     // Catch: java.util.concurrent.CancellationException -> L59
            if (r1 != r0) goto L4d
            goto L6d
        L4d:
            r1 = r9
        L4e:
            r8.f13448g = r1     // Catch: java.util.concurrent.CancellationException -> L29
            r8.f13447f = r4     // Catch: java.util.concurrent.CancellationException -> L29
            java.lang.Object r9 = t.m0.f(r1, r8)     // Catch: java.util.concurrent.CancellationException -> L29
            if (r9 != r0) goto L27
            goto L6d
        L59:
            r1 = move-exception
            r7 = r1
            r1 = r9
            r9 = r7
        L5d:
            boolean r6 = kc.w.s(r2)
            if (r6 == 0) goto L6e
            r8.f13448g = r1
            r8.f13447f = r3
            java.lang.Object r9 = t.m0.f(r1, r8)
            if (r9 != r0) goto L27
        L6d:
            return r0
        L6e:
            throw r9
        L6f:
            jb.v r8 = jb.v.f6774a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: u.e0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
