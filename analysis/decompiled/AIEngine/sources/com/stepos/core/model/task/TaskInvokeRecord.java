package com.stepos.core.model.task;

import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.Arrays;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskInvokeRecord {
    private final String abilityId;
    private final String backend;
    private final String callerPackage;
    private final int callerUid;
    private final Long canceledAt;
    private final long endedAt;
    private final int errorCode;
    private final String errorMessage;
    private final long firstTokenAt;
    private final long inferenceTimeMs;
    private final boolean modelCacheHit;
    private final String modelId;
    private final long postprocessTimeMs;
    private final long preprocessTimeMs;
    private final long startedAt;
    private final boolean success;
    private final String taskId;
    private final int tokenCount;

    public TaskInvokeRecord(String taskId, String abilityId, String modelId, String callerPackage, int i10, long j10, long j11, Long l10, long j12, int i11, long j13, long j14, long j15, String str, boolean z, boolean z3, int i12, String str2) {
        g.f(taskId, "taskId");
        g.f(abilityId, "abilityId");
        g.f(modelId, "modelId");
        g.f(callerPackage, "callerPackage");
        this.taskId = taskId;
        this.abilityId = abilityId;
        this.modelId = modelId;
        this.callerPackage = callerPackage;
        this.callerUid = i10;
        this.startedAt = j10;
        this.endedAt = j11;
        this.canceledAt = l10;
        this.firstTokenAt = j12;
        this.tokenCount = i11;
        this.preprocessTimeMs = j13;
        this.inferenceTimeMs = j14;
        this.postprocessTimeMs = j15;
        this.backend = str;
        this.modelCacheHit = z;
        this.success = z3;
        this.errorCode = i12;
        this.errorMessage = str2;
    }

    public static /* synthetic */ TaskInvokeRecord copy$default(TaskInvokeRecord taskInvokeRecord, String str, String str2, String str3, String str4, int i10, long j10, long j11, Long l10, long j12, int i11, long j13, long j14, long j15, String str5, boolean z, boolean z3, int i12, String str6, int i13, Object obj) {
        String str7;
        int i14;
        String str8 = (i13 & 1) != 0 ? taskInvokeRecord.taskId : str;
        String str9 = (i13 & 2) != 0 ? taskInvokeRecord.abilityId : str2;
        String str10 = (i13 & 4) != 0 ? taskInvokeRecord.modelId : str3;
        String str11 = (i13 & 8) != 0 ? taskInvokeRecord.callerPackage : str4;
        int i15 = (i13 & 16) != 0 ? taskInvokeRecord.callerUid : i10;
        long j16 = (i13 & 32) != 0 ? taskInvokeRecord.startedAt : j10;
        long j17 = (i13 & 64) != 0 ? taskInvokeRecord.endedAt : j11;
        Long l11 = (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? taskInvokeRecord.canceledAt : l10;
        long j18 = (i13 & 256) != 0 ? taskInvokeRecord.firstTokenAt : j12;
        int i16 = (i13 & VadSessionManager.FRAME_BYTES) != 0 ? taskInvokeRecord.tokenCount : i11;
        String str12 = str8;
        String str13 = str9;
        long j19 = (i13 & 1024) != 0 ? taskInvokeRecord.preprocessTimeMs : j13;
        long j20 = (i13 & 2048) != 0 ? taskInvokeRecord.inferenceTimeMs : j14;
        long j21 = (i13 & 4096) != 0 ? taskInvokeRecord.postprocessTimeMs : j15;
        String str14 = (i13 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? taskInvokeRecord.backend : str5;
        long j22 = j21;
        boolean z10 = (i13 & 16384) != 0 ? taskInvokeRecord.modelCacheHit : z;
        boolean z11 = (32768 & i13) != 0 ? taskInvokeRecord.success : z3;
        int i17 = (i13 & 65536) != 0 ? taskInvokeRecord.errorCode : i12;
        if ((i13 & 131072) != 0) {
            i14 = i17;
            str7 = taskInvokeRecord.errorMessage;
        } else {
            str7 = str6;
            i14 = i17;
        }
        return taskInvokeRecord.copy(str12, str13, str10, str11, i15, j16, j17, l11, j18, i16, j19, j20, j22, str14, z10, z11, i14, str7);
    }

    public final String component1() {
        return this.taskId;
    }

    public final int component10() {
        return this.tokenCount;
    }

    public final long component11() {
        return this.preprocessTimeMs;
    }

    public final long component12() {
        return this.inferenceTimeMs;
    }

    public final long component13() {
        return this.postprocessTimeMs;
    }

    public final String component14() {
        return this.backend;
    }

    public final boolean component15() {
        return this.modelCacheHit;
    }

    public final boolean component16() {
        return this.success;
    }

    public final int component17() {
        return this.errorCode;
    }

    public final String component18() {
        return this.errorMessage;
    }

    public final String component2() {
        return this.abilityId;
    }

    public final String component3() {
        return this.modelId;
    }

    public final String component4() {
        return this.callerPackage;
    }

    public final int component5() {
        return this.callerUid;
    }

    public final long component6() {
        return this.startedAt;
    }

    public final long component7() {
        return this.endedAt;
    }

    public final Long component8() {
        return this.canceledAt;
    }

    public final long component9() {
        return this.firstTokenAt;
    }

    public final TaskInvokeRecord copy(String taskId, String abilityId, String modelId, String callerPackage, int i10, long j10, long j11, Long l10, long j12, int i11, long j13, long j14, long j15, String str, boolean z, boolean z3, int i12, String str2) {
        g.f(taskId, "taskId");
        g.f(abilityId, "abilityId");
        g.f(modelId, "modelId");
        g.f(callerPackage, "callerPackage");
        return new TaskInvokeRecord(taskId, abilityId, modelId, callerPackage, i10, j10, j11, l10, j12, i11, j13, j14, j15, str, z, z3, i12, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskInvokeRecord)) {
            return false;
        }
        TaskInvokeRecord taskInvokeRecord = (TaskInvokeRecord) obj;
        return g.b(this.taskId, taskInvokeRecord.taskId) && g.b(this.abilityId, taskInvokeRecord.abilityId) && g.b(this.modelId, taskInvokeRecord.modelId) && g.b(this.callerPackage, taskInvokeRecord.callerPackage) && this.callerUid == taskInvokeRecord.callerUid && this.startedAt == taskInvokeRecord.startedAt && this.endedAt == taskInvokeRecord.endedAt && g.b(this.canceledAt, taskInvokeRecord.canceledAt) && this.firstTokenAt == taskInvokeRecord.firstTokenAt && this.tokenCount == taskInvokeRecord.tokenCount && this.preprocessTimeMs == taskInvokeRecord.preprocessTimeMs && this.inferenceTimeMs == taskInvokeRecord.inferenceTimeMs && this.postprocessTimeMs == taskInvokeRecord.postprocessTimeMs && g.b(this.backend, taskInvokeRecord.backend) && this.modelCacheHit == taskInvokeRecord.modelCacheHit && this.success == taskInvokeRecord.success && this.errorCode == taskInvokeRecord.errorCode && g.b(this.errorMessage, taskInvokeRecord.errorMessage);
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final String getBackend() {
        return this.backend;
    }

    public final String getCallerPackage() {
        return this.callerPackage;
    }

    public final int getCallerUid() {
        return this.callerUid;
    }

    public final Long getCanceledAt() {
        return this.canceledAt;
    }

    public final long getEndedAt() {
        return this.endedAt;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final long getFirstTokenAt() {
        return this.firstTokenAt;
    }

    public final long getInferenceTimeMs() {
        return this.inferenceTimeMs;
    }

    public final boolean getModelCacheHit() {
        return this.modelCacheHit;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final long getPostprocessTimeMs() {
        return this.postprocessTimeMs;
    }

    public final long getPreprocessTimeMs() {
        return this.preprocessTimeMs;
    }

    public final long getStartedAt() {
        return this.startedAt;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getTaskId() {
        return this.taskId;
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

    public final long getTotalTimeMs() {
        return this.endedAt - this.startedAt;
    }

    public int hashCode() {
        int iC = a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.callerUid, v1.d.a(v1.d.a(v1.d.a(this.taskId.hashCode() * 31, 31, this.abilityId), 31, this.modelId), 31, this.callerPackage), 31), this.startedAt, 31), this.endedAt, 31);
        Long l10 = this.canceledAt;
        int iC2 = a0.a.c(a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.tokenCount, a0.a.c((iC + (l10 == null ? 0 : l10.hashCode())) * 31, this.firstTokenAt, 31), 31), this.preprocessTimeMs, 31), this.inferenceTimeMs, 31), this.postprocessTimeMs, 31);
        String str = this.backend;
        int iD = ai.onnxruntime.a.d(this.errorCode, ai.onnxruntime.a.f(ai.onnxruntime.a.f((iC2 + (str == null ? 0 : str.hashCode())) * 31, 31, this.modelCacheHit), 31, this.success), 31);
        String str2 = this.errorMessage;
        return iD + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toLogString() {
        String str = this.taskId;
        String str2 = this.modelId;
        long j10 = this.inferenceTimeMs;
        long j11 = this.firstTokenAt;
        long j12 = j11 > 0 ? j11 - this.startedAt : -1L;
        String str3 = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(getTokensPerSecond())}, 1));
        boolean z = this.canceledAt != null;
        StringBuilder sbS = ai.onnxruntime.a.s("[", str, "] model=", str2, " invoke=");
        sbS.append(j10);
        a0.a.s(j12, "ms ttft=", "ms tps=", sbS);
        sbS.append(str3);
        sbS.append(" canceled=");
        sbS.append(z);
        return sbS.toString();
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.abilityId;
        String str3 = this.modelId;
        String str4 = this.callerPackage;
        int i10 = this.callerUid;
        long j10 = this.startedAt;
        long j11 = this.endedAt;
        Long l10 = this.canceledAt;
        long j12 = this.firstTokenAt;
        int i11 = this.tokenCount;
        long j13 = this.preprocessTimeMs;
        long j14 = this.inferenceTimeMs;
        long j15 = this.postprocessTimeMs;
        String str5 = this.backend;
        boolean z = this.modelCacheHit;
        boolean z3 = this.success;
        int i12 = this.errorCode;
        String str6 = this.errorMessage;
        StringBuilder sbS = ai.onnxruntime.a.s("TaskInvokeRecord(taskId=", str, ", abilityId=", str2, ", modelId=");
        ai.onnxruntime.a.z(sbS, str3, ", callerPackage=", str4, ", callerUid=");
        com.stepos.core.ota.d.s(sbS, i10, ", startedAt=", j10);
        a0.a.s(j11, ", endedAt=", ", canceledAt=", sbS);
        sbS.append(l10);
        sbS.append(", firstTokenAt=");
        sbS.append(j12);
        sbS.append(", tokenCount=");
        sbS.append(i11);
        sbS.append(", preprocessTimeMs=");
        sbS.append(j13);
        a0.a.s(j14, ", inferenceTimeMs=", ", postprocessTimeMs=", sbS);
        ai.onnxruntime.a.u(j15, ", backend=", str5, sbS);
        sbS.append(", modelCacheHit=");
        sbS.append(z);
        sbS.append(", success=");
        sbS.append(z3);
        sbS.append(", errorCode=");
        sbS.append(i12);
        sbS.append(", errorMessage=");
        sbS.append(str6);
        sbS.append(")");
        return sbS.toString();
    }

    public /* synthetic */ TaskInvokeRecord(String str, String str2, String str3, String str4, int i10, long j10, long j11, Long l10, long j12, int i11, long j13, long j14, long j15, String str5, boolean z, boolean z3, int i12, String str6, int i13, e eVar) {
        this(str, str2, str3, str4, i10, j10, j11, (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? null : l10, (i13 & 256) != 0 ? 0L : j12, i11, j13, j14, j15, str5, z, z3, i12, str6);
    }
}
