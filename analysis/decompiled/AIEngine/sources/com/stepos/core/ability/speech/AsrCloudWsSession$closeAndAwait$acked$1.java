package com.stepos.core.ability.speech;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrCloudWsSession$closeAndAwait$acked$1", f = "AsrCloudWsSession.kt", l = {962}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrCloudWsSession$closeAndAwait$acked$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    int label;
    final /* synthetic */ AsrCloudWsSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrCloudWsSession$closeAndAwait$acked$1(AsrCloudWsSession asrCloudWsSession, qb.b<? super AsrCloudWsSession$closeAndAwait$acked$1> bVar) {
        super(2, bVar);
        this.this$0 = asrCloudWsSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new AsrCloudWsSession$closeAndAwait$acked$1(this.this$0, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            CompletableDeferred completableDeferred = this.this$0.closeAck;
            this.label = 1;
            if (completableDeferred.await(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return lb.n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((AsrCloudWsSession$closeAndAwait$acked$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
