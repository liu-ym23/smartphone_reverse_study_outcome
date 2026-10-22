package com.stepos.core.ability.speech;

import ai.onnxruntime.BuildConfig;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.stepos.base.ability.AbilityBase;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.base.strategy.ExecutionPreference;
import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.core.ability.converter.AsrAudioFileDecoder;
import com.stepos.core.ability.telemetry.ModelCallBridge;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.cloud.AccountLoginState;
import com.stepos.core.common.cloud.AuthHeaderResult;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.cloud.RealtimeAsrProxy;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.data.ContentParams;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.task.AITaskRecord;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import com.stepos.core.ota.process.OtaIdleExitPolicy;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import s6.b;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrAbility extends AbilityBase<c.a, d.q> implements StreamingCapableAbility {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_DELTA = "asr.delta";
    public static final String EVENT_RECOGNIZED = "asr.recognized";
    public static final String EXTRA_EVENT_TYPE = "asr.event_type";
    public static final String EXTRA_SEGMENT_END_MS = "asr.segment.end_ms";
    public static final String EXTRA_SEGMENT_INDEX = "asr.segment.index";
    public static final String EXTRA_SEGMENT_SPEAKER_ID = "asr.segment.speaker_id";
    public static final String EXTRA_SEGMENT_START_MS = "asr.segment.start_ms";
    private static final long VAD_GATE_MAX_DURATION_MS = 30000;
    private final String TAG;
    private final AsrLocalStreamSessionManager localStreamManager;
    private final lb.d vadGate$delegate;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final long timeoutForDurationMs(long j10, long j11) {
            return j10 <= 0 ? j11 : dc.h.b0(j10 + HysteresisStrategy.DEFAULT_DWELL_MS, j11, OtaIdleExitPolicy.PAUSED_EXIT_MS);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.AsrAbility$buildOrchestrator$1, reason: invalid class name */
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
    @rb.c(c = "com.stepos.core.ability.speech.AsrAbility$createCloudWsSession$1", f = "ASRAbility.kt", l = {215}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrAbility$createCloudWsSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02981 extends SuspendLambda implements zb.l<qb.b<? super AuthHeaderResult>, Object> {
        final /* synthetic */ AsrCloudConfig $cfg;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02981(AsrCloudConfig asrCloudConfig, qb.b<? super C02981> bVar) {
            super(1, bVar);
            this.$cfg = asrCloudConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return new C02981(this.$cfg, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                return obj;
            }
            kotlin.c.b(obj);
            RealtimeAsrProxy realtimeAsrProxy = RealtimeAsrProxy.INSTANCE;
            String sceneType = this.$cfg.getSceneType();
            this.label = 1;
            Object objHeaders = realtimeAsrProxy.headers(sceneType, this);
            return objHeaders == coroutineSingletons ? coroutineSingletons : objHeaders;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super AuthHeaderResult> bVar) {
            return ((C02981) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrAbility$doFlowCloudInfer$2", f = "ASRAbility.kt", l = {335}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrAbility$doFlowCloudInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(kotlin.c.a(new OrchestrationRejectedException(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED, "Cloud ASR not configured: cloud.enable is false in abilities.json")));
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
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrAbility$doFlowCloudInfer$3", f = "ASRAbility.kt", l = {357}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrAbility$doFlowCloudInfer$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ OrchestrationRejectedException $e;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(OrchestrationRejectedException orchestrationRejectedException, qb.b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$e = orchestrationRejectedException;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$e, bVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
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
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass3) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrAbility$doFlowCloudInfer$4", f = "ASRAbility.kt", l = {378, 378}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrAbility$doFlowCloudInfer$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ c.a $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(c.a aVar, Object obj, qb.b<? super AnonymousClass4> bVar) {
            super(2, bVar);
            this.$input = aVar;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass4 anonymousClass4 = AsrAbility.this.new AnonymousClass4(this.$input, this.$record, bVar);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (r1.emit(r3, r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r7)
                goto L4e
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L18:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r7)
                kotlin.Result r7 = (kotlin.Result) r7
                java.lang.Object r7 = r7.f9987a
                goto L3d
            L24:
                kotlin.c.b(r7)
                java.lang.Object r7 = r6.L$0
                r1 = r7
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.core.ability.speech.AsrAbility r7 = com.stepos.core.ability.speech.AsrAbility.this
                v6.c$a r4 = r6.$input
                java.lang.Object r5 = r6.$record
                r6.L$0 = r1
                r6.label = r3
                java.lang.Object r7 = r7.m35doCloudInfer0E7RQCE(r4, r5, r6)
                if (r7 != r0) goto L3d
                goto L4d
            L3d:
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r7)
                r7 = 0
                r6.L$0 = r7
                r6.label = r2
                java.lang.Object r6 = r1.emit(r3, r6)
                if (r6 != r0) goto L4e
            L4d:
                return r0
            L4e:
                lb.n r6 = lb.n.f10413a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrAbility.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass4) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrAbility$doFlowCloudInfer$5", f = "ASRAbility.kt", l = {385}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrAbility$doFlowCloudInfer$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass5(qb.b<? super AnonymousClass5> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(bVar);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(a0.a.r("Realtime PCM cloud ASR is served by AsrCloudWsSession (WebSocket), not doFlowCloudInfer"));
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
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass5) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrAbility$doFlowInfer$2", f = "ASRAbility.kt", l = {256, 265, 274, 275, 280, 287, 291, 310}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrAbility$doFlowInfer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02992 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ c.a $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ AsrAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02992(c.a aVar, AsrAbility asrAbility, Object obj, qb.b<? super C02992> bVar) {
            super(2, bVar);
            this.$input = aVar;
            this.this$0 = asrAbility;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02992 c02992 = new C02992(this.$input, this.this$0, this.$record, bVar);
            c02992.L$0 = obj;
            return c02992;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x009d, code lost:
        
            if (r15.emit(r2, r14) == r1) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
        
            if (r0.collect(r2, r14) == r1) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x01e6, code lost:
        
            if (r14 == r1) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x021f, code lost:
        
            if (r2.emit(r0, r14) == r1) goto L84;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x013f A[Catch: Exception -> 0x0053, TRY_LEAVE, TryCatch #2 {Exception -> 0x0053, blocks: (B:19:0x004e, B:55:0x0137, B:57:0x013f, B:24:0x0068), top: B:90:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0193  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01a3 A[Catch: Exception -> 0x0197, TRY_LEAVE, TryCatch #0 {Exception -> 0x0197, blocks: (B:67:0x019b, B:69:0x01a3, B:75:0x01c6, B:51:0x0117, B:42:0x00da, B:45:0x00ed, B:47:0x00fb), top: B:88:0x00da }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01c6 A[Catch: Exception -> 0x0197, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0197, blocks: (B:67:0x019b, B:69:0x01a3, B:75:0x01c6, B:51:0x0117, B:42:0x00da, B:45:0x00ed, B:47:0x00fb), top: B:88:0x00da }] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01f4  */
        /* JADX WARN: Type inference failed for: r14v0, types: [com.stepos.core.ability.speech.AsrAbility$doFlowInfer$2, qb.b] */
        /* JADX WARN: Type inference failed for: r14v1, types: [com.stepos.core.ability.speech.AsrAbility$doFlowInfer$2, qb.b] */
        /* JADX WARN: Type inference failed for: r14v10 */
        /* JADX WARN: Type inference failed for: r14v11 */
        /* JADX WARN: Type inference failed for: r14v15 */
        /* JADX WARN: Type inference failed for: r14v16 */
        /* JADX WARN: Type inference failed for: r14v17 */
        /* JADX WARN: Type inference failed for: r14v18 */
        /* JADX WARN: Type inference failed for: r14v19 */
        /* JADX WARN: Type inference failed for: r14v20 */
        /* JADX WARN: Type inference failed for: r14v21 */
        /* JADX WARN: Type inference failed for: r14v3 */
        /* JADX WARN: Type inference failed for: r15v13 */
        /* JADX WARN: Type inference failed for: r15v14 */
        /* JADX WARN: Type inference failed for: r15v23 */
        /* JADX WARN: Type inference failed for: r15v24 */
        /* JADX WARN: Type inference failed for: r15v25 */
        /* JADX WARN: Type inference failed for: r15v26 */
        /* JADX WARN: Type inference failed for: r15v27 */
        /* JADX WARN: Type inference failed for: r15v7, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 572
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrAbility.C02992.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C02992) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrAbility", f = "ASRAbility.kt", l = {206, 207}, m = BuildConfig.BUILD_TYPE)
    /* renamed from: com.stepos.core.ability.speech.AsrAbility$release$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03001(qb.b<? super C03001> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrAbility.this.release(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        kotlin.jvm.internal.g.f(abilityConfig, "abilityConfig");
        this.TAG = "AsrAbility";
        this.vadGate$delegate = kotlin.b.b(new b(0));
        this.localStreamManager = new AsrLocalStreamSessionManager("AsrAbility", new AsrAbility$localStreamManager$1(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.core.ability.speech.AsrCloudConfig buildCloudConfig(java.lang.String r20, com.stepos.core.data.ContentParams r21, java.lang.String r22) {
        /*
            r19 = this;
            r0 = r20
            r1 = r22
            p6.a r2 = r19.getAbilityConfig()
            boolean r3 = r2.f11424j
            java.util.Map<java.lang.String, p6.c> r4 = r2.f11426l
            r5 = 0
            if (r3 != 0) goto L10
            return r5
        L10:
            if (r0 == 0) goto L2c
            boolean r3 = gc.q.t0(r0)
            if (r3 != 0) goto L22
            java.lang.String r3 = "unknown"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L22
            r3 = r0
            goto L23
        L22:
            r3 = r5
        L23:
            if (r3 == 0) goto L2c
            boolean r6 = r4.containsKey(r3)
            if (r6 == 0) goto L2c
            goto L2d
        L2c:
            r3 = r5
        L2d:
            if (r3 == 0) goto L36
            java.lang.Object r4 = r4.get(r3)
            r5 = r4
            p6.c r5 = (p6.c) r5
        L36:
            com.stepos.core.ability.speech.AsrCloudConfig r6 = new com.stepos.core.ability.speech.AsrCloudConfig
            long r7 = r2.f11423i
            com.stepos.core.common.cloud.RealtimeAsrProxy r4 = com.stepos.core.common.cloud.RealtimeAsrProxy.INSTANCE
            java.lang.String r13 = r4.wsEndpoint()
            p6.c r4 = r2.f11425k
            p6.c r14 = r4.c(r5)
            java.lang.String r16 = r2.d(r0, r1)
            r17 = 6
            r18 = 0
            r9 = 0
            r11 = 0
            r15 = r21
            r6.<init>(r7, r9, r11, r13, r14, r15, r16, r17, r18)
            if (r0 == 0) goto L9d
            java.lang.String r2 = r6.streamVadType()
            boolean r4 = gc.q.t0(r2)
            if (r4 == 0) goto L65
            java.lang.String r2 = "manual(empty)"
        L65:
            com.stepos.core.common.log.LogModule r4 = com.stepos.core.common.log.LogModule.ABILITY
            r5 = r19
            java.lang.String r5 = r5.TAG
            r7 = 0
            r8 = 1
            if (r3 == 0) goto L71
            r3 = r8
            goto L72
        L71:
            r3 = r7
        L72:
            java.lang.String r9 = r6.getSceneType()
            if (r9 == 0) goto L79
            r7 = r8
        L79:
            java.lang.String r8 = ", mode="
            java.lang.String r9 = ", turn_detection="
            java.lang.String r10 = "cloud config resolved: pkg="
            java.lang.StringBuilder r0 = ai.onnxruntime.a.s(r10, r0, r8, r1, r9)
            r0.append(r2)
            java.lang.String r1 = ", override="
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = ", hasSceneType="
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.stepos.core.common.log.AIEngineLogger.i(r4, r5, r0)
        L9d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrAbility.buildCloudConfig(java.lang.String, com.stepos.core.data.ContentParams, java.lang.String):com.stepos.core.ability.speech.AsrCloudConfig");
    }

    public static /* synthetic */ AsrCloudConfig buildCloudConfig$default(AsrAbility asrAbility, String str, ContentParams contentParams, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            contentParams = null;
        }
        if ((i10 & 4) != 0) {
            str2 = AsrCloudConfig.SCENE_MODE_STREAM;
        }
        return asrAbility.buildCloudConfig(str, contentParams, str2);
    }

    private final AsrFileCloudClient buildFileClient(String str) {
        AsrCloudConfig asrCloudConfigBuildCloudConfig$default = buildCloudConfig$default(this, str, null, AsrCloudConfig.SCENE_MODE_FILE, 2, null);
        if (asrCloudConfigBuildCloudConfig$default != null) {
            return new AsrFileCloudClient(asrCloudConfigBuildCloudConfig$default);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n createCloudWsSession$lambda$10() {
        RealtimeAsrProxy.INSTANCE.invalidate();
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n doCloudInfer_0E7RQCE$lambda$16(String str, CloudSessionCorrelationState it) {
        kotlin.jvm.internal.g.f(it, "it");
        ModelCallBridge.INSTANCE.logEstablished(str, it);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n doCloudInfer_0E7RQCE$lambda$17(String str) {
        ModelCallBridge.INSTANCE.recordFirstToken(str);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c.a ensurePcmBuffer(c.a aVar) throws IOException {
        String str = aVar.f13389e;
        if (aVar.f13386b.length != 0) {
            return aVar;
        }
        if (str == null || gc.q.t0(str)) {
            return aVar;
        }
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(str), 268435456);
        try {
            AsrAudioFileDecoder asrAudioFileDecoder = AsrAudioFileDecoder.INSTANCE;
            kotlin.jvm.internal.g.c(parcelFileDescriptorOpen);
            short[] sArrDecodeFromPfd = asrAudioFileDecoder.decodeFromPfd(parcelFileDescriptorOpen);
            parcelFileDescriptorOpen.close();
            return c.a.c(aVar, sArrDecodeFromPfd, null, null, null, null, 510);
        } finally {
        }
    }

    private final long fileLengthOf(String str) {
        Object objA;
        if (str == null) {
            return 0L;
        }
        try {
            objA = Long.valueOf(new File(str).length());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0L;
        }
        return ((Number) objA).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VadGate getVadGate() {
        return (VadGate) this.vadGate$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fb A[Catch: Exception -> 0x0121, TRY_LEAVE, TryCatch #8 {Exception -> 0x0121, blocks: (B:45:0x00f3, B:47:0x00fb), top: B:102:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013c A[Catch: Exception -> 0x0148, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0148, blocks: (B:61:0x013c, B:68:0x0159), top: B:99:0x013a }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014a A[Catch: Exception -> 0x01ef, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x01ef, blocks: (B:59:0x0136, B:65:0x014a, B:71:0x015f), top: B:89:0x0136 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* renamed from: inferSingleLocal-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m34inferSingleLocalgIAlus(v6.c.a r19, qb.b<? super kotlin.Result<v6.d.q>> r20) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrAbility.m34inferSingleLocalgIAlus(v6.c$a, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e7.a requireAudioProtocol() {
        return (e7.a) getProtocolManager().b(ProtocolType.f6380c);
    }

    private final String sanitizeUrl(String str) {
        return gc.q.K0(str, "?");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldRunVadGate(c.a aVar, c.a aVar2) {
        String str;
        int i10;
        if (aVar.d()) {
            return false;
        }
        String str2 = aVar2.f13389e;
        if ((str2 != null && !gc.q.t0(str2)) || ((str = aVar.f13389e) != null && !gc.q.t0(str))) {
            return false;
        }
        short[] sArr = aVar2.f13386b;
        return sArr.length != 0 && (i10 = aVar2.f13387c) > 0 && (((long) sArr.length) * 1000) / ((long) i10) <= 30000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VadGate vadGate_delegate$lambda$9() {
        Context context = l7.a.f10344a;
        if (context != null) {
            return new VadGate(context);
        }
        throw new IllegalStateException("ContextHolder must be initialized before use!");
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
        return new AsrOrchestrator(getAbilityConfig().c(), getAbilityConfig().f11424j, new AnonymousClass1(AccountLoginState.INSTANCE));
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public boolean cancel() {
        this.localStreamManager.cancelAll();
        return super.cancel();
    }

    @Override // com.stepos.core.ability.speech.StreamingCapableAbility
    public long cloudCloseAckTimeoutMs() {
        AsrCloudConfig asrCloudConfigBuildCloudConfig$default = buildCloudConfig$default(this, null, null, null, 7, null);
        if (asrCloudConfigBuildCloudConfig$default != null) {
            return asrCloudConfigBuildCloudConfig$default.closeAckTimeoutMs();
        }
        return 2000L;
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public void completeInput(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        this.localStreamManager.completeInput(inferId);
    }

    @Override // com.stepos.core.ability.speech.StreamingCapableAbility
    public AsrCloudWsSession createCloudWsSession(String str, String str2, ContentParams contentParams) {
        AsrCloudConfig asrCloudConfigBuildCloudConfig = buildCloudConfig(str, contentParams, AsrCloudConfig.SCENE_MODE_STREAM);
        if (asrCloudConfigBuildCloudConfig == null) {
            return null;
        }
        requireCloudSceneType(str);
        return new AsrCloudWsSession(asrCloudConfigBuildCloudConfig, new C02981(asrCloudConfigBuildCloudConfig, null), new a(0), str2);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doCloudInfer-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo17doCloudInfer0E7RQCE(v6.c cVar, Object obj, qb.b bVar) {
        return m35doCloudInfer0E7RQCE((c.a) cVar, obj, (qb.b<? super Result<d.q>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowCloudInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowCloudInfer((c.a) cVar, obj, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.a) cVar, obj, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m36doInfergIAlus((c.a) cVar, (qb.b<? super Result<d.q>>) bVar);
    }

    @Override // com.stepos.core.ability.speech.StreamingCapableAbility
    public Object ensureLocalReady(qb.b<? super Boolean> bVar) {
        if (requireAudioProtocol() != null) {
            return Boolean.TRUE;
        }
        Context context = l7.a.f10344a;
        if (context != null) {
            return internalPrepare(context, bVar);
        }
        throw new IllegalStateException("ContextHolder must be initialized before use!");
    }

    @Override // com.stepos.base.ability.AbilityBase
    public h7.b getExecutionConstraints(v6.c input) {
        String str;
        kotlin.jvm.internal.g.f(input, "input");
        c.a aVar = input instanceof c.a ? (c.a) input : null;
        if (aVar == null) {
            return h7.b.f9362d;
        }
        h7.b bVar = h7.b.f9362d;
        String str2 = aVar.f13388d;
        return (str2 == null || gc.q.t0(str2) || !(((str = aVar.f13389e) == null || gc.q.t0(str)) && aVar.f13386b.length == 0)) ? h7.b.a(bVar, aVar.f13391g) : h7.b.a(bVar, ExecutionPreference.f6388c);
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public void onFeedInput(String inferId, Object input) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        this.localStreamManager.onFeedInput(inferId, input);
    }

    @Override // com.stepos.core.ability.speech.StreamingCapableAbility
    public void registerLocalStreamingSession(String inferId, IInferenceCallback iInferenceCallback, int i10, zb.a<lb.n> onStreamComplete, PowerPerfTracker powerPerfTracker, AITaskRecord aITaskRecord) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(onStreamComplete, "onStreamComplete");
        this.localStreamManager.registerLocalStreamingSession(inferId, iInferenceCallback, i10, onStreamComplete, powerPerfTracker, aITaskRecord);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        if (super.release(r6, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.ability.AbilityBase, p6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object release(com.stepos.base.model.ModelReleaseReason r6, qb.b<? super lb.n> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.core.ability.speech.AsrAbility.C03001
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ability.speech.AsrAbility$release$1 r0 = (com.stepos.core.ability.speech.AsrAbility.C03001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.AsrAbility$release$1 r0 = new com.stepos.core.ability.speech.AsrAbility$release$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.c.b(r7)
            goto L5f
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            com.stepos.base.model.ModelReleaseReason r6 = (com.stepos.base.model.ModelReleaseReason) r6
            java.lang.Object r5 = r0.L$0
            com.stepos.core.ability.speech.AsrAbility r5 = (com.stepos.core.ability.speech.AsrAbility) r5
            kotlin.c.b(r7)
            goto L51
        L3f:
            kotlin.c.b(r7)
            com.stepos.core.ability.speech.AsrLocalStreamSessionManager r7 = r5.localStreamManager
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.releaseAndJoin(r0)
            if (r7 != r1) goto L51
            goto L5e
        L51:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r5 = super.release(r6, r0)
            if (r5 != r1) goto L5f
        L5e:
            return r1
        L5f:
            lb.n r5 = lb.n.f10413a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrAbility.release(com.stepos.base.model.ModelReleaseReason, qb.b):java.lang.Object");
    }

    @Override // com.stepos.core.ability.speech.StreamingCapableAbility
    public String requireCloudSceneType(String str) {
        return CloudSceneTypeGuard.INSTANCE.require(getAbilityConfig(), str, AsrCloudConfig.SCENE_MODE_STREAM);
    }

    @Override // com.stepos.core.ability.speech.StreamingCapableAbility
    public Object resolveStreamingDecision(ContentParams contentParams, qb.b<? super h7.e> bVar) {
        String string;
        String str = "";
        if (contentParams != null && (string = contentParams.getString("execution_preference", "")) != null) {
            str = string;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
        return buildOrchestrator().makeDecision(lb.n.f10413a, getAbilityConfig().f11416a, h7.b.a(h7.b.f9362d, lowerCase.equals("local") ? ExecutionPreference.f6387b : lowerCase.equals(ModelCallFlywheelBizMapper.MODEL_PATH_CLOUD) ? ExecutionPreference.f6388c : ExecutionPreference.f6386a), bVar);
    }

    @Override // com.stepos.core.ability.speech.StreamingCapableAbility
    public p6.i segmentationConfig() {
        return getAbilityConfig().f11430p;
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public long cloudExecutionTimeoutMs(c.a input) {
        kotlin.jvm.internal.g.f(input, "input");
        String str = input.f13389e;
        List<c.b> list = input.f13390f;
        long j10 = 0;
        if (list == null || list.isEmpty()) {
            return (str == null || gc.q.t0(str)) ? b.a.a(0L).f11896c : b.a.a(fileLengthOf(str)).f11896c;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            j10 += b.a.a(fileLengthOf(((c.b) it.next()).f13394a)).f11896c;
        }
        return j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.base.ability.AbilityBase
    public d.q defaultOutput() {
        return new d.q("", null, 0 == true ? 1 : 0, 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* renamed from: doCloudInfer-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m35doCloudInfer0E7RQCE(v6.c.a r34, java.lang.Object r35, qb.b<? super kotlin.Result<v6.d.q>> r36) {
        /*
            Method dump skipped, instructions count: 898
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrAbility.m35doCloudInfer0E7RQCE(v6.c$a, java.lang.Object, qb.b):java.lang.Object");
    }

    public Object doFlowCloudInfer(c.a aVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        String str = aVar.f13393j;
        String str2 = aVar.f13388d;
        String str3 = aVar.f13389e;
        if (str.length() == 0) {
            str = "?";
        }
        String str4 = str;
        List<c.b> list = aVar.f13390f;
        int size = (list == null || list.isEmpty()) ? ((str3 == null || gc.q.t0(str3)) && (str2 == null || gc.q.t0(str2))) ? 0 : 1 : list.size();
        LogModule logModule = LogModule.ABILITY;
        String str5 = this.TAG;
        boolean zD = aVar.d();
        boolean z = !(str2 == null || gc.q.t0(str2));
        String strS0 = str3 != null ? gc.r.S0(48, str3) : null;
        StringBuilder sbM = com.stepos.core.ota.d.m("[ASR-FILE] inferId=", str4, " stage=ROUTE enter isMultiFiles=", " fileCount=", zD);
        sbM.append(size);
        sbM.append(" hasAudioUrl=");
        sbM.append(z);
        sbM.append(" localPath=");
        a0.a.z(sbM, strS0, logModule, str5);
        if (buildCloudConfig$default(this, null, null, null, 7, null) == null) {
            AIEngineLogger.w(logModule, this.TAG, "[ASR-FILE] inferId=" + str4 + " stage=ROUTE reject reason=cloud.enable=false");
            return FlowKt.flow(new AnonymousClass2(null));
        }
        if (!aVar.d()) {
            if ((str3 == null || gc.q.t0(str3)) && (str2 == null || gc.q.t0(str2))) {
                AIEngineLogger.w(logModule, this.TAG, "[ASR-FILE] inferId=" + str4 + " stage=ROUTE route=WS_NOT_HERE (realtime PCM served by AsrCloudWsSession via Binder)");
                return FlowKt.flow(new AnonymousClass5(null));
            }
            AIEngineLogger.i(logModule, this.TAG, "[ASR-FILE] inferId=" + str4 + " stage=ROUTE route=FileAPI");
            return FlowKt.flow(new AnonymousClass4(aVar, obj, null));
        }
        AIEngineLogger.i(logModule, this.TAG, "[ASR-FILE] inferId=" + str4 + " stage=ROUTE route=AsrMultiFilesPipeline");
        String str6 = ModelCallBridge.INSTANCE.callerFromRecord(obj).f9986b;
        try {
            CloudSceneTypeGuard.INSTANCE.require(getAbilityConfig(), str6, AsrCloudConfig.SCENE_MODE_FILE);
            AsrFileCloudClient asrFileCloudClientBuildFileClient = buildFileClient(str6);
            if (asrFileCloudClientBuildFileClient == null) {
                return FlowKt.flow(new AsrAbility$doFlowCloudInfer$client$1(null));
            }
            AsrMultiFilesPipeline asrMultiFilesPipeline = new AsrMultiFilesPipeline(asrFileCloudClientBuildFileClient, getAbilityConfig().f11425k.a(AsrCloudConfig.SCENE_MODE_FILE), getAbilityConfig().f11428n);
            String str7 = getAbilityConfig().f11416a;
            b7.k kVar = (b7.k) kotlin.collections.a.v0(getAbilityConfig().f11419d);
            String str8 = kVar != null ? kVar.f3090a : null;
            if (str8 == null) {
                str8 = "";
            }
            return asrMultiFilesPipeline.runCloudMultiFiles(aVar, obj, str7, str8);
        } catch (OrchestrationRejectedException e10) {
            return FlowKt.flow(new AnonymousClass3(e10, null));
        }
    }

    public Object doFlowInfer(c.a aVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new C02992(aVar, this, obj, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m36doInfergIAlus(v6.c.a r5, qb.b<? super kotlin.Result<v6.d.q>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ability.speech.AsrAbility$doInfer$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ability.speech.AsrAbility$doInfer$1 r0 = (com.stepos.core.ability.speech.AsrAbility$doInfer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.AsrAbility$doInfer$1 r0 = new com.stepos.core.ability.speech.AsrAbility$doInfer$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.f9987a
            return r4
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.c.b(r6)
            boolean r6 = r5.d()
            if (r6 == 0) goto L43
            java.lang.String r4 = "Multi-file ASR must use streaming infer() Flow path"
            kotlin.Result$Failure r4 = a0.a.r(r4)
            return r4
        L43:
            r0.label = r3
            java.lang.Object r4 = r4.m34inferSingleLocalgIAlus(r5, r0)
            if (r4 != r1) goto L4c
            return r1
        L4c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrAbility.m36doInfergIAlus(v6.c$a, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.ability.AbilityBase
    public long localExecutionTimeoutMs(c.a input, long j10) {
        kotlin.jvm.internal.g.f(input, "input");
        List<c.b> list = input.f13390f;
        String str = input.f13389e;
        long jProbeDurationMs = 0;
        if (list != null && !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                jProbeDurationMs += AsrAudioFileDecoder.INSTANCE.probeDurationMs(((c.b) it.next()).f13394a);
            }
        } else if (str != null && !gc.q.t0(str)) {
            jProbeDurationMs = AsrAudioFileDecoder.INSTANCE.probeDurationMs(str);
        }
        return Companion.timeoutForDurationMs(jProbeDurationMs, j10);
    }
}
