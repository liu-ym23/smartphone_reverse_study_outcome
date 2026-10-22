package com.stepos.core.ability.speech;

import android.content.Context;
import android.os.Bundle;
import com.stepos.base.ability.AbilityBase;
import com.stepos.base.concurrency.data.PoolType;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.base.strategy.ExecutionPreference;
import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.ability.converter.AbilityOutputConverter;
import com.stepos.core.ability.handler.BinderResultHandler;
import com.stepos.core.ability.handler.InferResult;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.cloud.AccountLoginState;
import com.stepos.core.common.cloud.AuthHeaderResult;
import com.stepos.core.common.cloud.RealtimeTtsProxy;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper;
import com.stepos.core.common.util.TraceIdExtractorKt;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.manifest.ModelManifest;
import com.stepos.core.model.task.AITaskRecord;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsStreamAbility extends AbilityBase<c.g, d.b> {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String DEFAULT_SPEAKER = "tingting";

    @Deprecated
    public static final int LOCAL_TEXT_CHANNEL_CAPACITY = 64;

    @Deprecated
    public static final int NATIVE_SAMPLE_RATE = 16000;
    private final String TAG;
    private final ConcurrentHashMap<String, LocalStreamSession> localStreamSessions;
    private final AbilityOutputConverter outputConverter;
    private final CoroutineScope streamScope;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.TtsStreamAbility$buildOrchestrator$1, reason: invalid class name */
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
    @rb.c(c = "com.stepos.core.ability.speech.TtsStreamAbility$createCloudWsSession$1", f = "TtsStreamAbility.kt", l = {118}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsStreamAbility$createCloudWsSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03501 extends SuspendLambda implements zb.l<qb.b<? super AuthHeaderResult>, Object> {
        final /* synthetic */ TtsCloudConfig $config;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03501(TtsCloudConfig ttsCloudConfig, qb.b<? super C03501> bVar) {
            super(1, bVar);
            this.$config = ttsCloudConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return new C03501(this.$config, bVar);
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
            RealtimeTtsProxy realtimeTtsProxy = RealtimeTtsProxy.INSTANCE;
            String sceneType = this.$config.getSceneType();
            this.label = 1;
            Object objHeaders = realtimeTtsProxy.headers(sceneType, this);
            return objHeaders == coroutineSingletons ? coroutineSingletons : objHeaders;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super AuthHeaderResult> bVar) {
            return ((C03501) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsStreamAbility$doFlowCloudInfer$2", f = "TtsStreamAbility.kt", l = {347}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsStreamAbility$doFlowCloudInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.b>>, qb.b<? super lb.n>, Object> {
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
                Result result = new Result(kotlin.c.a(new OrchestrationRejectedException(AIEngineError.INFERENCE_FAILED, "Cloud TTS stream uses WS session, not batch infer")));
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
    @rb.c(c = "com.stepos.core.ability.speech.TtsStreamAbility$doFlowInfer$2", f = "TtsStreamAbility.kt", l = {330}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsStreamAbility$doFlowInfer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03512 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.b>>, qb.b<? super lb.n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C03512(qb.b<? super C03512> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03512 c03512 = new C03512(bVar);
            c03512.L$0 = obj;
            return c03512;
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
                Result result = new Result(kotlin.c.a(new UnsupportedOperationException("Use streaming infer path")));
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
            return ((C03512) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsStreamAbility", f = "TtsStreamAbility.kt", l = {268, 268}, m = "inferLocalChunk")
    /* renamed from: com.stepos.core.ability.speech.TtsStreamAbility$inferLocalChunk$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C03521(qb.b<? super C03521> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TtsStreamAbility.this.inferLocalChunk(null, null, null, null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsStreamAbility$registerLocalStreamingSession$1", f = "TtsStreamAbility.kt", l = {169}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsStreamAbility$registerLocalStreamingSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03541 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $inferId;
        final /* synthetic */ LocalStreamSession $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03541(String str, LocalStreamSession localStreamSession, qb.b<? super C03541> bVar) {
            super(2, bVar);
            this.$inferId = str;
            this.$session = localStreamSession;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return TtsStreamAbility.this.new C03541(this.$inferId, this.$session, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                TtsStreamAbility ttsStreamAbility = TtsStreamAbility.this;
                String str = this.$inferId;
                LocalStreamSession localStreamSession = this.$session;
                this.label = 1;
                if (ttsStreamAbility.runLocalStreamConsumer(str, localStreamSession, this) == coroutineSingletons) {
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
            return ((C03541) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsStreamAbility", f = "TtsStreamAbility.kt", l = {232, 241}, m = "runLocalStreamConsumer")
    /* renamed from: com.stepos.core.ability.speech.TtsStreamAbility$runLocalStreamConsumer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C03551(qb.b<? super C03551> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TtsStreamAbility.this.runLocalStreamConsumer(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TtsStreamAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        kotlin.jvm.internal.g.f(abilityConfig, "abilityConfig");
        this.TAG = "TtsStreamAbility";
        this.outputConverter = new AbilityOutputConverter();
        this.localStreamSessions = new ConcurrentHashMap<>();
        this.streamScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static /* synthetic */ TtsCloudConfig buildTtsCloudConfig$default(TtsStreamAbility ttsStreamAbility, String str, ContentParams contentParams, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            contentParams = null;
        }
        return ttsStreamAbility.buildTtsCloudConfig(str, contentParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TtsCloudWsSession createCloudWsSession$default(TtsStreamAbility ttsStreamAbility, TtsCloudConfig ttsCloudConfig, String str, zb.l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        return ttsStreamAbility.createCloudWsSession(ttsCloudConfig, str, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n createCloudWsSession$lambda$2() {
        RealtimeTtsProxy.INSTANCE.invalidate();
        return lb.n.f10413a;
    }

    private final void emitSessionOpened(String str, BinderResultHandler binderResultHandler) {
        TextContent textContent = new TextContent("");
        textContent.setParams(new ContentParams.Builder().putBoolean(TtsStreamingBuffer.KEY_TTS_SESSION_OPENED, true).build());
        binderResultHandler.onResult(str, new InferResult.Progress(0, textContent));
    }

    private final void finishLocalStream(String str, LocalStreamSession localStreamSession) {
        TtsPcmDumpSink.INSTANCE.close(str);
        this.localStreamSessions.remove(str);
        localStreamSession.getOnStreamComplete().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] floatToPcm16(float[] fArr) {
        byte[] bArr = new byte[fArr.length * 2];
        int i10 = 0;
        for (float f8 : fArr) {
            short sZ = (short) (dc.h.Z(f8, -1.0f, 1.0f) * AsrCloudWsSession.PCM_FULL_SCALE);
            int i11 = i10 + 1;
            bArr[i10] = (byte) (sZ & 255);
            i10 += 2;
            bArr[i11] = (byte) ((sZ >> 8) & 255);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0090, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r12).collect(r5, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object inferLocalChunk(java.lang.String r6, com.stepos.core.ability.handler.BinderResultHandler r7, e7.g r8, java.lang.String r9, com.stepos.core.data.ContentParams r10, com.stepos.core.ability.speech.TtsStreamAbility.LocalStreamSession r11, qb.b<? super lb.n> r12) {
        /*
            r5 = this;
            boolean r0 = r12 instanceof com.stepos.core.ability.speech.TtsStreamAbility.C03521
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.core.ability.speech.TtsStreamAbility$inferLocalChunk$1 r0 = (com.stepos.core.ability.speech.TtsStreamAbility.C03521) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.TtsStreamAbility$inferLocalChunk$1 r0 = new com.stepos.core.ability.speech.TtsStreamAbility$inferLocalChunk$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L53
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.c.b(r12)
            goto L93
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            java.lang.Object r5 = r0.L$4
            r11 = r5
            com.stepos.core.ability.speech.TtsStreamAbility$LocalStreamSession r11 = (com.stepos.core.ability.speech.TtsStreamAbility.LocalStreamSession) r11
            java.lang.Object r5 = r0.L$3
            r10 = r5
            com.stepos.core.data.ContentParams r10 = (com.stepos.core.data.ContentParams) r10
            java.lang.Object r5 = r0.L$2
            r7 = r5
            com.stepos.core.ability.handler.BinderResultHandler r7 = (com.stepos.core.ability.handler.BinderResultHandler) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.L$0
            com.stepos.core.ability.speech.TtsStreamAbility r5 = (com.stepos.core.ability.speech.TtsStreamAbility) r5
            kotlin.c.b(r12)
        L4d:
            r8 = r5
            r9 = r10
            r10 = r7
            r7 = r6
            r6 = r11
            goto L78
        L53:
            kotlin.c.b(r12)
            v6.c$g r12 = new v6.c$g
            android.os.Bundle r2 = r5.textExtrasFrom(r10)
            r12.<init>(r9, r2, r3)
            com.stepos.core.model.task.AITaskRecord r9 = r11.getRecord()
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r10
            r0.L$4 = r11
            r0.label = r4
            java.lang.String r2 = "tingting"
            java.lang.Object r12 = r8.processSynthesize(r12, r2, r9, r0)
            if (r12 != r1) goto L4d
            goto L92
        L78:
            kotlinx.coroutines.flow.Flow r12 = (kotlinx.coroutines.flow.Flow) r12
            com.stepos.core.ability.speech.TtsStreamAbility$inferLocalChunk$2 r5 = new com.stepos.core.ability.speech.TtsStreamAbility$inferLocalChunk$2
            r5.<init>()
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r0.L$3 = r6
            r0.L$4 = r6
            r0.label = r3
            java.lang.Object r5 = r12.collect(r5, r0)
            if (r5 != r1) goto L93
        L92:
            return r1
        L93:
            lb.n r5 = lb.n.f10413a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsStreamAbility.inferLocalChunk(java.lang.String, com.stepos.core.ability.handler.BinderResultHandler, e7.g, java.lang.String, com.stepos.core.data.ContentParams, com.stepos.core.ability.speech.TtsStreamAbility$LocalStreamSession, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] pcm16ToFloat(byte[] bArr) {
        float[] fArr = new float[bArr.length / 2];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 + 1 >= bArr.length) {
                return fArr;
            }
            fArr[i11] = ((short) ((bArr[r2] << 8) | (bArr[i10] & 255))) / 32768.0f;
            i10 += 2;
            i11++;
        }
    }

    public static /* synthetic */ void registerLocalStreamingSession$default(TtsStreamAbility ttsStreamAbility, String str, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, AITaskRecord aITaskRecord, zb.a aVar, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            aITaskRecord = null;
        }
        ttsStreamAbility.registerLocalStreamingSession(str, iInferenceCallback, i10, contentParams, aITaskRecord, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0055: MOVE (r14 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:86), block:B:16:0x0054 */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x005a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:91), block:B:18:0x005a */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x005e: MOVE (r1 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:95), block:B:19:0x005e */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0056: MOVE (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:87), block:B:16:0x0054 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x005b: MOVE (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:92), block:B:18:0x005a */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x005f: MOVE (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:96), block:B:19:0x005e */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0054: MOVE (r2 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]) (LINE:85), block:B:16:0x0054 */
    /* JADX WARN: Path cross not found for [B:102:0x002b, B:25:0x008b], limit reached: 103 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e9 A[Catch: all -> 0x0143, Exception -> 0x0146, CancellationException -> 0x0149, TryCatch #1 {all -> 0x0143, blocks: (B:36:0x00e1, B:38:0x00e9, B:40:0x00f7, B:65:0x0157), top: B:93:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0193  */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.stepos.core.ability.speech.TtsStreamAbility] */
    /* JADX WARN: Type inference failed for: r12v12, types: [com.stepos.core.ability.speech.TtsStreamAbility, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v9, types: [com.stepos.core.ability.speech.TtsStreamAbility] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.stepos.core.ability.speech.TtsStreamAbility] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.stepos.core.ability.handler.BinderResultHandler] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.stepos.core.ability.handler.BinderResultHandler] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runLocalStreamConsumer(java.lang.String r21, com.stepos.core.ability.speech.TtsStreamAbility.LocalStreamSession r22, qb.b<? super lb.n> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsStreamAbility.runLocalStreamConsumer(java.lang.String, com.stepos.core.ability.speech.TtsStreamAbility$LocalStreamSession, qb.b):java.lang.Object");
    }

    private final e7.g speechProtocol() {
        return (e7.g) getProtocolManager().b(ProtocolType.h);
    }

    private final Bundle textExtrasFrom(ContentParams contentParams) {
        boolean z;
        if (contentParams == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        boolean z3 = true;
        if (contentParams.containsKey("execution_preference")) {
            bundle.putString("execution_preference", contentParams.getString("execution_preference", "auto"));
            z = true;
        } else {
            z = false;
        }
        if (contentParams.containsKey("tts.voice")) {
            bundle.putString("tts.voice", contentParams.getString("tts.voice", ""));
            z = true;
        }
        if (contentParams.containsKey("tts.instruction")) {
            bundle.putString("tts.instruction", contentParams.getString("tts.instruction", ""));
            z = true;
        }
        if (contentParams.containsKey("tts.speed")) {
            bundle.putFloat("tts.speed", contentParams.getFloat("tts.speed", 1.0f));
            z = true;
        }
        if (contentParams.containsKey("tts.volume")) {
            bundle.putFloat("tts.volume", contentParams.getFloat("tts.volume", 1.0f));
            z = true;
        }
        if (contentParams.containsKey("tts.sample_rate")) {
            bundle.putInt("tts.sample_rate", contentParams.getInt("tts.sample_rate", 0));
            z = true;
        }
        if (contentParams.containsKey(TtsCloudConfig.KEY_MODE)) {
            bundle.putString(TtsCloudConfig.KEY_MODE, contentParams.getString(TtsCloudConfig.KEY_MODE, ""));
            z = true;
        }
        if (contentParams.containsKey(TtsCloudConfig.KEY_TEXT_NORMALIZATION)) {
            bundle.putString(TtsCloudConfig.KEY_TEXT_NORMALIZATION, contentParams.getString(TtsCloudConfig.KEY_TEXT_NORMALIZATION, ""));
        } else {
            z3 = z;
        }
        if (z3) {
            return bundle;
        }
        return null;
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public Object acquire(qb.b<? super Boolean> bVar) {
        if (!getAbilityConfig().f11424j) {
            return super.acquire(bVar);
        }
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, "acquire: defer on-device model load (cloud-first)");
        return Boolean.TRUE;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public h7.d buildOrchestrator() {
        return new TtsOrchestrator(getAbilityConfig().c(), getAbilityConfig().f11424j, new AnonymousClass1(AccountLoginState.INSTANCE));
    }

    public final TtsCloudConfig buildTtsCloudConfig(String str, ContentParams contentParams) {
        p6.a abilityConfig = getAbilityConfig();
        p6.c cVar = null;
        if (!abilityConfig.f11424j) {
            return null;
        }
        CloudSceneTypeGuard.require$default(CloudSceneTypeGuard.INSTANCE, abilityConfig, str, null, 4, null);
        TtsCloudConfig.Companion companion = TtsCloudConfig.Companion;
        companion.requireValidSampleRate(contentParams);
        if (str != null) {
            String str2 = (gc.q.t0(str) || str.equals("unknown")) ? null : str;
            if (str2 != null) {
                cVar = abilityConfig.f11426l.get(str2);
            }
        }
        p6.c cVarC = abilityConfig.f11425k.c(cVar).c(companion.requestOverrides(contentParams));
        TtsCloudConfig ttsCloudConfig = new TtsCloudConfig(abilityConfig.f11423i, RealtimeTtsProxy.INSTANCE.wsEndpoint(cVarC.b(ModelManifest.TYPE_MODEL, "")), cVarC, abilityConfig.f11429o, abilityConfig.d(str, ""));
        LogModule logModule = LogModule.ABILITY;
        String str3 = this.TAG;
        String strVoice = ttsCloudConfig.voice();
        double dSpeed = ttsCloudConfig.speed();
        double dVolume = ttsCloudConfig.volume();
        String strMode = ttsCloudConfig.mode();
        int iSampleRate = ttsCloudConfig.sampleRate();
        boolean z = cVar != null;
        StringBuilder sbS = ai.onnxruntime.a.s("cloud tts config: pkg=", str, ", voice=", strVoice, ", speed=");
        sbS.append(dSpeed);
        sbS.append(", volume=");
        sbS.append(dVolume);
        sbS.append(", mode=");
        com.stepos.core.ota.d.o(iSampleRate, strMode, ", sampleRate=", ", pkgOverride=", sbS);
        sbS.append(z);
        AIEngineLogger.i(logModule, str3, sbS.toString());
        return ttsCloudConfig;
    }

    public final void cancelLocalStream(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        LocalStreamSession localStreamSessionRemove = this.localStreamSessions.remove(inferId);
        if (localStreamSessionRemove != null) {
            Job consumerJob = localStreamSessionRemove.getConsumerJob();
            if (consumerJob != null) {
                Job.DefaultImpls.cancel$default(consumerJob, null, 1, null);
            }
            try {
                SendChannel.DefaultImpls.close$default(localStreamSessionRemove.getChannel(), null, 1, null);
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public void completeInput(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        LocalStreamSession localStreamSession = this.localStreamSessions.get(inferId);
        if (localStreamSession != null) {
            localStreamSession.getClosing().set(true);
            SendChannel.DefaultImpls.close$default(localStreamSession.getChannel(), null, 1, null);
        }
    }

    public final TtsCloudWsSession createCloudWsSession(TtsCloudConfig config, String str, zb.l<? super String, lb.n> lVar) {
        kotlin.jvm.internal.g.f(config, "config");
        return new TtsCloudWsSession(config, new C03501(config, null), new b(5), config.downstreamBufferCapacity(), str, lVar);
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
        return m61doInfergIAlus((c.g) cVar, (qb.b<? super Result<d.b>>) bVar);
    }

    public final Object ensureLocalReady(qb.b<? super Boolean> bVar) {
        if (speechProtocol() != null) {
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

    public final void notifyInputClosed(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        LocalStreamSession localStreamSession = this.localStreamSessions.get(inferId);
        if (localStreamSession == null) {
            return;
        }
        BinderResultHandler binderResultHandler = new BinderResultHandler(localStreamSession.getCallback());
        TextContent textContent = new TextContent("");
        textContent.setParams(new ContentParams.Builder().putBoolean(TtsStreamingBuffer.KEY_TTS_INPUT_CLOSED, true).build());
        binderResultHandler.onResult(inferId, new InferResult.Progress(0, textContent));
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public void onFeedInput(String inferId, Object input) {
        String text;
        LocalStreamSession localStreamSession;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        TextContent textContent = input instanceof TextContent ? (TextContent) input : null;
        if (textContent == null || (text = textContent.getText()) == null || text.length() == 0 || (localStreamSession = this.localStreamSessions.get(inferId)) == null) {
            return;
        }
        synchronized (localStreamSession.getFeedChainLock()) {
            localStreamSession.setFeedChainTail(BuildersKt__Builders_commonKt.launch$default(this.streamScope, null, null, new TtsStreamAbility$onFeedInput$1$1(localStreamSession.getFeedChainTail(), localStreamSession, text, this, inferId, null), 3, null));
            lb.n nVar = lb.n.f10413a;
        }
    }

    public final void registerLocalStreamingSession(String inferId, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, AITaskRecord aITaskRecord, zb.a<lb.n> onStreamComplete) {
        kotlin.coroutines.d aVar;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(onStreamComplete, "onStreamComplete");
        LocalStreamSession localStreamSession = new LocalStreamSession(iInferenceCallback, i10, contentParams, aITaskRecord, TraceIdExtractorKt.extractBusinessTraceId(contentParams), onStreamComplete, ChannelKt.Channel$default(64, BufferOverflow.SUSPEND, null, 4, null), null, null, null, null, null, 3968, null);
        this.localStreamSessions.put(inferId, localStreamSession);
        if (aITaskRecord != null) {
            TaskPriority priority = aITaskRecord.getFinalTier();
            if (priority == null) {
                priority = aITaskRecord.getPriority();
            }
            kotlin.jvm.internal.g.f(priority, "priority");
            PoolType.f6214b.getClass();
            aVar = new com.stepos.base.concurrency.cpuset.a(PoolType.a.a(priority));
        } else {
            aVar = null;
        }
        CoroutineScope coroutineScope = this.streamScope;
        if (aVar == null) {
            aVar = EmptyCoroutineContext.f10057a;
        }
        localStreamSession.setConsumerJob(BuildersKt__Builders_commonKt.launch$default(coroutineScope, aVar, null, new C03541(inferId, localStreamSession, null), 2, null));
    }

    public final Object resolveStreamingDecision(ContentParams contentParams, qb.b<? super h7.e> bVar) {
        String string;
        String str = "";
        if (contentParams != null && (string = contentParams.getString("execution_preference", "")) != null) {
            str = string;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
        return buildOrchestrator().makeDecision(lb.n.f10413a, getAbilityConfig().f11416a, h7.b.a(h7.b.f9362d, lowerCase.equals("local") ? ExecutionPreference.f6387b : lowerCase.equals(ModelCallFlywheelBizMapper.MODEL_PATH_CLOUD) ? ExecutionPreference.f6388c : ExecutionPreference.f6386a), bVar);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.b defaultOutput() {
        return new d.b(new float[0], 0, 0, 30);
    }

    public Object doFlowCloudInfer(c.g gVar, Object obj, qb.b<? super Flow<Result<d.b>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(null));
    }

    public Object doFlowInfer(c.g gVar, Object obj, qb.b<? super Flow<Result<d.b>>> bVar) {
        return FlowKt.flow(new C03512(null));
    }

    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    public Object m61doInfergIAlus(c.g gVar, qb.b<? super Result<d.b>> bVar) {
        return kotlin.c.a(new UnsupportedOperationException("Use streaming infer path"));
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class LocalStreamSession {
        private final IInferenceCallback callback;
        private final int callerUid;
        private final Channel<String> channel;
        private final AtomicBoolean closing;
        private volatile Job consumerJob;
        private final Object feedChainLock;
        private volatile Job feedChainTail;
        private final AtomicBoolean firstTokenRecorded;
        private final zb.a<lb.n> onStreamComplete;
        private final ContentParams params;
        private final AITaskRecord record;
        private final String traceId;

        public LocalStreamSession(IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, AITaskRecord aITaskRecord, String traceId, zb.a<lb.n> onStreamComplete, Channel<String> channel, Job job, Job job2, Object feedChainLock, AtomicBoolean closing, AtomicBoolean firstTokenRecorded) {
            kotlin.jvm.internal.g.f(traceId, "traceId");
            kotlin.jvm.internal.g.f(onStreamComplete, "onStreamComplete");
            kotlin.jvm.internal.g.f(channel, "channel");
            kotlin.jvm.internal.g.f(feedChainLock, "feedChainLock");
            kotlin.jvm.internal.g.f(closing, "closing");
            kotlin.jvm.internal.g.f(firstTokenRecorded, "firstTokenRecorded");
            this.callback = iInferenceCallback;
            this.callerUid = i10;
            this.params = contentParams;
            this.record = aITaskRecord;
            this.traceId = traceId;
            this.onStreamComplete = onStreamComplete;
            this.channel = channel;
            this.consumerJob = job;
            this.feedChainTail = job2;
            this.feedChainLock = feedChainLock;
            this.closing = closing;
            this.firstTokenRecorded = firstTokenRecorded;
        }

        public static /* synthetic */ LocalStreamSession copy$default(LocalStreamSession localStreamSession, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, AITaskRecord aITaskRecord, String str, zb.a aVar, Channel channel, Job job, Job job2, Object obj, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                iInferenceCallback = localStreamSession.callback;
            }
            if ((i11 & 2) != 0) {
                i10 = localStreamSession.callerUid;
            }
            if ((i11 & 4) != 0) {
                contentParams = localStreamSession.params;
            }
            if ((i11 & 8) != 0) {
                aITaskRecord = localStreamSession.record;
            }
            if ((i11 & 16) != 0) {
                str = localStreamSession.traceId;
            }
            if ((i11 & 32) != 0) {
                aVar = localStreamSession.onStreamComplete;
            }
            if ((i11 & 64) != 0) {
                channel = localStreamSession.channel;
            }
            if ((i11 & TraceIdKeys.MAX_LENGTH) != 0) {
                job = localStreamSession.consumerJob;
            }
            if ((i11 & 256) != 0) {
                job2 = localStreamSession.feedChainTail;
            }
            if ((i11 & VadSessionManager.FRAME_BYTES) != 0) {
                obj = localStreamSession.feedChainLock;
            }
            if ((i11 & 1024) != 0) {
                atomicBoolean = localStreamSession.closing;
            }
            if ((i11 & 2048) != 0) {
                atomicBoolean2 = localStreamSession.firstTokenRecorded;
            }
            AtomicBoolean atomicBoolean3 = atomicBoolean;
            AtomicBoolean atomicBoolean4 = atomicBoolean2;
            Job job3 = job2;
            Object obj3 = obj;
            Channel channel2 = channel;
            Job job4 = job;
            String str2 = str;
            zb.a aVar2 = aVar;
            return localStreamSession.copy(iInferenceCallback, i10, contentParams, aITaskRecord, str2, aVar2, channel2, job4, job3, obj3, atomicBoolean3, atomicBoolean4);
        }

        public final IInferenceCallback component1() {
            return this.callback;
        }

        public final Object component10() {
            return this.feedChainLock;
        }

        public final AtomicBoolean component11() {
            return this.closing;
        }

        public final AtomicBoolean component12() {
            return this.firstTokenRecorded;
        }

        public final int component2() {
            return this.callerUid;
        }

        public final ContentParams component3() {
            return this.params;
        }

        public final AITaskRecord component4() {
            return this.record;
        }

        public final String component5() {
            return this.traceId;
        }

        public final zb.a<lb.n> component6() {
            return this.onStreamComplete;
        }

        public final Channel<String> component7() {
            return this.channel;
        }

        public final Job component8() {
            return this.consumerJob;
        }

        public final Job component9() {
            return this.feedChainTail;
        }

        public final LocalStreamSession copy(IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, AITaskRecord aITaskRecord, String traceId, zb.a<lb.n> onStreamComplete, Channel<String> channel, Job job, Job job2, Object feedChainLock, AtomicBoolean closing, AtomicBoolean firstTokenRecorded) {
            kotlin.jvm.internal.g.f(traceId, "traceId");
            kotlin.jvm.internal.g.f(onStreamComplete, "onStreamComplete");
            kotlin.jvm.internal.g.f(channel, "channel");
            kotlin.jvm.internal.g.f(feedChainLock, "feedChainLock");
            kotlin.jvm.internal.g.f(closing, "closing");
            kotlin.jvm.internal.g.f(firstTokenRecorded, "firstTokenRecorded");
            return new LocalStreamSession(iInferenceCallback, i10, contentParams, aITaskRecord, traceId, onStreamComplete, channel, job, job2, feedChainLock, closing, firstTokenRecorded);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalStreamSession)) {
                return false;
            }
            LocalStreamSession localStreamSession = (LocalStreamSession) obj;
            return kotlin.jvm.internal.g.b(this.callback, localStreamSession.callback) && this.callerUid == localStreamSession.callerUid && kotlin.jvm.internal.g.b(this.params, localStreamSession.params) && kotlin.jvm.internal.g.b(this.record, localStreamSession.record) && kotlin.jvm.internal.g.b(this.traceId, localStreamSession.traceId) && kotlin.jvm.internal.g.b(this.onStreamComplete, localStreamSession.onStreamComplete) && kotlin.jvm.internal.g.b(this.channel, localStreamSession.channel) && kotlin.jvm.internal.g.b(this.consumerJob, localStreamSession.consumerJob) && kotlin.jvm.internal.g.b(this.feedChainTail, localStreamSession.feedChainTail) && kotlin.jvm.internal.g.b(this.feedChainLock, localStreamSession.feedChainLock) && kotlin.jvm.internal.g.b(this.closing, localStreamSession.closing) && kotlin.jvm.internal.g.b(this.firstTokenRecorded, localStreamSession.firstTokenRecorded);
        }

        public final IInferenceCallback getCallback() {
            return this.callback;
        }

        public final int getCallerUid() {
            return this.callerUid;
        }

        public final Channel<String> getChannel() {
            return this.channel;
        }

        public final AtomicBoolean getClosing() {
            return this.closing;
        }

        public final Job getConsumerJob() {
            return this.consumerJob;
        }

        public final Object getFeedChainLock() {
            return this.feedChainLock;
        }

        public final Job getFeedChainTail() {
            return this.feedChainTail;
        }

        public final AtomicBoolean getFirstTokenRecorded() {
            return this.firstTokenRecorded;
        }

        public final zb.a<lb.n> getOnStreamComplete() {
            return this.onStreamComplete;
        }

        public final ContentParams getParams() {
            return this.params;
        }

        public final AITaskRecord getRecord() {
            return this.record;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public int hashCode() {
            IInferenceCallback iInferenceCallback = this.callback;
            int iD = ai.onnxruntime.a.d(this.callerUid, (iInferenceCallback == null ? 0 : iInferenceCallback.hashCode()) * 31, 31);
            ContentParams contentParams = this.params;
            int iHashCode = (iD + (contentParams == null ? 0 : contentParams.hashCode())) * 31;
            AITaskRecord aITaskRecord = this.record;
            return this.firstTokenRecorded.hashCode() + ((this.closing.hashCode() + ((this.feedChainLock.hashCode() + ((((((this.channel.hashCode() + ((this.onStreamComplete.hashCode() + v1.d.a((iHashCode + (aITaskRecord == null ? 0 : aITaskRecord.hashCode())) * 31, 31, this.traceId)) * 31)) * 31) + (this.consumerJob == null ? 0 : this.consumerJob.hashCode())) * 31) + (this.feedChainTail != null ? this.feedChainTail.hashCode() : 0)) * 31)) * 31)) * 31);
        }

        public final void setConsumerJob(Job job) {
            this.consumerJob = job;
        }

        public final void setFeedChainTail(Job job) {
            this.feedChainTail = job;
        }

        public String toString() {
            return "LocalStreamSession(callback=" + this.callback + ", callerUid=" + this.callerUid + ", params=" + this.params + ", record=" + this.record + ", traceId=" + this.traceId + ", onStreamComplete=" + this.onStreamComplete + ", channel=" + this.channel + ", consumerJob=" + this.consumerJob + ", feedChainTail=" + this.feedChainTail + ", feedChainLock=" + this.feedChainLock + ", closing=" + this.closing + ", firstTokenRecorded=" + this.firstTokenRecorded + ")";
        }

        public /* synthetic */ LocalStreamSession(IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, AITaskRecord aITaskRecord, String str, zb.a aVar, Channel channel, Job job, Job job2, Object obj, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, int i11, kotlin.jvm.internal.e eVar) {
            this(iInferenceCallback, i10, contentParams, aITaskRecord, str, aVar, channel, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? null : job, (i11 & 256) != 0 ? null : job2, (i11 & VadSessionManager.FRAME_BYTES) != 0 ? new Object() : obj, (i11 & 1024) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i11 & 2048) != 0 ? new AtomicBoolean(false) : atomicBoolean2);
        }
    }
}
