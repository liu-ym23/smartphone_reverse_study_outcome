package kotlinx.coroutines.flow.internal;

/* loaded from: classes4.dex */
public final class f implements p9.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.channels.a f5246a;
    public final /* synthetic */ int b;

    public f(kotlinx.coroutines.channels.a aVar, int i) {
        this.f5246a = aVar;
        this.b = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        if (m9.AbstractC1683A.x(r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r6, H7.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f5239a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.b.b(r7)
            goto L54
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.b.b(r7)
            goto L4b
        L36:
            kotlin.b.b(r7)
            D7.D r7 = new D7.D
            int r2 = r5.b
            r7.<init>(r2, r6)
            r0.c = r4
            kotlinx.coroutines.channels.a r5 = r5.f5246a
            java.lang.Object r5 = r5.p(r0, r7)
            if (r5 != r1) goto L4b
            goto L53
        L4b:
            r0.c = r3
            java.lang.Object r5 = m9.AbstractC1683A.x(r0)
            if (r5 != r1) goto L54
        L53:
            return r1
        L54:
            C7.r r5 = C7.r.f317a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.f.emit(java.lang.Object, H7.c):java.lang.Object");
    }
}
