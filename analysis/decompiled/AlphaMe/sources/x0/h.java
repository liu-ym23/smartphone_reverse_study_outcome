package x0;

import S.z;
import b3.InterfaceC0379h;

/* loaded from: classes.dex */
public final class h implements InterfaceC0379h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15879a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15880b;

    public h(InterfaceC0379h[] interfaceC0379hArr) {
        this.f15880b = interfaceC0379hArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // b3.InterfaceC0379h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(b3.InterfaceC0380i r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            int r0 = r7.f15879a
            java.lang.Object r1 = r7.f15880b
            switch(r0) {
                case 0: goto L6f;
                default: goto L7;
            }
        L7:
            boolean r0 = r9 instanceof b3.C0372a
            if (r0 == 0) goto L1a
            r0 = r9
            b3.a r0 = (b3.C0372a) r0
            int r2 = r0.f4389d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L1a
            int r2 = r2 - r3
            r0.f4389d = r2
            goto L1f
        L1a:
            b3.a r0 = new b3.a
            r0.<init>(r7, r9)
        L1f:
            java.lang.Object r7 = r0.f4387b
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f4389d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            c3.o r8 = r0.f4386a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L32
            goto L5f
        L32:
            r7 = move-exception
            goto L6b
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            c3.o r7 = new c3.o
            kotlin.coroutines.CoroutineContext r2 = r0.get$context()
            r7.<init>(r8, r2)
            r0.f4386a = r7     // Catch: java.lang.Throwable -> L69
            r0.f4389d = r3     // Catch: java.lang.Throwable -> L69
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch: java.lang.Throwable -> L69
            java.lang.Object r8 = r1.invoke(r7, r0)     // Catch: java.lang.Throwable -> L69
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch: java.lang.Throwable -> L69
            if (r8 != r0) goto L59
            goto L5b
        L59:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L69
        L5b:
            if (r8 != r9) goto L5e
            goto L64
        L5e:
            r8 = r7
        L5f:
            r8.releaseIntercepted()
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
        L64:
            return r9
        L65:
            r6 = r8
            r8 = r7
            r7 = r6
            goto L6b
        L69:
            r8 = move-exception
            goto L65
        L6b:
            r8.releaseIntercepted()
            throw r7
        L6f:
            r5 = r1
            b3.h[] r5 = (b3.InterfaceC0379h[]) r5
            S.A r2 = new S.A
            r7 = 5
            r2.<init>(r7, r5)
            x0.g r3 = new x0.g
            r7 = 3
            r0 = 0
            r3.<init>(r7, r0)
            c3.i r7 = new c3.i
            r1 = 0
            r0 = r7
            r4 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            c3.k r8 = new c3.k
            kotlin.coroutines.CoroutineContext r0 = r9.get$context()
            r8.<init>(r9, r0)
            java.lang.Object r7 = com.stepos.statsrpk.c.O(r8, r8, r7)
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r8) goto L9d
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r9)
        L9d:
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r8) goto La4
            goto La6
        La4:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        La6:
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r8) goto Lad
            goto Laf
        Lad:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        Laf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.h.collect(b3.i, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public h(z zVar) {
        this.f15880b = zVar;
    }
}
