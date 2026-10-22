package com.stepos.core.model.task;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.lifecycle.j0;
import b7.j;
import b7.k;
import com.stepos.aicgroup.f;
import com.stepos.base.awareness.data.SceneType;
import com.stepos.base.awareness.data.ThermalState;
import com.stepos.base.concurrency.data.PoolType;
import com.stepos.base.health.EngineMetrics;
import com.stepos.base.model.InferenceConfig;
import com.stepos.base.model.ModelLoadException;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.base.task.data.TaskState;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.common.memory.NativeMemoryBridge;
import com.stepos.core.common.telemetry.AiPowerEventBus;
import com.stepos.core.common.telemetry.FailStage;
import com.stepos.core.common.telemetry.Hardware;
import com.stepos.core.common.telemetry.ModelCallOutcome;
import com.stepos.core.common.telemetry.ModelCallSessionTracker;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.common.telemetry.RecordStatus;
import com.stepos.core.common.telemetry.scene.AiStageSceneDonator;
import com.stepos.core.device.awareness.DefaultSceneAwareness;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.concurrency.PressureCancelledException;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import com.stepos.core.model.inference.InferenceBackendSelector;
import com.stepos.core.model.inference.InferenceExecutorImpl;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.model.policy.PolicyEngine;
import com.stepos.core.model.resilience.CircuitBreaker;
import com.stepos.core.model.resilience.CircuitBreakerStatistics;
import com.stepos.core.model.resilience.FlowController;
import com.stepos.core.model.resilience.FlowStatistics;
import com.stepos.core.model.resilience.IWatchdog;
import com.stepos.core.model.resilience.WatchdogImpl;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import com.stepos.core.performance.data.EnrichedVerdict;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.data.PerformanceRequestContext;
import com.stepos.core.performance.orchestrator.PerformanceOrchestratorImpl;
import com.stepos.core.performance.signal.SignalHub;
import j7.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import p6.b;
import p6.g;
import v6.c;
import zb.l;
import zb.p;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AITaskSupervisor implements j7.c {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_CAUSE_DEPTH = 8;
    private static final String TAG = "AITaskSupervisor";
    private static volatile AITaskSupervisor instance;
    private final InferenceBackendSelector backendSelector;
    private final CircuitBreaker circuitBreaker;
    private final Context context;
    private final FlowController flowController;
    private final lb.d inferenceExecutor$delegate;
    private boolean initialized;
    private final List<g> lifecycleObservers;
    private final lb.d orchestrator$delegate;
    private final PolicyEngine policyEngine;
    private final PriorityArbiterImpl priorityArbiter;
    private final q6.a sceneAwareness;
    private final AITaskStack taskStack;
    private final t6.b threadPoolManager;
    private final IWatchdog watchdog;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final AITaskSupervisor getInstance(Context context) {
            AITaskSupervisor aITaskSupervisor;
            kotlin.jvm.internal.g.f(context, "context");
            AITaskSupervisor aITaskSupervisor2 = AITaskSupervisor.instance;
            if (aITaskSupervisor2 != null) {
                return aITaskSupervisor2;
            }
            synchronized (this) {
                aITaskSupervisor = AITaskSupervisor.instance;
                if (aITaskSupervisor == null) {
                    Context applicationContext = context.getApplicationContext();
                    kotlin.jvm.internal.g.e(applicationContext, "getApplicationContext(...)");
                    aITaskSupervisor = new AITaskSupervisor(applicationContext, null);
                    AITaskSupervisor.instance = aITaskSupervisor;
                    c.a.f9709a = aITaskSupervisor;
                }
            }
            return aITaskSupervisor;
        }

        public final void resetForTesting$model_release() {
            AITaskSupervisor.instance = null;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskSessionState.values().length];
            try {
                iArr[TaskSessionState.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskSessionState.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TaskSessionState.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TaskSessionState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TaskSessionState.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TaskSessionState.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TaskSessionState.TIMEOUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.task.AITaskSupervisor$submitTask$5", f = "AITaskSupervisor.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.task.AITaskSupervisor$submitTask$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements q<FlowCollector<? super Result<? extends Object>>, Throwable, qb.b<? super n>, Object> {
        final /* synthetic */ TaskSession $session;
        final /* synthetic */ AITaskRecord $taskRecord;
        int label;
        final /* synthetic */ AITaskSupervisor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(TaskSession taskSession, AITaskRecord aITaskRecord, AITaskSupervisor aITaskSupervisor, qb.b<? super AnonymousClass5> bVar) {
            super(3, bVar);
            this.$session = taskSession;
            this.$taskRecord = aITaskRecord;
            this.this$0 = aITaskSupervisor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            d7.a aVar;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            this.$session.setBackend(this.$taskRecord.getBackend());
            this.$session.setModelCacheHit(this.$taskRecord.getModelCacheHit());
            this.$session.setPreprocessTimeMs(this.$taskRecord.getPreprocessTimeMs());
            this.$session.setInferenceTimeMs(this.$taskRecord.getInferenceTimeMs());
            this.$session.setPostprocessTimeMs(this.$taskRecord.getPostprocessTimeMs());
            this.$session.setSuccess(this.$taskRecord.getSuccess());
            this.$session.setErrorCode(this.$taskRecord.getErrorCode());
            this.$session.setErrorMessage(this.$taskRecord.getErrorMessage());
            int tokenCount = this.$taskRecord.getTokenCount();
            TaskSession taskSession = this.$session;
            for (int i10 = 0; i10 < tokenCount; i10++) {
                taskSession.recordToken();
            }
            TaskInvokeRecord record = this.$session.toRecord();
            TaskHistory.INSTANCE.record(record);
            AITaskSupervisor aITaskSupervisor = this.this$0;
            String modelId = this.$taskRecord.getModelId();
            k modelConfig = this.$taskRecord.getModelConfig();
            aITaskSupervisor.syncTaskHistoryToSignalHub(modelId, (modelConfig == null || (aVar = modelConfig.f3097i) == null) ? 0L : aVar.f8393b);
            a0.a.v("TaskHistory recorded: ", record.toLogString(), AITaskSupervisor.TAG);
            return n.f10413a;
        }

        @Override // zb.q
        public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, Throwable th, qb.b<? super n> bVar) {
            return new AnonymousClass5(this.$session, this.$taskRecord, this.this$0, bVar).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.task.AITaskSupervisor$submitToThreadPool$1", f = "AITaskSupervisor.kt", l = {531}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.task.AITaskSupervisor$submitToThreadPool$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements l<qb.b<? super Flow<? extends Result<? extends Object>>>, Object> {
        final /* synthetic */ r6.a $decision;
        final /* synthetic */ AITaskRecord $taskRecord;
        int label;
        final /* synthetic */ AITaskSupervisor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AITaskRecord aITaskRecord, AITaskSupervisor aITaskSupervisor, r6.a aVar, qb.b<? super AnonymousClass1> bVar) {
            super(1, bVar);
            this.$taskRecord = aITaskRecord;
            this.this$0 = aITaskSupervisor;
            this.$decision = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(qb.b<?> bVar) {
            return new AnonymousClass1(this.$taskRecord, this.this$0, this.$decision, bVar);
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
            AITaskRecord aITaskRecord = this.$taskRecord;
            InferenceExecutorImpl inferenceExecutor = this.this$0.getInferenceExecutor();
            r6.a aVar = this.$decision;
            this.label = 1;
            Object objExecute = aITaskRecord.execute(inferenceExecutor, aVar, this);
            return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
            return ((AnonymousClass1) create(bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.task.AITaskSupervisor$submitToThreadPool$2", f = "AITaskSupervisor.kt", l = {536}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.task.AITaskSupervisor$submitToThreadPool$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements l<qb.b<? super Flow<? extends Result<? extends Object>>>, Object> {
        final /* synthetic */ r6.a $decision;
        final /* synthetic */ AITaskRecord $taskRecord;
        int label;
        final /* synthetic */ AITaskSupervisor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AITaskRecord aITaskRecord, AITaskSupervisor aITaskSupervisor, r6.a aVar, qb.b<? super AnonymousClass2> bVar) {
            super(1, bVar);
            this.$taskRecord = aITaskRecord;
            this.this$0 = aITaskSupervisor;
            this.$decision = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(qb.b<?> bVar) {
            return new AnonymousClass2(this.$taskRecord, this.this$0, this.$decision, bVar);
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
            AITaskRecord aITaskRecord = this.$taskRecord;
            InferenceExecutorImpl inferenceExecutor = this.this$0.getInferenceExecutor();
            r6.a aVar = this.$decision;
            this.label = 1;
            Object objExecute = aITaskRecord.execute(inferenceExecutor, aVar, this);
            return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
            return ((AnonymousClass2) create(bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.task.AITaskSupervisor$submitToThreadPool$3", f = "AITaskSupervisor.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.task.AITaskSupervisor$submitToThreadPool$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<FlowCollector<? super Result<? extends Object>>, qb.b<? super n>, Object> {
        final /* synthetic */ AITaskRecord $taskRecord;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AITaskRecord aITaskRecord, qb.b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$taskRecord = aITaskRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return AITaskSupervisor.this.new AnonymousClass3(this.$taskRecord, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            AITaskSupervisor.this.handleTaskStart(this.$taskRecord);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass3) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.task.AITaskSupervisor$submitToThreadPool$4", f = "AITaskSupervisor.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.task.AITaskSupervisor$submitToThreadPool$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements q<FlowCollector<? super Result<? extends Object>>, Throwable, qb.b<? super n>, Object> {
        final /* synthetic */ AITaskRecord $taskRecord;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AITaskRecord aITaskRecord, qb.b<? super AnonymousClass4> bVar) {
            super(3, bVar);
            this.$taskRecord = aITaskRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            AITaskSupervisor.this.handleTaskCompletion(this.$taskRecord, (Throwable) this.L$0);
            return n.f10413a;
        }

        @Override // zb.q
        public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, Throwable th, qb.b<? super n> bVar) {
            AnonymousClass4 anonymousClass4 = AITaskSupervisor.this.new AnonymousClass4(this.$taskRecord, bVar);
            anonymousClass4.L$0 = th;
            return anonymousClass4.invokeSuspend(n.f10413a);
        }
    }

    public /* synthetic */ AITaskSupervisor(Context context, e eVar) {
        this(context);
    }

    private final TaskPriority clampPriorityByTrust(TaskPriority requested, int i10, boolean z) {
        TaskPriority.f6396b.getClass();
        kotlin.jvm.internal.g.f(requested, "requested");
        TaskPriority taskPriority = TaskPriority.f6397c;
        return requested != taskPriority ? requested : ((i10 == 0 || i10 < 10000) && z) ? taskPriority : TaskPriority.f6398d;
    }

    private final Integer codeOf(Throwable th) {
        Integer numValueOf = Integer.valueOf(AIEngineError.QUOTA_EXCEEDED);
        if (th instanceof InferenceException) {
            return Integer.valueOf(((InferenceException) th).getErrorCode());
        }
        if (th instanceof CircuitBreakerOpenException) {
            return Integer.valueOf(AIEngineError.CIRCUIT_BREAKER_OPEN);
        }
        if ((th instanceof BackpressureException) || (th instanceof com.stepos.core.model.concurrency.BackpressureException)) {
            return numValueOf;
        }
        if (th instanceof PressureCancelledException) {
            return Integer.valueOf(AIEngineError.PRESSURE_CANCELLED);
        }
        if (!(th instanceof ModelLoadException)) {
            return null;
        }
        Integer num = ((ModelLoadException) th).f6319a;
        return Integer.valueOf(num != null ? num.intValue() : AIEngineError.MODEL_LOAD_FAILED);
    }

    private final void enqueueTask(AITaskRecord aITaskRecord) {
        Log.d(TAG, "任务入队 ...");
        aITaskRecord.transitionTo(AITaskState.QUEUED);
        markStage(aITaskRecord, FailStage.QUEUE_WAIT);
        AiEngineAtrace.begin(aITaskRecord.getId(), "infer", "queue_wait");
        this.taskStack.enqueue(aITaskRecord);
        Log.d(TAG, "✅ TaskStack 入队完成，等待数: " + this.taskStack.getWaitingCount() + ", 运行数: " + this.taskStack.getRunningCount());
    }

    private final r6.a enrichAndDecide(AITaskRecord aITaskRecord) {
        Object objA;
        Log.d(TAG, "获取场景信息 ...");
        SceneType currentScene = this.sceneAwareness.getCurrentScene();
        r6.b systemLoad = this.sceneAwareness.getSystemLoad();
        ThermalState thermalState = systemLoad.h;
        aITaskRecord.setSceneId(currentScene.name());
        float f8 = systemLoad.f11748a;
        aITaskRecord.setSystemLoad(f8);
        aITaskRecord.setThermalState(thermalState.ordinal());
        Log.d(TAG, "✅ 场景信息: scene=" + currentScene.name() + ", load=" + f8 + "%, thermal=" + thermalState.name());
        Log.d(TAG, "优先级仲裁 ...");
        markStage(aITaskRecord, FailStage.PRIORITY_ARBITRATE);
        TaskPriority taskPriorityExtractRequestedPriority = extractRequestedPriority(aITaskRecord);
        if (taskPriorityExtractRequestedPriority != null) {
            aITaskRecord.setPriority(taskPriorityExtractRequestedPriority);
            Log.d(TAG, "请求优先级（已 clamp）: " + taskPriorityExtractRequestedPriority + " uid=" + aITaskRecord.getCallerUid() + " fg=" + aITaskRecord.isForeground());
        }
        TaskPriority taskPriorityClampPriorityByTrust = clampPriorityByTrust(this.priorityArbiter.calculate(aITaskRecord, currentScene.name(), f8, thermalState.ordinal()), aITaskRecord.getCallerUid(), aITaskRecord.isForeground());
        aITaskRecord.setPriority(taskPriorityClampPriorityByTrust);
        aITaskRecord.setPriorityScore(this.priorityArbiter.getScore(aITaskRecord, currentScene.name(), f8, thermalState.ordinal()));
        Log.d(TAG, "✅ 优先级仲裁: priority=" + taskPriorityClampPriorityByTrust + ", score=" + aITaskRecord.getPriorityScore());
        b7.b modelCache = getModelCache();
        ModelCacheImpl modelCacheImpl = modelCache instanceof ModelCacheImpl ? (ModelCacheImpl) modelCache : null;
        if (modelCacheImpl != null) {
            try {
                modelCacheImpl.recordAcquireTier(aITaskRecord.getModelId(), aITaskRecord.getPriority());
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                EngineMetrics.f6238n.incrementAndGet();
                a0.a.A("recordAcquireTier failed: ", thB.getMessage(), TAG);
            }
        } else {
            EngineMetrics.f6239o.incrementAndGet();
            ai.onnxruntime.a.x("recordAcquireTier skipped: modelCache is not ModelCacheImpl (impl=", getModelCache().getClass().getSimpleName(), ")", TAG);
        }
        GlobalVerdict globalVerdictCachedVerdict = getOrchestrator().cachedVerdict();
        String modelId = aITaskRecord.getModelId();
        TaskPriority priority = aITaskRecord.getPriority();
        p6.b bVar = p6.b.f11432e;
        p6.b bVarA = b.a.a(aITaskRecord.getAbilityId());
        long timeoutMs = aITaskRecord.getTimeoutMs();
        Long lValueOf = Long.valueOf(timeoutMs);
        if (timeoutMs <= 0) {
            lValueOf = null;
        }
        long jLongValue = AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS;
        long jLongValue2 = lValueOf != null ? lValueOf.longValue() : 30000L;
        boolean zIsForeground = aITaskRecord.isForeground();
        long timeoutMs2 = aITaskRecord.getTimeoutMs();
        Long lValueOf2 = Long.valueOf(timeoutMs2);
        if (timeoutMs2 <= 0) {
            lValueOf2 = null;
        }
        if (lValueOf2 != null) {
            jLongValue = lValueOf2.longValue();
        }
        EnrichedVerdict enrichedVerdictEnrich = getOrchestrator().enrich(globalVerdictCachedVerdict, new PerformanceRequestContext(modelId, priority, bVarA, 2048, 1, jLongValue2, zIsForeground, jLongValue));
        this.flowController.updateMaxConcurrent(enrichedVerdictEnrich.getGlobal().getMaxConcurrent());
        this.circuitBreaker.updateThresholds(enrichedVerdictEnrich.getGlobal().getCbFailureThreshold(), enrichedVerdictEnrich.getGlobal().getCbResetTimeoutMs());
        Log.d(TAG, "策略决策 ...");
        r6.a aVarMakeDecision = this.policyEngine.makeDecision(aITaskRecord, currentScene, systemLoad);
        long timeoutMs3 = enrichedVerdictEnrich.getTimeoutMs();
        Long lValueOf3 = timeoutMs3 > 0 ? Long.valueOf(timeoutMs3) : null;
        long jLongValue3 = lValueOf3 != null ? lValueOf3.longValue() : aVarMakeDecision.f11741e;
        aITaskRecord.setOomAdj(enrichedVerdictEnrich.getThreadCount() * 100);
        PoolType.a aVar = PoolType.f6214b;
        TaskPriority priority2 = aITaskRecord.getPriority();
        aVar.getClass();
        aITaskRecord.setThreadPool(PoolType.a.a(priority2).name());
        aITaskRecord.setTimeoutMs(jLongValue3);
        Log.d(TAG, "✅ 性能编排+Policy 决策: backend=" + enrichedVerdictEnrich.getRecommendedBackend() + ", timeout=" + jLongValue3 + "ms, threads=" + enrichedVerdictEnrich.getThreadCount());
        return r6.a.a(aVarMakeDecision, null, enrichedVerdictEnrich.getThreadCount(), jLongValue3, 0, 4071);
    }

    private final TaskPriority extractRequestedPriority(AITaskRecord aITaskRecord) {
        Bundle bundleInputExtras = inputExtras(aITaskRecord.getInput());
        if (bundleInputExtras == null || !bundleInputExtras.containsKey("task_priority")) {
            return null;
        }
        TaskPriority.a aVar = TaskPriority.f6396b;
        int i10 = bundleInputExtras.getInt("task_priority", 2);
        aVar.getClass();
        return clampPriorityByTrust(TaskPriority.a.a(i10), aITaskRecord.getCallerUid(), aITaskRecord.isForeground());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InferenceExecutorImpl getInferenceExecutor() {
        return (InferenceExecutorImpl) this.inferenceExecutor$delegate.getValue();
    }

    private final b7.b getModelCache() {
        ModelCacheImpl modelCacheImpl = j.f3087b;
        if (modelCacheImpl != null) {
            return modelCacheImpl;
        }
        throw new IllegalStateException("IModelCache not registered. Call ModelCacheHolder.register() at application startup.");
    }

    private final PerformanceOrchestratorImpl getOrchestrator() {
        return (PerformanceOrchestratorImpl) this.orchestrator$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void handleTaskCompletion(final AITaskRecord aITaskRecord, Throwable th) {
        Object objA;
        Object objA2;
        Throwable exc;
        if (!aITaskRecord.getCancelledByWatchdog()) {
            AITaskState aiState = aITaskRecord.getAiState();
            AITaskState aITaskState = AITaskState.TIMEOUT;
            if (aiState != aITaskState) {
                Log.d(TAG, "◀ 任务执行完成: " + aITaskRecord.getId() + ", error=" + th);
                this.watchdog.cancel(aITaskRecord.getId());
                final long jCurrentTimeMillis = System.currentTimeMillis() - aITaskRecord.getCreatedAt();
                boolean zIsBenignFlowAbortAfterFirstElement = AITaskSupervisorKt.isBenignFlowAbortAfterFirstElement(th);
                boolean zIsCircuitBreakerNeutralCancellation = AITaskSupervisorKt.isCircuitBreakerNeutralCancellation(th);
                Object[] objArr = aITaskRecord.getErrorCode() != 0;
                String str = "inference failed";
                Object objA3 = null;
                if ((th == null || zIsBenignFlowAbortAfterFirstElement) && !objArr == true) {
                    if (zIsBenignFlowAbortAfterFirstElement) {
                        a0.a.v("◀ 视为成功（下游仅消费部分 Flow，如 first()）: ", aITaskRecord.getId(), TAG);
                    }
                    aITaskRecord.transitionTo(AITaskState.COMPLETED);
                    aITaskRecord.setSuccess(true);
                    this.circuitBreaker.recordSuccess();
                    this.taskStack.markCompleted(aITaskRecord.getId(), true);
                    this.taskStack.remove(aITaskRecord.getId());
                    Log.d(TAG, "✅ 任务成功完成");
                    notifyObservers(new l() { // from class: com.stepos.core.model.task.c
                        @Override // zb.l
                        public final Object invoke(Object obj) {
                            return AITaskSupervisor.handleTaskCompletion$lambda$18(aITaskRecord, jCurrentTimeMillis, (g) obj);
                        }
                    });
                } else if (zIsCircuitBreakerNeutralCancellation && objArr != true) {
                    a0.a.v("◀ 协作取消，不计入熔断: ", aITaskRecord.getId(), TAG);
                    aITaskRecord.transitionTo(AITaskState.CANCELLED);
                    aITaskRecord.setSuccess(false);
                    aITaskRecord.setErrorMessage(th != null ? th.getMessage() : null);
                    this.taskStack.markCompleted(aITaskRecord.getId(), false);
                    this.taskStack.remove(aITaskRecord.getId());
                    notifyObservers(new b(aITaskRecord, 1));
                } else if (th instanceof TimeoutCancellationException) {
                    aITaskRecord.transitionTo(aITaskState);
                    aITaskRecord.setSuccess(false);
                    if (aITaskRecord.getErrorCode() == 0) {
                        aITaskRecord.setErrorCode(AIEngineError.TIMEOUT);
                    }
                    TimeoutCancellationException timeoutCancellationException = (TimeoutCancellationException) th;
                    aITaskRecord.setErrorMessage(timeoutCancellationException.getMessage());
                    this.circuitBreaker.recordFailure();
                    this.taskStack.markCompleted(aITaskRecord.getId(), false);
                    this.taskStack.remove(aITaskRecord.getId());
                    Log.w(TAG, "⏱ 任务超时: " + timeoutCancellationException.getMessage());
                    notifyObservers(new f(3, aITaskRecord, timeoutCancellationException));
                } else {
                    aITaskRecord.setSuccess(false);
                    if (aITaskRecord.getErrorCode() == 0) {
                        aITaskRecord.setErrorCode(th != null ? resolveErrorCode(th) : AIEngineError.INFERENCE_FAILED);
                    }
                    String errorMessage = aITaskRecord.getErrorMessage();
                    if (errorMessage == null || errorMessage.length() == 0) {
                        aITaskRecord.setErrorMessage(th != null ? th.getMessage() : null);
                    }
                    this.circuitBreaker.recordFailure();
                    this.taskStack.markCompleted(aITaskRecord.getId(), false);
                    this.taskStack.remove(aITaskRecord.getId());
                    a0.a.u("❌ 任务失败: code=", aITaskRecord.getErrorCode(), ", ", aITaskRecord.getErrorMessage(), TAG);
                    if (th == null) {
                        String errorMessage2 = aITaskRecord.getErrorMessage();
                        if (errorMessage2 == null) {
                            errorMessage2 = "inference failed";
                        }
                        exc = new Exception(errorMessage2);
                    } else {
                        exc = th;
                    }
                    if (th instanceof CancellationException) {
                        notifyObservers(new b(aITaskRecord, 2));
                    } else {
                        notifyObservers(new f(4, aITaskRecord, exc));
                    }
                }
                try {
                    Object powerTracker = aITaskRecord.getPowerTracker();
                    PowerPerfTracker powerPerfTracker = powerTracker instanceof PowerPerfTracker ? (PowerPerfTracker) powerTracker : null;
                    if (powerPerfTracker != null) {
                        powerPerfTracker.setQueuedAtMonoNs(aITaskRecord.getQueuedAtMonoNs());
                        powerPerfTracker.setStartedAtMonoNs(aITaskRecord.getStartedAtMonoNs());
                        if (aITaskRecord.getAiState() == AITaskState.CANCELLED) {
                            powerPerfTracker.getStatus().set(RecordStatus.CANCELLED);
                            if (aITaskRecord.getErrorCode() != 0) {
                                powerPerfTracker.getErrorCode().set(aITaskRecord.getErrorCode());
                            }
                        } else if (aITaskRecord.getAiState() == aITaskState) {
                            powerPerfTracker.getStatus().set(RecordStatus.TIMEOUT);
                            if (aITaskRecord.getErrorCode() != 0) {
                                powerPerfTracker.getErrorCode().set(aITaskRecord.getErrorCode());
                            }
                        } else if (!aITaskRecord.getSuccess()) {
                            powerPerfTracker.getStatus().set(RecordStatus.FAILED);
                            powerPerfTracker.getErrorCode().set(aITaskRecord.getErrorCode());
                        }
                        if (!aITaskRecord.getSuccess()) {
                            if (th != null) {
                                powerPerfTracker.recordFailure(th);
                            } else if (powerPerfTracker.getFailClass().length() == 0) {
                                String errorMessage3 = aITaskRecord.getErrorMessage();
                                if (errorMessage3 != null) {
                                    str = errorMessage3;
                                }
                                powerPerfTracker.recordFailure(new Exception(str));
                            }
                        }
                        if (kotlin.jvm.internal.g.b(powerPerfTracker.getCurrentStage().get(), FailStage.QUEUE_WAIT)) {
                            PoolType.a aVar = PoolType.f6214b;
                            TaskPriority finalTier = aITaskRecord.getFinalTier();
                            if (finalTier == null) {
                                finalTier = aITaskRecord.getPriority();
                            }
                            aVar.getClass();
                            PoolType poolTypeA = PoolType.a.a(finalTier);
                            t6.b bVar = this.threadPoolManager;
                            ThreadPoolManagerImpl threadPoolManagerImpl = bVar instanceof ThreadPoolManagerImpl ? (ThreadPoolManagerImpl) bVar : null;
                            if (threadPoolManagerImpl != null && threadPoolManagerImpl.isDispatchGateClosed(poolTypeA)) {
                                powerPerfTracker.markStage(FailStage.DISPATCH_GATE_WAIT);
                            }
                        }
                        powerPerfTracker.setExecutionLocation(aITaskRecord.getExecutionLocation().name());
                        TaskPriority finalTier2 = aITaskRecord.getFinalTier();
                        if (finalTier2 == null) {
                            finalTier2 = aITaskRecord.getPriority();
                        }
                        powerPerfTracker.setPriority(finalTier2.name());
                        try {
                            Iterator<T> it = powerPerfTracker.drainOpenScenes().iterator();
                            while (it.hasNext()) {
                                AiStageSceneDonator.INSTANCE.onStageAbort(((Number) it.next()).intValue(), powerPerfTracker.isForeground(), powerPerfTracker.getModelId());
                            }
                            objA2 = n.f10413a;
                        } catch (Throwable th2) {
                            objA2 = kotlin.c.a(th2);
                        }
                        Throwable thB = Result.b(objA2);
                        if (thB != null) {
                            Log.w(TAG, "scene abort compensation failed for task " + aITaskRecord.getId() + ": " + thB.getMessage());
                        }
                        if (powerPerfTracker.shouldPublish() && powerPerfTracker.tryClaimPublish()) {
                            AiPowerEventBus.INSTANCE.post(powerPerfTracker.buildRecord(SystemClock.elapsedRealtimeNanos()));
                        }
                        objA3 = n.f10413a;
                    }
                } catch (Throwable th3) {
                    objA3 = kotlin.c.a(th3);
                }
                Throwable thB2 = Result.b(objA3);
                if (thB2 != null) {
                    a0.a.w("telemetry publish failed for task ", aITaskRecord.getId(), ": ", thB2.getMessage(), TAG);
                }
                try {
                    if (aITaskRecord.getReportModelCallTerminal() && kotlin.jvm.internal.g.b(aITaskRecord.getExecutionLocation().name(), "LOCAL")) {
                        ModelCallSessionTracker.reportTerminalOnce$default(ModelCallSessionTracker.INSTANCE, aITaskRecord.getId(), aITaskRecord.getAiState() == AITaskState.CANCELLED ? ModelCallOutcome.CANCELLED : aITaskRecord.getAiState() == AITaskState.TIMEOUT ? ModelCallOutcome.TIMEOUT : !aITaskRecord.getSuccess() ? ModelCallOutcome.FAILED : ModelCallOutcome.SUCCESS, aITaskRecord.getErrorCode(), null, 8, null);
                    }
                    objA = n.f10413a;
                } catch (Throwable th4) {
                    objA = kotlin.c.a(th4);
                }
                Throwable thB3 = Result.b(objA);
                if (thB3 != null) {
                    a0.a.w("model_call flywheel publish failed for task ", aITaskRecord.getId(), ": ", thB3.getMessage(), TAG);
                }
                AiEngineAtrace.endAll(aITaskRecord.getId());
                this.flowController.release();
                Log.d(TAG, "━━━━━━━━━━ submitTask 结束 ━━━━━━━━━━");
                return;
            }
        }
        StringBuilder sbF = h0.e.f("[Watchdog] Late native completion after timeout, refusing to overwrite TIMEOUT state: taskId=", aITaskRecord.getId(), ", nativeChars=", aITaskRecord.getNativeProducedChars(), ", error=");
        sbF.append(th);
        Log.w(TAG, sbF.toString());
        this.watchdog.cancel(aITaskRecord.getId());
        AiEngineAtrace.endAll(aITaskRecord.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n handleTaskCompletion$lambda$18(AITaskRecord aITaskRecord, long j10, g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onAfterInfer(aITaskRecord.getId(), aITaskRecord.getModelId(), j10);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n handleTaskCompletion$lambda$19(AITaskRecord aITaskRecord, g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onInferCancelled(aITaskRecord.getId(), aITaskRecord.getModelId());
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n handleTaskCompletion$lambda$20(AITaskRecord aITaskRecord, Throwable th, g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onInferError(aITaskRecord.getId(), aITaskRecord.getModelId(), th);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n handleTaskCompletion$lambda$22(AITaskRecord aITaskRecord, g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onInferCancelled(aITaskRecord.getId(), aITaskRecord.getModelId());
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n handleTaskCompletion$lambda$23(AITaskRecord aITaskRecord, Throwable th, g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onInferError(aITaskRecord.getId(), aITaskRecord.getModelId(), th);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleTaskStart(AITaskRecord aITaskRecord) {
        a0.a.v("▶ 任务开始执行: ", aITaskRecord.getId(), TAG);
        aITaskRecord.transitionTo(AITaskState.RUNNING);
        try {
            Object powerTracker = aITaskRecord.getPowerTracker();
            PowerPerfTracker powerPerfTracker = powerTracker instanceof PowerPerfTracker ? (PowerPerfTracker) powerTracker : null;
            if (powerPerfTracker != null) {
                powerPerfTracker.setQueuedAtMonoNs(aITaskRecord.getQueuedAtMonoNs());
                powerPerfTracker.setStartedAtMonoNs(aITaskRecord.getStartedAtMonoNs());
                n nVar = n.f10413a;
            }
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        this.taskStack.markRunning(aITaskRecord);
        notifyObservers(new b(aITaskRecord, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n handleTaskStart$lambda$16(AITaskRecord aITaskRecord, g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onBeforeInfer(aITaskRecord.getId(), aITaskRecord.getModelId());
        return n.f10413a;
    }

    private final void handleTaskTimeout(AITaskRecord aITaskRecord) {
        long timeoutMs = aITaskRecord.getTimeoutMs();
        long jCurrentTimeMillis = System.currentTimeMillis() - aITaskRecord.getCreatedAt();
        StringBuilder sbS = ai.onnxruntime.a.s("[Watchdog] Task timeout: taskId=", aITaskRecord.getId(), ", modelId=", aITaskRecord.getModelId(), ", configuredMs=");
        sbS.append(timeoutMs);
        sbS.append(", aliveMs=");
        sbS.append(jCurrentTimeMillis);
        Log.w(TAG, sbS.toString());
        aITaskRecord.setCancelledByWatchdog(true);
        aITaskRecord.setCancelReason("watchdog_timeout");
        aITaskRecord.setErrorCode(AIEngineError.TIMEOUT);
        aITaskRecord.setErrorMessage("watchdog timeout: configured=" + timeoutMs + "ms");
        aITaskRecord.transitionTo(AITaskState.TIMEOUT);
        AtomicLong atomicLong = EngineMetrics.f6226a;
        EngineMetrics.f6240p.incrementAndGet();
        InferenceExecutorImpl inferenceExecutor = getInferenceExecutor();
        if (inferenceExecutor == null) {
            inferenceExecutor = null;
        }
        if (inferenceExecutor != null) {
            inferenceExecutor.deliverErrorAndCancel(aITaskRecord.getId(), AIEngineError.TIMEOUT, ai.onnxruntime.a.h(timeoutMs, "watchdog timeout: configured=", "ms"));
        } else {
            getInferenceExecutor().cancel(aITaskRecord.getId());
        }
        this.taskStack.remove(aITaskRecord.getId());
        this.circuitBreaker.recordFailure();
        AiEngineAtrace.endAll(aITaskRecord.getId());
        this.flowController.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InferenceExecutorImpl inferenceExecutor_delegate$lambda$0(AITaskSupervisor aITaskSupervisor) {
        return new InferenceExecutorImpl(aITaskSupervisor.backendSelector, aITaskSupervisor.getModelCache(), null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialize$lambda$2(AITaskSupervisor aITaskSupervisor) {
        return aITaskSupervisor.flowController.isIdle();
    }

    private final Bundle inputExtras(Object obj) {
        if (obj instanceof c.g) {
            return ((c.g) obj).f13418d;
        }
        if (obj instanceof c.e) {
            return ((c.e) obj).f13411d;
        }
        if (obj instanceof c.f) {
            return ((c.f) obj).f13414d;
        }
        if (obj instanceof c.a) {
            return ((c.a) obj).f13392i;
        }
        if (obj instanceof c.C0155c) {
            return ((c.C0155c) obj).f13405l;
        }
        return null;
    }

    private final TaskPriority mapPriority(r6.a aVar) {
        long j10 = aVar.f11741e;
        return j10 <= TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS ? TaskPriority.f6397c : j10 <= AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS ? TaskPriority.f6398d : j10 <= HysteresisStrategy.DEFAULT_DWELL_MS ? TaskPriority.f6399e : TaskPriority.h;
    }

    private final void markStage(AITaskRecord aITaskRecord, String str) {
        Object powerTracker = aITaskRecord.getPowerTracker();
        PowerPerfTracker powerPerfTracker = powerTracker instanceof PowerPerfTracker ? (PowerPerfTracker) powerTracker : null;
        if (powerPerfTracker != null) {
            powerPerfTracker.markStage(str);
        }
    }

    private final void notifyObservers(l<? super g, n> lVar) {
        List listO0;
        synchronized (this.lifecycleObservers) {
            listO0 = kotlin.collections.a.O0(this.lifecycleObservers);
        }
        Iterator it = listO0.iterator();
        while (it.hasNext()) {
            try {
                lVar.invoke((g) it.next());
            } catch (Exception e10) {
                a0.a.A("Lifecycle observer error: ", e10.getMessage(), TAG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PerformanceOrchestratorImpl orchestrator_delegate$lambda$1(AITaskSupervisor aITaskSupervisor) {
        return PerformanceOrchestratorImpl.Companion.getInstance(aITaskSupervisor.context);
    }

    private final Flow<Result<Object>> performPreChecks(AITaskRecord aITaskRecord) {
        Log.d(TAG, "FlowController.tryAcquire() ...");
        markStage(aITaskRecord, FailStage.FLOW_CONTROL);
        FlowController.AcquireResult acquireResultTryAcquire = this.flowController.tryAcquire();
        if (!acquireResultTryAcquire.getAcquired()) {
            Log.w(TAG, "❌ FlowController 拒绝：系统繁忙, retryAfterMs=" + acquireResultTryAcquire.getRetryAfterMs());
            return FlowKt.flowOf(new Result(kotlin.c.a(new BackpressureException("系统繁忙，请稍后重试", acquireResultTryAcquire.getRetryAfterMs()))));
        }
        Log.d(TAG, "✅ FlowController 允许通过");
        Log.d(TAG, "CircuitBreaker.allowRequest() ...");
        markStage(aITaskRecord, FailStage.CIRCUIT_BREAKER);
        if (this.circuitBreaker.allowRequest()) {
            Log.d(TAG, "✅ CircuitBreaker 允许通过");
            return null;
        }
        Log.w(TAG, "❌ CircuitBreaker 熔断：服务不可用");
        this.flowController.release();
        return FlowKt.flowOf(new Result(kotlin.c.a(new CircuitBreakerOpenException("服务暂时不可用，请稍后重试"))));
    }

    private final void prepareTask(AITaskRecord aITaskRecord) {
        if (aITaskRecord.getModelConfig() == null) {
            aITaskRecord.setModelConfig(getModelCache().getAcquiredConfig(aITaskRecord.getModelId()));
            if (aITaskRecord.getModelConfig() == null) {
                Log.w(TAG, h0.e.c("prepareTask: no acquired config for modelId=", aITaskRecord.getModelId(), " (ability=", aITaskRecord.getAbilityId(), "); model likely evicted mid-flight"));
            }
        }
        if (aITaskRecord.getModelType() == null) {
            k modelConfig = aITaskRecord.getModelConfig();
            aITaskRecord.setModelType(modelConfig != null ? modelConfig.c(ProtocolType.f6379b) ? "VLM" : "LLM" : null);
        }
    }

    private final int resolveErrorCode(Throwable th) {
        int i10 = 0;
        while (th != null && i10 < 8) {
            Integer numCodeOf = codeOf(th);
            if (numCodeOf != null) {
                return numCodeOf.intValue();
            }
            Throwable cause = th.getCause();
            if (cause == th) {
                return AIEngineError.INFERENCE_FAILED;
            }
            i10++;
            th = cause;
        }
        return AIEngineError.INFERENCE_FAILED;
    }

    private final void startWatchdog(AITaskRecord aITaskRecord, long j10) {
        Log.d(TAG, "Watchdog.watch() timeout=" + j10 + "ms");
        this.watchdog.watch(aITaskRecord.getId(), j10, new android.llama.cpp.b(7, this, aITaskRecord));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n startWatchdog$lambda$13(AITaskSupervisor aITaskSupervisor, AITaskRecord aITaskRecord) {
        aITaskSupervisor.handleTaskTimeout(aITaskRecord);
        return n.f10413a;
    }

    private final Flow<Result<Object>> submitToThreadPool(AITaskRecord aITaskRecord, r6.a aVar) {
        r6.a aVar2;
        Flow<Result<Object>> flowSubmitFlow;
        Log.d(TAG, "ThreadPoolManager.submitFlow() ...");
        t6.b bVar = this.threadPoolManager;
        ThreadPoolManagerImpl threadPoolManagerImpl = bVar instanceof ThreadPoolManagerImpl ? (ThreadPoolManagerImpl) bVar : null;
        if (threadPoolManagerImpl != null) {
            String id2 = aITaskRecord.getId();
            TaskPriority finalTier = aITaskRecord.getFinalTier();
            if (finalTier == null) {
                finalTier = aITaskRecord.getPriority();
            }
            aVar2 = aVar;
            flowSubmitFlow = threadPoolManagerImpl.submitFlow(id2, finalTier, aVar2, aITaskRecord.getCallerUid(), new AnonymousClass1(aITaskRecord, this, aVar, null));
            if (flowSubmitFlow == null) {
            }
            return FlowKt.onCompletion(FlowKt.onStart(flowSubmitFlow, new AnonymousClass3(aITaskRecord, null)), new AnonymousClass4(aITaskRecord, null));
        }
        aVar2 = aVar;
        t6.b bVar2 = this.threadPoolManager;
        String id3 = aITaskRecord.getId();
        TaskPriority finalTier2 = aITaskRecord.getFinalTier();
        if (finalTier2 == null) {
            finalTier2 = aITaskRecord.getPriority();
        }
        flowSubmitFlow = bVar2.submitFlow(id3, finalTier2, aVar2, new AnonymousClass2(aITaskRecord, this, aVar2, null));
        return FlowKt.onCompletion(FlowKt.onStart(flowSubmitFlow, new AnonymousClass3(aITaskRecord, null)), new AnonymousClass4(aITaskRecord, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncTaskHistoryToSignalHub(String str, long j10) {
        try {
            SignalHub signalHub = getOrchestrator().signalHub();
            TaskHistory taskHistory = TaskHistory.INSTANCE;
            signalHub.updateModelHistory(str, taskHistory.getAverageInitTimeMs(str), j10, taskHistory.getAverageInvokeTimeMs(str), taskHistory.getAverageTtftMs(str));
            signalHub.invalidate();
        } catch (Exception e10) {
            a0.a.A("syncTaskHistoryToSignalHub: ", e10.getMessage(), TAG);
        }
    }

    @Override // j7.c
    public AutoCloseable acquireAllOrNull(long j10) {
        return this.flowController.acquireAllOrNull(j10);
    }

    public final void addLifecycleObserver(g observer) {
        kotlin.jvm.internal.g.f(observer, "observer");
        synchronized (this.lifecycleObservers) {
            this.lifecycleObservers.add(observer);
        }
    }

    public boolean cancel(String taskId) {
        kotlin.jvm.internal.g.f(taskId, "taskId");
        cancelTask(taskId);
        return true;
    }

    public void cancelAll() {
        this.watchdog.cancelAll();
        this.taskStack.clear();
    }

    public final void cancelTask(String taskId) {
        kotlin.jvm.internal.g.f(taskId, "taskId");
        getInferenceExecutor().cancel(taskId);
        this.watchdog.cancel(taskId);
        this.taskStack.markCancelled(taskId);
        AiEngineAtrace.end(taskId, "infer", "queue_wait");
    }

    public final Object clearCache(qb.b<? super n> bVar) {
        this.watchdog.cancelAll();
        this.taskStack.clear();
        return n.f10413a;
    }

    public final ResilienceStatistics getResilienceStatistics() {
        FlowStatistics statistics = this.flowController.getStatistics();
        CircuitBreakerStatistics statistics2 = this.circuitBreaker.getStatistics();
        IWatchdog iWatchdog = this.watchdog;
        WatchdogImpl watchdogImpl = iWatchdog instanceof WatchdogImpl ? (WatchdogImpl) iWatchdog : null;
        return new ResilienceStatistics(statistics, statistics2, watchdogImpl != null ? watchdogImpl.getStatistics() : null);
    }

    public int getRunningCount() {
        return this.taskStack.getRunningCount();
    }

    public TaskState getTaskState(String taskId) {
        kotlin.jvm.internal.g.f(taskId, "taskId");
        AITaskRecord task = this.taskStack.getTask(taskId);
        if (task != null) {
            return task.getState();
        }
        TaskSession session = this.taskStack.getSession(taskId);
        if (session == null) {
            return null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[session.getState().ordinal()]) {
            case 1:
                return TaskState.f6403a;
            case 2:
                return TaskState.f6404b;
            case 3:
                return TaskState.f6405c;
            case 4:
                return TaskState.f6406d;
            case 5:
                return TaskState.h;
            case 6:
                return TaskState.f6407e;
            case 7:
                return TaskState.f6408j;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public int getWaitingCount() {
        return this.taskStack.getWaitingCount();
    }

    public final void initialize() {
        if (this.initialized) {
            Log.w(TAG, "AITaskSupervisor already initialized");
            return;
        }
        Log.i(TAG, "━━━━━━━━━━ AITaskSupervisor.initialize() ━━━━━━━━━━");
        Log.i(TAG, "✅ SceneAwareness: ".concat(this.sceneAwareness.getClass().getSimpleName()));
        Log.i(TAG, "✅ PolicyEngine: initialized");
        Log.i(TAG, "✅ ThreadPoolManager: initialized");
        Log.i(TAG, "✅ InferenceExecutor: initialized");
        Log.i(TAG, "✅ FlowController: maxConcurrent=8 (fail-fast, retryAfterMs=100)");
        NativeMemoryBridge.setIdleGate(new d(this, 0));
        Log.i(TAG, "✅ NativeMemoryBridge.idleGate: bound to FlowController");
        Log.i(TAG, "✅ CircuitBreaker: failureThreshold=5");
        Log.i(TAG, "✅ Watchdog: initialized");
        Log.i(TAG, "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        this.initialized = true;
    }

    @Override // j7.c
    public boolean isIdle() {
        return this.flowController.isIdle();
    }

    public final boolean isInitialized() {
        return this.initialized;
    }

    public final void notifyLifecycleObservers(l<? super g, n> action) {
        kotlin.jvm.internal.g.f(action, "action");
        notifyObservers(action);
    }

    public final void removeLifecycleObserver(g observer) {
        kotlin.jvm.internal.g.f(observer, "observer");
        synchronized (this.lifecycleObservers) {
            this.lifecycleObservers.remove(observer);
        }
    }

    public final void resetCircuitBreaker() {
        this.circuitBreaker.reset();
    }

    public void schedule(j7.b task, r6.a decision) {
        kotlin.jvm.internal.g.f(task, "task");
        kotlin.jvm.internal.g.f(decision, "decision");
        a0.a.v("schedule task: ", task.getId(), TAG);
    }

    public final void shutdown() {
        this.threadPoolManager.shutdown();
        this.watchdog.cancelAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0091, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r1).collect(r4, r2) == r3) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, kotlin.Result$Failure] */
    /* renamed from: submit-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m108submityxL6bBk(java.lang.String r24, java.lang.String r25, java.lang.Object r26, h7.b r27, qb.b<? super kotlin.Result<? extends java.lang.Object>> r28) {
        /*
            r23 = this;
            r0 = r23
            r1 = r28
            boolean r2 = r1 instanceof com.stepos.core.model.task.AITaskSupervisor$submit$1
            if (r2 == 0) goto L17
            r2 = r1
            com.stepos.core.model.task.AITaskSupervisor$submit$1 r2 = (com.stepos.core.model.task.AITaskSupervisor$submit$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.stepos.core.model.task.AITaskSupervisor$submit$1 r2 = new com.stepos.core.model.task.AITaskSupervisor$submit$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L42
            if (r4 == r6) goto L3a
            if (r4 != r5) goto L32
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
            kotlin.c.b(r1)
            goto L94
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
            kotlin.c.b(r1)
            goto L82
        L42:
            kotlin.c.b(r1)
            j7.e r7 = new j7.e
            r20 = 0
            r21 = 7921(0x1ef1, float:1.11E-41)
            r8 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r9 = r24
            r10 = r25
            r11 = r26
            r15 = r27
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r20, r21)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            java.lang.Exception r4 = new java.lang.Exception
            java.lang.String r8 = "No result"
            r4.<init>(r8)
            kotlin.Result$Failure r4 = kotlin.c.a(r4)
            r1.f10076a = r4
            r2.L$0 = r1
            r2.label = r6
            java.lang.Object r0 = r0.submitTask(r7, r2)
            if (r0 != r3) goto L7d
            goto L93
        L7d:
            r22 = r1
            r1 = r0
            r0 = r22
        L82:
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            com.stepos.core.model.task.AITaskSupervisor$submit$2 r4 = new com.stepos.core.model.task.AITaskSupervisor$submit$2
            r4.<init>()
            r2.L$0 = r0
            r2.label = r5
            java.lang.Object r1 = r1.collect(r4, r2)
            if (r1 != r3) goto L94
        L93:
            return r3
        L94:
            T r0 = r0.f10076a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.task.AITaskSupervisor.m108submityxL6bBk(java.lang.String, java.lang.String, java.lang.Object, h7.b, qb.b):java.lang.Object");
    }

    public Object submitStream(String str, String str2, Object obj, h7.b bVar, qb.b<? super Flow<? extends Result<? extends Object>>> bVar2) {
        return submitTask(new j7.e(null, str, str2, obj, 0, 0, null, bVar, false, null, 0L, false, 7921), bVar2);
    }

    public final Object submitTask(j7.e eVar, qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
        String strName;
        InferenceConfig inferenceConfig;
        InferenceConfig.ComputeDevice computeDevice;
        InferenceConfig inferenceConfig2;
        TaskSession taskSession = new TaskSession(eVar);
        Log.d(TAG, "━━━━━━━━━━ submitTask(TaskRequest) 开始 ━━━━━━━━━━");
        String str = eVar.f9710a;
        String str2 = eVar.f9711b;
        String str3 = eVar.f9712c;
        StringBuilder sbS = ai.onnxruntime.a.s("TaskId: ", str, ", AbilityId: ", str2, ", ModelId: ");
        sbS.append(str3);
        Log.d(TAG, sbS.toString());
        AITaskRecord aITaskRecord = new AITaskRecord(eVar.f9710a, eVar.f9716g, eVar.f9714e, eVar.f9715f, eVar.f9718j, eVar.h, 0L, eVar.f9711b, null, 0L, null, null, eVar.f9712c, null, null, 0L, false, eVar.f9713d, null, false, false, null, 0.0f, 0, null, 0, 0, null, null, 0L, null, null, null, null, 0L, 0L, 0L, null, 0L, 0, null, false, 0, null, false, null, 0, 0, null, 0L, 0L, false, eVar.f9717i, -135360, 1048575, null);
        aITaskRecord.setPowerTracker(eVar.f9719k);
        aITaskRecord.setReportModelCallTerminal(eVar.f9721m);
        long j10 = eVar.f9720l;
        if (j10 > 0) {
            aITaskRecord.setTimeoutMs(j10);
        }
        prepareTask(aITaskRecord);
        if (aITaskRecord.getPowerTracker() == null) {
            k modelConfig = aITaskRecord.getModelConfig();
            String id2 = aITaskRecord.getId();
            Integer num = new Integer(aITaskRecord.getCallerUid());
            if (num.intValue() == 0) {
                num = null;
            }
            int iIntValue = num != null ? num.intValue() : Process.myUid();
            String callerPackage = aITaskRecord.getCallerPackage();
            if (gc.q.t0(callerPackage)) {
                callerPackage = this.context.getPackageName();
            }
            String str4 = callerPackage;
            kotlin.jvm.internal.g.e(str4, "ifBlank(...)");
            String abilityId = aITaskRecord.getAbilityId();
            String modelId = aITaskRecord.getModelId();
            boolean zIsForeground = aITaskRecord.isForeground();
            String str5 = (modelConfig == null || (inferenceConfig2 = modelConfig.f3096g) == null) ? null : inferenceConfig2.f6263a;
            if (str5 == null) {
                str5 = "";
            }
            String str6 = str5;
            if (modelConfig == null || (inferenceConfig = modelConfig.f3096g) == null || (computeDevice = inferenceConfig.f6264b) == null || (strName = Hardware.Companion.fromComputeDevice(computeDevice).name()) == null) {
                strName = ModelFlowMeta.PLAN_NONE;
            }
            aITaskRecord.setPowerTracker(new PowerPerfTracker(id2, iIntValue, str4, abilityId, modelId, zIsForeground, str6, strName, null, 0L, 0L, 1792, null));
            Log.d(TAG, "[Phase] created default PowerPerfTracker for local TaskRequest: taskId=" + aITaskRecord.getId() + ", modelId=" + aITaskRecord.getModelId());
        }
        taskSession.setModelConfig(aITaskRecord.getModelConfig());
        taskSession.setModelType(aITaskRecord.getModelType());
        Flow<Result<Object>> flowPerformPreChecks = performPreChecks(aITaskRecord);
        if (flowPerformPreChecks != null) {
            return flowPerformPreChecks;
        }
        r6.a aVarEnrichAndDecide = enrichAndDecide(aITaskRecord);
        taskSession.setSceneId(aITaskRecord.getSceneId());
        taskSession.setSystemLoad(aITaskRecord.getSystemLoad());
        taskSession.setThermalState(aITaskRecord.getThermalState());
        taskSession.setPriority(aITaskRecord.getPriority());
        taskSession.setPriorityScore(aITaskRecord.getPriorityScore());
        taskSession.setTimeoutMs(aITaskRecord.getTimeoutMs());
        taskSession.setThreadPool(aITaskRecord.getThreadPool());
        Object powerTracker = aITaskRecord.getPowerTracker();
        PowerPerfTracker powerPerfTracker = powerTracker instanceof PowerPerfTracker ? (PowerPerfTracker) powerTracker : null;
        if (powerPerfTracker != null) {
            TaskPriority finalTier = aITaskRecord.getFinalTier();
            if (finalTier == null) {
                finalTier = aITaskRecord.getPriority();
            }
            powerPerfTracker.setPriority(finalTier.name());
        }
        enqueueTask(aITaskRecord);
        this.taskStack.enqueue(taskSession);
        startWatchdog(aITaskRecord, aVarEnrichAndDecide.f11741e);
        return FlowKt.onCompletion(submitToThreadPool(aITaskRecord, aVarEnrichAndDecide), new AnonymousClass5(taskSession, aITaskRecord, this, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AITaskSupervisor(Context context) {
        this.context = context;
        this.taskStack = new AITaskStack();
        DefaultSceneAwareness defaultSceneAwareness = new DefaultSceneAwareness(null, null, null, 7, null);
        this.sceneAwareness = defaultSceneAwareness;
        this.priorityArbiter = PriorityArbiterImpl.Companion.forContext(context);
        this.policyEngine = new PolicyEngine(defaultSceneAwareness);
        int i10 = 1;
        this.threadPoolManager = new ThreadPoolManagerImpl(null, i10, 0 == true ? 1 : 0);
        this.backendSelector = new InferenceBackendSelector();
        this.inferenceExecutor$delegate = kotlin.b.b(new j0(this, 5));
        this.flowController = new FlowController(8);
        this.circuitBreaker = new CircuitBreaker(5, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS, 0, 4, null);
        this.watchdog = new WatchdogImpl(0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        this.orchestrator$delegate = kotlin.b.b(new d(this, 1));
        this.lifecycleObservers = new ArrayList();
    }

    public final Object submitTask(AITaskRecord aITaskRecord, qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
        Log.d(TAG, "━━━━━━━━━━ submitTask 开始 ━━━━━━━━━━");
        Log.d(TAG, "TaskId: " + aITaskRecord.getId());
        Log.d(TAG, "AbilityId: " + aITaskRecord.getAbilityId() + ", ModelId: " + aITaskRecord.getModelId());
        prepareTask(aITaskRecord);
        Flow<Result<Object>> flowPerformPreChecks = performPreChecks(aITaskRecord);
        if (flowPerformPreChecks != null) {
            return flowPerformPreChecks;
        }
        r6.a aVarEnrichAndDecide = enrichAndDecide(aITaskRecord);
        enqueueTask(aITaskRecord);
        startWatchdog(aITaskRecord, aVarEnrichAndDecide.f11741e);
        return submitToThreadPool(aITaskRecord, aVarEnrichAndDecide);
    }
}
