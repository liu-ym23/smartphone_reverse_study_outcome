package com.stepos.core.common.telemetry;

import android.os.Process;
import android.os.SystemClock;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.log.Sanitizer;
import com.stepos.core.common.telemetry.CpuPerCoreSampler;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.error.AIEngineError;
import gc.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import lb.n;
import mb.l;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PowerPerfTracker {
    private static final long DDR_SAMPLE_DELAY_MS = 10;
    private static final String INFER_STAGE_TAG = "AIEngine_InferStage";
    private static final int MAX_EXCEPTION_MSG = 256;
    private static final String RETRY_AFTER_MARKER = "|retryAfterMs=";
    private static final int STACK_DIGEST_BYTES = 8;
    private static final int STACK_DIGEST_FRAMES = 8;
    private static final int STAGE_AUDIO_ENCODER_INFER_END = 4002;
    private static final int STAGE_LLM_DECODE_BEGIN = 3003;
    private static final int STAGE_LLM_DECODE_END = 3005;
    private static final int STAGE_LLM_PREFILL_BEGIN = 3000;
    private static final int STAGE_LLM_PREFILL_END = 3002;
    private static final int STAGE_MODEL_INFER_END = 1001;
    private static final int STAGE_VIT_INFER_END = 2004;
    private static final int STAGE_VIT_PREPROCESS_END = 2002;
    private final String abilityId;
    private String backend;
    private final String callerPkg;
    private final int callerUid;
    private volatile boolean chunkedModel;
    private final AtomicBoolean closed;
    private final AtomicReference<String> currentStage;
    private volatile DataVolume dataVolume;
    private final CopyOnWriteArrayList<Integer> ddrMcccSamplesKhz;
    private final AtomicInteger engineSceneId;
    private final CpuPerCoreSampler.Snapshot entryCpuSnapshot;
    private final long entryCpuTimeMs;
    private final int entryDdrFreqKhz;
    private final AtomicInteger errorCode;
    private volatile String exceptionMsg;
    private volatile String executionLocation;
    private volatile String failClass;
    private volatile String failStack;
    private final AtomicLong firstTokenMonoNs;
    private String hardware;
    private final boolean isForeground;
    private ModelCacheState modelCacheState;
    private final String modelId;
    private final AtomicLong modelLoadMs;
    private volatile String modelVersion;
    private final CopyOnWriteArrayList<PhaseRecord> nativePhases;
    private volatile String npuPerfLevel;
    private final Set<Integer> openSceneFgIds;
    private final ConcurrentHashMap<String, Long> pendingPhaseStartMs;
    private final AtomicInteger prefillEndSeen;
    private final AtomicBoolean prefillToFirstTokenTraceStarted;
    private volatile String priority;
    private final AtomicBoolean publishClaimed;
    private long queuedAtMonoNs;
    private volatile long retryAfterMs;
    private volatile boolean sceneDonationClosed;
    private String sceneId;
    private volatile String stackDigest;
    private final long startMonoNs;
    private final long startWallMs;
    private long startedAtMonoNs;
    private final AtomicReference<RecordStatus> status;
    private final String taskId;
    private final String traceId;
    private static final Companion Companion = new Companion(null);
    private static final Map<Integer, String> ERROR_CODE_STAGE = kotlin.collections.b.g0(new Pair(Integer.valueOf(AIEngineError.MODEL_LOAD_BACKOFF), FailStage.MODEL_LOAD_BACKOFF), new Pair(Integer.valueOf(AIEngineError.MODEL_BLACKLISTED), FailStage.MODEL_LOAD), new Pair(Integer.valueOf(AIEngineError.MODEL_FILE_NOT_FOUND), FailStage.MODEL_LOAD), new Pair(Integer.valueOf(AIEngineError.MODEL_LOAD_FAILED), FailStage.MODEL_LOAD), new Pair(Integer.valueOf(AIEngineError.MODEL_INIT_FAILED), FailStage.MODEL_LOAD), new Pair(Integer.valueOf(AIEngineError.MODEL_CONFIG_INVALID), FailStage.MODEL_LOAD), new Pair(Integer.valueOf(AIEngineError.MODEL_UPDATING), FailStage.MODEL_DRAIN_WAIT), new Pair(Integer.valueOf(AIEngineError.INPUT_DATA_INVALID), FailStage.INPUT_CONVERT));
    private static final Set<String> HW_COMPUTE_PHASES = l.s0(new String[]{FailStage.VIT_ENCODE, FailStage.AUDIO_ENCODE, FailStage.PREFILL, FailStage.DECODE, FailStage.FLOW_MATCH, FailStage.HIFT});

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String beginStageToPhaseName(int i10) {
            if (i10 == 1000) {
                return FailStage.INFERENCE;
            }
            if (i10 == 2000) {
                return FailStage.IMAGE_PREPROCESS;
            }
            if (i10 == 2003) {
                return FailStage.VIT_ENCODE;
            }
            if (i10 == 2100) {
                return FailStage.AUDIO_PREPROCESS;
            }
            if (i10 == PowerPerfTracker.STAGE_LLM_PREFILL_BEGIN) {
                return FailStage.PREFILL;
            }
            if (i10 == PowerPerfTracker.STAGE_LLM_DECODE_BEGIN) {
                return FailStage.DECODE;
            }
            if (i10 == 4000) {
                return FailStage.AUDIO_ENCODE;
            }
            if (i10 == 5000) {
                return FailStage.FLOW_MATCH;
            }
            if (i10 != 6000) {
                return null;
            }
            return FailStage.HIFT;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String inferStageName(int i10) {
            if (i10 == 1000) {
                return "MODEL_INFER_BEGIN";
            }
            if (i10 == PowerPerfTracker.STAGE_MODEL_INFER_END) {
                return "MODEL_INFER_END";
            }
            if (i10 == 5000) {
                return "FLOW_MATCHING_BEGIN";
            }
            if (i10 == 5001) {
                return "FLOW_MATCHING_END";
            }
            if (i10 == 6000) {
                return "HIFT_BEGIN";
            }
            if (i10 == 6001) {
                return "HIFT_END";
            }
            switch (i10) {
                case 2000:
                    return "VIT_PREPROCESS_BEGIN";
                case 2001:
                    return "VIT_PREPROCESS_TICK";
                case PowerPerfTracker.STAGE_VIT_PREPROCESS_END /* 2002 */:
                    return "VIT_PREPROCESS_END";
                case 2003:
                    return "VIT_INFER_BEGIN";
                case PowerPerfTracker.STAGE_VIT_INFER_END /* 2004 */:
                    return "VIT_INFER_END";
                default:
                    switch (i10) {
                        case 2100:
                            return "AUDIO_PREPROCESS_BEGIN";
                        case 2101:
                            return "AUDIO_PREPROCESS_TICK";
                        case 2102:
                            return "AUDIO_PREPROCESS_END";
                        default:
                            switch (i10) {
                                case PowerPerfTracker.STAGE_LLM_PREFILL_BEGIN /* 3000 */:
                                    return "LLM_PREFILL_BEGIN";
                                case 3001:
                                    return "LLM_PREFILL_TICK";
                                case PowerPerfTracker.STAGE_LLM_PREFILL_END /* 3002 */:
                                    return "LLM_PREFILL_END";
                                case PowerPerfTracker.STAGE_LLM_DECODE_BEGIN /* 3003 */:
                                    return "LLM_DECODE_BEGIN";
                                case 3004:
                                    return "LLM_DECODE_TICK";
                                case PowerPerfTracker.STAGE_LLM_DECODE_END /* 3005 */:
                                    return "LLM_DECODE_END";
                                default:
                                    switch (i10) {
                                        case 4000:
                                            return "AUDIO_ENCODER_INFER_BEGIN";
                                        case 4001:
                                            return "AUDIO_ENCODER_INFER_TICK";
                                        case PowerPerfTracker.STAGE_AUDIO_ENCODER_INFER_END /* 4002 */:
                                            return "AUDIO_ENCODER_INFER_END";
                                        default:
                                            return FailStage.UNKNOWN;
                                    }
                            }
                    }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String modelTypeName(int i10) {
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? FailStage.UNKNOWN : "TTS" : "ASR" : "VLM" : "LLM";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pair<Boolean, String> stageAtraceEvent(int i10) {
            if (i10 == 1000) {
                return new Pair<>(Boolean.TRUE, "inference");
            }
            if (i10 == PowerPerfTracker.STAGE_MODEL_INFER_END) {
                return new Pair<>(Boolean.FALSE, "inference");
            }
            if (i10 == 2000) {
                return new Pair<>(Boolean.TRUE, "image_preprocess");
            }
            if (i10 == 2100) {
                return new Pair<>(Boolean.TRUE, "audio_preprocess");
            }
            if (i10 == 2102) {
                return new Pair<>(Boolean.FALSE, "audio_preprocess");
            }
            if (i10 == PowerPerfTracker.STAGE_LLM_PREFILL_BEGIN) {
                return new Pair<>(Boolean.TRUE, "prefill");
            }
            if (i10 == PowerPerfTracker.STAGE_LLM_DECODE_END) {
                return new Pair<>(Boolean.FALSE, "decode");
            }
            if (i10 == 4000) {
                return new Pair<>(Boolean.TRUE, "audio_encode");
            }
            if (i10 == PowerPerfTracker.STAGE_AUDIO_ENCODER_INFER_END) {
                return new Pair<>(Boolean.FALSE, "audio_encode");
            }
            if (i10 == PowerPerfTracker.STAGE_LLM_PREFILL_END) {
                return new Pair<>(Boolean.FALSE, "prefill");
            }
            if (i10 == PowerPerfTracker.STAGE_LLM_DECODE_BEGIN) {
                return new Pair<>(Boolean.TRUE, "decode");
            }
            if (i10 == 5000) {
                return new Pair<>(Boolean.TRUE, "flow_match");
            }
            if (i10 == 5001) {
                return new Pair<>(Boolean.FALSE, "flow_match");
            }
            if (i10 == 6000) {
                return new Pair<>(Boolean.TRUE, "hift");
            }
            if (i10 == 6001) {
                return new Pair<>(Boolean.FALSE, "hift");
            }
            switch (i10) {
                case PowerPerfTracker.STAGE_VIT_PREPROCESS_END /* 2002 */:
                    return new Pair<>(Boolean.FALSE, "image_preprocess");
                case 2003:
                    return new Pair<>(Boolean.TRUE, "vit_encode");
                case PowerPerfTracker.STAGE_VIT_INFER_END /* 2004 */:
                    return new Pair<>(Boolean.FALSE, "vit_encode");
                default:
                    return null;
            }
        }

        private Companion() {
        }
    }

    public PowerPerfTracker(String taskId, int i10, String callerPkg, String abilityId, String modelId, boolean z, String backend, String hardware, String traceId, long j10, long j11) {
        kotlin.jvm.internal.g.f(taskId, "taskId");
        kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(backend, "backend");
        kotlin.jvm.internal.g.f(hardware, "hardware");
        kotlin.jvm.internal.g.f(traceId, "traceId");
        this.taskId = taskId;
        this.callerUid = i10;
        this.callerPkg = callerPkg;
        this.abilityId = abilityId;
        this.modelId = modelId;
        this.isForeground = z;
        this.backend = backend;
        this.hardware = hardware;
        this.traceId = traceId;
        this.startMonoNs = j10;
        this.startWallMs = j11;
        this.entryCpuTimeMs = Process.getElapsedCpuTime();
        this.entryCpuSnapshot = CpuPerCoreSampler.INSTANCE.snapshot();
        this.entryDdrFreqKhz = DdrFreqSampler.INSTANCE.readKhz();
        this.executionLocation = "LOCAL";
        this.status = new AtomicReference<>(RecordStatus.SUCCESS);
        this.errorCode = new AtomicInteger(0);
        this.failClass = "";
        this.exceptionMsg = "";
        this.stackDigest = "";
        this.failStack = "";
        this.priority = "";
        this.retryAfterMs = -1L;
        this.currentStage = new AtomicReference<>(FailStage.UNKNOWN);
        this.modelCacheState = ModelCacheState.WARM;
        this.modelLoadMs = new AtomicLong(0L);
        resolveModelLoad();
        this.npuPerfLevel = "";
        this.firstTokenMonoNs = new AtomicLong(0L);
        this.prefillEndSeen = new AtomicInteger(0);
        this.prefillToFirstTokenTraceStarted = new AtomicBoolean(false);
        this.publishClaimed = new AtomicBoolean(false);
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        kotlin.jvm.internal.g.e(keySetViewNewKeySet, "newKeySet(...)");
        this.openSceneFgIds = keySetViewNewKeySet;
        this.modelVersion = "";
        this.engineSceneId = new AtomicInteger(0);
        this.nativePhases = new CopyOnWriteArrayList<>();
        this.pendingPhaseStartMs = new ConcurrentHashMap<>();
        this.ddrMcccSamplesKhz = new CopyOnWriteArrayList<>();
        this.closed = new AtomicBoolean(false);
    }

    private final int avgMhz(int i10, int i11) {
        if (i10 > 0 || i11 > 0) {
            return i10 <= 0 ? i11 / 1000 : i11 <= 0 ? i10 / 1000 : ((i10 + i11) / 2) / 1000;
        }
        return -1;
    }

    public static /* synthetic */ void beginPhase$default(PowerPerfTracker powerPerfTracker, Phase phase, Hardware hardware, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            hardware = Hardware.NONE;
        }
        powerPerfTracker.beginPhase(phase, hardware);
    }

    private static final int buildRecord$attributedMs(List<PhaseRecord> list, Hardware hardware) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            PhaseRecord phaseRecord = (PhaseRecord) obj;
            if (phaseRecord.getHardware() == hardware && HW_COMPUTE_PHASES.contains(phaseRecord.getPhase())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        int size = arrayList.size();
        int durationMs = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            durationMs += ((PhaseRecord) obj2).getDurationMs();
        }
        return durationMs;
    }

    private final String digestStack(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        kotlin.jvm.internal.g.e(stackTrace, "getStackTrace(...)");
        String strZ0 = kotlin.collections.a.z0(l.m0(stackTrace), "\n", null, null, new com.stepos.core.common.cloud.d(9), 30);
        return strZ0.length() == 0 ? "" : Sanitizer.hashHex(strZ0, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence digestStack$lambda$1(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataVolume onInferStageFromNative$lambda$10(int i10, DataVolume old) {
        kotlin.jvm.internal.g.f(old, "old");
        Integer imageTokens = old.getImageTokens();
        return DataVolume.copy$default(old, null, null, Integer.valueOf((imageTokens != null ? imageTokens.intValue() : 0) + i10), null, null, null, null, null, null, 507, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataVolume onInferStageFromNative$lambda$11(int i10, DataVolume old) {
        kotlin.jvm.internal.g.f(old, "old");
        Integer audioTokens = old.getAudioTokens();
        return DataVolume.copy$default(old, null, null, null, Integer.valueOf((audioTokens != null ? audioTokens.intValue() : 0) + i10), null, null, null, null, null, 503, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onInferStageFromNative$lambda$7(PowerPerfTracker powerPerfTracker) {
        int khz = McccClkSampler.INSTANCE.readKhz();
        if (khz > 0) {
            powerPerfTracker.onDdrSample(khz);
        }
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataVolume onInferStageFromNative$lambda$8(int i10, DataVolume old) {
        kotlin.jvm.internal.g.f(old, "old");
        Integer inputTokens = old.getInputTokens();
        return DataVolume.copy$default(old, Integer.valueOf((inputTokens != null ? inputTokens.intValue() : 0) + i10), null, null, null, null, null, null, null, null, 510, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataVolume onInferStageFromNative$lambda$9(int i10, DataVolume old) {
        kotlin.jvm.internal.g.f(old, "old");
        Integer outputTokens = old.getOutputTokens();
        return DataVolume.copy$default(old, null, Integer.valueOf((outputTokens != null ? outputTokens.intValue() : 0) + i10), null, null, null, null, null, null, null, 509, null);
    }

    private final long parseRetryAfterMs(String str) {
        int iU0 = str != null ? q.u0(6, str, RETRY_AFTER_MARKER) : -1;
        if (iU0 < 0) {
            return -1L;
        }
        kotlin.jvm.internal.g.c(str);
        String strSubstring = str.substring(iU0 + 14);
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        int length = strSubstring.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (!Character.isDigit(strSubstring.charAt(i10))) {
                strSubstring = strSubstring.substring(0, i10);
                kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
                break;
            }
            i10++;
        }
        Long lD0 = gc.n.d0(strSubstring);
        if (lD0 != null) {
            return lD0.longValue();
        }
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        if (kotlin.jvm.internal.g.b(r6, com.stepos.core.common.telemetry.FailStage.INFERENCE) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String resolveFailStage(int r7) {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r6 = r6.currentStage
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            java.util.Map<java.lang.Integer, java.lang.String> r0 = com.stepos.core.common.telemetry.PowerPerfTracker.ERROR_CODE_STAGE
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "ORCHESTRATION"
            java.lang.String r3 = "UNKNOWN"
            if (r1 == 0) goto L3c
            boolean r4 = kotlin.jvm.internal.g.b(r6, r3)
            if (r4 != 0) goto L3b
            boolean r4 = kotlin.jvm.internal.g.b(r6, r2)
            if (r4 == 0) goto L27
            goto L3b
        L27:
            java.lang.String r4 = "INFERENCE"
            boolean r5 = kotlin.jvm.internal.g.b(r6, r4)
            if (r5 == 0) goto L35
            r5 = 260002(0x3f7a2, float:3.6434E-40)
            if (r7 != r5) goto L35
            goto L58
        L35:
            boolean r4 = kotlin.jvm.internal.g.b(r6, r4)
            if (r4 == 0) goto L3c
        L3b:
            return r1
        L3c:
            boolean r1 = kotlin.jvm.internal.g.b(r6, r3)
            if (r1 != 0) goto L4c
            boolean r1 = kotlin.jvm.internal.g.b(r6, r2)
            if (r1 != 0) goto L4c
            kotlin.jvm.internal.g.c(r6)
            return r6
        L4c:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Object r7 = r0.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L59
        L58:
            return r6
        L59:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.telemetry.PowerPerfTracker.resolveFailStage(int):java.lang.String");
    }

    private final void resolveModelLoad() {
        Long lClaimPending;
        ModelCacheState modelCacheState = this.modelCacheState;
        ModelCacheState modelCacheState2 = ModelCacheState.COLD;
        if (modelCacheState == modelCacheState2 || (lClaimPending = ModelLoadLedger.INSTANCE.claimPending(this.modelId)) == null) {
            return;
        }
        this.modelLoadMs.set(lClaimPending.longValue());
        this.modelCacheState = modelCacheState2;
    }

    public final void addPhasesFromNative(List<PhaseRecord> phases) {
        kotlin.jvm.internal.g.f(phases, "phases");
        if (this.closed.get()) {
            return;
        }
        ArrayList arrayList = new ArrayList(m.Z(phases, 10));
        for (PhaseRecord phaseRecordCopy$default : phases) {
            Long lRemove = this.pendingPhaseStartMs.remove(phaseRecordCopy$default.getPhase());
            if (lRemove != null && phaseRecordCopy$default.getBeginMs() < 0) {
                phaseRecordCopy$default = PhaseRecord.copy$default(phaseRecordCopy$default, null, null, 0, lRemove.longValue(), 7, null);
            }
            arrayList.add(phaseRecordCopy$default);
        }
        this.nativePhases.addAll(arrayList);
    }

    public final void beginPhase(Phase phase, Hardware hw) {
        kotlin.jvm.internal.g.f(phase, "phase");
        kotlin.jvm.internal.g.f(hw, "hw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.common.telemetry.AiPowerPerfRecord buildRecord(long r59) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.telemetry.PowerPerfTracker.buildRecord(long):com.stepos.core.common.telemetry.AiPowerPerfRecord");
    }

    public final Set<Integer> drainOpenScenes() {
        this.sceneDonationClosed = true;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Integer> it = this.openSceneFgIds.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (this.openSceneFgIds.remove(Integer.valueOf(iIntValue))) {
                linkedHashSet.add(Integer.valueOf(iIntValue));
            }
        }
        return linkedHashSet;
    }

    public final Object endPhase() {
        return null;
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final String getBackend() {
        return this.backend;
    }

    public final String getCallerPkg() {
        return this.callerPkg;
    }

    public final int getCallerUid() {
        return this.callerUid;
    }

    public final AtomicReference<String> getCurrentStage() {
        return this.currentStage;
    }

    public final DataVolume getDataVolume() {
        return this.dataVolume;
    }

    public final AtomicInteger getEngineSceneId() {
        return this.engineSceneId;
    }

    public final AtomicInteger getErrorCode() {
        return this.errorCode;
    }

    public final String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public final String getExecutionLocation() {
        return this.executionLocation;
    }

    public final String getFailClass() {
        return this.failClass;
    }

    public final String getFailStack() {
        return this.failStack;
    }

    public final String getHardware() {
        return this.hardware;
    }

    public final ModelCacheState getModelCacheState() {
        return this.modelCacheState;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final AtomicLong getModelLoadMs() {
        return this.modelLoadMs;
    }

    public final String getModelVersion() {
        return this.modelVersion;
    }

    public final String getNpuPerfLevel() {
        return this.npuPerfLevel;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final long getQueuedAtMonoNs() {
        return this.queuedAtMonoNs;
    }

    public final long getRetryAfterMs() {
        return this.retryAfterMs;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final String getStackDigest() {
        return this.stackDigest;
    }

    public final long getStartMonoNs() {
        return this.startMonoNs;
    }

    public final long getStartWallMs() {
        return this.startWallMs;
    }

    public final long getStartedAtMonoNs() {
        return this.startedAtMonoNs;
    }

    public final AtomicReference<RecordStatus> getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final boolean isForeground() {
        return this.isForeground;
    }

    public final void markStage(String stage) {
        kotlin.jvm.internal.g.f(stage, "stage");
        this.currentStage.set(stage);
    }

    public final void onDdrSample(int i10) {
        if (this.closed.get() || i10 <= 0) {
            return;
        }
        this.ddrMcccSamplesKhz.add(Integer.valueOf(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0142 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0245  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onInferStageFromNative(int r17, int r18, int r19, int r20, long r21, int r23, final int r24, int r25, long r26, int r28, int r29, long r30, int r32, int r33, long r34, int r36, int r37, int r38, int r39, int r40, int r41, long r42, final int r44, int r45) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.telemetry.PowerPerfTracker.onInferStageFromNative(int, int, int, int, long, int, int, int, long, int, int, long, int, int, long, int, int, int, int, int, int, long, int, int):void");
    }

    public final void recordFailure(Throwable t8) {
        kotlin.jvm.internal.g.f(t8, "t");
        if (this.failClass.length() > 0) {
            return;
        }
        this.failClass = t8.getClass().getSimpleName();
        this.exceptionMsg = Sanitizer.text(t8.getMessage(), 256);
        this.stackDigest = digestStack(t8);
        this.failStack = FailStack.format$default(FailStack.INSTANCE, t8, 0, 2, null);
        this.retryAfterMs = parseRetryAfterMs(t8.getMessage());
    }

    public final void recordFirstToken() {
        if (this.firstTokenMonoNs.compareAndSet(0L, SystemClock.elapsedRealtimeNanos())) {
            try {
                ModelCallSessionTracker.INSTANCE.recordFirstToken(this.taskId);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
    }

    public final void setBackend(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        this.backend = str;
    }

    public final void setDataVolume(DataVolume dataVolume) {
        this.dataVolume = dataVolume;
    }

    public final void setExceptionMsg(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        this.exceptionMsg = str;
    }

    public final void setExecutionLocation(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        this.executionLocation = str;
    }

    public final void setFailClass(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        this.failClass = str;
    }

    public final void setFailStack(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        this.failStack = str;
    }

    public final void setHardware(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        this.hardware = str;
    }

    public final void setModelCacheState(ModelCacheState modelCacheState) {
        kotlin.jvm.internal.g.f(modelCacheState, "<set-?>");
        this.modelCacheState = modelCacheState;
    }

    public final void setModelVersion(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        this.modelVersion = str;
    }

    public final void setNpuPerfLevel(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        this.npuPerfLevel = str;
    }

    public final void setPriority(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        this.priority = str;
    }

    public final void setQueuedAtMonoNs(long j10) {
        this.queuedAtMonoNs = j10;
    }

    public final void setRetryAfterMs(long j10) {
        this.retryAfterMs = j10;
    }

    public final void setSceneId(String str) {
        this.sceneId = str;
    }

    public final void setStackDigest(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        this.stackDigest = str;
    }

    public final void setStartedAtMonoNs(long j10) {
        this.startedAtMonoNs = j10;
    }

    public final boolean shouldPublish() {
        return this.status.get() == RecordStatus.SUCCESS ? kotlin.jvm.internal.g.b(this.executionLocation, "LOCAL") : !kotlin.jvm.internal.g.b(this.executionLocation, "CLOUD");
    }

    public final boolean tryClaimPublish() {
        return this.publishClaimed.compareAndSet(false, true);
    }

    public final void updateDataVolume(zb.l<? super DataVolume, DataVolume> merger) {
        kotlin.jvm.internal.g.f(merger, "merger");
        synchronized (this) {
            try {
                DataVolume dataVolume = this.dataVolume;
                if (dataVolume == null) {
                    dataVolume = new DataVolume(null, null, null, null, null, null, null, null, null, 511, null);
                }
                this.dataVolume = merger.invoke(dataVolume);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ PowerPerfTracker(String str, int i10, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, long j10, long j11, int i11, kotlin.jvm.internal.e eVar) {
        this(str, i10, str2, str3, str4, z, (i11 & 64) != 0 ? "" : str5, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? ModelFlowMeta.PLAN_NONE : str6, (i11 & 256) != 0 ? "" : str7, (i11 & VadSessionManager.FRAME_BYTES) != 0 ? SystemClock.elapsedRealtimeNanos() : j10, (i11 & 1024) != 0 ? System.currentTimeMillis() : j11);
    }

    public final void updateTokensFromNative(int i10, int i11, int i12) {
    }
}
