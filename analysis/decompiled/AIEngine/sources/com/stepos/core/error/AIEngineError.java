package com.stepos.core.error;

import ai.onnxruntime.a;
import com.stepos.core.common.telemetry.FailStage;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.b;
import mb.l;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AIEngineError {
    public static final int ABILITY_ALREADY_REGISTERED = 240002;
    public static final int ABILITY_CONFIG_INVALID = 240005;
    public static final int ABILITY_CREATE_FAILED = 140001;
    public static final int ABILITY_DISABLED = 240006;
    public static final int ABILITY_NOT_READY = 240003;
    public static final int ABILITY_NOT_REGISTERED = 240001;
    public static final int ABILITY_TYPE_MISMATCH = 240004;
    public static final int ALREADY_CLOSED = 100008;
    public static final int CANCELLED = -100;
    public static final int CIRCUIT_BREAKER_OPEN = 220010;
    public static final int CLOUD_AUTH_FAILED = 170002;
    public static final int CLOUD_ENDPOINT_NOT_CONFIGURED = 170001;
    public static final int CLOUD_INSUFFICIENT_BALANCE = 170003;
    public static final int CLOUD_INVALID_REQUEST = 270006;
    public static final int CLOUD_MODEL_DISABLED = 240008;
    public static final int CLOUD_NETWORK_ERROR = 270010;
    public static final int CLOUD_NETWORK_UNAVAILABLE = 270001;
    public static final int CLOUD_QUOTA_EXCEEDED = 270008;
    public static final int CLOUD_REQUEST_TIMEOUT = 270002;
    public static final int CLOUD_RESPONSE_INVALID = 270005;
    private static final Set<Integer> CLOUD_RETRYABLE_CODES;
    public static final int CLOUD_RISK_BLOCKED = 270007;
    public static final int CLOUD_SCENE_TYPE_NOT_PERMITTED = 240010;
    public static final int CLOUD_SERVER_ERROR = 270003;
    public static final int CLOUD_STREAM_TRUNCATED = 270011;
    public static final int CLOUD_TASK_FAILED = 270004;
    public static final int CLOUD_TOKEN_TEMP_UNAVAILABLE = 270009;
    public static final int CTA_NOT_GRANTED = 240009;
    public static final int HARDWARE_ACCELERATION_UNAVAILABLE = 110008;
    public static final int INFERENCE_ENGINE_ERROR = 120003;
    public static final int INFERENCE_FAILED = 220001;
    public static final int INFERENCE_IN_PROGRESS = 220003;
    public static final int INFERENCE_NATIVE_ERROR = 120001;
    public static final int INFERENCE_OOM = 120002;
    public static final int INFERENCE_QUEUE_FULL = 220002;
    public static final int INFERENCE_RESULT_EMPTY = 220004;
    public static final int INFERENCE_RESULT_PARSE_FAILED = 220005;
    public static final int INFERENCE_TOKEN_LIMIT_EXCEEDED = 220006;
    public static final int INPUT_AUDIO_DURATION_UNKNOWN = 260009;
    public static final int INPUT_AUDIO_FORMAT_UNSUPPORTED = 260004;
    public static final int INPUT_AUDIO_SIZE_TOO_LARGE = 260008;
    public static final int INPUT_DATA_INVALID = 260002;
    public static final int INPUT_IMAGE_FORMAT_UNSUPPORTED = 260003;
    public static final int INPUT_TEXT_EMPTY = 260005;
    public static final int INPUT_TYPE_UNSUPPORTED = 260001;
    public static final AIEngineError INSTANCE = new AIEngineError();
    public static final int INTERRUPTED = -102;
    public static final int INVALID_ARGUMENT = 100002;
    public static final int INVALID_STATE = 100003;
    public static final int IPC_BINDER_FAILED = 130001;
    public static final int IPC_DESERIALIZATION_FAILED = 230004;
    public static final int IPC_HARDWARE_BUFFER_FAILED = 130004;
    public static final int IPC_MESSAGE_TOO_LARGE = 230005;
    public static final int IPC_NOT_CONNECTED = 230001;
    public static final int IPC_SERIALIZATION_FAILED = 230003;
    public static final int IPC_SERVICE_BUSY = 230002;
    public static final int IPC_SERVICE_DIED = 130002;
    public static final int IPC_SHARED_MEMORY_FAILED = 130003;
    public static final int LEASE_CLOSE_PARTIAL_FAILURE = 300002;
    public static final int LLAMA_LIBRARY_LOAD_FAILED = 110007;
    public static final int LOCAL_MODEL_DISABLED = 240007;
    public static final int MODEL_ALREADY_LOADED = 210002;
    public static final int MODEL_BLACKLISTED = 210008;
    public static final int MODEL_CONFIG_INVALID = 210006;
    public static final int MODEL_FILE_CORRUPTED = 110002;
    public static final int MODEL_FILE_NOT_FOUND = 110001;
    public static final int MODEL_FORMAT_UNSUPPORTED = 110003;
    public static final int MODEL_INIT_FAILED = 110005;
    public static final int MODEL_LOADING = 210003;
    public static final int MODEL_LOAD_BACKOFF = 210009;
    public static final int MODEL_LOAD_FAILED = 110004;
    public static final int MODEL_NOT_FOUND = 210004;
    public static final int MODEL_NOT_LOADED = 210001;
    public static final int MODEL_UPDATING = 210007;
    public static final int MODEL_VERSION_MISMATCH = 210005;
    public static final int NATIVE_CANCEL_REQUESTED = -103;
    public static final int NOT_INITIALIZED = 100007;
    public static final int NULL_POINTER = 100001;
    public static final int OUTPUT_CONVERSION_FAILED = 260007;
    public static final int OUTPUT_TYPE_MISMATCH = 260006;
    public static final int PERMISSION_DENIED = 100005;
    public static final int PRESSURE_CANCELLED = 220009;
    public static final int PROTOCOL_NOT_AVAILABLE = 250001;
    public static final int PROTOCOL_TYPE_MISMATCH = 250002;
    public static final int PROTOCOL_VERSION_INCOMPATIBLE = 250003;
    public static final int QNN_LIBRARY_LOAD_FAILED = 110006;
    public static final int QUOTA_EXCEEDED = 220007;
    public static final int RESOURCE_EXHAUSTED = 100006;
    public static final int SERVICE_RECOVERED_FROM_CRASH = 200001;
    public static final int SESSION_BUSY = 220008;
    public static final int SLA_NO_VALID_ACTION = 280001;
    public static final int SLA_SCREEN_LOCKED = 280002;
    public static final int SLA_UNSUPPORTED = 280003;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = -101;
    public static final int UNKNOWN = 100000;
    public static final int UNSUPPORTED = 100004;
    public static final int WATCHDOG_SAFE_MODE = 300001;
    private static final Map<Integer, String> errorMessages;

    static {
        Integer numValueOf = Integer.valueOf(CLOUD_NETWORK_UNAVAILABLE);
        Integer numValueOf2 = Integer.valueOf(CLOUD_NETWORK_ERROR);
        Integer numValueOf3 = Integer.valueOf(CLOUD_REQUEST_TIMEOUT);
        Integer numValueOf4 = Integer.valueOf(CLOUD_SERVER_ERROR);
        Integer numValueOf5 = Integer.valueOf(CLOUD_TASK_FAILED);
        Integer numValueOf6 = Integer.valueOf(CLOUD_QUOTA_EXCEEDED);
        Integer numValueOf7 = Integer.valueOf(CLOUD_TOKEN_TEMP_UNAVAILABLE);
        Integer numValueOf8 = Integer.valueOf(CLOUD_STREAM_TRUNCATED);
        CLOUD_RETRYABLE_CODES = l.s0(new Integer[]{numValueOf, numValueOf2, numValueOf3, numValueOf4, numValueOf5, numValueOf6, numValueOf7, numValueOf8});
        errorMessages = b.g0(new Pair(0, "Success"), new Pair(-100, "Operation cancelled by user"), new Pair(Integer.valueOf(TIMEOUT), "Operation timeout"), new Pair(Integer.valueOf(INTERRUPTED), "Operation interrupted by system"), new Pair(Integer.valueOf(NATIVE_CANCEL_REQUESTED), "Inference cancelled by external cancel request"), new Pair(Integer.valueOf(UNKNOWN), "Unknown error"), new Pair(100001, "Null pointer exception"), new Pair(Integer.valueOf(INVALID_ARGUMENT), "Invalid argument"), new Pair(Integer.valueOf(INVALID_STATE), "Invalid state"), new Pair(Integer.valueOf(UNSUPPORTED), "Unsupported operation"), new Pair(Integer.valueOf(PERMISSION_DENIED), "Permission denied"), new Pair(Integer.valueOf(RESOURCE_EXHAUSTED), "Resource exhausted"), new Pair(Integer.valueOf(NOT_INITIALIZED), "Not initialized"), new Pair(Integer.valueOf(ALREADY_CLOSED), "Already closed"), new Pair(Integer.valueOf(SERVICE_RECOVERED_FROM_CRASH), "Service recovered from crash; requested model is blacklisted, use fallback chain"), new Pair(Integer.valueOf(MODEL_FILE_NOT_FOUND), "Model file not found"), new Pair(Integer.valueOf(MODEL_FILE_CORRUPTED), "Model file corrupted"), new Pair(110003, "Model format not supported"), new Pair(Integer.valueOf(MODEL_LOAD_FAILED), "Failed to load model"), new Pair(Integer.valueOf(MODEL_INIT_FAILED), "Failed to initialize model"), new Pair(Integer.valueOf(QNN_LIBRARY_LOAD_FAILED), "Failed to load QNN library"), new Pair(Integer.valueOf(LLAMA_LIBRARY_LOAD_FAILED), "Failed to load LLAMA library"), new Pair(Integer.valueOf(HARDWARE_ACCELERATION_UNAVAILABLE), "Hardware acceleration unavailable"), new Pair(210001, "Model not loaded"), new Pair(210002, "Model already loaded"), new Pair(Integer.valueOf(MODEL_LOADING), "Model is loading"), new Pair(Integer.valueOf(MODEL_NOT_FOUND), "Model not found"), new Pair(Integer.valueOf(MODEL_VERSION_MISMATCH), "Model version mismatch"), new Pair(Integer.valueOf(MODEL_CONFIG_INVALID), "Invalid model config"), new Pair(Integer.valueOf(MODEL_UPDATING), "Model is being updated via OTA, please retry"), new Pair(Integer.valueOf(MODEL_BLACKLISTED), "Model is blacklisted after crash recovery, use fallback chain"), new Pair(Integer.valueOf(MODEL_LOAD_BACKOFF), "Model is in load-failure backoff window, retry later"), new Pair(Integer.valueOf(INFERENCE_NATIVE_ERROR), "Native inference error"), new Pair(Integer.valueOf(INFERENCE_OOM), "Out of memory during inference"), new Pair(Integer.valueOf(INFERENCE_ENGINE_ERROR), "Inference engine internal error"), new Pair(Integer.valueOf(INFERENCE_FAILED), "Inference failed"), new Pair(Integer.valueOf(INFERENCE_QUEUE_FULL), "Inference queue is full"), new Pair(Integer.valueOf(INFERENCE_IN_PROGRESS), "Inference already in progress"), new Pair(Integer.valueOf(INFERENCE_RESULT_EMPTY), "Inference result is empty"), new Pair(Integer.valueOf(INFERENCE_RESULT_PARSE_FAILED), "Failed to parse inference result"), new Pair(Integer.valueOf(INFERENCE_TOKEN_LIMIT_EXCEEDED), "Token limit exceeded"), new Pair(Integer.valueOf(SESSION_BUSY), "Session busy, another inference is in progress"), new Pair(Integer.valueOf(QUOTA_EXCEEDED), "Inference quota exceeded, please retry later"), new Pair(Integer.valueOf(PRESSURE_CANCELLED), "Background inference cancelled due to memory pressure, please retry later"), new Pair(Integer.valueOf(CIRCUIT_BREAKER_OPEN), "Inference service temporarily unavailable (circuit breaker open), please retry later"), new Pair(Integer.valueOf(CLOUD_ENDPOINT_NOT_CONFIGURED), "Cloud endpoint not configured"), new Pair(Integer.valueOf(CLOUD_AUTH_FAILED), "Cloud authentication failed (invalid or missing api_key)"), new Pair(Integer.valueOf(CLOUD_INSUFFICIENT_BALANCE), "Cloud account balance insufficient, top up required (retry will not help)"), new Pair(numValueOf, "Network unavailable"), new Pair(numValueOf3, "Cloud request timed out"), new Pair(numValueOf4, "Cloud server error"), new Pair(numValueOf5, "Cloud task failed on server"), new Pair(Integer.valueOf(CLOUD_RESPONSE_INVALID), "Cloud response invalid or unparseable"), new Pair(Integer.valueOf(CLOUD_INVALID_REQUEST), "Cloud rejected request parameters"), new Pair(Integer.valueOf(CLOUD_RISK_BLOCKED), "Cloud request blocked by risk control"), new Pair(numValueOf6, "Cloud quota or rate limit exceeded"), new Pair(numValueOf7, "User token temporarily unavailable (network/system time), retry later"), new Pair(numValueOf2, "Cloud connection never established (weak network)"), new Pair(numValueOf8, "Cloud stream ended before the terminal event (partial result)"), new Pair(Integer.valueOf(IPC_BINDER_FAILED), "Binder connection failed"), new Pair(Integer.valueOf(IPC_SERVICE_DIED), "Service process died"), new Pair(Integer.valueOf(IPC_SHARED_MEMORY_FAILED), "Failed to create shared memory"), new Pair(Integer.valueOf(IPC_HARDWARE_BUFFER_FAILED), "Failed to transfer hardware buffer"), new Pair(Integer.valueOf(IPC_NOT_CONNECTED), "Service not connected"), new Pair(Integer.valueOf(IPC_SERVICE_BUSY), "Service is busy"), new Pair(Integer.valueOf(IPC_SERIALIZATION_FAILED), "Serialization failed"), new Pair(Integer.valueOf(IPC_DESERIALIZATION_FAILED), "Deserialization failed"), new Pair(Integer.valueOf(IPC_MESSAGE_TOO_LARGE), "Message too large"), new Pair(Integer.valueOf(ABILITY_CREATE_FAILED), "Failed to create ability"), new Pair(Integer.valueOf(ABILITY_NOT_REGISTERED), "Ability not registered"), new Pair(Integer.valueOf(ABILITY_ALREADY_REGISTERED), "Ability already registered"), new Pair(Integer.valueOf(ABILITY_NOT_READY), "Ability not ready"), new Pair(Integer.valueOf(ABILITY_TYPE_MISMATCH), "Ability type mismatch"), new Pair(Integer.valueOf(ABILITY_CONFIG_INVALID), "Invalid ability config"), new Pair(Integer.valueOf(ABILITY_DISABLED), "Ability disabled: both local and cloud paths are turned off"), new Pair(Integer.valueOf(LOCAL_MODEL_DISABLED), "Local model disabled; cannot fall back to on-device path"), new Pair(Integer.valueOf(CLOUD_MODEL_DISABLED), "Cloud model disabled; use AUTO/LOCAL_ONLY or enable cloud path"), new Pair(Integer.valueOf(CTA_NOT_GRANTED), "CTA privacy consent not granted; cloud path unavailable"), new Pair(Integer.valueOf(CLOUD_SCENE_TYPE_NOT_PERMITTED), "Cloud scene_type not authorized for caller package; apply to AIEngine with package name and ability id"), new Pair(Integer.valueOf(PROTOCOL_NOT_AVAILABLE), "Protocol not available"), new Pair(Integer.valueOf(PROTOCOL_TYPE_MISMATCH), "Protocol type mismatch"), new Pair(Integer.valueOf(PROTOCOL_VERSION_INCOMPATIBLE), "Protocol version incompatible"), new Pair(Integer.valueOf(INPUT_TYPE_UNSUPPORTED), "Input type not supported"), new Pair(Integer.valueOf(INPUT_DATA_INVALID), "Invalid input data"), new Pair(Integer.valueOf(INPUT_IMAGE_FORMAT_UNSUPPORTED), "Image format not supported"), new Pair(Integer.valueOf(INPUT_AUDIO_FORMAT_UNSUPPORTED), "Audio format not supported"), new Pair(Integer.valueOf(INPUT_TEXT_EMPTY), "Input text is empty"), new Pair(Integer.valueOf(OUTPUT_TYPE_MISMATCH), "Output type mismatch"), new Pair(Integer.valueOf(OUTPUT_CONVERSION_FAILED), "Output conversion failed"), new Pair(Integer.valueOf(INPUT_AUDIO_SIZE_TOO_LARGE), "Audio file size exceeds the limit"), new Pair(Integer.valueOf(INPUT_AUDIO_DURATION_UNKNOWN), "Audio duration could not be determined"), new Pair(Integer.valueOf(WATCHDOG_SAFE_MODE), "Watchdog triggered safe mode; NPU disabled, inference forced to CPU"), new Pair(Integer.valueOf(LEASE_CLOSE_PARTIAL_FAILURE), "InferenceLease close completed with partial failures; resources best-effort released"), new Pair(Integer.valueOf(SLA_NO_VALID_ACTION), "No valid action recognized"), new Pair(Integer.valueOf(SLA_SCREEN_LOCKED), "Screen is locked; recognized function not allowed on lock screen"), new Pair(Integer.valueOf(SLA_UNSUPPORTED), "On-device SLA does not support this instruction"));
    }

    private AIEngineError() {
    }

    public static /* synthetic */ String format$default(AIEngineError aIEngineError, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return aIEngineError.format(i10, str);
    }

    public final String format(int i10, String str) {
        String module = getModule(i10);
        String level = getLevel(i10);
        if (str == null) {
            str = getMessage(i10);
        }
        StringBuilder sbS = a.s("[", module, "][", level, "] ");
        sbS.append(str);
        sbS.append(" (");
        sbS.append(i10);
        sbS.append(")");
        return sbS.toString();
    }

    public final String getLevel(int i10) {
        return i10 == 0 ? "SUCCESS" : i10 < 0 ? "CANCEL" : (100000 > i10 || i10 >= 200000) ? (200000 > i10 || i10 >= 300000) ? (300000 > i10 || i10 >= 400000) ? FailStage.UNKNOWN : "WARNING" : "BUSINESS" : "SYSTEM";
    }

    public final String getMessage(int i10) {
        String str = errorMessages.get(Integer.valueOf(i10));
        return str == null ? ai.onnxruntime.providers.a.a(i10, "Unknown error: ") : str;
    }

    public final String getModule(int i10) {
        if (i10 < 0) {
            return "CANCEL";
        }
        int i11 = (i10 / 1000) % 100;
        return i11 != 0 ? i11 != 10 ? i11 != 20 ? i11 != 30 ? i11 != 40 ? i11 != 50 ? i11 != 60 ? i11 != 70 ? FailStage.UNKNOWN : "CLOUD" : "IO" : "PROTOCOL" : "ABILITY" : "IPC" : FailStage.INFERENCE : "MODEL" : "COMMON";
    }

    public final boolean isBusinessError(int i10) {
        return 200000 <= i10 && i10 < 300000;
    }

    public final boolean isCancellation(int i10) {
        return m.b0(-100, Integer.valueOf(TIMEOUT), Integer.valueOf(INTERRUPTED), Integer.valueOf(NATIVE_CANCEL_REQUESTED)).contains(Integer.valueOf(i10));
    }

    public final boolean isCloudRetryable(int i10) {
        return CLOUD_RETRYABLE_CODES.contains(Integer.valueOf(i10));
    }

    public final boolean isSuccess(int i10) {
        return i10 == 0;
    }

    public final boolean isSystemError(int i10) {
        return 100000 <= i10 && i10 < 200000;
    }

    public final boolean isWarning(int i10) {
        return 300000 <= i10 && i10 < 400000;
    }
}
