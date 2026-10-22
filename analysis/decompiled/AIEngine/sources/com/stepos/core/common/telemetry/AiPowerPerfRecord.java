package com.stepos.core.common.telemetry;

import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.crypto.CryptoHeaderParser;
import com.tonyodev.fetch2core.server.FileResponse;
import fc.p;
import fc.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.MapBuilder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiPowerPerfRecord {
    private final String abilityId;
    private final String backend;
    private final String callerPkg;
    private final int callerUid;
    private final int cpuAttributedMs;
    private final long cpuEnergyUj;
    private final int cpuFreqMhzAvg;
    private final DataVolume dataVolume;
    private final int ddrFreqMhzAvg;
    private final float decodeTps;
    private final int dspAttributedMs;
    private final long e2eMs;
    private final long endMonoNs;
    private final int engineSceneId;
    private final String engineVersion;
    private final int errorCode;
    private final String exceptionMsg;
    private final String executionLocation;
    private final String expLogId;
    private final String failClass;
    private final String failStack;
    private final String failStage;
    private final int gpuAttributedMs;
    private final String hardware;
    private final boolean isForeground;
    private final String modelCacheState;
    private final String modelId;
    private final int modelLoadMs;
    private final String modelVersion;
    private final int npuAttributedMs;
    private final String npuPerfLevel;
    private final List<PhaseRecord> phases;
    private final String priority;
    private final long retryAfterMs;
    private final String sceneId;
    private final float shellTempC;
    private final String stackDigest;
    private final long startMonoNs;
    private final long startWallMs;
    private final String status;
    private final String taskId;
    private final String traceId;
    private final long ttftMs;

    public AiPowerPerfRecord(String traceId, String taskId, int i10, String callerPkg, String abilityId, String modelId, String modelVersion, String engineVersion, String backend, String hardware, String executionLocation, long j10, long j11, long j12, long j13, long j14, float f8, String modelCacheState, int i11, int i12, int i13, int i14, int i15, long j15, String npuPerfLevel, int i16, int i17, float f9, String status, int i18, String expLogId, boolean z, String failClass, String exceptionMsg, String stackDigest, String failStack, long j16, String priority, String failStage, String str, int i19, List<PhaseRecord> phases, DataVolume dataVolume) {
        kotlin.jvm.internal.g.f(traceId, "traceId");
        kotlin.jvm.internal.g.f(taskId, "taskId");
        kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(modelVersion, "modelVersion");
        kotlin.jvm.internal.g.f(engineVersion, "engineVersion");
        kotlin.jvm.internal.g.f(backend, "backend");
        kotlin.jvm.internal.g.f(hardware, "hardware");
        kotlin.jvm.internal.g.f(executionLocation, "executionLocation");
        kotlin.jvm.internal.g.f(modelCacheState, "modelCacheState");
        kotlin.jvm.internal.g.f(npuPerfLevel, "npuPerfLevel");
        kotlin.jvm.internal.g.f(status, "status");
        kotlin.jvm.internal.g.f(expLogId, "expLogId");
        kotlin.jvm.internal.g.f(failClass, "failClass");
        kotlin.jvm.internal.g.f(exceptionMsg, "exceptionMsg");
        kotlin.jvm.internal.g.f(stackDigest, "stackDigest");
        kotlin.jvm.internal.g.f(failStack, "failStack");
        kotlin.jvm.internal.g.f(priority, "priority");
        kotlin.jvm.internal.g.f(failStage, "failStage");
        kotlin.jvm.internal.g.f(phases, "phases");
        this.traceId = traceId;
        this.taskId = taskId;
        this.callerUid = i10;
        this.callerPkg = callerPkg;
        this.abilityId = abilityId;
        this.modelId = modelId;
        this.modelVersion = modelVersion;
        this.engineVersion = engineVersion;
        this.backend = backend;
        this.hardware = hardware;
        this.executionLocation = executionLocation;
        this.startMonoNs = j10;
        this.endMonoNs = j11;
        this.startWallMs = j12;
        this.e2eMs = j13;
        this.ttftMs = j14;
        this.decodeTps = f8;
        this.modelCacheState = modelCacheState;
        this.modelLoadMs = i11;
        this.npuAttributedMs = i12;
        this.gpuAttributedMs = i13;
        this.dspAttributedMs = i14;
        this.cpuAttributedMs = i15;
        this.cpuEnergyUj = j15;
        this.npuPerfLevel = npuPerfLevel;
        this.cpuFreqMhzAvg = i16;
        this.ddrFreqMhzAvg = i17;
        this.shellTempC = f9;
        this.status = status;
        this.errorCode = i18;
        this.expLogId = expLogId;
        this.isForeground = z;
        this.failClass = failClass;
        this.exceptionMsg = exceptionMsg;
        this.stackDigest = stackDigest;
        this.failStack = failStack;
        this.retryAfterMs = j16;
        this.priority = priority;
        this.failStage = failStage;
        this.sceneId = str;
        this.engineSceneId = i19;
        this.phases = phases;
        this.dataVolume = dataVolume;
    }

    public static /* synthetic */ AiPowerPerfRecord copy$default(AiPowerPerfRecord aiPowerPerfRecord, String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, long j10, long j11, long j12, long j13, long j14, float f8, String str11, int i11, int i12, int i13, int i14, int i15, long j15, String str12, int i16, int i17, float f9, String str13, int i18, String str14, boolean z, String str15, String str16, String str17, String str18, long j16, String str19, String str20, String str21, int i19, List list, DataVolume dataVolume, int i20, int i21, Object obj) {
        long j17;
        long j18;
        String str22 = (i20 & 1) != 0 ? aiPowerPerfRecord.traceId : str;
        String str23 = (i20 & 2) != 0 ? aiPowerPerfRecord.taskId : str2;
        int i22 = (i20 & 4) != 0 ? aiPowerPerfRecord.callerUid : i10;
        String str24 = (i20 & 8) != 0 ? aiPowerPerfRecord.callerPkg : str3;
        String str25 = (i20 & 16) != 0 ? aiPowerPerfRecord.abilityId : str4;
        String str26 = (i20 & 32) != 0 ? aiPowerPerfRecord.modelId : str5;
        String str27 = (i20 & 64) != 0 ? aiPowerPerfRecord.modelVersion : str6;
        String str28 = (i20 & TraceIdKeys.MAX_LENGTH) != 0 ? aiPowerPerfRecord.engineVersion : str7;
        String str29 = (i20 & 256) != 0 ? aiPowerPerfRecord.backend : str8;
        String str30 = (i20 & VadSessionManager.FRAME_BYTES) != 0 ? aiPowerPerfRecord.hardware : str9;
        String str31 = (i20 & 1024) != 0 ? aiPowerPerfRecord.executionLocation : str10;
        long j19 = (i20 & 2048) != 0 ? aiPowerPerfRecord.startMonoNs : j10;
        String str32 = str22;
        String str33 = str23;
        long j20 = (i20 & 4096) != 0 ? aiPowerPerfRecord.endMonoNs : j11;
        long j21 = (i20 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? aiPowerPerfRecord.startWallMs : j12;
        long j22 = (i20 & 16384) != 0 ? aiPowerPerfRecord.e2eMs : j13;
        long j23 = (i20 & 32768) != 0 ? aiPowerPerfRecord.ttftMs : j14;
        float f10 = (i20 & 65536) != 0 ? aiPowerPerfRecord.decodeTps : f8;
        String str34 = (i20 & 131072) != 0 ? aiPowerPerfRecord.modelCacheState : str11;
        int i23 = (i20 & 262144) != 0 ? aiPowerPerfRecord.modelLoadMs : i11;
        int i24 = (i20 & 524288) != 0 ? aiPowerPerfRecord.npuAttributedMs : i12;
        int i25 = (i20 & CryptoHeaderParser.MAX_BLOCK_SIZE) != 0 ? aiPowerPerfRecord.gpuAttributedMs : i13;
        int i26 = (i20 & 2097152) != 0 ? aiPowerPerfRecord.dspAttributedMs : i14;
        int i27 = (i20 & 4194304) != 0 ? aiPowerPerfRecord.cpuAttributedMs : i15;
        long j24 = j23;
        long j25 = (i20 & 8388608) != 0 ? aiPowerPerfRecord.cpuEnergyUj : j15;
        int i28 = i27;
        String str35 = (i20 & 16777216) != 0 ? aiPowerPerfRecord.npuPerfLevel : str12;
        int i29 = (i20 & 33554432) != 0 ? aiPowerPerfRecord.cpuFreqMhzAvg : i16;
        int i30 = (i20 & 67108864) != 0 ? aiPowerPerfRecord.ddrFreqMhzAvg : i17;
        float f11 = (i20 & 134217728) != 0 ? aiPowerPerfRecord.shellTempC : f9;
        String str36 = (i20 & 268435456) != 0 ? aiPowerPerfRecord.status : str13;
        int i31 = (i20 & 536870912) != 0 ? aiPowerPerfRecord.errorCode : i18;
        String str37 = (i20 & 1073741824) != 0 ? aiPowerPerfRecord.expLogId : str14;
        boolean z3 = (i20 & Integer.MIN_VALUE) != 0 ? aiPowerPerfRecord.isForeground : z;
        String str38 = (i21 & 1) != 0 ? aiPowerPerfRecord.failClass : str15;
        String str39 = (i21 & 2) != 0 ? aiPowerPerfRecord.exceptionMsg : str16;
        String str40 = (i21 & 4) != 0 ? aiPowerPerfRecord.stackDigest : str17;
        String str41 = (i21 & 8) != 0 ? aiPowerPerfRecord.failStack : str18;
        if ((i21 & 16) != 0) {
            j17 = j25;
            j18 = aiPowerPerfRecord.retryAfterMs;
        } else {
            j17 = j25;
            j18 = j16;
        }
        return aiPowerPerfRecord.copy(str32, str33, i22, str24, str25, str26, str27, str28, str29, str30, str31, j19, j20, j21, j22, j24, f10, str34, i23, i24, i25, i26, i28, j17, str35, i29, i30, f11, str36, i31, str37, z3, str38, str39, str40, str41, j18, (i21 & 32) != 0 ? aiPowerPerfRecord.priority : str19, (i21 & 64) != 0 ? aiPowerPerfRecord.failStage : str20, (i21 & TraceIdKeys.MAX_LENGTH) != 0 ? aiPowerPerfRecord.sceneId : str21, (i21 & 256) != 0 ? aiPowerPerfRecord.engineSceneId : i19, (i21 & VadSessionManager.FRAME_BYTES) != 0 ? aiPowerPerfRecord.phases : list, (i21 & 1024) != 0 ? aiPowerPerfRecord.dataVolume : dataVolume);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long toTags$lambda$13$lambda$5$lambda$3(PhaseRecord it) {
        kotlin.jvm.internal.g.f(it, "it");
        return it.getBeginMs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean toTags$lambda$13$lambda$5$lambda$4(long j10) {
        return j10 >= 0;
    }

    public final String component1() {
        return this.traceId;
    }

    public final String component10() {
        return this.hardware;
    }

    public final String component11() {
        return this.executionLocation;
    }

    public final long component12() {
        return this.startMonoNs;
    }

    public final long component13() {
        return this.endMonoNs;
    }

    public final long component14() {
        return this.startWallMs;
    }

    public final long component15() {
        return this.e2eMs;
    }

    public final long component16() {
        return this.ttftMs;
    }

    public final float component17() {
        return this.decodeTps;
    }

    public final String component18() {
        return this.modelCacheState;
    }

    public final int component19() {
        return this.modelLoadMs;
    }

    public final String component2() {
        return this.taskId;
    }

    public final int component20() {
        return this.npuAttributedMs;
    }

    public final int component21() {
        return this.gpuAttributedMs;
    }

    public final int component22() {
        return this.dspAttributedMs;
    }

    public final int component23() {
        return this.cpuAttributedMs;
    }

    public final long component24() {
        return this.cpuEnergyUj;
    }

    public final String component25() {
        return this.npuPerfLevel;
    }

    public final int component26() {
        return this.cpuFreqMhzAvg;
    }

    public final int component27() {
        return this.ddrFreqMhzAvg;
    }

    public final float component28() {
        return this.shellTempC;
    }

    public final String component29() {
        return this.status;
    }

    public final int component3() {
        return this.callerUid;
    }

    public final int component30() {
        return this.errorCode;
    }

    public final String component31() {
        return this.expLogId;
    }

    public final boolean component32() {
        return this.isForeground;
    }

    public final String component33() {
        return this.failClass;
    }

    public final String component34() {
        return this.exceptionMsg;
    }

    public final String component35() {
        return this.stackDigest;
    }

    public final String component36() {
        return this.failStack;
    }

    public final long component37() {
        return this.retryAfterMs;
    }

    public final String component38() {
        return this.priority;
    }

    public final String component39() {
        return this.failStage;
    }

    public final String component4() {
        return this.callerPkg;
    }

    public final String component40() {
        return this.sceneId;
    }

    public final int component41() {
        return this.engineSceneId;
    }

    public final List<PhaseRecord> component42() {
        return this.phases;
    }

    public final DataVolume component43() {
        return this.dataVolume;
    }

    public final String component5() {
        return this.abilityId;
    }

    public final String component6() {
        return this.modelId;
    }

    public final String component7() {
        return this.modelVersion;
    }

    public final String component8() {
        return this.engineVersion;
    }

    public final String component9() {
        return this.backend;
    }

    public final AiPowerPerfRecord copy(String traceId, String taskId, int i10, String callerPkg, String abilityId, String modelId, String modelVersion, String engineVersion, String backend, String hardware, String executionLocation, long j10, long j11, long j12, long j13, long j14, float f8, String modelCacheState, int i11, int i12, int i13, int i14, int i15, long j15, String npuPerfLevel, int i16, int i17, float f9, String status, int i18, String expLogId, boolean z, String failClass, String exceptionMsg, String stackDigest, String failStack, long j16, String priority, String failStage, String str, int i19, List<PhaseRecord> phases, DataVolume dataVolume) {
        kotlin.jvm.internal.g.f(traceId, "traceId");
        kotlin.jvm.internal.g.f(taskId, "taskId");
        kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(modelVersion, "modelVersion");
        kotlin.jvm.internal.g.f(engineVersion, "engineVersion");
        kotlin.jvm.internal.g.f(backend, "backend");
        kotlin.jvm.internal.g.f(hardware, "hardware");
        kotlin.jvm.internal.g.f(executionLocation, "executionLocation");
        kotlin.jvm.internal.g.f(modelCacheState, "modelCacheState");
        kotlin.jvm.internal.g.f(npuPerfLevel, "npuPerfLevel");
        kotlin.jvm.internal.g.f(status, "status");
        kotlin.jvm.internal.g.f(expLogId, "expLogId");
        kotlin.jvm.internal.g.f(failClass, "failClass");
        kotlin.jvm.internal.g.f(exceptionMsg, "exceptionMsg");
        kotlin.jvm.internal.g.f(stackDigest, "stackDigest");
        kotlin.jvm.internal.g.f(failStack, "failStack");
        kotlin.jvm.internal.g.f(priority, "priority");
        kotlin.jvm.internal.g.f(failStage, "failStage");
        kotlin.jvm.internal.g.f(phases, "phases");
        return new AiPowerPerfRecord(traceId, taskId, i10, callerPkg, abilityId, modelId, modelVersion, engineVersion, backend, hardware, executionLocation, j10, j11, j12, j13, j14, f8, modelCacheState, i11, i12, i13, i14, i15, j15, npuPerfLevel, i16, i17, f9, status, i18, expLogId, z, failClass, exceptionMsg, stackDigest, failStack, j16, priority, failStage, str, i19, phases, dataVolume);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiPowerPerfRecord)) {
            return false;
        }
        AiPowerPerfRecord aiPowerPerfRecord = (AiPowerPerfRecord) obj;
        return kotlin.jvm.internal.g.b(this.traceId, aiPowerPerfRecord.traceId) && kotlin.jvm.internal.g.b(this.taskId, aiPowerPerfRecord.taskId) && this.callerUid == aiPowerPerfRecord.callerUid && kotlin.jvm.internal.g.b(this.callerPkg, aiPowerPerfRecord.callerPkg) && kotlin.jvm.internal.g.b(this.abilityId, aiPowerPerfRecord.abilityId) && kotlin.jvm.internal.g.b(this.modelId, aiPowerPerfRecord.modelId) && kotlin.jvm.internal.g.b(this.modelVersion, aiPowerPerfRecord.modelVersion) && kotlin.jvm.internal.g.b(this.engineVersion, aiPowerPerfRecord.engineVersion) && kotlin.jvm.internal.g.b(this.backend, aiPowerPerfRecord.backend) && kotlin.jvm.internal.g.b(this.hardware, aiPowerPerfRecord.hardware) && kotlin.jvm.internal.g.b(this.executionLocation, aiPowerPerfRecord.executionLocation) && this.startMonoNs == aiPowerPerfRecord.startMonoNs && this.endMonoNs == aiPowerPerfRecord.endMonoNs && this.startWallMs == aiPowerPerfRecord.startWallMs && this.e2eMs == aiPowerPerfRecord.e2eMs && this.ttftMs == aiPowerPerfRecord.ttftMs && Float.compare(this.decodeTps, aiPowerPerfRecord.decodeTps) == 0 && kotlin.jvm.internal.g.b(this.modelCacheState, aiPowerPerfRecord.modelCacheState) && this.modelLoadMs == aiPowerPerfRecord.modelLoadMs && this.npuAttributedMs == aiPowerPerfRecord.npuAttributedMs && this.gpuAttributedMs == aiPowerPerfRecord.gpuAttributedMs && this.dspAttributedMs == aiPowerPerfRecord.dspAttributedMs && this.cpuAttributedMs == aiPowerPerfRecord.cpuAttributedMs && this.cpuEnergyUj == aiPowerPerfRecord.cpuEnergyUj && kotlin.jvm.internal.g.b(this.npuPerfLevel, aiPowerPerfRecord.npuPerfLevel) && this.cpuFreqMhzAvg == aiPowerPerfRecord.cpuFreqMhzAvg && this.ddrFreqMhzAvg == aiPowerPerfRecord.ddrFreqMhzAvg && Float.compare(this.shellTempC, aiPowerPerfRecord.shellTempC) == 0 && kotlin.jvm.internal.g.b(this.status, aiPowerPerfRecord.status) && this.errorCode == aiPowerPerfRecord.errorCode && kotlin.jvm.internal.g.b(this.expLogId, aiPowerPerfRecord.expLogId) && this.isForeground == aiPowerPerfRecord.isForeground && kotlin.jvm.internal.g.b(this.failClass, aiPowerPerfRecord.failClass) && kotlin.jvm.internal.g.b(this.exceptionMsg, aiPowerPerfRecord.exceptionMsg) && kotlin.jvm.internal.g.b(this.stackDigest, aiPowerPerfRecord.stackDigest) && kotlin.jvm.internal.g.b(this.failStack, aiPowerPerfRecord.failStack) && this.retryAfterMs == aiPowerPerfRecord.retryAfterMs && kotlin.jvm.internal.g.b(this.priority, aiPowerPerfRecord.priority) && kotlin.jvm.internal.g.b(this.failStage, aiPowerPerfRecord.failStage) && kotlin.jvm.internal.g.b(this.sceneId, aiPowerPerfRecord.sceneId) && this.engineSceneId == aiPowerPerfRecord.engineSceneId && kotlin.jvm.internal.g.b(this.phases, aiPowerPerfRecord.phases) && kotlin.jvm.internal.g.b(this.dataVolume, aiPowerPerfRecord.dataVolume);
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

    public final int getCpuAttributedMs() {
        return this.cpuAttributedMs;
    }

    public final long getCpuEnergyUj() {
        return this.cpuEnergyUj;
    }

    public final int getCpuFreqMhzAvg() {
        return this.cpuFreqMhzAvg;
    }

    public final DataVolume getDataVolume() {
        return this.dataVolume;
    }

    public final int getDdrFreqMhzAvg() {
        return this.ddrFreqMhzAvg;
    }

    public final float getDecodeTps() {
        return this.decodeTps;
    }

    public final int getDspAttributedMs() {
        return this.dspAttributedMs;
    }

    public final long getE2eMs() {
        return this.e2eMs;
    }

    public final long getEndMonoNs() {
        return this.endMonoNs;
    }

    public final int getEngineSceneId() {
        return this.engineSceneId;
    }

    public final String getEngineVersion() {
        return this.engineVersion;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public final String getExecutionLocation() {
        return this.executionLocation;
    }

    public final String getExpLogId() {
        return this.expLogId;
    }

    public final String getFailClass() {
        return this.failClass;
    }

    public final String getFailStack() {
        return this.failStack;
    }

    public final String getFailStage() {
        return this.failStage;
    }

    public final int getGpuAttributedMs() {
        return this.gpuAttributedMs;
    }

    public final String getHardware() {
        return this.hardware;
    }

    public final String getModelCacheState() {
        return this.modelCacheState;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final int getModelLoadMs() {
        return this.modelLoadMs;
    }

    public final String getModelVersion() {
        return this.modelVersion;
    }

    public final int getNpuAttributedMs() {
        return this.npuAttributedMs;
    }

    public final String getNpuPerfLevel() {
        return this.npuPerfLevel;
    }

    public final List<PhaseRecord> getPhases() {
        return this.phases;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final long getRetryAfterMs() {
        return this.retryAfterMs;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final float getShellTempC() {
        return this.shellTempC;
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

    public final String getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final long getTtftMs() {
        return this.ttftMs;
    }

    public int hashCode() {
        int iA = v1.d.a(v1.d.a(a0.a.c(v1.d.a(v1.d.a(v1.d.a(v1.d.a(ai.onnxruntime.a.f(v1.d.a(ai.onnxruntime.a.d(this.errorCode, v1.d.a(a0.a.a(this.shellTempC, ai.onnxruntime.a.d(this.ddrFreqMhzAvg, ai.onnxruntime.a.d(this.cpuFreqMhzAvg, v1.d.a(a0.a.c(ai.onnxruntime.a.d(this.cpuAttributedMs, ai.onnxruntime.a.d(this.dspAttributedMs, ai.onnxruntime.a.d(this.gpuAttributedMs, ai.onnxruntime.a.d(this.npuAttributedMs, ai.onnxruntime.a.d(this.modelLoadMs, v1.d.a(a0.a.a(this.decodeTps, a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(ai.onnxruntime.a.d(this.callerUid, v1.d.a(this.traceId.hashCode() * 31, 31, this.taskId), 31), 31, this.callerPkg), 31, this.abilityId), 31, this.modelId), 31, this.modelVersion), 31, this.engineVersion), 31, this.backend), 31, this.hardware), 31, this.executionLocation), this.startMonoNs, 31), this.endMonoNs, 31), this.startWallMs, 31), this.e2eMs, 31), this.ttftMs, 31), 31), 31, this.modelCacheState), 31), 31), 31), 31), 31), this.cpuEnergyUj, 31), 31, this.npuPerfLevel), 31), 31), 31), 31, this.status), 31), 31, this.expLogId), 31, this.isForeground), 31, this.failClass), 31, this.exceptionMsg), 31, this.stackDigest), 31, this.failStack), this.retryAfterMs, 31), 31, this.priority), 31, this.failStage);
        String str = this.sceneId;
        int iB = h0.e.b(this.phases, ai.onnxruntime.a.d(this.engineSceneId, (iA + (str == null ? 0 : str.hashCode())) * 31, 31), 31);
        DataVolume dataVolume = this.dataVolume;
        return iB + (dataVolume != null ? dataVolume.hashCode() : 0);
    }

    public final boolean isForeground() {
        return this.isForeground;
    }

    public String toString() {
        String str = this.traceId;
        String str2 = this.taskId;
        int i10 = this.callerUid;
        String str3 = this.callerPkg;
        String str4 = this.abilityId;
        String str5 = this.modelId;
        String str6 = this.modelVersion;
        String str7 = this.engineVersion;
        String str8 = this.backend;
        String str9 = this.hardware;
        String str10 = this.executionLocation;
        long j10 = this.startMonoNs;
        long j11 = this.endMonoNs;
        long j12 = this.startWallMs;
        long j13 = this.e2eMs;
        long j14 = this.ttftMs;
        float f8 = this.decodeTps;
        String str11 = this.modelCacheState;
        int i11 = this.modelLoadMs;
        int i12 = this.npuAttributedMs;
        int i13 = this.gpuAttributedMs;
        int i14 = this.dspAttributedMs;
        int i15 = this.cpuAttributedMs;
        long j15 = this.cpuEnergyUj;
        String str12 = this.npuPerfLevel;
        int i16 = this.cpuFreqMhzAvg;
        int i17 = this.ddrFreqMhzAvg;
        float f9 = this.shellTempC;
        String str13 = this.status;
        int i18 = this.errorCode;
        String str14 = this.expLogId;
        boolean z = this.isForeground;
        String str15 = this.failClass;
        String str16 = this.exceptionMsg;
        String str17 = this.stackDigest;
        String str18 = this.failStack;
        long j16 = this.retryAfterMs;
        String str19 = this.priority;
        String str20 = this.failStage;
        String str21 = this.sceneId;
        int i19 = this.engineSceneId;
        List<PhaseRecord> list = this.phases;
        DataVolume dataVolume = this.dataVolume;
        StringBuilder sbS = ai.onnxruntime.a.s("AiPowerPerfRecord(traceId=", str, ", taskId=", str2, ", callerUid=");
        h0.e.h(i10, ", callerPkg=", str3, ", abilityId=", sbS);
        ai.onnxruntime.a.z(sbS, str4, ", modelId=", str5, ", modelVersion=");
        ai.onnxruntime.a.z(sbS, str6, ", engineVersion=", str7, ", backend=");
        ai.onnxruntime.a.z(sbS, str8, ", hardware=", str9, ", executionLocation=");
        com.stepos.core.ota.d.p(j10, str10, ", startMonoNs=", sbS);
        a0.a.s(j11, ", endMonoNs=", ", startWallMs=", sbS);
        sbS.append(j12);
        a0.a.s(j13, ", e2eMs=", ", ttftMs=", sbS);
        sbS.append(j14);
        sbS.append(", decodeTps=");
        sbS.append(f8);
        sbS.append(", modelCacheState=");
        sbS.append(str11);
        sbS.append(", modelLoadMs=");
        sbS.append(i11);
        sbS.append(", npuAttributedMs=");
        sbS.append(i12);
        sbS.append(", gpuAttributedMs=");
        sbS.append(i13);
        sbS.append(", dspAttributedMs=");
        sbS.append(i14);
        sbS.append(", cpuAttributedMs=");
        sbS.append(i15);
        a0.a.s(j15, ", cpuEnergyUj=", ", npuPerfLevel=", sbS);
        com.stepos.core.ota.d.o(i16, str12, ", cpuFreqMhzAvg=", ", ddrFreqMhzAvg=", sbS);
        sbS.append(i17);
        sbS.append(", shellTempC=");
        sbS.append(f9);
        sbS.append(", status=");
        com.stepos.core.ota.d.o(i18, str13, ", errorCode=", ", expLogId=", sbS);
        sbS.append(str14);
        sbS.append(", isForeground=");
        sbS.append(z);
        sbS.append(", failClass=");
        ai.onnxruntime.a.z(sbS, str15, ", exceptionMsg=", str16, ", stackDigest=");
        ai.onnxruntime.a.z(sbS, str17, ", failStack=", str18, ", retryAfterMs=");
        ai.onnxruntime.a.u(j16, ", priority=", str19, sbS);
        ai.onnxruntime.a.z(sbS, ", failStage=", str20, ", sceneId=", str21);
        sbS.append(", engineSceneId=");
        sbS.append(i19);
        sbS.append(", phases=");
        sbS.append(list);
        sbS.append(", dataVolume=");
        sbS.append(dataVolume);
        sbS.append(")");
        return sbS.toString();
    }

    public final Map<String, String> toTags() {
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put("ai_trace_id", this.traceId);
        mapBuilder.put("ai_task_id", this.taskId);
        mapBuilder.put("caller_uid", String.valueOf(this.callerUid));
        mapBuilder.put("caller_pkg", this.callerPkg);
        mapBuilder.put("ability_id", this.abilityId);
        mapBuilder.put("model_id", this.modelId);
        if (this.modelVersion.length() > 0) {
            mapBuilder.put("model_version", this.modelVersion);
        }
        mapBuilder.put("engine_version", this.engineVersion);
        mapBuilder.put("backend", this.backend);
        mapBuilder.put("hardware", this.hardware);
        mapBuilder.put("start_mono_ns", String.valueOf(this.startMonoNs));
        mapBuilder.put("end_mono_ns", String.valueOf(this.endMonoNs));
        mapBuilder.put("start_wall_ms", String.valueOf(this.startWallMs));
        mapBuilder.put("e2e_ms", String.valueOf(this.e2eMs));
        long j10 = this.ttftMs;
        if (j10 > 0) {
            mapBuilder.put("ttft_ms", String.valueOf(j10));
        }
        float f8 = this.decodeTps;
        if (f8 > 0.0f) {
            mapBuilder.put("decode_tps", String.valueOf(f8));
        }
        if (this.modelCacheState.length() > 0) {
            mapBuilder.put("model_cache_state", this.modelCacheState);
        }
        int i10 = this.modelLoadMs;
        if (i10 > 0) {
            mapBuilder.put("model_load_ms", String.valueOf(i10));
        }
        int i11 = this.npuAttributedMs;
        if (i11 != -1) {
            mapBuilder.put("npu_attributed_ms", String.valueOf(i11));
        }
        int i12 = this.gpuAttributedMs;
        if (i12 != -1) {
            mapBuilder.put("gpu_attributed_ms", String.valueOf(i12));
        }
        int i13 = this.dspAttributedMs;
        if (i13 != -1) {
            mapBuilder.put("dsp_attributed_ms", String.valueOf(i13));
        }
        int i14 = this.cpuAttributedMs;
        if (i14 != -1) {
            mapBuilder.put("cpu_attributed_ms", String.valueOf(i14));
        }
        long j11 = this.cpuEnergyUj;
        if (j11 != -1) {
            mapBuilder.put("cpu_energy_uj", String.valueOf(j11));
        }
        if (this.npuPerfLevel.length() > 0) {
            mapBuilder.put("npu_perf_level", this.npuPerfLevel);
        }
        int i15 = this.cpuFreqMhzAvg;
        if (i15 != -1) {
            mapBuilder.put("cpu_freq_mhz_avg", String.valueOf(i15));
        }
        int i16 = this.ddrFreqMhzAvg;
        if (i16 != -1) {
            mapBuilder.put("ddr_freq_mhz_avg", String.valueOf(i16));
        }
        float f9 = this.shellTempC;
        if (f9 > 0.0f) {
            mapBuilder.put("shell_temp_c", String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f9)}, 1)));
        }
        mapBuilder.put(FileResponse.FIELD_STATUS, this.status);
        int i17 = this.errorCode;
        if (i17 != 0) {
            mapBuilder.put("error_code", String.valueOf(i17));
        }
        if (this.expLogId.length() > 0) {
            mapBuilder.put("exp_log_id", this.expLogId);
        }
        String str = this.sceneId;
        if (str != null) {
        }
        int i18 = this.engineSceneId;
        if (i18 != 0) {
            mapBuilder.put("engine_scene_id", String.valueOf(i18));
        }
        if (!this.phases.isEmpty()) {
            StringBuilder sb2 = new StringBuilder(64);
            List<PhaseRecord> list = this.phases;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                String phase = ((PhaseRecord) obj).getPhase();
                Object arrayList = linkedHashMap.get(phase);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(phase, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                List list2 = (List) entry.getValue();
                Iterator it = list2.iterator();
                int durationMs = 0;
                while (it.hasNext()) {
                    durationMs += ((PhaseRecord) it.next()).getDurationMs();
                }
                if (durationMs > 0) {
                    Long l10 = (Long) p.z(new fc.f(new q(kotlin.collections.a.l0(list2), new b(0)), new com.stepos.core.common.cloud.d(5)));
                    long jLongValue = l10 != null ? l10.longValue() : -1L;
                    sb2.append('{');
                    sb2.append(str2);
                    sb2.append('|');
                    sb2.append(jLongValue);
                    sb2.append('|');
                    sb2.append(durationMs);
                    sb2.append('}');
                }
            }
            if (sb2.length() > 0) {
                String string = sb2.toString();
                kotlin.jvm.internal.g.e(string, "toString(...)");
                mapBuilder.put("phases", string);
            }
        }
        DataVolume dataVolume = this.dataVolume;
        if (dataVolume != null) {
            Integer inputTokens = dataVolume.getInputTokens();
            if (inputTokens != null) {
            }
            Integer outputTokens = dataVolume.getOutputTokens();
            if (outputTokens != null) {
            }
            Integer imageTokens = dataVolume.getImageTokens();
            if (imageTokens != null) {
            }
            Integer audioTokens = dataVolume.getAudioTokens();
            if (audioTokens != null) {
            }
            Integer inputSizeBytes = dataVolume.getInputSizeBytes();
            if (inputSizeBytes != null) {
            }
            Integer outputSizeBytes = dataVolume.getOutputSizeBytes();
            if (outputSizeBytes != null) {
                mapBuilder.put("output_size_bytes", String.valueOf(outputSizeBytes.intValue()));
            }
        }
        return mapBuilder.b();
    }

    public AiPowerPerfRecord(String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, long j10, long j11, long j12, long j13, long j14, float f8, String str11, int i11, int i12, int i13, int i14, int i15, long j15, String str12, int i16, int i17, float f9, String str13, int i18, String str14, boolean z, String str15, String str16, String str17, String str18, long j16, String str19, String str20, String str21, int i19, List list, DataVolume dataVolume, int i20, int i21, kotlin.jvm.internal.e eVar) {
        this(str, str2, i10, str3, str4, str5, (i20 & 64) != 0 ? "" : str6, (i20 & TraceIdKeys.MAX_LENGTH) != 0 ? "" : str7, str8, str9, (i20 & 1024) != 0 ? "LOCAL" : str10, j10, j11, j12, j13, j14, f8, str11, i11, (524288 & i20) != 0 ? -1 : i12, (1048576 & i20) != 0 ? -1 : i13, (2097152 & i20) != 0 ? -1 : i14, (4194304 & i20) != 0 ? -1 : i15, (8388608 & i20) != 0 ? -1L : j15, (16777216 & i20) != 0 ? "" : str12, (33554432 & i20) != 0 ? -1 : i16, (67108864 & i20) != 0 ? -1 : i17, (134217728 & i20) != 0 ? -1.0f : f9, str13, i18, (1073741824 & i20) != 0 ? "" : str14, (i20 & Integer.MIN_VALUE) != 0 ? false : z, (i21 & 1) != 0 ? "" : str15, (i21 & 2) != 0 ? "" : str16, (i21 & 4) != 0 ? "" : str17, (i21 & 8) != 0 ? "" : str18, (i21 & 16) != 0 ? -1L : j16, (i21 & 32) != 0 ? "" : str19, (i21 & 64) != 0 ? FailStage.UNKNOWN : str20, (i21 & TraceIdKeys.MAX_LENGTH) != 0 ? null : str21, (i21 & 256) != 0 ? 0 : i19, (i21 & VadSessionManager.FRAME_BYTES) != 0 ? EmptyList.f10001a : list, (i21 & 1024) != 0 ? null : dataVolume);
    }
}
