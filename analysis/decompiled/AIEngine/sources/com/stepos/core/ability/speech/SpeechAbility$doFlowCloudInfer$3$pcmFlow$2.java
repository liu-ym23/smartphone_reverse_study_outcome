package com.stepos.core.ability.speech;

import com.stepos.core.ability.telemetry.ModelCallBridge;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.SpeechAbility$doFlowCloudInfer$3$pcmFlow$2", f = "SpeechAbility.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SpeechAbility$doFlowCloudInfer$3$pcmFlow$2 extends SuspendLambda implements zb.p<byte[], qb.b<? super lb.n>, Object> {
    final /* synthetic */ AtomicBoolean $firstAudioEmitted;
    final /* synthetic */ String $inferId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeechAbility$doFlowCloudInfer$3$pcmFlow$2(AtomicBoolean atomicBoolean, String str, qb.b<? super SpeechAbility$doFlowCloudInfer$3$pcmFlow$2> bVar) {
        super(2, bVar);
        this.$firstAudioEmitted = atomicBoolean;
        this.$inferId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new SpeechAbility$doFlowCloudInfer$3$pcmFlow$2(this.$firstAudioEmitted, this.$inferId, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        if (this.$firstAudioEmitted.compareAndSet(false, true)) {
            ModelCallBridge.INSTANCE.recordFirstToken(this.$inferId);
        }
        return lb.n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(byte[] bArr, qb.b<? super lb.n> bVar) {
        return ((SpeechAbility$doFlowCloudInfer$3$pcmFlow$2) create(bArr, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
