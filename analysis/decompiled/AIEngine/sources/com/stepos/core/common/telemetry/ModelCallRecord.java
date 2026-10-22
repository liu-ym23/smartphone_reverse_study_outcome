package com.stepos.core.common.telemetry;

import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.cloud.CloudCorrelationSource;
import com.stepos.core.common.cloud.CloudTransport;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.crypto.CryptoHeaderParser;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import com.tonyodev.fetch2core.server.FileResponse;
import gc.q;
import java.util.Map;
import kotlin.collections.builders.MapBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCallRecord {
    public static final Companion Companion = new Companion(null);
    private final String abilityId;
    private final long asrMs;
    private final String asyncTaskId;
    private final long audioDurationMs;
    private final String callerPkg;
    private final int callerUid;
    private final String clientDebugTraceId;
    private final String cloudCorrelationId;
    private final long connectToOpenMs;
    private final int connectionGeneration;
    private final String correlationSource;
    private final long e2eMs;
    private final long endMonoNs;
    private final int errorCode;
    private final ModelCallExecutionPath executionPath;
    private final String gatewayTraceId;
    private final long handshakeAckToReadyMs;
    private final long headerFetchMs;
    private final String inferId;
    private final String modelId;
    private final long openToHandshakeAckMs;
    private final long startMonoNs;
    private final long startWallMs;
    private final String status;
    private final String transport;
    private final long ttftMs;
    private final long uploadMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final String sourceName(CloudCorrelationSource cloudCorrelationSource) {
            String strName = cloudCorrelationSource != null ? cloudCorrelationSource.name() : null;
            return strName == null ? "" : strName;
        }

        public final String transportName(CloudTransport transport) {
            kotlin.jvm.internal.g.f(transport, "transport");
            return transport.name();
        }

        private Companion() {
        }
    }

    public ModelCallRecord(ModelCallExecutionPath executionPath, String cloudCorrelationId, String correlationSource, String inferId, String abilityId, String modelId, String transport, int i10, String callerPkg, String clientDebugTraceId, String gatewayTraceId, String asyncTaskId, int i11, String status, int i12, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21) {
        kotlin.jvm.internal.g.f(executionPath, "executionPath");
        kotlin.jvm.internal.g.f(cloudCorrelationId, "cloudCorrelationId");
        kotlin.jvm.internal.g.f(correlationSource, "correlationSource");
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(transport, "transport");
        kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
        kotlin.jvm.internal.g.f(clientDebugTraceId, "clientDebugTraceId");
        kotlin.jvm.internal.g.f(gatewayTraceId, "gatewayTraceId");
        kotlin.jvm.internal.g.f(asyncTaskId, "asyncTaskId");
        kotlin.jvm.internal.g.f(status, "status");
        this.executionPath = executionPath;
        this.cloudCorrelationId = cloudCorrelationId;
        this.correlationSource = correlationSource;
        this.inferId = inferId;
        this.abilityId = abilityId;
        this.modelId = modelId;
        this.transport = transport;
        this.callerUid = i10;
        this.callerPkg = callerPkg;
        this.clientDebugTraceId = clientDebugTraceId;
        this.gatewayTraceId = gatewayTraceId;
        this.asyncTaskId = asyncTaskId;
        this.connectionGeneration = i11;
        this.status = status;
        this.errorCode = i12;
        this.startMonoNs = j10;
        this.endMonoNs = j11;
        this.startWallMs = j12;
        this.e2eMs = j13;
        this.ttftMs = j14;
        this.headerFetchMs = j15;
        this.connectToOpenMs = j16;
        this.openToHandshakeAckMs = j17;
        this.handshakeAckToReadyMs = j18;
        this.uploadMs = j19;
        this.asrMs = j20;
        this.audioDurationMs = j21;
    }

    public static /* synthetic */ ModelCallRecord copy$default(ModelCallRecord modelCallRecord, ModelCallExecutionPath modelCallExecutionPath, String str, String str2, String str3, String str4, String str5, String str6, int i10, String str7, String str8, String str9, String str10, int i11, String str11, int i12, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, int i13, Object obj) {
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j30;
        int i14;
        String str12;
        String str13;
        String str14;
        String str15;
        int i15;
        String str16;
        int i16;
        long j31;
        long j32;
        long j33;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        ModelCallExecutionPath modelCallExecutionPath2 = (i13 & 1) != 0 ? modelCallRecord.executionPath : modelCallExecutionPath;
        String str23 = (i13 & 2) != 0 ? modelCallRecord.cloudCorrelationId : str;
        String str24 = (i13 & 4) != 0 ? modelCallRecord.correlationSource : str2;
        String str25 = (i13 & 8) != 0 ? modelCallRecord.inferId : str3;
        String str26 = (i13 & 16) != 0 ? modelCallRecord.abilityId : str4;
        String str27 = (i13 & 32) != 0 ? modelCallRecord.modelId : str5;
        String str28 = (i13 & 64) != 0 ? modelCallRecord.transport : str6;
        int i17 = (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? modelCallRecord.callerUid : i10;
        String str29 = (i13 & 256) != 0 ? modelCallRecord.callerPkg : str7;
        String str30 = (i13 & VadSessionManager.FRAME_BYTES) != 0 ? modelCallRecord.clientDebugTraceId : str8;
        String str31 = (i13 & 1024) != 0 ? modelCallRecord.gatewayTraceId : str9;
        String str32 = (i13 & 2048) != 0 ? modelCallRecord.asyncTaskId : str10;
        int i18 = (i13 & 4096) != 0 ? modelCallRecord.connectionGeneration : i11;
        String str33 = (i13 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? modelCallRecord.status : str11;
        ModelCallExecutionPath modelCallExecutionPath3 = modelCallExecutionPath2;
        int i19 = (i13 & 16384) != 0 ? modelCallRecord.errorCode : i12;
        long j34 = (i13 & 32768) != 0 ? modelCallRecord.startMonoNs : j10;
        long j35 = (i13 & 65536) != 0 ? modelCallRecord.endMonoNs : j11;
        long j36 = (i13 & 131072) != 0 ? modelCallRecord.startWallMs : j12;
        long j37 = (i13 & 262144) != 0 ? modelCallRecord.e2eMs : j13;
        long j38 = (i13 & 524288) != 0 ? modelCallRecord.ttftMs : j14;
        long j39 = (i13 & CryptoHeaderParser.MAX_BLOCK_SIZE) != 0 ? modelCallRecord.headerFetchMs : j15;
        long j40 = (i13 & 2097152) != 0 ? modelCallRecord.connectToOpenMs : j16;
        long j41 = (i13 & 4194304) != 0 ? modelCallRecord.openToHandshakeAckMs : j17;
        long j42 = (i13 & 8388608) != 0 ? modelCallRecord.handshakeAckToReadyMs : j18;
        long j43 = (i13 & 16777216) != 0 ? modelCallRecord.uploadMs : j19;
        long j44 = (i13 & 33554432) != 0 ? modelCallRecord.asrMs : j20;
        if ((i13 & 67108864) != 0) {
            j23 = j44;
            j22 = modelCallRecord.audioDurationMs;
            j25 = j38;
            j26 = j39;
            j27 = j40;
            j28 = j41;
            j29 = j42;
            j30 = j43;
            str13 = str30;
            str14 = str31;
            str15 = str32;
            i15 = i18;
            str16 = str33;
            i16 = i19;
            j31 = j34;
            j32 = j35;
            j33 = j36;
            j24 = j37;
            str17 = str23;
            str18 = str24;
            str19 = str25;
            str20 = str26;
            str21 = str27;
            str22 = str28;
            i14 = i17;
            str12 = str29;
        } else {
            j22 = j21;
            j23 = j44;
            j24 = j37;
            j25 = j38;
            j26 = j39;
            j27 = j40;
            j28 = j41;
            j29 = j42;
            j30 = j43;
            i14 = i17;
            str12 = str29;
            str13 = str30;
            str14 = str31;
            str15 = str32;
            i15 = i18;
            str16 = str33;
            i16 = i19;
            j31 = j34;
            j32 = j35;
            j33 = j36;
            str17 = str23;
            str18 = str24;
            str19 = str25;
            str20 = str26;
            str21 = str27;
            str22 = str28;
        }
        return modelCallRecord.copy(modelCallExecutionPath3, str17, str18, str19, str20, str21, str22, i14, str12, str13, str14, str15, i15, str16, i16, j31, j32, j33, j24, j25, j26, j27, j28, j29, j30, j23, j22);
    }

    public final ModelCallExecutionPath component1() {
        return this.executionPath;
    }

    public final String component10() {
        return this.clientDebugTraceId;
    }

    public final String component11() {
        return this.gatewayTraceId;
    }

    public final String component12() {
        return this.asyncTaskId;
    }

    public final int component13() {
        return this.connectionGeneration;
    }

    public final String component14() {
        return this.status;
    }

    public final int component15() {
        return this.errorCode;
    }

    public final long component16() {
        return this.startMonoNs;
    }

    public final long component17() {
        return this.endMonoNs;
    }

    public final long component18() {
        return this.startWallMs;
    }

    public final long component19() {
        return this.e2eMs;
    }

    public final String component2() {
        return this.cloudCorrelationId;
    }

    public final long component20() {
        return this.ttftMs;
    }

    public final long component21() {
        return this.headerFetchMs;
    }

    public final long component22() {
        return this.connectToOpenMs;
    }

    public final long component23() {
        return this.openToHandshakeAckMs;
    }

    public final long component24() {
        return this.handshakeAckToReadyMs;
    }

    public final long component25() {
        return this.uploadMs;
    }

    public final long component26() {
        return this.asrMs;
    }

    public final long component27() {
        return this.audioDurationMs;
    }

    public final String component3() {
        return this.correlationSource;
    }

    public final String component4() {
        return this.inferId;
    }

    public final String component5() {
        return this.abilityId;
    }

    public final String component6() {
        return this.modelId;
    }

    public final String component7() {
        return this.transport;
    }

    public final int component8() {
        return this.callerUid;
    }

    public final String component9() {
        return this.callerPkg;
    }

    public final ModelCallRecord copy(ModelCallExecutionPath executionPath, String cloudCorrelationId, String correlationSource, String inferId, String abilityId, String modelId, String transport, int i10, String callerPkg, String clientDebugTraceId, String gatewayTraceId, String asyncTaskId, int i11, String status, int i12, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21) {
        kotlin.jvm.internal.g.f(executionPath, "executionPath");
        kotlin.jvm.internal.g.f(cloudCorrelationId, "cloudCorrelationId");
        kotlin.jvm.internal.g.f(correlationSource, "correlationSource");
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(transport, "transport");
        kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
        kotlin.jvm.internal.g.f(clientDebugTraceId, "clientDebugTraceId");
        kotlin.jvm.internal.g.f(gatewayTraceId, "gatewayTraceId");
        kotlin.jvm.internal.g.f(asyncTaskId, "asyncTaskId");
        kotlin.jvm.internal.g.f(status, "status");
        return new ModelCallRecord(executionPath, cloudCorrelationId, correlationSource, inferId, abilityId, modelId, transport, i10, callerPkg, clientDebugTraceId, gatewayTraceId, asyncTaskId, i11, status, i12, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModelCallRecord)) {
            return false;
        }
        ModelCallRecord modelCallRecord = (ModelCallRecord) obj;
        return this.executionPath == modelCallRecord.executionPath && kotlin.jvm.internal.g.b(this.cloudCorrelationId, modelCallRecord.cloudCorrelationId) && kotlin.jvm.internal.g.b(this.correlationSource, modelCallRecord.correlationSource) && kotlin.jvm.internal.g.b(this.inferId, modelCallRecord.inferId) && kotlin.jvm.internal.g.b(this.abilityId, modelCallRecord.abilityId) && kotlin.jvm.internal.g.b(this.modelId, modelCallRecord.modelId) && kotlin.jvm.internal.g.b(this.transport, modelCallRecord.transport) && this.callerUid == modelCallRecord.callerUid && kotlin.jvm.internal.g.b(this.callerPkg, modelCallRecord.callerPkg) && kotlin.jvm.internal.g.b(this.clientDebugTraceId, modelCallRecord.clientDebugTraceId) && kotlin.jvm.internal.g.b(this.gatewayTraceId, modelCallRecord.gatewayTraceId) && kotlin.jvm.internal.g.b(this.asyncTaskId, modelCallRecord.asyncTaskId) && this.connectionGeneration == modelCallRecord.connectionGeneration && kotlin.jvm.internal.g.b(this.status, modelCallRecord.status) && this.errorCode == modelCallRecord.errorCode && this.startMonoNs == modelCallRecord.startMonoNs && this.endMonoNs == modelCallRecord.endMonoNs && this.startWallMs == modelCallRecord.startWallMs && this.e2eMs == modelCallRecord.e2eMs && this.ttftMs == modelCallRecord.ttftMs && this.headerFetchMs == modelCallRecord.headerFetchMs && this.connectToOpenMs == modelCallRecord.connectToOpenMs && this.openToHandshakeAckMs == modelCallRecord.openToHandshakeAckMs && this.handshakeAckToReadyMs == modelCallRecord.handshakeAckToReadyMs && this.uploadMs == modelCallRecord.uploadMs && this.asrMs == modelCallRecord.asrMs && this.audioDurationMs == modelCallRecord.audioDurationMs;
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final long getAsrMs() {
        return this.asrMs;
    }

    public final String getAsyncTaskId() {
        return this.asyncTaskId;
    }

    public final long getAudioDurationMs() {
        return this.audioDurationMs;
    }

    public final String getCallerPkg() {
        return this.callerPkg;
    }

    public final int getCallerUid() {
        return this.callerUid;
    }

    public final String getClientDebugTraceId() {
        return this.clientDebugTraceId;
    }

    public final String getCloudCorrelationId() {
        return this.cloudCorrelationId;
    }

    public final long getConnectToOpenMs() {
        return this.connectToOpenMs;
    }

    public final int getConnectionGeneration() {
        return this.connectionGeneration;
    }

    public final String getCorrelationSource() {
        return this.correlationSource;
    }

    public final long getE2eMs() {
        return this.e2eMs;
    }

    public final long getEndMonoNs() {
        return this.endMonoNs;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final ModelCallExecutionPath getExecutionPath() {
        return this.executionPath;
    }

    public final String getGatewayTraceId() {
        return this.gatewayTraceId;
    }

    public final long getHandshakeAckToReadyMs() {
        return this.handshakeAckToReadyMs;
    }

    public final long getHeaderFetchMs() {
        return this.headerFetchMs;
    }

    public final String getInferId() {
        return this.inferId;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final long getOpenToHandshakeAckMs() {
        return this.openToHandshakeAckMs;
    }

    public final String getReconciliationId() {
        String str = this.cloudCorrelationId;
        return q.t0(str) ? this.asyncTaskId : str;
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

    public final String getTransport() {
        return this.transport;
    }

    public final long getTtftMs() {
        return this.ttftMs;
    }

    public final long getUploadMs() {
        return this.uploadMs;
    }

    public int hashCode() {
        return Long.hashCode(this.audioDurationMs) + a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.errorCode, v1.d.a(ai.onnxruntime.a.d(this.connectionGeneration, v1.d.a(v1.d.a(v1.d.a(v1.d.a(ai.onnxruntime.a.d(this.callerUid, v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(this.executionPath.hashCode() * 31, 31, this.cloudCorrelationId), 31, this.correlationSource), 31, this.inferId), 31, this.abilityId), 31, this.modelId), 31, this.transport), 31), 31, this.callerPkg), 31, this.clientDebugTraceId), 31, this.gatewayTraceId), 31, this.asyncTaskId), 31), 31, this.status), 31), this.startMonoNs, 31), this.endMonoNs, 31), this.startWallMs, 31), this.e2eMs, 31), this.ttftMs, 31), this.headerFetchMs, 31), this.connectToOpenMs, 31), this.openToHandshakeAckMs, 31), this.handshakeAckToReadyMs, 31), this.uploadMs, 31), this.asrMs, 31);
    }

    public final String toEstablishedLogJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("phase", "ESTABLISHED");
        jSONObject.put("executionPath", this.executionPath.name());
        jSONObject.put("cloudCorrelationId", this.cloudCorrelationId);
        jSONObject.put("reconciliationId", getReconciliationId());
        jSONObject.put("correlationSource", this.correlationSource);
        jSONObject.put("inferId", this.inferId);
        jSONObject.put("abilityId", this.abilityId);
        jSONObject.put("modelId", this.modelId);
        jSONObject.put("transport", this.transport);
        if (this.clientDebugTraceId.length() > 0) {
            jSONObject.put("clientDebugTraceId", this.clientDebugTraceId);
        }
        if (this.gatewayTraceId.length() > 0) {
            jSONObject.put("gatewayTraceId", this.gatewayTraceId);
        }
        if (this.asyncTaskId.length() > 0) {
            jSONObject.put("asyncTaskId", this.asyncTaskId);
        }
        jSONObject.put("connectionGeneration", this.connectionGeneration);
        jSONObject.put("callerUid", this.callerUid);
        jSONObject.put("callerPkg", this.callerPkg);
        long j10 = this.headerFetchMs;
        if (j10 >= 0) {
            jSONObject.put("headerFetchMs", j10);
        }
        long j11 = this.connectToOpenMs;
        if (j11 >= 0) {
            jSONObject.put("connectToOpenMs", j11);
        }
        long j12 = this.openToHandshakeAckMs;
        if (j12 >= 0) {
            jSONObject.put("openToHandshakeAckMs", j12);
        }
        long j13 = this.handshakeAckToReadyMs;
        if (j13 >= 0) {
            jSONObject.put("handshakeAckToReadyMs", j13);
        }
        long j14 = this.uploadMs;
        if (j14 >= 0) {
            jSONObject.put("uploadMs", j14);
        }
        long j15 = this.asrMs;
        if (j15 >= 0) {
            jSONObject.put("asrMs", j15);
        }
        long j16 = this.audioDurationMs;
        if (j16 >= 0) {
            jSONObject.put("audioDurationMs", j16);
        }
        String string = jSONObject.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final String toLogJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("executionPath", this.executionPath.name());
        jSONObject.put("cloudCorrelationId", this.cloudCorrelationId);
        jSONObject.put("reconciliationId", getReconciliationId());
        jSONObject.put("correlationSource", this.correlationSource);
        jSONObject.put("inferId", this.inferId);
        jSONObject.put("abilityId", this.abilityId);
        jSONObject.put("modelId", this.modelId);
        jSONObject.put("transport", this.transport);
        jSONObject.put(FileResponse.FIELD_STATUS, this.status);
        jSONObject.put(BaseConstantsKt.KEY_ERROR_CODE, this.errorCode);
        jSONObject.put("e2eMs", this.e2eMs);
        long j10 = this.ttftMs;
        if (j10 > 0) {
            jSONObject.put("ttftMs", j10);
        }
        if (this.clientDebugTraceId.length() > 0) {
            jSONObject.put("clientDebugTraceId", this.clientDebugTraceId);
        }
        if (this.gatewayTraceId.length() > 0) {
            jSONObject.put("gatewayTraceId", this.gatewayTraceId);
        }
        if (this.asyncTaskId.length() > 0) {
            jSONObject.put("asyncTaskId", this.asyncTaskId);
        }
        jSONObject.put("connectionGeneration", this.connectionGeneration);
        jSONObject.put("callerUid", this.callerUid);
        jSONObject.put("callerPkg", this.callerPkg);
        long j11 = this.headerFetchMs;
        if (j11 >= 0) {
            jSONObject.put("headerFetchMs", j11);
        }
        long j12 = this.connectToOpenMs;
        if (j12 >= 0) {
            jSONObject.put("connectToOpenMs", j12);
        }
        long j13 = this.openToHandshakeAckMs;
        if (j13 >= 0) {
            jSONObject.put("openToHandshakeAckMs", j13);
        }
        long j14 = this.handshakeAckToReadyMs;
        if (j14 >= 0) {
            jSONObject.put("handshakeAckToReadyMs", j14);
        }
        long j15 = this.uploadMs;
        if (j15 >= 0) {
            jSONObject.put("uploadMs", j15);
        }
        long j16 = this.asrMs;
        if (j16 >= 0) {
            jSONObject.put("asrMs", j16);
        }
        long j17 = this.audioDurationMs;
        if (j17 >= 0) {
            jSONObject.put("audioDurationMs", j17);
        }
        String string = jSONObject.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public String toString() {
        ModelCallExecutionPath modelCallExecutionPath = this.executionPath;
        String str = this.cloudCorrelationId;
        String str2 = this.correlationSource;
        String str3 = this.inferId;
        String str4 = this.abilityId;
        String str5 = this.modelId;
        String str6 = this.transport;
        int i10 = this.callerUid;
        String str7 = this.callerPkg;
        String str8 = this.clientDebugTraceId;
        String str9 = this.gatewayTraceId;
        String str10 = this.asyncTaskId;
        int i11 = this.connectionGeneration;
        String str11 = this.status;
        int i12 = this.errorCode;
        long j10 = this.startMonoNs;
        long j11 = this.endMonoNs;
        long j12 = this.startWallMs;
        long j13 = this.e2eMs;
        long j14 = this.ttftMs;
        long j15 = this.headerFetchMs;
        long j16 = this.connectToOpenMs;
        long j17 = this.openToHandshakeAckMs;
        long j18 = this.handshakeAckToReadyMs;
        long j19 = this.uploadMs;
        long j20 = this.asrMs;
        long j21 = this.audioDurationMs;
        StringBuilder sb2 = new StringBuilder("ModelCallRecord(executionPath=");
        sb2.append(modelCallExecutionPath);
        sb2.append(", cloudCorrelationId=");
        sb2.append(str);
        sb2.append(", correlationSource=");
        ai.onnxruntime.a.z(sb2, str2, ", inferId=", str3, ", abilityId=");
        ai.onnxruntime.a.z(sb2, str4, ", modelId=", str5, ", transport=");
        com.stepos.core.ota.d.o(i10, str6, ", callerUid=", ", callerPkg=", sb2);
        ai.onnxruntime.a.z(sb2, str7, ", clientDebugTraceId=", str8, ", gatewayTraceId=");
        ai.onnxruntime.a.z(sb2, str9, ", asyncTaskId=", str10, ", connectionGeneration=");
        h0.e.h(i11, ", status=", str11, ", errorCode=", sb2);
        com.stepos.core.ota.d.s(sb2, i12, ", startMonoNs=", j10);
        a0.a.s(j11, ", endMonoNs=", ", startWallMs=", sb2);
        sb2.append(j12);
        a0.a.s(j13, ", e2eMs=", ", ttftMs=", sb2);
        sb2.append(j14);
        a0.a.s(j15, ", headerFetchMs=", ", connectToOpenMs=", sb2);
        sb2.append(j16);
        a0.a.s(j17, ", openToHandshakeAckMs=", ", handshakeAckToReadyMs=", sb2);
        sb2.append(j18);
        a0.a.s(j19, ", uploadMs=", ", asrMs=", sb2);
        sb2.append(j20);
        return a0.a.d(j21, ", audioDurationMs=", ")", sb2);
    }

    public final Map<String, String> toTags() {
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put("execution_path", this.executionPath.name());
        String reconciliationId = getReconciliationId();
        if (q.t0(reconciliationId)) {
            reconciliationId = null;
        }
        if (reconciliationId != null) {
        }
        if (this.correlationSource.length() > 0) {
            mapBuilder.put("cloud_correlation_source", this.correlationSource);
        }
        mapBuilder.put("ai_task_id", this.inferId);
        mapBuilder.put("ability_id", this.abilityId);
        if (this.modelId.length() > 0) {
            mapBuilder.put("model_id", this.modelId);
        }
        mapBuilder.put("transport", this.transport);
        mapBuilder.put(FileResponse.FIELD_STATUS, this.status);
        mapBuilder.put("caller_uid", String.valueOf(this.callerUid));
        mapBuilder.put("caller_pkg", this.callerPkg);
        mapBuilder.put("start_mono_ns", String.valueOf(this.startMonoNs));
        mapBuilder.put("end_mono_ns", String.valueOf(this.endMonoNs));
        mapBuilder.put("start_wall_ms", String.valueOf(this.startWallMs));
        mapBuilder.put("e2e_ms", String.valueOf(this.e2eMs));
        long j10 = this.ttftMs;
        if (j10 > 0) {
            mapBuilder.put("ttft_ms", String.valueOf(j10));
        }
        int i10 = this.errorCode;
        if (i10 != 0) {
            mapBuilder.put("error_code", String.valueOf(i10));
        }
        if (this.clientDebugTraceId.length() > 0) {
            mapBuilder.put("client_debug_trace_id", this.clientDebugTraceId);
        }
        if (this.gatewayTraceId.length() > 0) {
            mapBuilder.put("gateway_trace_id", this.gatewayTraceId);
        }
        if (this.asyncTaskId.length() > 0) {
            mapBuilder.put("async_task_id", this.asyncTaskId);
        }
        int i11 = this.connectionGeneration;
        if (i11 > 0) {
            mapBuilder.put("connection_generation", String.valueOf(i11));
        }
        long j11 = this.headerFetchMs;
        if (j11 >= 0) {
            mapBuilder.put("header_fetch_ms", String.valueOf(j11));
        }
        long j12 = this.connectToOpenMs;
        if (j12 >= 0) {
            mapBuilder.put("connect_to_open_ms", String.valueOf(j12));
        }
        long j13 = this.openToHandshakeAckMs;
        if (j13 >= 0) {
            mapBuilder.put("open_to_handshake_ack_ms", String.valueOf(j13));
        }
        long j14 = this.handshakeAckToReadyMs;
        if (j14 >= 0) {
            mapBuilder.put("handshake_ack_to_ready_ms", String.valueOf(j14));
        }
        long j15 = this.uploadMs;
        if (j15 >= 0) {
            mapBuilder.put("upload_ms", String.valueOf(j15));
        }
        long j16 = this.asrMs;
        if (j16 >= 0) {
            mapBuilder.put("asr_ms", String.valueOf(j16));
        }
        long j17 = this.audioDurationMs;
        if (j17 >= 0) {
            mapBuilder.put("audio_duration_ms", String.valueOf(j17));
        }
        return mapBuilder.b();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ ModelCallRecord(com.stepos.core.common.telemetry.ModelCallExecutionPath r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, int r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, int r56, java.lang.String r57, int r58, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, int r83, kotlin.jvm.internal.e r84) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.telemetry.ModelCallRecord.<init>(com.stepos.core.common.telemetry.ModelCallExecutionPath, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, long, long, long, long, long, long, long, long, long, long, long, long, int, kotlin.jvm.internal.e):void");
    }
}
