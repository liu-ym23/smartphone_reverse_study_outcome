package com.stepos.core.ability.speech;

import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.TtsSsePrebufferGateKt$prebufferOnStart$2$1$1$1", f = "TtsSsePrebufferGate.kt", l = {82, 82}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TtsSsePrebufferGateKt$prebufferOnStart$2$1$1$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ ProducerScope<byte[]> $$this$channelFlow;
    final /* synthetic */ ArrayList<byte[]> $buffer;
    final /* synthetic */ Ref$BooleanRef $flushed;
    final /* synthetic */ long $hold;
    final /* synthetic */ Mutex $mutex;
    final /* synthetic */ long $ttfb;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TtsSsePrebufferGateKt$prebufferOnStart$2$1$1$1(long j10, long j11, Mutex mutex, Ref$BooleanRef ref$BooleanRef, ArrayList<byte[]> arrayList, ProducerScope<? super byte[]> producerScope, qb.b<? super TtsSsePrebufferGateKt$prebufferOnStart$2$1$1$1> bVar) {
        super(2, bVar);
        this.$hold = j10;
        this.$ttfb = j11;
        this.$mutex = mutex;
        this.$flushed = ref$BooleanRef;
        this.$buffer = arrayList;
        this.$$this$channelFlow = producerScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new TtsSsePrebufferGateKt$prebufferOnStart$2$1$1$1(this.$hold, this.$ttfb, this.$mutex, this.$flushed, this.$buffer, this.$$this$channelFlow, bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (com.stepos.core.ability.speech.TtsSsePrebufferGateKt.AnonymousClass2.invokeSuspend$flush(r3, r4, r5, r6, "deadline", r8, r10, r13) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.c.b(r14)
            goto L42
        L10:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L18:
            kotlin.c.b(r14)
            goto L2a
        L1c:
            kotlin.c.b(r14)
            long r4 = r13.$hold
            r13.label = r3
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r4, r13)
            if (r14 != r0) goto L2a
            goto L41
        L2a:
            kotlinx.coroutines.sync.Mutex r3 = r13.$mutex
            kotlin.jvm.internal.Ref$BooleanRef r4 = r13.$flushed
            java.util.ArrayList<byte[]> r5 = r13.$buffer
            kotlinx.coroutines.channels.ProducerScope<byte[]> r6 = r13.$$this$channelFlow
            long r8 = r13.$ttfb
            long r10 = r13.$hold
            r13.label = r2
            java.lang.String r7 = "deadline"
            r12 = r13
            java.lang.Object r13 = com.stepos.core.ability.speech.TtsSsePrebufferGateKt.AnonymousClass2.access$invokeSuspend$flush(r3, r4, r5, r6, r7, r8, r10, r12)
            if (r13 != r0) goto L42
        L41:
            return r0
        L42:
            lb.n r13 = lb.n.f10413a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsSsePrebufferGateKt$prebufferOnStart$2$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((TtsSsePrebufferGateKt$prebufferOnStart$2$1$1$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
