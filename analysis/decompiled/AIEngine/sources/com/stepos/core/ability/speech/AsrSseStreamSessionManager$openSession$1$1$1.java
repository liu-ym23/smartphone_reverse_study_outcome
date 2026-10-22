package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.VadPipeline;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ProducerScope;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrSseStreamSessionManager$openSession$1$1$1", f = "AsrSseStreamSessionManager.kt", l = {346}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrSseStreamSessionManager$openSession$1$1$1 extends SuspendLambda implements zb.p<VadPipeline.Event, qb.b<? super lb.n>, Object> {
    final /* synthetic */ ProducerScope<Result<d.q>> $$this$channelFlow;
    final /* synthetic */ Ref$ObjectRef<String> $endReason;
    final /* synthetic */ Ref$BooleanRef $ended;
    final /* synthetic */ String $inferId;
    final /* synthetic */ VadPipeline $p;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AsrSseStreamSessionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AsrSseStreamSessionManager$openSession$1$1$1(AsrSseStreamSessionManager asrSseStreamSessionManager, String str, VadPipeline vadPipeline, ProducerScope<? super Result<d.q>> producerScope, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef<String> ref$ObjectRef, qb.b<? super AsrSseStreamSessionManager$openSession$1$1$1> bVar) {
        super(2, bVar);
        this.this$0 = asrSseStreamSessionManager;
        this.$inferId = str;
        this.$p = vadPipeline;
        this.$$this$channelFlow = producerScope;
        this.$ended = ref$BooleanRef;
        this.$endReason = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        AsrSseStreamSessionManager$openSession$1$1$1 asrSseStreamSessionManager$openSession$1$1$1 = new AsrSseStreamSessionManager$openSession$1$1$1(this.this$0, this.$inferId, this.$p, this.$$this$channelFlow, this.$ended, this.$endReason, bVar);
        asrSseStreamSessionManager$openSession$1$1$1.L$0 = obj;
        return asrSseStreamSessionManager$openSession$1$1$1;
    }

    @Override // zb.p
    public final Object invoke(VadPipeline.Event event, qb.b<? super lb.n> bVar) {
        return ((AsrSseStreamSessionManager$openSession$1$1$1) create(event, bVar)).invokeSuspend(lb.n.f10413a);
    }

    /* JADX WARN: Type inference failed for: r11v4, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            VadPipeline.Event event = (VadPipeline.Event) this.L$0;
            if (event instanceof VadPipeline.Event.SpeechStart) {
                LogModule logModule = LogModule.ABILITY;
                String str = this.this$0.tag;
                String str2 = this.$inferId;
                VadPipeline.Event.SpeechStart speechStart = (VadPipeline.Event.SpeechStart) event;
                long elapsedMs = speechStart.getElapsedMs();
                String strStats = this.$p.stats();
                StringBuilder sbL = com.stepos.core.ota.d.l("[ASR-SSE-STREAM] speech_start inferId=", elapsedMs, str2, " at ");
                sbL.append("ms ");
                sbL.append(strStats);
                AIEngineLogger.i(logModule, str, sbL.toString());
                ProducerScope<Result<d.q>> producerScope = this.$$this$channelFlow;
                Result<d.q> result = new Result<>(this.this$0.speechStartEvent(speechStart.getElapsedMs()));
                this.label = 1;
                if (producerScope.send(result, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (!(event instanceof VadPipeline.Event.SpeechEnd)) {
                    throw new NoWhenBranchMatchedException();
                }
                LogModule logModule2 = LogModule.ABILITY;
                String str3 = this.this$0.tag;
                String str4 = this.$inferId;
                VadPipeline.Event.SpeechEnd speechEnd = (VadPipeline.Event.SpeechEnd) event;
                long elapsedMs2 = speechEnd.getElapsedMs();
                String reason = speechEnd.getReason();
                StringBuilder sbL2 = com.stepos.core.ota.d.l("[ASR-SSE-STREAM] speech_end inferId=", elapsedMs2, str4, " at ");
                sbL2.append("ms reason=");
                sbL2.append(reason);
                AIEngineLogger.i(logModule2, str3, sbL2.toString());
                this.$ended.f10073a = true;
                this.$endReason.f10076a = speechEnd.getReason();
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return lb.n.f10413a;
    }
}
