package com.stepos.core.model.task;

import android.os.SystemClock;
import b7.k;
import com.stepos.base.inference.data.BackendType;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.base.task.data.TaskState;
import com.stepos.base.task.data.TaskType;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.telemetry.ModelCallSessionTracker;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.model.inference.InferenceExecutorImpl;
import com.stepos.core.ota.crypto.CryptoHeaderParser;
import h7.e;
import java.util.Iterator;
import java.util.UUID;
import k7.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.m;
import v6.d;
import x6.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AITaskRecord implements j7.b, j7.d {
    public static final Companion Companion = new Companion(null);
    private TaskPriority _priority;
    private AITaskState _state;
    private final String abilityId;
    private String backend;
    private final String callerPackage;
    private final int callerPid;
    private final int callerUid;
    private String cancelReason;
    private boolean cancelledByWatchdog;
    private boolean circuitBroken;
    private Long completedAt;
    private h7.b constraints;
    private final long createdAt;
    private final long createdAtMonoNs;
    private int dropAfterCancelChars;
    private int errorCode;
    private String errorMessage;
    private ExecutionLocation executionLocation;
    private TaskPriority finalTier;
    private Long firstTokenAt;
    private boolean flowControlled;

    /* renamed from: id, reason: collision with root package name */
    private final String f7473id;
    private long inferenceTimeMs;
    private Object input;
    private long inputSize;
    private String inputType;
    private boolean isForeground;
    private boolean modelCacheHit;
    private k modelConfig;
    private final String modelId;
    private long modelLoadTimeMs;
    private String modelType;
    private int nativeProducedChars;
    private int oomAdj;
    private String orchestrationReason;
    private long postprocessTimeMs;
    private transient Object powerTracker;
    private long preprocessTimeMs;
    private int priorityScore;
    private Long queuedAt;
    private long queuedAtMonoNs;
    private boolean reportModelCallTerminal;
    private e routingDecision;
    private String sceneId;
    private Long startedAt;
    private long startedAtMonoNs;
    private boolean success;
    private float systemLoad;
    private int thermalState;
    private String threadName;
    private String threadPool;
    private long timeToFirstToken;
    private long timeoutMs;
    private int tokenCount;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public static /* synthetic */ AITaskRecord create$default(Companion companion, String str, String str2, Object obj, String str3, boolean z, int i10, Object obj2) {
            if ((i10 & 4) != 0) {
                obj = null;
            }
            Object obj3 = obj;
            if ((i10 & 8) != 0) {
                str3 = "";
            }
            String str4 = str3;
            if ((i10 & 16) != 0) {
                z = true;
            }
            return companion.create(str, str2, obj3, str4, z);
        }

        public final AITaskRecord create(String abilityId, String modelId, Object obj, String callerPackage, boolean z) {
            g.f(abilityId, "abilityId");
            g.f(modelId, "modelId");
            g.f(callerPackage, "callerPackage");
            return new AITaskRecord(null, callerPackage, 0, 0, z, 0L, 0L, abilityId, null, 0L, null, null, modelId, null, null, 0L, false, obj, null, false, false, null, 0.0f, 0, null, 0, 0, null, null, 0L, null, null, null, null, 0L, 0L, 0L, null, 0L, 0, null, false, 0, null, false, null, 0, 0, null, 0L, 0L, false, null, -135315, 2097151, null);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AITaskState.values().length];
            try {
                iArr[AITaskState.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AITaskState.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AITaskState.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AITaskState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AITaskState.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AITaskState.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AITaskState.TIMEOUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TaskState.values().length];
            try {
                TaskState taskState = TaskState.f6403a;
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                TaskState taskState2 = TaskState.f6403a;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                TaskState taskState3 = TaskState.f6403a;
                iArr2[2] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                TaskState taskState4 = TaskState.f6403a;
                iArr2[3] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                TaskState taskState5 = TaskState.f6403a;
                iArr2[5] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                TaskState taskState6 = TaskState.f6403a;
                iArr2[4] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                TaskState taskState7 = TaskState.f6403a;
                iArr2[6] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.task.AITaskRecord$execute$2", f = "AITaskRecord.kt", l = {281}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.task.AITaskRecord$execute$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<ProducerScope<? super Result<? extends Object>>, qb.b<? super n>, Object> {
        final /* synthetic */ r6.a $decision;
        final /* synthetic */ x6.b $inferenceExecutor;
        final /* synthetic */ AITaskRecord $record;
        final /* synthetic */ Object $taskInput;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(x6.b bVar, AITaskRecord aITaskRecord, Object obj, r6.a aVar, qb.b<? super AnonymousClass2> bVar2) {
            super(2, bVar2);
            this.$inferenceExecutor = bVar;
            this.$record = aITaskRecord;
            this.$taskInput = obj;
            this.$decision = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$inferenceExecutor, this.$record, this.$taskInput, this.$decision, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                x6.b bVar = this.$inferenceExecutor;
                String id2 = this.$record.getId();
                Object obj2 = this.$taskInput;
                r6.a aVar = this.$decision;
                final AITaskRecord aITaskRecord = this.$record;
                bVar.executeStream(id2, 0L, obj2, aVar, new b.c() { // from class: com.stepos.core.model.task.AITaskRecord.execute.2.1
                    @Override // x6.b.c
                    public void onComplete(y6.c result) {
                        g.f(result, "result");
                        boolean z = result.f14156b;
                        BackendType backendType = result.h;
                        if (backendType != null) {
                            aITaskRecord.setBackend(backendType.name());
                        }
                        aITaskRecord.setTokenCount(result.f14158d);
                        aITaskRecord.setTimeToFirstToken(result.f14159e);
                        aITaskRecord.setInferenceTimeMs(result.f14160f);
                        aITaskRecord.setPreprocessTimeMs(result.f14164k);
                        aITaskRecord.setPostprocessTimeMs(result.f14165l);
                        aITaskRecord.setModelCacheHit(result.f14166m);
                        aITaskRecord.setSuccess(z);
                        if (!z) {
                            aITaskRecord.setErrorCode(result.f14162i);
                            aITaskRecord.setErrorMessage(result.f14163j);
                        }
                        SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                    }

                    @Override // x6.b.c
                    public void onDropAfterCancel(int i11) {
                        AITaskRecord aITaskRecord2 = aITaskRecord;
                        aITaskRecord2.setDropAfterCancelChars(aITaskRecord2.getDropAfterCancelChars() + i11);
                    }

                    @Override // x6.b.c
                    public void onError(int i11, String message, Throwable th) {
                        g.f(message, "message");
                        onError(i11, message);
                    }

                    @Override // x6.b.c
                    public void onOutput(Object output) {
                        g.f(output, "output");
                        aITaskRecord.recordFirstToken();
                        int length = output instanceof d.q ? ((d.q) output).f13487a.length() : output instanceof String ? ((String) output).length() : 0;
                        if (length > 0) {
                            AITaskRecord aITaskRecord2 = aITaskRecord;
                            aITaskRecord2.setNativeProducedChars(aITaskRecord2.getNativeProducedChars() + length);
                        }
                        producerScope.mo149trySendJP2dKIU(new Result<>(output));
                    }

                    @Override // x6.b.c
                    public void onError(int i11, String message) {
                        g.f(message, "message");
                        aITaskRecord.setErrorCode(i11);
                        aITaskRecord.setErrorMessage(message);
                        aITaskRecord.setSuccess(false);
                        producerScope.mo149trySendJP2dKIU(new Result<>(kotlin.c.a(new IllegalStateException("Inference error: ".concat(message)))));
                        SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                    }
                });
                a aVar2 = new a();
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, aVar2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(ProducerScope<? super Result<? extends Object>> producerScope, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(producerScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    public AITaskRecord(String id2, String callerPackage, int i10, int i11, boolean z, long j10, long j11, String abilityId, String str, long j12, ExecutionLocation executionLocation, String orchestrationReason, String modelId, String str2, k kVar, long j13, boolean z3, Object obj, AITaskState _state, boolean z10, boolean z11, String str3, float f8, int i12, TaskPriority _priority, int i13, int i14, TaskPriority taskPriority, Long l10, long j14, String str4, Long l11, String str5, String str6, long j15, long j16, long j17, Long l12, long j18, int i15, Long l13, boolean z12, int i16, String str7, boolean z13, String cancelReason, int i17, int i18, Object obj2, long j19, long j20, boolean z14, h7.b bVar) {
        g.f(id2, "id");
        g.f(callerPackage, "callerPackage");
        g.f(abilityId, "abilityId");
        g.f(executionLocation, "executionLocation");
        g.f(orchestrationReason, "orchestrationReason");
        g.f(modelId, "modelId");
        g.f(_state, "_state");
        g.f(_priority, "_priority");
        g.f(cancelReason, "cancelReason");
        this.f7473id = id2;
        this.callerPackage = callerPackage;
        this.callerUid = i10;
        this.callerPid = i11;
        this.isForeground = z;
        this.createdAt = j10;
        this.createdAtMonoNs = j11;
        this.abilityId = abilityId;
        this.inputType = str;
        this.inputSize = j12;
        this.executionLocation = executionLocation;
        this.orchestrationReason = orchestrationReason;
        this.modelId = modelId;
        this.modelType = str2;
        this.modelConfig = kVar;
        this.modelLoadTimeMs = j13;
        this.modelCacheHit = z3;
        this.input = obj;
        this._state = _state;
        this.flowControlled = z10;
        this.circuitBroken = z11;
        this.sceneId = str3;
        this.systemLoad = f8;
        this.thermalState = i12;
        this._priority = _priority;
        this.priorityScore = i13;
        this.oomAdj = i14;
        this.finalTier = taskPriority;
        this.queuedAt = l10;
        this.timeoutMs = j14;
        this.threadPool = str4;
        this.startedAt = l11;
        this.threadName = str5;
        this.backend = str6;
        this.preprocessTimeMs = j15;
        this.inferenceTimeMs = j16;
        this.postprocessTimeMs = j17;
        this.firstTokenAt = l12;
        this.timeToFirstToken = j18;
        this.tokenCount = i15;
        this.completedAt = l13;
        this.success = z12;
        this.errorCode = i16;
        this.errorMessage = str7;
        this.cancelledByWatchdog = z13;
        this.cancelReason = cancelReason;
        this.nativeProducedChars = i17;
        this.dropAfterCancelChars = i18;
        this.powerTracker = obj2;
        this.queuedAtMonoNs = j19;
        this.startedAtMonoNs = j20;
        this.reportModelCallTerminal = z14;
        this.constraints = bVar;
    }

    private final AITaskState component19() {
        return this._state;
    }

    private final TaskPriority component25() {
        return this._priority;
    }

    public static /* synthetic */ AITaskRecord copy$default(AITaskRecord aITaskRecord, String str, String str2, int i10, int i11, boolean z, long j10, long j11, String str3, String str4, long j12, ExecutionLocation executionLocation, String str5, String str6, String str7, k kVar, long j13, boolean z3, Object obj, AITaskState aITaskState, boolean z10, boolean z11, String str8, float f8, int i12, TaskPriority taskPriority, int i13, int i14, TaskPriority taskPriority2, Long l10, long j14, String str9, Long l11, String str10, String str11, long j15, long j16, long j17, Long l12, long j18, int i15, Long l13, boolean z12, int i16, String str12, boolean z13, String str13, int i17, int i18, Object obj2, long j19, long j20, boolean z14, h7.b bVar, int i19, int i20, Object obj3) {
        long j21;
        long j22;
        String str14 = (i19 & 1) != 0 ? aITaskRecord.f7473id : str;
        String str15 = (i19 & 2) != 0 ? aITaskRecord.callerPackage : str2;
        int i21 = (i19 & 4) != 0 ? aITaskRecord.callerUid : i10;
        int i22 = (i19 & 8) != 0 ? aITaskRecord.callerPid : i11;
        boolean z15 = (i19 & 16) != 0 ? aITaskRecord.isForeground : z;
        long j23 = (i19 & 32) != 0 ? aITaskRecord.createdAt : j10;
        long j24 = (i19 & 64) != 0 ? aITaskRecord.createdAtMonoNs : j11;
        String str16 = (i19 & TraceIdKeys.MAX_LENGTH) != 0 ? aITaskRecord.abilityId : str3;
        String str17 = (i19 & 256) != 0 ? aITaskRecord.inputType : str4;
        long j25 = (i19 & VadSessionManager.FRAME_BYTES) != 0 ? aITaskRecord.inputSize : j12;
        String str18 = str14;
        ExecutionLocation executionLocation2 = (i19 & 1024) != 0 ? aITaskRecord.executionLocation : executionLocation;
        String str19 = (i19 & 2048) != 0 ? aITaskRecord.orchestrationReason : str5;
        String str20 = (i19 & 4096) != 0 ? aITaskRecord.modelId : str6;
        String str21 = (i19 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? aITaskRecord.modelType : str7;
        k kVar2 = (i19 & 16384) != 0 ? aITaskRecord.modelConfig : kVar;
        String str22 = str15;
        long j26 = (i19 & 32768) != 0 ? aITaskRecord.modelLoadTimeMs : j13;
        boolean z16 = (i19 & 65536) != 0 ? aITaskRecord.modelCacheHit : z3;
        Object obj4 = (i19 & 131072) != 0 ? aITaskRecord.input : obj;
        AITaskState aITaskState2 = (i19 & 262144) != 0 ? aITaskRecord._state : aITaskState;
        boolean z17 = (i19 & 524288) != 0 ? aITaskRecord.flowControlled : z10;
        boolean z18 = (i19 & CryptoHeaderParser.MAX_BLOCK_SIZE) != 0 ? aITaskRecord.circuitBroken : z11;
        String str23 = (i19 & 2097152) != 0 ? aITaskRecord.sceneId : str8;
        float f9 = (i19 & 4194304) != 0 ? aITaskRecord.systemLoad : f8;
        int i23 = (i19 & 8388608) != 0 ? aITaskRecord.thermalState : i12;
        TaskPriority taskPriority3 = (i19 & 16777216) != 0 ? aITaskRecord._priority : taskPriority;
        int i24 = (i19 & 33554432) != 0 ? aITaskRecord.priorityScore : i13;
        int i25 = (i19 & 67108864) != 0 ? aITaskRecord.oomAdj : i14;
        TaskPriority taskPriority4 = (i19 & 134217728) != 0 ? aITaskRecord.finalTier : taskPriority2;
        Long l14 = (i19 & 268435456) != 0 ? aITaskRecord.queuedAt : l10;
        if ((i19 & 536870912) != 0) {
            j21 = j26;
            j22 = aITaskRecord.timeoutMs;
        } else {
            j21 = j26;
            j22 = j14;
        }
        Long l15 = l14;
        String str24 = (i19 & 1073741824) != 0 ? aITaskRecord.threadPool : str9;
        Long l16 = (i19 & Integer.MIN_VALUE) != 0 ? aITaskRecord.startedAt : l11;
        String str25 = (i20 & 1) != 0 ? aITaskRecord.threadName : str10;
        String str26 = (i20 & 2) != 0 ? aITaskRecord.backend : str11;
        return aITaskRecord.copy(str18, str22, i21, i22, z15, j23, j24, str16, str17, j25, executionLocation2, str19, str20, str21, kVar2, j21, z16, obj4, aITaskState2, z17, z18, str23, f9, i23, taskPriority3, i24, i25, taskPriority4, l15, j22, str24, l16, str25, str26, (i20 & 4) != 0 ? aITaskRecord.preprocessTimeMs : j15, (i20 & 8) != 0 ? aITaskRecord.inferenceTimeMs : j16, (i20 & 16) != 0 ? aITaskRecord.postprocessTimeMs : j17, (i20 & 32) != 0 ? aITaskRecord.firstTokenAt : l12, (i20 & 64) != 0 ? aITaskRecord.timeToFirstToken : j18, (i20 & TraceIdKeys.MAX_LENGTH) != 0 ? aITaskRecord.tokenCount : i15, (i20 & 256) != 0 ? aITaskRecord.completedAt : l13, (i20 & VadSessionManager.FRAME_BYTES) != 0 ? aITaskRecord.success : z12, (i20 & 1024) != 0 ? aITaskRecord.errorCode : i16, (i20 & 2048) != 0 ? aITaskRecord.errorMessage : str12, (i20 & 4096) != 0 ? aITaskRecord.cancelledByWatchdog : z13, (i20 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? aITaskRecord.cancelReason : str13, (i20 & 16384) != 0 ? aITaskRecord.nativeProducedChars : i17, (i20 & 32768) != 0 ? aITaskRecord.dropAfterCancelChars : i18, (i20 & 65536) != 0 ? aITaskRecord.powerTracker : obj2, (i20 & 131072) != 0 ? aITaskRecord.queuedAtMonoNs : j19, (i20 & 262144) != 0 ? aITaskRecord.startedAtMonoNs : j20, (i20 & 524288) != 0 ? aITaskRecord.reportModelCallTerminal : z14, (i20 & CryptoHeaderParser.MAX_BLOCK_SIZE) != 0 ? aITaskRecord.constraints : bVar);
    }

    public void cancel() {
        this._state = AITaskState.CANCELLED;
    }

    public final String component1() {
        return this.f7473id;
    }

    public final long component10() {
        return this.inputSize;
    }

    public final ExecutionLocation component11() {
        return this.executionLocation;
    }

    public final String component12() {
        return this.orchestrationReason;
    }

    public final String component13() {
        return this.modelId;
    }

    public final String component14() {
        return this.modelType;
    }

    public final k component15() {
        return this.modelConfig;
    }

    public final long component16() {
        return this.modelLoadTimeMs;
    }

    public final boolean component17() {
        return this.modelCacheHit;
    }

    public final Object component18() {
        return this.input;
    }

    public final String component2() {
        return this.callerPackage;
    }

    public final boolean component20() {
        return this.flowControlled;
    }

    public final boolean component21() {
        return this.circuitBroken;
    }

    public final String component22() {
        return this.sceneId;
    }

    public final float component23() {
        return this.systemLoad;
    }

    public final int component24() {
        return this.thermalState;
    }

    public final int component26() {
        return this.priorityScore;
    }

    public final int component27() {
        return this.oomAdj;
    }

    public final TaskPriority component28() {
        return this.finalTier;
    }

    public final Long component29() {
        return this.queuedAt;
    }

    public final int component3() {
        return this.callerUid;
    }

    public final long component30() {
        return this.timeoutMs;
    }

    public final String component31() {
        return this.threadPool;
    }

    public final Long component32() {
        return this.startedAt;
    }

    public final String component33() {
        return this.threadName;
    }

    public final String component34() {
        return this.backend;
    }

    public final long component35() {
        return this.preprocessTimeMs;
    }

    public final long component36() {
        return this.inferenceTimeMs;
    }

    public final long component37() {
        return this.postprocessTimeMs;
    }

    public final Long component38() {
        return this.firstTokenAt;
    }

    public final long component39() {
        return this.timeToFirstToken;
    }

    public final int component4() {
        return this.callerPid;
    }

    public final int component40() {
        return this.tokenCount;
    }

    public final Long component41() {
        return this.completedAt;
    }

    public final boolean component42() {
        return this.success;
    }

    public final int component43() {
        return this.errorCode;
    }

    public final String component44() {
        return this.errorMessage;
    }

    public final boolean component45() {
        return this.cancelledByWatchdog;
    }

    public final String component46() {
        return this.cancelReason;
    }

    public final int component47() {
        return this.nativeProducedChars;
    }

    public final int component48() {
        return this.dropAfterCancelChars;
    }

    public final Object component49() {
        return this.powerTracker;
    }

    public final boolean component5() {
        return this.isForeground;
    }

    public final long component50() {
        return this.queuedAtMonoNs;
    }

    public final long component51() {
        return this.startedAtMonoNs;
    }

    public final boolean component52() {
        return this.reportModelCallTerminal;
    }

    public final h7.b component53() {
        return this.constraints;
    }

    public final long component6() {
        return this.createdAt;
    }

    public final long component7() {
        return this.createdAtMonoNs;
    }

    public final String component8() {
        return this.abilityId;
    }

    public final String component9() {
        return this.inputType;
    }

    public final AITaskRecord copy(String id2, String callerPackage, int i10, int i11, boolean z, long j10, long j11, String abilityId, String str, long j12, ExecutionLocation executionLocation, String orchestrationReason, String modelId, String str2, k kVar, long j13, boolean z3, Object obj, AITaskState _state, boolean z10, boolean z11, String str3, float f8, int i12, TaskPriority _priority, int i13, int i14, TaskPriority taskPriority, Long l10, long j14, String str4, Long l11, String str5, String str6, long j15, long j16, long j17, Long l12, long j18, int i15, Long l13, boolean z12, int i16, String str7, boolean z13, String cancelReason, int i17, int i18, Object obj2, long j19, long j20, boolean z14, h7.b bVar) {
        g.f(id2, "id");
        g.f(callerPackage, "callerPackage");
        g.f(abilityId, "abilityId");
        g.f(executionLocation, "executionLocation");
        g.f(orchestrationReason, "orchestrationReason");
        g.f(modelId, "modelId");
        g.f(_state, "_state");
        g.f(_priority, "_priority");
        g.f(cancelReason, "cancelReason");
        return new AITaskRecord(id2, callerPackage, i10, i11, z, j10, j11, abilityId, str, j12, executionLocation, orchestrationReason, modelId, str2, kVar, j13, z3, obj, _state, z10, z11, str3, f8, i12, _priority, i13, i14, taskPriority, l10, j14, str4, l11, str5, str6, j15, j16, j17, l12, j18, i15, l13, z12, i16, str7, z13, cancelReason, i17, i18, obj2, j19, j20, z14, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AITaskRecord)) {
            return false;
        }
        AITaskRecord aITaskRecord = (AITaskRecord) obj;
        return g.b(this.f7473id, aITaskRecord.f7473id) && g.b(this.callerPackage, aITaskRecord.callerPackage) && this.callerUid == aITaskRecord.callerUid && this.callerPid == aITaskRecord.callerPid && this.isForeground == aITaskRecord.isForeground && this.createdAt == aITaskRecord.createdAt && this.createdAtMonoNs == aITaskRecord.createdAtMonoNs && g.b(this.abilityId, aITaskRecord.abilityId) && g.b(this.inputType, aITaskRecord.inputType) && this.inputSize == aITaskRecord.inputSize && this.executionLocation == aITaskRecord.executionLocation && g.b(this.orchestrationReason, aITaskRecord.orchestrationReason) && g.b(this.modelId, aITaskRecord.modelId) && g.b(this.modelType, aITaskRecord.modelType) && g.b(this.modelConfig, aITaskRecord.modelConfig) && this.modelLoadTimeMs == aITaskRecord.modelLoadTimeMs && this.modelCacheHit == aITaskRecord.modelCacheHit && g.b(this.input, aITaskRecord.input) && this._state == aITaskRecord._state && this.flowControlled == aITaskRecord.flowControlled && this.circuitBroken == aITaskRecord.circuitBroken && g.b(this.sceneId, aITaskRecord.sceneId) && Float.compare(this.systemLoad, aITaskRecord.systemLoad) == 0 && this.thermalState == aITaskRecord.thermalState && this._priority == aITaskRecord._priority && this.priorityScore == aITaskRecord.priorityScore && this.oomAdj == aITaskRecord.oomAdj && this.finalTier == aITaskRecord.finalTier && g.b(this.queuedAt, aITaskRecord.queuedAt) && this.timeoutMs == aITaskRecord.timeoutMs && g.b(this.threadPool, aITaskRecord.threadPool) && g.b(this.startedAt, aITaskRecord.startedAt) && g.b(this.threadName, aITaskRecord.threadName) && g.b(this.backend, aITaskRecord.backend) && this.preprocessTimeMs == aITaskRecord.preprocessTimeMs && this.inferenceTimeMs == aITaskRecord.inferenceTimeMs && this.postprocessTimeMs == aITaskRecord.postprocessTimeMs && g.b(this.firstTokenAt, aITaskRecord.firstTokenAt) && this.timeToFirstToken == aITaskRecord.timeToFirstToken && this.tokenCount == aITaskRecord.tokenCount && g.b(this.completedAt, aITaskRecord.completedAt) && this.success == aITaskRecord.success && this.errorCode == aITaskRecord.errorCode && g.b(this.errorMessage, aITaskRecord.errorMessage) && this.cancelledByWatchdog == aITaskRecord.cancelledByWatchdog && g.b(this.cancelReason, aITaskRecord.cancelReason) && this.nativeProducedChars == aITaskRecord.nativeProducedChars && this.dropAfterCancelChars == aITaskRecord.dropAfterCancelChars && g.b(this.powerTracker, aITaskRecord.powerTracker) && this.queuedAtMonoNs == aITaskRecord.queuedAtMonoNs && this.startedAtMonoNs == aITaskRecord.startedAtMonoNs && this.reportModelCallTerminal == aITaskRecord.reportModelCallTerminal && g.b(this.constraints, aITaskRecord.constraints);
    }

    public k7.a execute(r6.a decision) {
        g.f(decision, "decision");
        return new a.C0101a();
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final AITaskState getAiState() {
        return this._state;
    }

    public final String getBackend() {
        return this.backend;
    }

    public final String getCallerPackage() {
        return this.callerPackage;
    }

    public final int getCallerPid() {
        return this.callerPid;
    }

    public final int getCallerUid() {
        return this.callerUid;
    }

    public final String getCancelReason() {
        return this.cancelReason;
    }

    public final boolean getCancelledByWatchdog() {
        return this.cancelledByWatchdog;
    }

    public final boolean getCircuitBroken() {
        return this.circuitBroken;
    }

    public final Long getCompletedAt() {
        return this.completedAt;
    }

    public final h7.b getConstraints() {
        return this.constraints;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public final long getCreatedAtMonoNs() {
        return this.createdAtMonoNs;
    }

    public final int getDropAfterCancelChars() {
        return this.dropAfterCancelChars;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final ExecutionLocation getExecutionLocation() {
        return this.executionLocation;
    }

    @Override // j7.d
    public String getExecutionLocationName() {
        return this.executionLocation.name();
    }

    public final long getExecutionTime() {
        Long l10 = this.startedAt;
        if (l10 == null) {
            return 0L;
        }
        long jLongValue = l10.longValue();
        Long l11 = this.completedAt;
        return (l11 != null ? l11.longValue() : System.currentTimeMillis()) - jLongValue;
    }

    public final TaskPriority getFinalTier() {
        return this.finalTier;
    }

    public final Long getFirstTokenAt() {
        return this.firstTokenAt;
    }

    public final boolean getFlowControlled() {
        return this.flowControlled;
    }

    @Override // j7.b
    public String getId() {
        return this.f7473id;
    }

    public final long getInferenceTimeMs() {
        return this.inferenceTimeMs;
    }

    public final Object getInput() {
        return this.input;
    }

    public final long getInputSize() {
        return this.inputSize;
    }

    public final String getInputType() {
        return this.inputType;
    }

    public final boolean getModelCacheHit() {
        return this.modelCacheHit;
    }

    public final k getModelConfig() {
        return this.modelConfig;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final long getModelLoadTimeMs() {
        return this.modelLoadTimeMs;
    }

    public final String getModelType() {
        return this.modelType;
    }

    public final int getNativeProducedChars() {
        return this.nativeProducedChars;
    }

    public final int getOomAdj() {
        return this.oomAdj;
    }

    @Override // j7.d
    public String getOrchestrationReason() {
        return this.orchestrationReason;
    }

    public final long getPostprocessTimeMs() {
        return this.postprocessTimeMs;
    }

    public final Object getPowerTracker() {
        return this.powerTracker;
    }

    public final long getPreprocessTimeMs() {
        return this.preprocessTimeMs;
    }

    @Override // j7.b
    public TaskPriority getPriority() {
        return this._priority;
    }

    public final int getPriorityScore() {
        return this.priorityScore;
    }

    public final Long getQueuedAt() {
        return this.queuedAt;
    }

    public final long getQueuedAtMonoNs() {
        return this.queuedAtMonoNs;
    }

    public final boolean getReportModelCallTerminal() {
        return this.reportModelCallTerminal;
    }

    @Override // j7.d
    public e getRoutingDecision() {
        return this.routingDecision;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final Long getStartedAt() {
        return this.startedAt;
    }

    public final long getStartedAtMonoNs() {
        return this.startedAtMonoNs;
    }

    public TaskState getState() {
        switch (WhenMappings.$EnumSwitchMapping$0[this._state.ordinal()]) {
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

    public final boolean getSuccess() {
        return this.success;
    }

    public final float getSystemLoad() {
        return this.systemLoad;
    }

    public final int getThermalState() {
        return this.thermalState;
    }

    public final String getThreadName() {
        return this.threadName;
    }

    public final String getThreadPool() {
        return this.threadPool;
    }

    public final long getTimeToFirstToken() {
        return this.timeToFirstToken;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final int getTokenCount() {
        return this.tokenCount;
    }

    public final float getTokensPerSecond() {
        long j10 = this.inferenceTimeMs;
        if (j10 > 0) {
            return this.tokenCount / (j10 / 1000.0f);
        }
        return 0.0f;
    }

    public final long getTotalTime() {
        Long l10 = this.completedAt;
        return (l10 != null ? l10.longValue() : System.currentTimeMillis()) - getCreatedAt();
    }

    public TaskType getType() {
        return TaskType.f6410a;
    }

    public final long getWaitTime() {
        Long l10 = this.queuedAt;
        if (l10 == null) {
            return 0L;
        }
        long jLongValue = l10.longValue();
        Long l11 = this.startedAt;
        return (l11 != null ? l11.longValue() : System.currentTimeMillis()) - jLongValue;
    }

    public int hashCode() {
        int iA = v1.d.a(a0.a.c(a0.a.c(ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.callerPid, ai.onnxruntime.a.d(this.callerUid, v1.d.a(this.f7473id.hashCode() * 31, 31, this.callerPackage), 31), 31), 31, this.isForeground), this.createdAt, 31), this.createdAtMonoNs, 31), 31, this.abilityId);
        String str = this.inputType;
        int iA2 = v1.d.a(v1.d.a((this.executionLocation.hashCode() + a0.a.c((iA + (str == null ? 0 : str.hashCode())) * 31, this.inputSize, 31)) * 31, 31, this.orchestrationReason), 31, this.modelId);
        String str2 = this.modelType;
        int iHashCode = (iA2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        k kVar = this.modelConfig;
        int iF = ai.onnxruntime.a.f(a0.a.c((iHashCode + (kVar == null ? 0 : kVar.hashCode())) * 31, this.modelLoadTimeMs, 31), 31, this.modelCacheHit);
        Object obj = this.input;
        int iF2 = ai.onnxruntime.a.f(ai.onnxruntime.a.f((this._state.hashCode() + ((iF + (obj == null ? 0 : obj.hashCode())) * 31)) * 31, 31, this.flowControlled), 31, this.circuitBroken);
        String str3 = this.sceneId;
        int iD = ai.onnxruntime.a.d(this.oomAdj, ai.onnxruntime.a.d(this.priorityScore, (this._priority.hashCode() + ai.onnxruntime.a.d(this.thermalState, a0.a.a(this.systemLoad, (iF2 + (str3 == null ? 0 : str3.hashCode())) * 31, 31), 31)) * 31, 31), 31);
        TaskPriority taskPriority = this.finalTier;
        int iHashCode2 = (iD + (taskPriority == null ? 0 : taskPriority.hashCode())) * 31;
        Long l10 = this.queuedAt;
        int iC = a0.a.c((iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31, this.timeoutMs, 31);
        String str4 = this.threadPool;
        int iHashCode3 = (iC + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l11 = this.startedAt;
        int iHashCode4 = (iHashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str5 = this.threadName;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.backend;
        int iC2 = a0.a.c(a0.a.c(a0.a.c((iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31, this.preprocessTimeMs, 31), this.inferenceTimeMs, 31), this.postprocessTimeMs, 31);
        Long l12 = this.firstTokenAt;
        int iD2 = ai.onnxruntime.a.d(this.tokenCount, a0.a.c((iC2 + (l12 == null ? 0 : l12.hashCode())) * 31, this.timeToFirstToken, 31), 31);
        Long l13 = this.completedAt;
        int iD3 = ai.onnxruntime.a.d(this.errorCode, ai.onnxruntime.a.f((iD2 + (l13 == null ? 0 : l13.hashCode())) * 31, 31, this.success), 31);
        String str7 = this.errorMessage;
        int iD4 = ai.onnxruntime.a.d(this.dropAfterCancelChars, ai.onnxruntime.a.d(this.nativeProducedChars, v1.d.a(ai.onnxruntime.a.f((iD3 + (str7 == null ? 0 : str7.hashCode())) * 31, 31, this.cancelledByWatchdog), 31, this.cancelReason), 31), 31);
        Object obj2 = this.powerTracker;
        int iF3 = ai.onnxruntime.a.f(a0.a.c(a0.a.c((iD4 + (obj2 == null ? 0 : obj2.hashCode())) * 31, this.queuedAtMonoNs, 31), this.startedAtMonoNs, 31), 31, this.reportModelCallTerminal);
        h7.b bVar = this.constraints;
        return iF3 + (bVar != null ? bVar.hashCode() : 0);
    }

    public final boolean isCompleted() {
        return m.b0(AITaskState.COMPLETED, AITaskState.FAILED, AITaskState.CANCELLED, AITaskState.TIMEOUT).contains(this._state);
    }

    public final boolean isForeground() {
        return this.isForeground;
    }

    public final boolean isRunning() {
        return this._state == AITaskState.RUNNING;
    }

    public final boolean isSuccessful() {
        return this._state == AITaskState.COMPLETED && this.success;
    }

    public final void recordFirstToken() {
        if (this.firstTokenAt == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.firstTokenAt = Long.valueOf(jCurrentTimeMillis);
            Long l10 = this.startedAt;
            this.timeToFirstToken = jCurrentTimeMillis - (l10 != null ? l10.longValue() : getCreatedAt());
            try {
                ModelCallSessionTracker.INSTANCE.recordFirstToken(getId());
                n nVar = n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
        this.tokenCount++;
    }

    public final void setBackend(String str) {
        this.backend = str;
    }

    public final void setCancelReason(String str) {
        g.f(str, "<set-?>");
        this.cancelReason = str;
    }

    public final void setCancelledByWatchdog(boolean z) {
        this.cancelledByWatchdog = z;
    }

    public final void setCircuitBroken(boolean z) {
        this.circuitBroken = z;
    }

    public final void setCompletedAt(Long l10) {
        this.completedAt = l10;
    }

    public final void setConstraints(h7.b bVar) {
        this.constraints = bVar;
    }

    public final void setDropAfterCancelChars(int i10) {
        this.dropAfterCancelChars = i10;
    }

    public final void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setExecutionLocation(ExecutionLocation executionLocation) {
        g.f(executionLocation, "<set-?>");
        this.executionLocation = executionLocation;
    }

    @Override // j7.d
    public void setExecutionLocationName(String value) {
        ExecutionLocation next;
        g.f(value, "value");
        Iterator<ExecutionLocation> it = ExecutionLocation.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (g.b(next.name(), value)) {
                    break;
                }
            }
        }
        ExecutionLocation executionLocation = next;
        if (executionLocation == null) {
            executionLocation = ExecutionLocation.UNKNOWN;
        }
        this.executionLocation = executionLocation;
    }

    public final void setFinalTier(TaskPriority taskPriority) {
        this.finalTier = taskPriority;
    }

    public final void setFirstTokenAt(Long l10) {
        this.firstTokenAt = l10;
    }

    public final void setFlowControlled(boolean z) {
        this.flowControlled = z;
    }

    public final void setForeground(boolean z) {
        this.isForeground = z;
    }

    public final void setInferenceTimeMs(long j10) {
        this.inferenceTimeMs = j10;
    }

    public final void setInput(Object obj) {
        this.input = obj;
    }

    public final void setInputSize(long j10) {
        this.inputSize = j10;
    }

    public final void setInputType(String str) {
        this.inputType = str;
    }

    public final void setModelCacheHit(boolean z) {
        this.modelCacheHit = z;
    }

    public final void setModelConfig(k kVar) {
        this.modelConfig = kVar;
    }

    public final void setModelLoadTimeMs(long j10) {
        this.modelLoadTimeMs = j10;
    }

    public final void setModelType(String str) {
        this.modelType = str;
    }

    public final void setNativeProducedChars(int i10) {
        this.nativeProducedChars = i10;
    }

    public final void setOomAdj(int i10) {
        this.oomAdj = i10;
    }

    @Override // j7.d
    public void setOrchestrationReason(String str) {
        g.f(str, "<set-?>");
        this.orchestrationReason = str;
    }

    public final void setPostprocessTimeMs(long j10) {
        this.postprocessTimeMs = j10;
    }

    public final void setPowerTracker(Object obj) {
        this.powerTracker = obj;
    }

    public final void setPreprocessTimeMs(long j10) {
        this.preprocessTimeMs = j10;
    }

    public final void setPriority(TaskPriority value) {
        g.f(value, "value");
        this._priority = value;
    }

    public final void setPriorityScore(int i10) {
        this.priorityScore = i10;
    }

    public final void setQueuedAt(Long l10) {
        this.queuedAt = l10;
    }

    public final void setQueuedAtMonoNs(long j10) {
        this.queuedAtMonoNs = j10;
    }

    public final void setReportModelCallTerminal(boolean z) {
        this.reportModelCallTerminal = z;
    }

    @Override // j7.d
    public void setRoutingDecision(e eVar) {
        this.routingDecision = eVar;
    }

    public final void setSceneId(String str) {
        this.sceneId = str;
    }

    public final void setStartedAt(Long l10) {
        this.startedAt = l10;
    }

    public final void setStartedAtMonoNs(long j10) {
        this.startedAtMonoNs = j10;
    }

    @Override // j7.b
    public void setState(TaskState value) {
        AITaskState aITaskState;
        g.f(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$1[value.ordinal()]) {
            case 1:
                aITaskState = AITaskState.PENDING;
                break;
            case 2:
                aITaskState = AITaskState.QUEUED;
                break;
            case 3:
                aITaskState = AITaskState.RUNNING;
                break;
            case 4:
                aITaskState = AITaskState.COMPLETED;
                break;
            case 5:
                aITaskState = AITaskState.FAILED;
                break;
            case 6:
                aITaskState = AITaskState.CANCELLED;
                break;
            case 7:
                aITaskState = AITaskState.TIMEOUT;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this._state = aITaskState;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final void setSystemLoad(float f8) {
        this.systemLoad = f8;
    }

    public final void setThermalState(int i10) {
        this.thermalState = i10;
    }

    public final void setThreadName(String str) {
        this.threadName = str;
    }

    public final void setThreadPool(String str) {
        this.threadPool = str;
    }

    public final void setTimeToFirstToken(long j10) {
        this.timeToFirstToken = j10;
    }

    public final void setTimeoutMs(long j10) {
        this.timeoutMs = j10;
    }

    public final void setTokenCount(int i10) {
        this.tokenCount = i10;
    }

    public String toString() {
        String str = this.f7473id;
        String str2 = this.callerPackage;
        int i10 = this.callerUid;
        int i11 = this.callerPid;
        boolean z = this.isForeground;
        long j10 = this.createdAt;
        long j11 = this.createdAtMonoNs;
        String str3 = this.abilityId;
        String str4 = this.inputType;
        long j12 = this.inputSize;
        ExecutionLocation executionLocation = this.executionLocation;
        String str5 = this.orchestrationReason;
        String str6 = this.modelId;
        String str7 = this.modelType;
        k kVar = this.modelConfig;
        long j13 = this.modelLoadTimeMs;
        boolean z3 = this.modelCacheHit;
        Object obj = this.input;
        AITaskState aITaskState = this._state;
        boolean z10 = this.flowControlled;
        boolean z11 = this.circuitBroken;
        String str8 = this.sceneId;
        float f8 = this.systemLoad;
        int i12 = this.thermalState;
        TaskPriority taskPriority = this._priority;
        int i13 = this.priorityScore;
        int i14 = this.oomAdj;
        TaskPriority taskPriority2 = this.finalTier;
        Long l10 = this.queuedAt;
        long j14 = this.timeoutMs;
        String str9 = this.threadPool;
        Long l11 = this.startedAt;
        String str10 = this.threadName;
        String str11 = this.backend;
        long j15 = this.preprocessTimeMs;
        long j16 = this.inferenceTimeMs;
        long j17 = this.postprocessTimeMs;
        Long l12 = this.firstTokenAt;
        long j18 = this.timeToFirstToken;
        int i15 = this.tokenCount;
        Long l13 = this.completedAt;
        boolean z12 = this.success;
        int i16 = this.errorCode;
        String str12 = this.errorMessage;
        boolean z13 = this.cancelledByWatchdog;
        String str13 = this.cancelReason;
        int i17 = this.nativeProducedChars;
        int i18 = this.dropAfterCancelChars;
        Object obj2 = this.powerTracker;
        long j19 = this.queuedAtMonoNs;
        long j20 = this.startedAtMonoNs;
        boolean z14 = this.reportModelCallTerminal;
        h7.b bVar = this.constraints;
        StringBuilder sbS = ai.onnxruntime.a.s("AITaskRecord(id=", str, ", callerPackage=", str2, ", callerUid=");
        h0.e.l(sbS, i10, ", callerPid=", i11, ", isForeground=");
        sbS.append(z);
        sbS.append(", createdAt=");
        sbS.append(j10);
        a0.a.s(j11, ", createdAtMonoNs=", ", abilityId=", sbS);
        ai.onnxruntime.a.z(sbS, str3, ", inputType=", str4, ", inputSize=");
        sbS.append(j12);
        sbS.append(", executionLocation=");
        sbS.append(executionLocation);
        ai.onnxruntime.a.z(sbS, ", orchestrationReason=", str5, ", modelId=", str6);
        sbS.append(", modelType=");
        sbS.append(str7);
        sbS.append(", modelConfig=");
        sbS.append(kVar);
        a0.a.s(j13, ", modelLoadTimeMs=", ", modelCacheHit=", sbS);
        sbS.append(z3);
        sbS.append(", input=");
        sbS.append(obj);
        sbS.append(", _state=");
        sbS.append(aITaskState);
        sbS.append(", flowControlled=");
        sbS.append(z10);
        sbS.append(", circuitBroken=");
        sbS.append(z11);
        sbS.append(", sceneId=");
        sbS.append(str8);
        sbS.append(", systemLoad=");
        sbS.append(f8);
        sbS.append(", thermalState=");
        sbS.append(i12);
        sbS.append(", _priority=");
        sbS.append(taskPriority);
        sbS.append(", priorityScore=");
        sbS.append(i13);
        sbS.append(", oomAdj=");
        sbS.append(i14);
        sbS.append(", finalTier=");
        sbS.append(taskPriority2);
        sbS.append(", queuedAt=");
        sbS.append(l10);
        sbS.append(", timeoutMs=");
        sbS.append(j14);
        sbS.append(", threadPool=");
        sbS.append(str9);
        sbS.append(", startedAt=");
        sbS.append(l11);
        ai.onnxruntime.a.z(sbS, ", threadName=", str10, ", backend=", str11);
        a0.a.s(j15, ", preprocessTimeMs=", ", inferenceTimeMs=", sbS);
        sbS.append(j16);
        a0.a.s(j17, ", postprocessTimeMs=", ", firstTokenAt=", sbS);
        sbS.append(l12);
        sbS.append(", timeToFirstToken=");
        sbS.append(j18);
        sbS.append(", tokenCount=");
        sbS.append(i15);
        sbS.append(", completedAt=");
        sbS.append(l13);
        sbS.append(", success=");
        sbS.append(z12);
        sbS.append(", errorCode=");
        sbS.append(i16);
        sbS.append(", errorMessage=");
        sbS.append(str12);
        sbS.append(", cancelledByWatchdog=");
        sbS.append(z13);
        sbS.append(", cancelReason=");
        sbS.append(str13);
        sbS.append(", nativeProducedChars=");
        sbS.append(i17);
        sbS.append(", dropAfterCancelChars=");
        sbS.append(i18);
        sbS.append(", powerTracker=");
        sbS.append(obj2);
        a0.a.s(j19, ", queuedAtMonoNs=", ", startedAtMonoNs=", sbS);
        sbS.append(j20);
        sbS.append(", reportModelCallTerminal=");
        sbS.append(z14);
        sbS.append(", constraints=");
        sbS.append(bVar);
        sbS.append(")");
        return sbS.toString();
    }

    public final void transitionTo(AITaskState newState) {
        g.f(newState, "newState");
        this._state = newState;
        switch (WhenMappings.$EnumSwitchMapping$0[newState.ordinal()]) {
            case 2:
                this.queuedAt = Long.valueOf(System.currentTimeMillis());
                this.queuedAtMonoNs = SystemClock.elapsedRealtimeNanos();
                break;
            case 3:
                this.startedAt = Long.valueOf(System.currentTimeMillis());
                this.startedAtMonoNs = SystemClock.elapsedRealtimeNanos();
                this.threadName = Thread.currentThread().getName();
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                this.completedAt = Long.valueOf(System.currentTimeMillis());
                break;
        }
    }

    public final Object execute(x6.b bVar, r6.a aVar, qb.b<? super Flow<? extends Result<? extends Object>>> bVar2) {
        this.startedAt = new Long(System.currentTimeMillis());
        transitionTo(AITaskState.RUNNING);
        this.threadName = Thread.currentThread().getName();
        InferenceExecutorImpl inferenceExecutorImpl = bVar instanceof InferenceExecutorImpl ? (InferenceExecutorImpl) bVar : null;
        if (inferenceExecutorImpl != null) {
            return inferenceExecutorImpl.execute(this, bVar2);
        }
        Object obj = this.input;
        if (obj != null) {
            return FlowKt.callbackFlow(new AnonymousClass2(bVar, this, obj, aVar, null));
        }
        throw new IllegalArgumentException("Task input is null");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AITaskRecord(String str, String str2, int i10, int i11, boolean z, long j10, long j11, String str3, String str4, long j12, ExecutionLocation executionLocation, String str5, String str6, String str7, k kVar, long j13, boolean z3, Object obj, AITaskState aITaskState, boolean z10, boolean z11, String str8, float f8, int i12, TaskPriority taskPriority, int i13, int i14, TaskPriority taskPriority2, Long l10, long j14, String str9, Long l11, String str10, String str11, long j15, long j16, long j17, Long l12, long j18, int i15, Long l13, boolean z12, int i16, String str12, boolean z13, String str13, int i17, int i18, Object obj2, long j19, long j20, boolean z14, h7.b bVar, int i19, int i20, kotlin.jvm.internal.e eVar) {
        String string = (i19 & 1) != 0 ? UUID.randomUUID().toString() : str;
        String str14 = (i19 & 2) != 0 ? "" : str2;
        int i21 = (i19 & 4) != 0 ? 0 : i10;
        int i22 = (i19 & 8) != 0 ? 0 : i11;
        boolean z15 = (i19 & 16) != 0 ? true : z;
        long jCurrentTimeMillis = (i19 & 32) != 0 ? System.currentTimeMillis() : j10;
        long jElapsedRealtimeNanos = (i19 & 64) != 0 ? SystemClock.elapsedRealtimeNanos() : j11;
        String str15 = (i19 & 256) != 0 ? null : str4;
        long j21 = (i19 & VadSessionManager.FRAME_BYTES) != 0 ? 0L : j12;
        ExecutionLocation executionLocation2 = (i19 & 1024) != 0 ? ExecutionLocation.LOCAL : executionLocation;
        String str16 = (i19 & 2048) != 0 ? "" : str5;
        String str17 = (i19 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? null : str7;
        k kVar2 = (i19 & 16384) != 0 ? null : kVar;
        long j22 = (i19 & 32768) != 0 ? 0L : j13;
        boolean z16 = (i19 & 65536) != 0 ? false : z3;
        Object obj3 = (i19 & 131072) != 0 ? null : obj;
        AITaskState aITaskState2 = (i19 & 262144) != 0 ? AITaskState.PENDING : aITaskState;
        boolean z17 = (i19 & 524288) != 0 ? false : z10;
        boolean z18 = (i19 & CryptoHeaderParser.MAX_BLOCK_SIZE) != 0 ? false : z11;
        String str18 = (i19 & 2097152) != 0 ? null : str8;
        float f9 = (i19 & 4194304) != 0 ? 0.0f : f8;
        int i23 = (i19 & 8388608) != 0 ? 0 : i12;
        TaskPriority taskPriority3 = (i19 & 16777216) != 0 ? TaskPriority.f6399e : taskPriority;
        int i24 = (i19 & 33554432) != 0 ? 50 : i13;
        int i25 = (i19 & 67108864) != 0 ? 500 : i14;
        TaskPriority taskPriority4 = (i19 & 134217728) != 0 ? null : taskPriority2;
        Long l14 = (i19 & 268435456) != 0 ? null : l10;
        long j23 = (i19 & 536870912) != 0 ? AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS : j14;
        String str19 = (i19 & 1073741824) != 0 ? null : str9;
        Long l15 = (i19 & Integer.MIN_VALUE) != 0 ? null : l11;
        String str20 = (i20 & 1) != 0 ? null : str10;
        String str21 = (i20 & 2) != 0 ? null : str11;
        long j24 = (i20 & 4) != 0 ? 0L : j15;
        long j25 = (i20 & 8) != 0 ? 0L : j16;
        long j26 = (i20 & 16) != 0 ? 0L : j17;
        Long l16 = (i20 & 32) != 0 ? null : l12;
        this(string, str14, i21, i22, z15, jCurrentTimeMillis, jElapsedRealtimeNanos, str3, str15, j21, executionLocation2, str16, str6, str17, kVar2, j22, z16, obj3, aITaskState2, z17, z18, str18, f9, i23, taskPriority3, i24, i25, taskPriority4, l14, j23, str19, l15, str20, str21, j24, j25, j26, l16, (i20 & 64) != 0 ? 0L : j18, (i20 & TraceIdKeys.MAX_LENGTH) != 0 ? 0 : i15, (i20 & 256) != 0 ? null : l13, (i20 & VadSessionManager.FRAME_BYTES) != 0 ? false : z12, (i20 & 1024) != 0 ? 0 : i16, (i20 & 2048) != 0 ? null : str12, (i20 & 4096) != 0 ? false : z13, (i20 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? "" : str13, (i20 & 16384) != 0 ? 0 : i17, (i20 & 32768) != 0 ? 0 : i18, (i20 & 65536) != 0 ? null : obj2, (i20 & 131072) != 0 ? 0L : j19, (i20 & 262144) != 0 ? 0L : j20, (i20 & 524288) != 0 ? true : z14, (1048576 & i20) != 0 ? null : bVar);
    }
}
