package com.stepos.core.model.concurrency;

import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import lb.n;
import rb.c;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.model.concurrency.ThreadPoolManagerImpl$submitFlow$2$work$1", f = "ThreadPoolManagerImpl.kt", l = {215, 215}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ThreadPoolManagerImpl$submitFlow$2$work$1 extends SuspendLambda implements l<qb.b<? super n>, Object> {
    final /* synthetic */ l<qb.b<? super Flow<? extends Result<? extends Object>>>, Object> $block;
    final /* synthetic */ ProducerScope<Result<? extends Object>> $out;
    final /* synthetic */ String $taskId;
    int label;
    final /* synthetic */ ThreadPoolManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ThreadPoolManagerImpl$submitFlow$2$work$1(l<? super qb.b<? super Flow<? extends Result<? extends Object>>>, ? extends Object> lVar, ThreadPoolManagerImpl threadPoolManagerImpl, String str, ProducerScope<? super Result<? extends Object>> producerScope, qb.b<? super ThreadPoolManagerImpl$submitFlow$2$work$1> bVar) {
        super(1, bVar);
        this.$block = lVar;
        this.this$0 = threadPoolManagerImpl;
        this.$taskId = str;
        this.$out = producerScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(qb.b<?> bVar) {
        return new ThreadPoolManagerImpl$submitFlow$2$work$1(this.$block, this.this$0, this.$taskId, this.$out, bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r8).collect(r2, r7) == r1) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.String r0 = "flow task failed: "
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r7.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L26
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            kotlin.c.b(r8)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            goto L46
        L13:
            r8 = move-exception
            goto L8c
        L16:
            r8 = move-exception
            goto L4c
        L18:
            r8 = move-exception
            goto L71
        L1a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L22:
            kotlin.c.b(r8)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            goto L34
        L26:
            kotlin.c.b(r8)
            zb.l<qb.b<? super kotlinx.coroutines.flow.Flow<? extends kotlin.Result<? extends java.lang.Object>>>, java.lang.Object> r8 = r7.$block     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            r7.label = r4     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            java.lang.Object r8 = r8.invoke(r7)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            if (r8 != r1) goto L34
            goto L45
        L34:
            kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            com.stepos.core.model.concurrency.ThreadPoolManagerImpl$submitFlow$2$work$1$1 r2 = new com.stepos.core.model.concurrency.ThreadPoolManagerImpl$submitFlow$2$work$1$1     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            kotlinx.coroutines.channels.ProducerScope<kotlin.Result<? extends java.lang.Object>> r6 = r7.$out     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            r2.<init>()     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            r7.label = r3     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            java.lang.Object r8 = r8.collect(r2, r7)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16 java.util.concurrent.CancellationException -> L18
            if (r8 != r1) goto L46
        L45:
            return r1
        L46:
            kotlinx.coroutines.channels.ProducerScope<kotlin.Result<? extends java.lang.Object>> r7 = r7.$out
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r7, r5, r4, r5)
            goto L6e
        L4c:
            java.lang.String r1 = "ThreadPoolManager"
            java.lang.String r2 = r7.$taskId     // Catch: java.lang.Throwable -> L13
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L13
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L13
            r3.append(r2)     // Catch: java.lang.Throwable -> L13
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L13
            android.util.Log.e(r1, r0, r8)     // Catch: java.lang.Throwable -> L13
            kotlinx.coroutines.channels.ProducerScope<kotlin.Result<? extends java.lang.Object>> r0 = r7.$out     // Catch: java.lang.Throwable -> L13
            kotlin.Result$Failure r8 = kotlin.c.a(r8)     // Catch: java.lang.Throwable -> L13
            kotlin.Result r1 = new kotlin.Result     // Catch: java.lang.Throwable -> L13
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L13
            r0.mo149trySendJP2dKIU(r1)     // Catch: java.lang.Throwable -> L13
            goto L46
        L6e:
            lb.n r7 = lb.n.f10413a
            return r7
        L71:
            com.stepos.core.model.concurrency.ThreadPoolManagerImpl r0 = r7.this$0     // Catch: java.lang.Throwable -> L13
            com.stepos.core.model.concurrency.PressureCancelledException r0 = com.stepos.core.model.concurrency.ThreadPoolManagerImpl.access$findPressureCancelled(r0, r8)     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L8b
            kotlinx.coroutines.channels.ProducerScope<kotlin.Result<? extends java.lang.Object>> r1 = r7.$out     // Catch: java.lang.Throwable -> L13
            kotlin.Result$Failure r0 = kotlin.c.a(r0)     // Catch: java.lang.Throwable -> L13
            kotlin.Result r2 = new kotlin.Result     // Catch: java.lang.Throwable -> L13
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L13
            java.lang.Object r0 = r1.mo149trySendJP2dKIU(r2)     // Catch: java.lang.Throwable -> L13
            kotlinx.coroutines.channels.ChannelResult.m152boximpl(r0)     // Catch: java.lang.Throwable -> L13
        L8b:
            throw r8     // Catch: java.lang.Throwable -> L13
        L8c:
            kotlinx.coroutines.channels.ProducerScope<kotlin.Result<? extends java.lang.Object>> r7 = r7.$out
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r7, r5, r4, r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.concurrency.ThreadPoolManagerImpl$submitFlow$2$work$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // zb.l
    public final Object invoke(qb.b<? super n> bVar) {
        return ((ThreadPoolManagerImpl$submitFlow$2$work$1) create(bVar)).invokeSuspend(n.f10413a);
    }
}
