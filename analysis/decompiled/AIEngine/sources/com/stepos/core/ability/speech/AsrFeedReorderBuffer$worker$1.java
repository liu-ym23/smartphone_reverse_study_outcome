package com.stepos.core.ability.speech;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrFeedReorderBuffer$worker$1", f = "AsrFeedReorderBuffer.kt", l = {137}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrFeedReorderBuffer$worker$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AsrFeedReorderBuffer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrFeedReorderBuffer$worker$1(AsrFeedReorderBuffer asrFeedReorderBuffer, qb.b<? super AsrFeedReorderBuffer$worker$1> bVar) {
        super(2, bVar);
        this.this$0 = asrFeedReorderBuffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        AsrFeedReorderBuffer$worker$1 asrFeedReorderBuffer$worker$1 = new AsrFeedReorderBuffer$worker$1(this.this$0, bVar);
        asrFeedReorderBuffer$worker$1.L$0 = obj;
        return asrFeedReorderBuffer$worker$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0039 -> B:12:0x003c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L1d
            if (r1 != r2) goto L15
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r8.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.c.b(r9)
            goto L3c
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1d:
            kotlin.c.b(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            com.stepos.core.ability.speech.AsrFeedReorderBuffer r1 = r8.this$0
            kotlinx.coroutines.channels.Channel r1 = com.stepos.core.ability.speech.AsrFeedReorderBuffer.access$getWake$p(r1)
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r3 = r9
        L2f:
            r8.L$0 = r3
            r8.L$1 = r1
            r8.label = r2
            java.lang.Object r9 = r1.hasNext(r8)
            if (r9 != r0) goto L3c
            return r0
        L3c:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L76
            r1.next()
            com.stepos.core.ability.speech.AsrFeedReorderBuffer r9 = r8.this$0
            com.stepos.core.ability.speech.AsrFeedReorderBuffer.access$evaluate(r9)     // Catch: java.lang.Throwable -> L4f
            lb.n r9 = lb.n.f10413a     // Catch: java.lang.Throwable -> L4f
            goto L54
        L4f:
            r9 = move-exception
            kotlin.Result$Failure r9 = kotlin.c.a(r9)
        L54:
            com.stepos.core.ability.speech.AsrFeedReorderBuffer r4 = r8.this$0
            java.lang.Throwable r9 = kotlin.Result.b(r9)
            if (r9 == 0) goto L2f
            com.stepos.core.common.log.LogModule r5 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r4 = com.stepos.core.ability.speech.AsrFeedReorderBuffer.access$getInferId$p(r4)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "reorder deliver round failed, inferId="
            r6.<init>(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = "AsrFeedReorder"
            com.stepos.core.common.log.AIEngineLogger.e(r5, r6, r4, r9)
            goto L2f
        L76:
            lb.n r8 = lb.n.f10413a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFeedReorderBuffer$worker$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((AsrFeedReorderBuffer$worker$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
