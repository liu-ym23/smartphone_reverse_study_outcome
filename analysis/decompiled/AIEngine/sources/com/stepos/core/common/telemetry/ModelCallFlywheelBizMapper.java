package com.stepos.core.common.telemetry;

import com.stepos.core.ability.speech.AsrSseEvent;
import gc.q;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import mb.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCallFlywheelBizMapper {
    public static final ModelCallFlywheelBizMapper INSTANCE = new ModelCallFlywheelBizMapper();
    public static final String MODEL_PATH_CLOUD = "cloud";
    public static final String MODEL_PATH_EDGE = "edge";
    public static final String MSG_TYPE_DOWNLINK = "downlink";
    public static final String MSG_TYPE_TRACE_LOG = "trace_log";
    public static final String MSG_TYPE_UPLINK = "uplink";
    public static final String NODE_NAME = "model_call";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ModelCallExecutionPath.values().length];
            try {
                iArr[ModelCallExecutionPath.EDGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModelCallExecutionPath.CLOUD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ModelCallFlywheelBizMapper() {
    }

    private final void putStageTiming(Map<String, Object> map, ModelCallRecord modelCallRecord) {
        if (modelCallRecord.getUploadMs() >= 0) {
            map.put("upload_ms", Long.valueOf(modelCallRecord.getUploadMs()));
        }
        if (modelCallRecord.getAsrMs() >= 0) {
            map.put("asr_ms", Long.valueOf(modelCallRecord.getAsrMs()));
        }
        if (modelCallRecord.getAudioDurationMs() >= 0) {
            map.put("audio_duration_ms", Long.valueOf(modelCallRecord.getAudioDurationMs()));
        }
    }

    public final String asyncTaskId(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        String asyncTaskId = record.getAsyncTaskId();
        if (q.t0(asyncTaskId)) {
            return null;
        }
        return asyncTaskId;
    }

    public final Map<String, Object> bizData(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        MapBuilder mapBuilder = new MapBuilder();
        if (record.getModelId().length() > 0) {
            mapBuilder.put("target_model", record.getModelId());
        }
        ModelCallFlywheelBizMapper modelCallFlywheelBizMapper = INSTANCE;
        mapBuilder.put("model_path", modelCallFlywheelBizMapper.modelPath(record));
        mapBuilder.put("duration_ms", Long.valueOf(record.getE2eMs()));
        String strResultDigest = modelCallFlywheelBizMapper.resultDigest(record.getStatus());
        if (strResultDigest.length() > 0) {
            mapBuilder.put("result_digest", strResultDigest);
        }
        String strStepTraceId = modelCallFlywheelBizMapper.stepTraceId(record);
        if (strStepTraceId != null) {
            mapBuilder.put("step_trace_id", strStepTraceId);
        }
        String strAsyncTaskId = modelCallFlywheelBizMapper.asyncTaskId(record);
        if (strAsyncTaskId != null) {
            mapBuilder.put("async_task_id", strAsyncTaskId);
        }
        modelCallFlywheelBizMapper.putStageTiming(mapBuilder, record);
        return mapBuilder.b();
    }

    public final Map<String, Object> commonFields(String msgType) {
        kotlin.jvm.internal.g.f(msgType, "msgType");
        return v.b0(new Pair("msg_type", msgType));
    }

    public final String handshakeLogFields(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        StringBuilder sb2 = new StringBuilder();
        if (record.getHeaderFetchMs() >= 0) {
            sb2.append("header_fetch_ms=");
            sb2.append(record.getHeaderFetchMs());
        }
        if (record.getConnectToOpenMs() >= 0) {
            if (sb2.length() > 0) {
                sb2.append(' ');
            }
            sb2.append("connect_to_open_ms=");
            sb2.append(record.getConnectToOpenMs());
        }
        if (record.getOpenToHandshakeAckMs() >= 0) {
            if (sb2.length() > 0) {
                sb2.append(' ');
            }
            sb2.append("open_to_handshake_ack_ms=");
            sb2.append(record.getOpenToHandshakeAckMs());
        }
        if (record.getHandshakeAckToReadyMs() >= 0) {
            if (sb2.length() > 0) {
                sb2.append(' ');
            }
            sb2.append("handshake_ack_to_ready_ms=");
            sb2.append(record.getHandshakeAckToReadyMs());
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        if (string.length() > 0) {
            return string;
        }
        return null;
    }

    public final String modelPath(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        return modelSource(record);
    }

    public final String modelSource(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        int i10 = WhenMappings.$EnumSwitchMapping$0[record.getExecutionPath().ordinal()];
        if (i10 == 1) {
            return MODEL_PATH_EDGE;
        }
        if (i10 == 2) {
            return MODEL_PATH_CLOUD;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String reportLogFields(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        StringBuilder sb2 = new StringBuilder();
        if (record.getAbilityId().length() > 0) {
            sb2.append("target_model=");
            sb2.append(record.getAbilityId());
        }
        sb2.append(sb2.length() == 0 ? "" : " ");
        sb2.append("model_source=");
        ModelCallFlywheelBizMapper modelCallFlywheelBizMapper = INSTANCE;
        sb2.append(modelCallFlywheelBizMapper.modelSource(record));
        String strAsyncTaskId = modelCallFlywheelBizMapper.asyncTaskId(record);
        if (strAsyncTaskId != null) {
            sb2.append(' ');
            sb2.append("async_task_id=");
            sb2.append(strAsyncTaskId);
        }
        String strStageTimingLogFields = modelCallFlywheelBizMapper.stageTimingLogFields(record);
        if (strStageTimingLogFields != null) {
            sb2.append(' ');
            sb2.append(strStageTimingLogFields);
        }
        String strHandshakeLogFields = modelCallFlywheelBizMapper.handshakeLogFields(record);
        if (strHandshakeLogFields != null) {
            sb2.append(' ');
            sb2.append(strHandshakeLogFields);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final String reportTraceId(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        return q.L0(record.getClientDebugTraceId()).toString();
    }

    public final String resultDigest(String status) {
        kotlin.jvm.internal.g.f(status, "status");
        String upperCase = status.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.g.e(upperCase, "toUpperCase(...)");
        int iHashCode = upperCase.hashCode();
        return iHashCode != -1149187101 ? iHashCode != -1031784143 ? iHashCode != -595928767 ? iHashCode != 0 ? iHashCode != 99577758 ? (iHashCode == 2066319421 && upperCase.equals("FAILED")) ? "fail" : AsrSseEvent.TYPE_ERROR : !upperCase.equals("TRUNCATED") ? AsrSseEvent.TYPE_ERROR : "truncated" : !upperCase.equals("") ? AsrSseEvent.TYPE_ERROR : "" : !upperCase.equals("TIMEOUT") ? AsrSseEvent.TYPE_ERROR : "timeout" : !upperCase.equals("CANCELLED") ? AsrSseEvent.TYPE_ERROR : "cancelled" : !upperCase.equals("SUCCESS") ? AsrSseEvent.TYPE_ERROR : "success";
    }

    public final String stageTimingLogFields(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        StringBuilder sb2 = new StringBuilder();
        if (record.getUploadMs() >= 0) {
            sb2.append("upload_ms=");
            sb2.append(record.getUploadMs());
        }
        if (record.getAsrMs() >= 0) {
            if (sb2.length() > 0) {
                sb2.append(' ');
            }
            sb2.append("asr_ms=");
            sb2.append(record.getAsrMs());
        }
        if (record.getAudioDurationMs() >= 0) {
            if (sb2.length() > 0) {
                sb2.append(' ');
            }
            sb2.append("audio_duration_ms=");
            sb2.append(record.getAudioDurationMs());
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        if (string.length() > 0) {
            return string;
        }
        return null;
    }

    public final int statusCode(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        return (kotlin.jvm.internal.g.b(record.getStatus(), "SUCCESS") && record.getErrorCode() == 0) ? 200 : 500;
    }

    public final String stepTraceId(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        int i10 = WhenMappings.$EnumSwitchMapping$0[record.getExecutionPath().ordinal()];
        if (i10 == 1) {
            String inferId = record.getInferId();
            if (q.t0(inferId)) {
                return null;
            }
            return inferId;
        }
        if (i10 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        String reconciliationId = record.getReconciliationId();
        if (q.t0(reconciliationId)) {
            return null;
        }
        return reconciliationId;
    }

    public final Map<String, Object> uplinkBizData(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        MapBuilder mapBuilder = new MapBuilder();
        if (record.getModelId().length() > 0) {
            mapBuilder.put("target_model", record.getModelId());
        }
        ModelCallFlywheelBizMapper modelCallFlywheelBizMapper = INSTANCE;
        mapBuilder.put("model_path", modelCallFlywheelBizMapper.modelPath(record));
        String strStepTraceId = modelCallFlywheelBizMapper.stepTraceId(record);
        if (strStepTraceId != null) {
            mapBuilder.put("step_trace_id", strStepTraceId);
        }
        String strAsyncTaskId = modelCallFlywheelBizMapper.asyncTaskId(record);
        if (strAsyncTaskId != null) {
            mapBuilder.put("async_task_id", strAsyncTaskId);
        }
        modelCallFlywheelBizMapper.putStageTiming(mapBuilder, record);
        return mapBuilder.b();
    }
}
