package p9;

/* loaded from: classes4.dex */
public final class f implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1792a f5558a;
    public final /* synthetic */ S7.o b;

    public f(C1792a c1792a, S7.o oVar) {
        this.f5558a = c1792a;
        this.b = oVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p9.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(p9.d r9, H7.c r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f5204a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.b
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L53
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r8 = r0.d
            kotlinx.coroutines.flow.internal.SafeCollector r8 = (kotlinx.coroutines.flow.internal.SafeCollector) r8
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L32
            goto L7e
        L32:
            r9 = move-exception
            goto L86
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            java.lang.Object r8 = r0.d
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            kotlin.b.b(r10)
            goto L9e
        L44:
            p9.d r9 = r0.e
            java.lang.Object r8 = r0.d
            p9.f r8 = (p9.f) r8
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L4e
            goto L65
        L4e:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L8a
        L53:
            kotlin.b.b(r10)
            p9.a r10 = r8.f5558a     // Catch: java.lang.Throwable -> L4e
            r0.d = r8     // Catch: java.lang.Throwable -> L4e
            r0.e = r9     // Catch: java.lang.Throwable -> L4e
            r0.b = r5     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L4e
            if (r10 != r1) goto L65
            goto L9d
        L65:
            kotlinx.coroutines.flow.internal.SafeCollector r10 = new kotlinx.coroutines.flow.internal.SafeCollector
            H7.h r2 = r0.getContext()
            r10.<init>(r9, r2)
            S7.o r8 = r8.b     // Catch: java.lang.Throwable -> L84
            r0.d = r10     // Catch: java.lang.Throwable -> L84
            r0.e = r6     // Catch: java.lang.Throwable -> L84
            r0.b = r3     // Catch: java.lang.Throwable -> L84
            java.lang.Object r8 = r8.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L84
            if (r8 != r1) goto L7d
            goto L9d
        L7d:
            r8 = r10
        L7e:
            r8.releaseIntercepted()
            C7.r r8 = C7.r.f317a
            return r8
        L84:
            r9 = move-exception
            r8 = r10
        L86:
            r8.releaseIntercepted()
            throw r9
        L8a:
            p9.v r10 = new p9.v
            r10.<init>(r8)
            S7.o r9 = r9.b
            r0.d = r8
            r0.e = r6
            r0.b = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.d.a(r10, r9, r8, r0)
            if (r9 != r1) goto L9e
        L9d:
            return r1
        L9e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p9.f.collect(p9.d, H7.c):java.lang.Object");
    }
}
