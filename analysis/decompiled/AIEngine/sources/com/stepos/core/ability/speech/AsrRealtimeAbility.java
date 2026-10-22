package com.stepos.core.ability.speech;

import ai.onnxruntime.BuildConfig;
import android.content.Context;
import com.stepos.base.ability.AbilityBase;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.base.strategy.ExecutionPreference;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.cloud.AccountLoginState;
import com.stepos.core.common.cloud.AuthHeaderResult;
import com.stepos.core.common.cloud.RealtimeAsrProxy;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.data.ContentParams;
import com.stepos.core.model.task.AITaskRecord;
import java.util.Locale;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrRealtimeAbility extends AbilityBase<c.a, d.q> implements StreamingCapableAbility {
    private final String TAG;
    private final AsrLocalStreamSessionManager localStreamManager;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeAbility$buildOrchestrator$1, reason: invalid class name */
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
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeAbility$createCloudWsSession$1", f = "AsrRealtimeAbility.kt", l = {109}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeAbility$createCloudWsSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03221 extends SuspendLambda implements zb.l<qb.b<? super AuthHeaderResult>, Object> {
        final /* synthetic */ AsrCloudConfig $cfg;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03221(AsrCloudConfig asrCloudConfig, qb.b<? super C03221> bVar) {
            super(1, bVar);
            this.$cfg = asrCloudConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return new C03221(this.$cfg, bVar);
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
            return ((C03221) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeAbility$doFlowInfer$2", f = "AsrRealtimeAbility.kt", l = {61}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeAbility$doFlowInfer$2, reason: invalid class name */
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
                Result result = new Result(a0.a.r("stepos-asr-realtime is streaming-only; use recognize() (open/write/close), not infer()"));
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
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeAbility", f = "AsrRealtimeAbility.kt", l = {134, 135}, m = BuildConfig.BUILD_TYPE)
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeAbility$release$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03231(qb.b<? super C03231> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrRealtimeAbility.this.release(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrRealtimeAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        kotlin.jvm.internal.g.f(abilityConfig, "abilityConfig");
        this.TAG = "AsrRealtimeAbility";
        this.localStreamManager = new AsrLocalStreamSessionManager("AsrRealtimeAbility", new AsrRealtimeAbility$localStreamManager$1(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.core.ability.speech.AsrCloudConfig buildCloudConfig(java.lang.String r19, com.stepos.core.data.ContentParams r20) {
        /*
            r18 = this;
            r0 = r19
            p6.a r1 = r18.getAbilityConfig()
            boolean r2 = r1.f11424j
            java.util.Map<java.lang.String, p6.c> r3 = r1.f11426l
            r4 = 0
            if (r2 != 0) goto Le
            return r4
        Le:
            if (r0 == 0) goto L2a
            boolean r2 = gc.q.t0(r0)
            if (r2 != 0) goto L20
            java.lang.String r2 = "unknown"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L20
            r2 = r0
            goto L21
        L20:
            r2 = r4
        L21:
            if (r2 == 0) goto L2a
            boolean r5 = r3.containsKey(r2)
            if (r5 == 0) goto L2a
            goto L2b
        L2a:
            r2 = r4
        L2b:
            if (r2 == 0) goto L34
            java.lang.Object r2 = r3.get(r2)
            r4 = r2
            p6.c r4 = (p6.c) r4
        L34:
            com.stepos.core.ability.speech.AsrCloudConfig r5 = new com.stepos.core.ability.speech.AsrCloudConfig
            long r6 = r1.f11423i
            com.stepos.core.common.cloud.RealtimeAsrProxy r2 = com.stepos.core.common.cloud.RealtimeAsrProxy.INSTANCE
            java.lang.String r12 = r2.wsEndpoint()
            p6.c r2 = r1.f11425k
            p6.c r13 = r2.c(r4)
            java.lang.String r2 = ""
            java.lang.String r15 = r1.d(r0, r2)
            r16 = 6
            r17 = 0
            r8 = 0
            r10 = 0
            r14 = r20
            r5.<init>(r6, r8, r10, r12, r13, r14, r15, r16, r17)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrRealtimeAbility.buildCloudConfig(java.lang.String, com.stepos.core.data.ContentParams):com.stepos.core.ability.speech.AsrCloudConfig");
    }

    public static /* synthetic */ AsrCloudConfig buildCloudConfig$default(AsrRealtimeAbility asrRealtimeAbility, String str, ContentParams contentParams, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            contentParams = null;
        }
        return asrRealtimeAbility.buildCloudConfig(str, contentParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n createCloudWsSession$lambda$0() {
        RealtimeAsrProxy.INSTANCE.invalidate();
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e7.a requireAudioProtocol() {
        return (e7.a) getProtocolManager().b(ProtocolType.f6380c);
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
        AsrCloudConfig asrCloudConfigBuildCloudConfig$default = buildCloudConfig$default(this, null, null, 3, null);
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
        AsrCloudConfig asrCloudConfigBuildCloudConfig = buildCloudConfig(str, contentParams);
        if (asrCloudConfigBuildCloudConfig == null) {
            return null;
        }
        requireCloudSceneType(str);
        return new AsrCloudWsSession(asrCloudConfigBuildCloudConfig, new C03221(asrCloudConfigBuildCloudConfig, null), new b(1), str2);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.a) cVar, obj, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m56doInfergIAlus((c.a) cVar, (qb.b<? super Result<d.q>>) bVar);
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
            boolean r0 = r7 instanceof com.stepos.core.ability.speech.AsrRealtimeAbility.C03231
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ability.speech.AsrRealtimeAbility$release$1 r0 = (com.stepos.core.ability.speech.AsrRealtimeAbility.C03231) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.AsrRealtimeAbility$release$1 r0 = new com.stepos.core.ability.speech.AsrRealtimeAbility$release$1
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
            com.stepos.core.ability.speech.AsrRealtimeAbility r5 = (com.stepos.core.ability.speech.AsrRealtimeAbility) r5
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrRealtimeAbility.release(com.stepos.base.model.ModelReleaseReason, qb.b):java.lang.Object");
    }

    @Override // com.stepos.core.ability.speech.StreamingCapableAbility
    public String requireCloudSceneType(String str) {
        return CloudSceneTypeGuard.require$default(CloudSceneTypeGuard.INSTANCE, getAbilityConfig(), str, null, 4, null);
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
    public d.q defaultOutput() {
        return new d.q("", null, null, 6);
    }

    public Object doFlowInfer(c.a aVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(null));
    }

    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    public Object m56doInfergIAlus(c.a aVar, qb.b<? super Result<d.q>> bVar) {
        return a0.a.r("stepos-asr-realtime is streaming-only; use recognize() (open/write/close), not infer()");
    }
}
