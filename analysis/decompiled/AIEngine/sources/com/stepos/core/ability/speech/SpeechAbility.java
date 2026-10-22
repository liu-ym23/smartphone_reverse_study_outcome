package com.stepos.core.ability.speech;

import android.os.Bundle;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.base.ability.AbilityBase;
import com.stepos.base.strategy.ExecutionPreference;
import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.core.ability.telemetry.ModelCallBridge;
import com.stepos.core.common.cloud.AccountLoginState;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper;
import com.stepos.core.common.telemetry.ModelCallOutcome;
import com.stepos.core.data.ContentParams;
import com.stepos.core.error.AIEngineError;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SpeechAbility extends AbilityBase<c.g, d.b> {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String EXTRA_TTS_INSTRUCTION = "tts.instruction";

    @Deprecated
    public static final String EXTRA_TTS_SAMPLE_RATE = "tts.sample_rate";

    @Deprecated
    public static final String EXTRA_TTS_SPEED = "tts.speed";

    @Deprecated
    public static final String EXTRA_TTS_VOICE = "tts.voice";

    @Deprecated
    public static final String EXTRA_TTS_VOLUME = "tts.volume";

    @Deprecated
    public static final int NATIVE_SAMPLE_RATE = 16000;
    private final String TAG;
    private String speakerId;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.SpeechAbility$buildOrchestrator$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements zb.a<Boolean> {
        public AnonymousClass1(Object obj) {
            super(0, obj, AccountLoginState.class, "isLoggedIn", "isLoggedIn()Z", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // zb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((AccountLoginState) this.receiver).isLoggedIn());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.SpeechAbility$doFlowCloudInfer$2", f = "SpeechAbility.kt", l = {246}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.SpeechAbility$doFlowCloudInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.b>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ OrchestrationRejectedException $e;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(OrchestrationRejectedException orchestrationRejectedException, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$e = orchestrationRejectedException;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$e, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.b>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.b>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(kotlin.c.a(this.$e));
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
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

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.b>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.SpeechAbility$doFlowCloudInfer$3", f = "SpeechAbility.kt", l = {309}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.SpeechAbility$doFlowCloudInfer$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.b>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ int $callerUid;
        final /* synthetic */ TtsCloudConfig $cfg;
        final /* synthetic */ TtsCloudClient $client;
        final /* synthetic */ AtomicReference<CloudSessionCorrelationState> $correlationOut;
        final /* synthetic */ AtomicBoolean $firstAudioEmitted;
        final /* synthetic */ String $inferId;
        final /* synthetic */ String $instruction;
        final /* synthetic */ List<String> $segments;
        final /* synthetic */ float $speed;
        final /* synthetic */ String $traceId;
        final /* synthetic */ String $voice;
        final /* synthetic */ float $volume;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ SpeechAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(List<String> list, SpeechAbility speechAbility, String str, TtsCloudClient ttsCloudClient, String str2, float f8, float f9, String str3, AtomicReference<CloudSessionCorrelationState> atomicReference, String str4, AtomicBoolean atomicBoolean, TtsCloudConfig ttsCloudConfig, int i10, qb.b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$segments = list;
            this.this$0 = speechAbility;
            this.$traceId = str;
            this.$client = ttsCloudClient;
            this.$voice = str2;
            this.$speed = f8;
            this.$volume = f9;
            this.$instruction = str3;
            this.$correlationOut = atomicReference;
            this.$inferId = str4;
            this.$firstAudioEmitted = atomicBoolean;
            this.$cfg = ttsCloudConfig;
            this.$callerUid = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$0(String str, CloudSessionCorrelationState cloudSessionCorrelationState) {
            ModelCallBridge.INSTANCE.logEstablished(str, cloudSessionCorrelationState);
            return lb.n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$segments, this.this$0, this.$traceId, this.$client, this.$voice, this.$speed, this.$volume, this.$instruction, this.$correlationOut, this.$inferId, this.$firstAudioEmitted, this.$cfg, this.$callerUid, bVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.b>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.b>>) flowCollector, bVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00de  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00d7 -> B:17:0x00da). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 225
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.SpeechAbility.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.b>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass3) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.SpeechAbility$doFlowCloudInfer$4", f = "SpeechAbility.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.SpeechAbility$doFlowCloudInfer$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements zb.q<FlowCollector<? super Result<? extends d.b>>, Throwable, qb.b<? super lb.n>, Object> {
        final /* synthetic */ AtomicReference<CloudSessionCorrelationState> $correlationOut;
        final /* synthetic */ String $inferId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(String str, AtomicReference<CloudSessionCorrelationState> atomicReference, qb.b<? super AnonymousClass4> bVar) {
            super(3, bVar);
            this.$inferId = str;
            this.$correlationOut = atomicReference;
        }

        @Override // zb.q
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.b>> flowCollector, Throwable th, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.b>>) flowCollector, th, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Throwable th = (Throwable) this.L$0;
            TtsPcmDumpSink.INSTANCE.close(this.$inferId);
            if (th == null) {
                ModelCallBridge.reportTerminal$default(ModelCallBridge.INSTANCE, this.$inferId, ModelCallOutcome.SUCCESS, 0, this.$correlationOut.get(), 4, null);
            }
            return lb.n.f10413a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.b>> flowCollector, Throwable th, qb.b<? super lb.n> bVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$inferId, this.$correlationOut, bVar);
            anonymousClass4.L$0 = th;
            return anonymousClass4.invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.SpeechAbility$doFlowCloudInfer$5", f = "SpeechAbility.kt", l = {345}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.SpeechAbility$doFlowCloudInfer$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements zb.q<FlowCollector<? super Result<? extends d.b>>, Throwable, qb.b<? super lb.n>, Object> {
        final /* synthetic */ AtomicReference<CloudSessionCorrelationState> $correlationOut;
        final /* synthetic */ String $inferId;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(String str, AtomicReference<CloudSessionCorrelationState> atomicReference, qb.b<? super AnonymousClass5> bVar) {
            super(3, bVar);
            this.$inferId = str;
            this.$correlationOut = atomicReference;
        }

        @Override // zb.q
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.b>> flowCollector, Throwable th, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.b>>) flowCollector, th, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                if (th instanceof CancellationException) {
                    throw th;
                }
                TtsCloudException ttsCloudException = th instanceof TtsCloudException ? (TtsCloudException) th : null;
                int errorCode = ttsCloudException != null ? ttsCloudException.getErrorCode() : AIEngineError.CLOUD_SERVER_ERROR;
                AIEngineLogger.e(LogModule.ABILITY, SpeechAbility.this.TAG, "doFlowCloudInfer failed: " + th.getMessage(), th);
                ModelCallBridge.INSTANCE.reportTerminal(this.$inferId, ModelCallOutcome.FAILED, errorCode, this.$correlationOut.get());
                String message = th.getMessage();
                if (message == null) {
                    message = "cloud tts failed";
                }
                Result result = new Result(kotlin.c.a(new OrchestrationRejectedException(errorCode, message)));
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
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

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.b>> flowCollector, Throwable th, qb.b<? super lb.n> bVar) {
            AnonymousClass5 anonymousClass5 = SpeechAbility.this.new AnonymousClass5(this.$inferId, this.$correlationOut, bVar);
            anonymousClass5.L$0 = flowCollector;
            anonymousClass5.L$1 = th;
            return anonymousClass5.invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.SpeechAbility", f = "SpeechAbility.kt", l = {157}, m = "doFlowInfer")
    /* renamed from: com.stepos.core.ability.speech.SpeechAbility$doFlowInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03351 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C03351(qb.b<? super C03351> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpeechAbility.this.doFlowInfer((c.g) null, (Object) null, (qb.b<? super Flow<Result<d.b>>>) this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.SpeechAbility$doFlowInfer$2", f = "SpeechAbility.kt", l = {120}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.SpeechAbility$doFlowInfer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03362 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.b>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ OrchestrationRejectedException $e;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03362(OrchestrationRejectedException orchestrationRejectedException, qb.b<? super C03362> bVar) {
            super(2, bVar);
            this.$e = orchestrationRejectedException;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03362 c03362 = new C03362(this.$e, bVar);
            c03362.L$0 = obj;
            return c03362;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.b>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.b>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(kotlin.c.a(this.$e));
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
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

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.b>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C03362) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.SpeechAbility$doFlowInfer$3", f = "SpeechAbility.kt", l = {134}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.SpeechAbility$doFlowInfer$3, reason: invalid class name and case insensitive filesystem */
    public static final class C03373 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.b>>, qb.b<? super lb.n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C03373(qb.b<? super C03373> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03373 c03373 = new C03373(bVar);
            c03373.L$0 = obj;
            return c03373;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.b>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.b>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(a0.a.r("SpeechProtocol not initialized, call prepare() first"));
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
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

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.b>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C03373) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.SpeechAbility$doFlowInfer$5", f = "SpeechAbility.kt", l = {198}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.SpeechAbility$doFlowInfer$5, reason: invalid class name and case insensitive filesystem */
    public static final class C03385 extends SuspendLambda implements zb.q<FlowCollector<? super Result<? extends d.b>>, Throwable, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Ref$IntRef $chunkCount;
        final /* synthetic */ long $startTime;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ SpeechAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03385(long j10, SpeechAbility speechAbility, Ref$IntRef ref$IntRef, qb.b<? super C03385> bVar) {
            super(3, bVar);
            this.$startTime = j10;
            this.this$0 = speechAbility;
            this.$chunkCount = ref$IntRef;
        }

        @Override // zb.q
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.b>> flowCollector, Throwable th, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.b>>) flowCollector, th, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                long jCurrentTimeMillis = System.currentTimeMillis() - this.$startTime;
                if (th instanceof CancellationException) {
                    AIEngineLogger.w(LogModule.ABILITY, this.this$0.TAG, "doFlowInfer cancelled after " + jCurrentTimeMillis + "ms, chunks=" + this.$chunkCount.f10074a);
                    throw th;
                }
                AIEngineLogger.e(LogModule.ABILITY, this.this$0.TAG, a0.a.h("doFlowInfer failed after ", jCurrentTimeMillis, "ms: ", th.getMessage()), th);
                Result result = new Result(kotlin.c.a(th));
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
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

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.b>> flowCollector, Throwable th, qb.b<? super lb.n> bVar) {
            C03385 c03385 = new C03385(this.$startTime, this.this$0, this.$chunkCount, bVar);
            c03385.L$0 = flowCollector;
            c03385.L$1 = th;
            return c03385.invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.SpeechAbility$doFlowInfer$6", f = "SpeechAbility.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.SpeechAbility$doFlowInfer$6, reason: invalid class name */
    public static final class AnonymousClass6 extends SuspendLambda implements zb.q<FlowCollector<? super Result<? extends d.b>>, Throwable, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Ref$IntRef $chunkCount;
        final /* synthetic */ String $flywheelInferId;
        final /* synthetic */ long $startTime;
        int label;
        final /* synthetic */ SpeechAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(String str, long j10, SpeechAbility speechAbility, Ref$IntRef ref$IntRef, qb.b<? super AnonymousClass6> bVar) {
            super(3, bVar);
            this.$flywheelInferId = str;
            this.$startTime = j10;
            this.this$0 = speechAbility;
            this.$chunkCount = ref$IntRef;
        }

        @Override // zb.q
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.b>> flowCollector, Throwable th, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.b>>) flowCollector, th, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            String str = this.$flywheelInferId;
            if (str != null) {
                TtsPcmDumpSink.INSTANCE.close(str);
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.$startTime;
            AIEngineLogger.d(LogModule.ABILITY, this.this$0.TAG, "doFlowInfer completed: chunks=" + this.$chunkCount.f10074a + ", duration=" + jCurrentTimeMillis + "ms");
            return lb.n.f10413a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.b>> flowCollector, Throwable th, qb.b<? super lb.n> bVar) {
            return new AnonymousClass6(this.$flywheelInferId, this.$startTime, this.this$0, this.$chunkCount, bVar).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeechAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        kotlin.jvm.internal.g.f(abilityConfig, "abilityConfig");
        this.TAG = "SpeechAbility";
        this.speakerId = TtsStreamAbility.DEFAULT_SPEAKER;
    }

    private final TtsCloudConfig buildTtsCloudConfig(String str, Bundle bundle) {
        p6.a abilityConfig = getAbilityConfig();
        if (!abilityConfig.f11424j) {
            return null;
        }
        TtsCloudConfig.Companion.requireValidSampleRate(bundle);
        return new TtsCloudConfig(abilityConfig.f11423i, null, abilityConfig.f11425k.c(overridesFromExtras(bundle)), abilityConfig.f11429o, abilityConfig.d(str, ""), 2, null);
    }

    public static /* synthetic */ TtsCloudConfig buildTtsCloudConfig$default(SpeechAbility speechAbility, String str, Bundle bundle, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            bundle = null;
        }
        return speechAbility.buildTtsCloudConfig(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] floatToPcm16(float[] fArr) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(fArr.length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (float f8 : fArr) {
            byteBufferOrder.putShort((short) (dc.h.Z(f8, -1.0f, 1.0f) * AsrCloudWsSession.PCM_FULL_SCALE));
        }
        byte[] bArrArray = byteBufferOrder.array();
        kotlin.jvm.internal.g.e(bArrArray, "array(...)");
        return bArrArray;
    }

    private final p6.c overridesFromExtras(Bundle bundle) {
        if (bundle == null) {
            p6.c cVar = p6.c.f11438b;
            return p6.c.f11438b;
        }
        ContentParams.Builder builder = new ContentParams.Builder();
        String string = bundle.getString("tts.voice");
        if (string != null) {
            if (gc.q.t0(string)) {
                string = null;
            }
            if (string != null) {
                builder.putString("tts.voice", string);
            }
        }
        String string2 = bundle.getString("tts.instruction");
        if (string2 != null) {
            String str = gc.q.t0(string2) ? null : string2;
            if (str != null) {
                builder.putString("tts.instruction", str);
            }
        }
        if (bundle.containsKey("tts.speed")) {
            builder.putFloat("tts.speed", bundle.getFloat("tts.speed", 1.0f));
        }
        if (bundle.containsKey("tts.volume")) {
            builder.putFloat("tts.volume", bundle.getFloat("tts.volume", 1.0f));
        }
        if (bundle.containsKey("tts.sample_rate")) {
            builder.putInt("tts.sample_rate", bundle.getInt("tts.sample_rate", 0));
        }
        return TtsCloudConfig.Companion.requestOverrides(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] pcm16ToFloat(byte[] bArr) {
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        int length = bArr.length / 2;
        float[] fArr = new float[length];
        for (int i10 = 0; i10 < length; i10++) {
            fArr[i10] = byteBufferOrder.getShort() / 32768.0f;
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.b resampleLocalIfRequested(d.b bVar, Bundle bundle) {
        int i10 = bVar.f13431b;
        float[] data = bVar.f13430a;
        if (i10 <= 0) {
            i10 = 16000;
        }
        int i11 = i10;
        Integer numSanitizeSampleRate = null;
        if (bundle != null) {
            if (!bundle.containsKey("tts.sample_rate")) {
                bundle = null;
            }
            if (bundle != null) {
                numSanitizeSampleRate = TtsCloudConfig.Companion.sanitizeSampleRate(bundle.getInt("tts.sample_rate", 0));
            }
        }
        int iIntValue = numSanitizeSampleRate != null ? numSanitizeSampleRate.intValue() : i11;
        if (iIntValue != i11) {
            return new d.b(pcm16ToFloat(TtsPcmResampler.INSTANCE.resampleMonoS16le(floatToPcm16(data), i11, iIntValue)), iIntValue, bVar.f13432c, 24);
        }
        if (bVar.f13431b == i11) {
            return bVar;
        }
        int i12 = bVar.f13432c;
        int i13 = bVar.f13433d;
        String id2 = bVar.f13434e;
        kotlin.jvm.internal.g.f(data, "data");
        kotlin.jvm.internal.g.f(id2, "id");
        return new d.b(data, i11, i12, i13, id2);
    }

    private final String resolveVoice(c.g gVar, TtsCloudConfig ttsCloudConfig) {
        String string;
        Bundle bundle = gVar.f13418d;
        if (bundle != null && (string = bundle.getString("tts.voice")) != null) {
            if (gc.q.t0(string)) {
                string = null;
            }
            if (string != null) {
                return string;
            }
        }
        return ttsCloudConfig.voice();
    }

    private final List<String> splitText(String str, int i10) {
        if (str.length() <= i10) {
            return b1.P(str);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            sb2.append(cCharAt);
            if (((cCharAt == 12290 || cCharAt == 65292 || cCharAt == 65307 || cCharAt == '\n' || cCharAt == '.' || cCharAt == '!' || cCharAt == '?') && sb2.length() >= i10 / 2) || sb2.length() >= i10) {
                arrayList.add(sb2.toString());
                sb2.setLength(0);
            }
        }
        if (sb2.length() > 0) {
            arrayList.add(sb2.toString());
        }
        return arrayList;
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public Object acquire(qb.b<? super Boolean> bVar) {
        if (!getAbilityConfig().f11424j) {
            return super.acquire(bVar);
        }
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, "acquire: defer on-device model load (cloud-first, lazy per S4)");
        return Boolean.TRUE;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public h7.d buildOrchestrator() {
        return new TtsOrchestrator(getAbilityConfig().c(), getAbilityConfig().f11424j, new AnonymousClass1(AccountLoginState.INSTANCE));
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowCloudInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowCloudInfer((c.g) cVar, obj, (qb.b<? super Flow<Result<d.b>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.g) cVar, obj, (qb.b<? super Flow<Result<d.b>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m60doInfergIAlus((c.g) cVar, (qb.b<? super Result<d.b>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public h7.b getExecutionConstraints(v6.c input) {
        kotlin.jvm.internal.g.f(input, "input");
        String lowerCase = null;
        c.g gVar = input instanceof c.g ? (c.g) input : null;
        if (gVar == null) {
            return h7.b.f9362d;
        }
        Bundle bundle = gVar.f13418d;
        String string = bundle != null ? bundle.getString("execution_preference") : null;
        if (string != null) {
            lowerCase = string.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
        }
        return h7.b.a(h7.b.f9362d, kotlin.jvm.internal.g.b(lowerCase, "local") ? ExecutionPreference.f6387b : kotlin.jvm.internal.g.b(lowerCase, ModelCallFlywheelBizMapper.MODEL_PATH_CLOUD) ? ExecutionPreference.f6388c : ExecutionPreference.f6386a);
    }

    public final void setSpeakerId(String str) {
        this.speakerId = str;
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.b defaultOutput() {
        int i10 = 0;
        return new d.b(new float[0], i10, i10, 30);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doFlowCloudInfer(v6.c.g r37, java.lang.Object r38, qb.b<? super kotlinx.coroutines.flow.Flow<kotlin.Result<v6.d.b>>> r39) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.SpeechAbility.doFlowCloudInfer(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doFlowInfer(v6.c.g r30, java.lang.Object r31, qb.b<? super kotlinx.coroutines.flow.Flow<kotlin.Result<v6.d.b>>> r32) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.SpeechAbility.doFlowInfer(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0090, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r10).collect(r2, r0) == r1) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m60doInfergIAlus(v6.c.g r9, qb.b<? super kotlin.Result<v6.d.b>> r10) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.SpeechAbility.m60doInfergIAlus(v6.c$g, qb.b):java.lang.Object");
    }
}
