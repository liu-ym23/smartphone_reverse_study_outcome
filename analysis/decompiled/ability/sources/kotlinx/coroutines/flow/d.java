package kotlinx.coroutines.flow;

import C7.r;
import S7.n;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import m9.AbstractC1683A;
import m9.AbstractC1729v;
import m9.b0;
import o9.C1778d;
import o9.InterfaceC1779e;
import p9.l;
import p9.m;
import p9.q;
import p9.s;
import p9.t;
import s9.C1923c;

/* loaded from: classes4.dex */
public abstract class d {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(p9.v r4, S7.o r5, java.lang.Throwable r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Throwable r6 = r0.f5205a
            kotlin.b.b(r7)     // Catch: java.lang.Throwable -> L29
            goto L41
        L29:
            r4 = move-exception
            goto L44
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r7)
            r0.f5205a = r6     // Catch: java.lang.Throwable -> L29
            r0.c = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L41
            return r1
        L41:
            C7.r r4 = C7.r.f317a
            return r4
        L44:
            if (r6 == 0) goto L4b
            if (r6 == r4) goto L4b
            S0.b.e0(r4, r6)
        L4b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.d.a(p9.v, S7.o, java.lang.Throwable, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static p9.c b(p9.c cVar, int i) {
        BufferOverflow bufferOverflow = BufferOverflow.f5184a;
        if (i < 0 && i != -2 && i != -1) {
            throw new IllegalArgumentException(B7.a.h(i, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ").toString());
        }
        if (i == -1) {
            bufferOverflow = BufferOverflow.b;
            i = 0;
        }
        int i6 = i;
        BufferOverflow bufferOverflow2 = bufferOverflow;
        return cVar instanceof q9.g ? q9.b.a((q9.g) cVar, null, i6, bufferOverflow2, 1) : new q9.d(cVar, null, i6, bufferOverflow2, 2);
    }

    public static final b c(n nVar) {
        return new b(nVar, EmptyCoroutineContext.f4908a, -2, BufferOverflow.f5184a);
    }

    public static final Object d(p9.c cVar, n nVar, H7.c cVar2) {
        int i = p9.h.f5560a;
        Object objCollect = b(new kotlinx.coroutines.flow.internal.d(new FlowKt__MergeKt$mapLatest$1(nVar, null), cVar, EmptyCoroutineContext.f4908a, -2, BufferOverflow.f5184a), 0).collect(q9.i.f5626a, cVar2);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        r rVar = r.f317a;
        if (objCollect != coroutineSingletons) {
            objCollect = rVar;
        }
        return objCollect == coroutineSingletons ? objCollect : rVar;
    }

    public static final p9.c e(p9.c cVar, long j5) {
        long jN = kotlinx.coroutines.a.n(j5);
        if (jN >= 0) {
            return jN == 0 ? cVar : new kotlinx.coroutines.flow.internal.h(new FlowKt__DelayKt$debounceInternal$1(new R3.f(jN, 6), cVar, null));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    public static final p9.c f(p9.c cVar) {
        if (cVar instanceof t) {
            return cVar;
        }
        com.stepos.core.a aVar = p9.e.f5557a;
        if (cVar instanceof p9.b) {
            p9.b bVar = (p9.b) cVar;
            bVar.getClass();
            if (bVar.b == aVar) {
                return (p9.b) cVar;
            }
        }
        return new p9.b(cVar, aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        if (r2.emit(r10, r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x002f, B:25:0x0056, B:29:0x006b, B:31:0x0073, B:20:0x0047, B:24:0x0052), top: B:52:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0085 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(p9.d r7, o9.n r8, boolean r9, H7.c r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L3f
            if (r2 != r4) goto L37
            boolean r9 = r0.d
            o9.b r7 = r0.c
            o9.n r8 = r0.b
            p9.d r2 = r0.f5198a
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L35
        L32:
            r10 = r7
            r7 = r2
            goto L56
        L35:
            r7 = move-exception
            goto L90
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            boolean r9 = r0.d
            o9.b r7 = r0.c
            o9.n r8 = r0.b
            p9.d r2 = r0.f5198a
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L35
            goto L6b
        L4b:
            kotlin.b.b(r10)
            boolean r10 = r7 instanceof p9.v
            if (r10 != 0) goto Lab
            o9.b r10 = r8.iterator()     // Catch: java.lang.Throwable -> L35
        L56:
            r0.f5198a = r7     // Catch: java.lang.Throwable -> L35
            r0.b = r8     // Catch: java.lang.Throwable -> L35
            r0.c = r10     // Catch: java.lang.Throwable -> L35
            r0.d = r9     // Catch: java.lang.Throwable -> L35
            r0.f = r5     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r10.b(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L67
            goto L87
        L67:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L6b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L88
            java.lang.Object r10 = r7.d()     // Catch: java.lang.Throwable -> L35
            r0.f5198a = r2     // Catch: java.lang.Throwable -> L35
            r0.b = r8     // Catch: java.lang.Throwable -> L35
            r0.c = r7     // Catch: java.lang.Throwable -> L35
            r0.d = r9     // Catch: java.lang.Throwable -> L35
            r0.f = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r1) goto L32
        L87:
            return r1
        L88:
            if (r9 == 0) goto L8d
            r8.cancel(r3)
        L8d:
            C7.r r7 = C7.r.f317a
            return r7
        L90:
            throw r7     // Catch: java.lang.Throwable -> L91
        L91:
            r10 = move-exception
            if (r9 == 0) goto Laa
            boolean r9 = r7 instanceof java.util.concurrent.CancellationException
            if (r9 == 0) goto L9b
            r3 = r7
            java.util.concurrent.CancellationException r3 = (java.util.concurrent.CancellationException) r3
        L9b:
            if (r3 != 0) goto La7
            java.util.concurrent.CancellationException r3 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "Channel was consumed, consumer had failed"
            r3.<init>(r9)
            r3.initCause(r7)
        La7:
            r8.cancel(r3)
        Laa:
            throw r10
        Lab:
            p9.v r7 = (p9.v) r7
            java.lang.Throwable r7 = r7.f5569a
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.d.g(p9.d, o9.n, boolean, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(p9.c r6, H7.c r7) {
        /*
            a5.d r0 = q9.b.b
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            if (r1 == 0) goto L15
            r1 = r7
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) r1
            int r2 = r1.d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.d = r2
            goto L1a
        L15:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            r1.<init>(r7)
        L1a:
            java.lang.Object r7 = r1.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.d
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            G4.i r6 = r1.b
            kotlin.jvm.internal.Ref$ObjectRef r1 = r1.f5212a
            kotlin.b.b(r7)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2d
            goto L5e
        L2d:
            r7 = move-exception
            goto L5a
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.b.b(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.f4920a = r0
            G4.i r3 = new G4.i
            r5 = 1
            r3.<init>(r7, r5)
            r1.f5212a = r7     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            r1.b = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            r1.d = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            java.lang.Object r6 = r6.collect(r3, r1)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            if (r6 != r2) goto L54
            return r2
        L54:
            r1 = r7
            goto L5e
        L56:
            r6 = move-exception
            r1 = r7
            r7 = r6
            r6 = r3
        L5a:
            java.lang.Object r2 = r7.f5229a
            if (r2 != r6) goto L6b
        L5e:
            java.lang.Object r6 = r1.f4920a
            if (r6 == r0) goto L63
            return r6
        L63:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.String r7 = "Expected at least one element"
            r6.<init>(r7)
            throw r6
        L6b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.d.h(p9.c, H7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(p9.c r6, S7.n r7, H7.c r8) {
        /*
            a5.d r0 = q9.b.b
            boolean r1 = r8 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            if (r1 == 0) goto L15
            r1 = r8
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3) r1
            int r2 = r1.e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.e = r2
            goto L1a
        L15:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            r1.<init>(r8)
        L1a:
            java.lang.Object r8 = r1.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.e
            r4 = 1
            if (r3 == 0) goto L3b
            if (r3 != r4) goto L33
            com.stepos.policy.sdk.d r6 = r1.c
            kotlin.jvm.internal.Ref$ObjectRef r7 = r1.b
            kotlin.coroutines.jvm.internal.SuspendLambda r1 = r1.f5213a
            S7.n r1 = (S7.n) r1
            kotlin.b.b(r8)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L31
            goto L69
        L31:
            r8 = move-exception
            goto L65
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.b.b(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            r8.f4920a = r0
            com.stepos.policy.sdk.d r3 = new com.stepos.policy.sdk.d
            r5 = 3
            r3.<init>(r5, r7, r8)
            r5 = r7
            kotlin.coroutines.jvm.internal.SuspendLambda r5 = (kotlin.coroutines.jvm.internal.SuspendLambda) r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L60
            r1.f5213a = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L60
            r1.b = r8     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L60
            r1.c = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L60
            r1.e = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L60
            java.lang.Object r6 = r6.collect(r3, r1)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L60
            if (r6 != r2) goto L5d
            return r2
        L5d:
            r1 = r7
            r7 = r8
            goto L69
        L60:
            r6 = move-exception
            r1 = r7
            r7 = r8
            r8 = r6
            r6 = r3
        L65:
            java.lang.Object r2 = r8.f5229a
            if (r2 != r6) goto L82
        L69:
            java.lang.Object r6 = r7.f4920a
            if (r6 == r0) goto L6e
            return r6
        L6e:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Expected at least one element matching the predicate "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L82:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.d.i(p9.c, S7.n, H7.c):java.lang.Object");
    }

    public static final p9.c j(p9.c cVar, AbstractC1729v abstractC1729v) {
        if (abstractC1729v.get(b0.f5325a) == null) {
            return abstractC1729v.equals(EmptyCoroutineContext.f4908a) ? cVar : cVar instanceof q9.g ? q9.b.a((q9.g) cVar, abstractC1729v, 0, null, 6) : new q9.d(cVar, abstractC1729v, 0, null, 12);
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + abstractC1729v).toString());
    }

    public static final l k(m mVar, C1923c c1923c, s sVar, Float f) {
        InterfaceC1779e.f5455J.getClass();
        C1778d c1778d = C1778d.f5454a;
        BufferOverflow bufferOverflow = BufferOverflow.f5184a;
        O2.a aVar = new O2.a(8, mVar, EmptyCoroutineContext.f4908a);
        i iVarC = p9.e.c(f);
        AbstractC1683A.m(c1923c, (H7.h) aVar.c, sVar.equals(q.f5566a) ? CoroutineStart.f5175a : CoroutineStart.d, new FlowKt__ShareKt$launchSharing$1(sVar, (p9.c) aVar.b, iVarC, f, null));
        return new l(iVarC);
    }
}
