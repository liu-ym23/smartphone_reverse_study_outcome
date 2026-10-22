package com.stepos.core.error;

import Y8.j;
import Z8.C1173v;
import Z8.Y;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b]\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0005J\u000e\u0010e\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0005J\u000e\u0010f\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0005J\u000e\u0010g\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0005J\u000e\u0010h\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0005J\u000e\u0010k\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0005J\u000e\u0010l\u001a\u00020m2\u0006\u0010d\u001a\u00020\u0005J\u000e\u0010n\u001a\u00020m2\u0006\u0010d\u001a\u00020\u0005J\u000e\u0010o\u001a\u00020m2\u0006\u0010d\u001a\u00020\u0005J\u001a\u0010p\u001a\u00020m2\u0006\u0010d\u001a\u00020\u00052\n\b\u0002\u0010q\u001a\u0004\u0018\u00010mR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00050jX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020m0sX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/stepos/core/error/AIEngineError;", "", "<init>", "()V", AMapLocationStaticsEntity.SUCCESS_STATUS, "", "CANCELLED", "TIMEOUT", "INTERRUPTED", "NATIVE_CANCEL_REQUESTED", "UNKNOWN", "NULL_POINTER", "INVALID_ARGUMENT", "INVALID_STATE", "UNSUPPORTED", "PERMISSION_DENIED", "RESOURCE_EXHAUSTED", "NOT_INITIALIZED", "ALREADY_CLOSED", "SERVICE_RECOVERED_FROM_CRASH", "MODEL_FILE_NOT_FOUND", "MODEL_FILE_CORRUPTED", "MODEL_FORMAT_UNSUPPORTED", "MODEL_LOAD_FAILED", "MODEL_INIT_FAILED", "QNN_LIBRARY_LOAD_FAILED", "LLAMA_LIBRARY_LOAD_FAILED", "HARDWARE_ACCELERATION_UNAVAILABLE", "MODEL_NOT_LOADED", "MODEL_ALREADY_LOADED", "MODEL_LOADING", "MODEL_NOT_FOUND", "MODEL_VERSION_MISMATCH", "MODEL_CONFIG_INVALID", "MODEL_UPDATING", "MODEL_BLACKLISTED", "INFERENCE_NATIVE_ERROR", "INFERENCE_OOM", "INFERENCE_ENGINE_ERROR", "INFERENCE_FAILED", "INFERENCE_QUEUE_FULL", "INFERENCE_IN_PROGRESS", "INFERENCE_RESULT_EMPTY", "INFERENCE_RESULT_PARSE_FAILED", "INFERENCE_TOKEN_LIMIT_EXCEEDED", "SESSION_BUSY", "QUOTA_EXCEEDED", "PRESSURE_CANCELLED", "IPC_BINDER_FAILED", "IPC_SERVICE_DIED", "IPC_SHARED_MEMORY_FAILED", "IPC_HARDWARE_BUFFER_FAILED", "IPC_NOT_CONNECTED", "IPC_SERVICE_BUSY", "IPC_SERIALIZATION_FAILED", "IPC_DESERIALIZATION_FAILED", "IPC_MESSAGE_TOO_LARGE", "ABILITY_CREATE_FAILED", "ABILITY_NOT_REGISTERED", "ABILITY_ALREADY_REGISTERED", "ABILITY_NOT_READY", "ABILITY_TYPE_MISMATCH", "ABILITY_CONFIG_INVALID", "ABILITY_DISABLED", "LOCAL_MODEL_DISABLED", "CLOUD_MODEL_DISABLED", "CTA_NOT_GRANTED", "PROTOCOL_NOT_AVAILABLE", "PROTOCOL_TYPE_MISMATCH", "PROTOCOL_VERSION_INCOMPATIBLE", "INPUT_TYPE_UNSUPPORTED", "INPUT_DATA_INVALID", "INPUT_IMAGE_FORMAT_UNSUPPORTED", "INPUT_AUDIO_FORMAT_UNSUPPORTED", "INPUT_TEXT_EMPTY", "OUTPUT_TYPE_MISMATCH", "OUTPUT_CONVERSION_FAILED", "INPUT_AUDIO_SIZE_TOO_LARGE", "INPUT_AUDIO_DURATION_UNKNOWN", "CLOUD_ENDPOINT_NOT_CONFIGURED", "CLOUD_AUTH_FAILED", "CLOUD_INSUFFICIENT_BALANCE", "CLOUD_NETWORK_UNAVAILABLE", "CLOUD_REQUEST_TIMEOUT", "CLOUD_SERVER_ERROR", "CLOUD_TASK_FAILED", "CLOUD_RESPONSE_INVALID", "CLOUD_INVALID_REQUEST", "CLOUD_RISK_BLOCKED", "CLOUD_QUOTA_EXCEEDED", "CLOUD_TOKEN_TEMP_UNAVAILABLE", "CLOUD_NETWORK_ERROR", "CLOUD_STREAM_TRUNCATED", "WATCHDOG_SAFE_MODE", "LEASE_CLOSE_PARTIAL_FAILURE", "SLA_NO_VALID_ACTION", "SLA_SCREEN_LOCKED", "SLA_UNSUPPORTED", "isSuccess", "", "code", "isCancellation", "isSystemError", "isBusinessError", "isCloudRetryable", "CLOUD_RETRYABLE_CODES", "", "isWarning", "getModule", "", "getLevel", "getMessage", "format", "customMessage", "errorMessages", "", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
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
        CLOUD_RETRYABLE_CODES = Y.j(numValueOf, numValueOf2, numValueOf3, numValueOf4, numValueOf5, numValueOf6, numValueOf7, numValueOf8);
        errorMessages = a.m(j.a(0, "Success"), j.a(-100, "Operation cancelled by user"), j.a(Integer.valueOf(TIMEOUT), "Operation timeout"), j.a(Integer.valueOf(INTERRUPTED), "Operation interrupted by system"), j.a(Integer.valueOf(NATIVE_CANCEL_REQUESTED), "Inference cancelled by external cancel request"), j.a(Integer.valueOf(UNKNOWN), "Unknown error"), j.a(100001, "Null pointer exception"), j.a(Integer.valueOf(INVALID_ARGUMENT), "Invalid argument"), j.a(Integer.valueOf(INVALID_STATE), "Invalid state"), j.a(Integer.valueOf(UNSUPPORTED), "Unsupported operation"), j.a(Integer.valueOf(PERMISSION_DENIED), "Permission denied"), j.a(Integer.valueOf(RESOURCE_EXHAUSTED), "Resource exhausted"), j.a(Integer.valueOf(NOT_INITIALIZED), "Not initialized"), j.a(Integer.valueOf(ALREADY_CLOSED), "Already closed"), j.a(Integer.valueOf(SERVICE_RECOVERED_FROM_CRASH), "Service recovered from crash; requested model is blacklisted, use fallback chain"), j.a(Integer.valueOf(MODEL_FILE_NOT_FOUND), "Model file not found"), j.a(Integer.valueOf(MODEL_FILE_CORRUPTED), "Model file corrupted"), j.a(110003, "Model format not supported"), j.a(110004, "Failed to load model"), j.a(Integer.valueOf(MODEL_INIT_FAILED), "Failed to initialize model"), j.a(Integer.valueOf(QNN_LIBRARY_LOAD_FAILED), "Failed to load QNN library"), j.a(Integer.valueOf(LLAMA_LIBRARY_LOAD_FAILED), "Failed to load LLAMA library"), j.a(Integer.valueOf(HARDWARE_ACCELERATION_UNAVAILABLE), "Hardware acceleration unavailable"), j.a(210001, "Model not loaded"), j.a(210002, "Model already loaded"), j.a(Integer.valueOf(MODEL_LOADING), "Model is loading"), j.a(Integer.valueOf(MODEL_NOT_FOUND), "Model not found"), j.a(Integer.valueOf(MODEL_VERSION_MISMATCH), "Model version mismatch"), j.a(Integer.valueOf(MODEL_CONFIG_INVALID), "Invalid model config"), j.a(Integer.valueOf(MODEL_UPDATING), "Model is being updated via OTA, please retry"), j.a(Integer.valueOf(MODEL_BLACKLISTED), "Model is blacklisted after crash recovery, use fallback chain"), j.a(Integer.valueOf(INFERENCE_NATIVE_ERROR), "Native inference error"), j.a(Integer.valueOf(INFERENCE_OOM), "Out of memory during inference"), j.a(Integer.valueOf(INFERENCE_ENGINE_ERROR), "Inference engine internal error"), j.a(Integer.valueOf(INFERENCE_FAILED), "Inference failed"), j.a(Integer.valueOf(INFERENCE_QUEUE_FULL), "Inference queue is full"), j.a(Integer.valueOf(INFERENCE_IN_PROGRESS), "Inference already in progress"), j.a(Integer.valueOf(INFERENCE_RESULT_EMPTY), "Inference result is empty"), j.a(Integer.valueOf(INFERENCE_RESULT_PARSE_FAILED), "Failed to parse inference result"), j.a(Integer.valueOf(INFERENCE_TOKEN_LIMIT_EXCEEDED), "Token limit exceeded"), j.a(Integer.valueOf(SESSION_BUSY), "Session busy, another inference is in progress"), j.a(Integer.valueOf(QUOTA_EXCEEDED), "Inference quota exceeded, please retry later"), j.a(Integer.valueOf(PRESSURE_CANCELLED), "Background inference cancelled due to memory pressure, please retry later"), j.a(Integer.valueOf(CLOUD_ENDPOINT_NOT_CONFIGURED), "Cloud endpoint not configured"), j.a(Integer.valueOf(CLOUD_AUTH_FAILED), "Cloud authentication failed (invalid or missing api_key)"), j.a(Integer.valueOf(CLOUD_INSUFFICIENT_BALANCE), "Cloud account balance insufficient, top up required (retry will not help)"), j.a(numValueOf, "Network unavailable"), j.a(numValueOf3, "Cloud request timed out"), j.a(numValueOf4, "Cloud server error"), j.a(numValueOf5, "Cloud task failed on server"), j.a(Integer.valueOf(CLOUD_RESPONSE_INVALID), "Cloud response invalid or unparseable"), j.a(Integer.valueOf(CLOUD_INVALID_REQUEST), "Cloud rejected request parameters"), j.a(Integer.valueOf(CLOUD_RISK_BLOCKED), "Cloud request blocked by risk control"), j.a(numValueOf6, "Cloud quota or rate limit exceeded"), j.a(numValueOf7, "User token temporarily unavailable (network/system time), retry later"), j.a(numValueOf2, "Cloud connection never established (weak network)"), j.a(numValueOf8, "Cloud stream ended before the terminal event (partial result)"), j.a(Integer.valueOf(IPC_BINDER_FAILED), "Binder connection failed"), j.a(Integer.valueOf(IPC_SERVICE_DIED), "Service process died"), j.a(Integer.valueOf(IPC_SHARED_MEMORY_FAILED), "Failed to create shared memory"), j.a(Integer.valueOf(IPC_HARDWARE_BUFFER_FAILED), "Failed to transfer hardware buffer"), j.a(Integer.valueOf(IPC_NOT_CONNECTED), "Service not connected"), j.a(Integer.valueOf(IPC_SERVICE_BUSY), "Service is busy"), j.a(Integer.valueOf(IPC_SERIALIZATION_FAILED), "Serialization failed"), j.a(Integer.valueOf(IPC_DESERIALIZATION_FAILED), "Deserialization failed"), j.a(Integer.valueOf(IPC_MESSAGE_TOO_LARGE), "Message too large"), j.a(Integer.valueOf(ABILITY_CREATE_FAILED), "Failed to create ability"), j.a(Integer.valueOf(ABILITY_NOT_REGISTERED), "Ability not registered"), j.a(Integer.valueOf(ABILITY_ALREADY_REGISTERED), "Ability already registered"), j.a(Integer.valueOf(ABILITY_NOT_READY), "Ability not ready"), j.a(Integer.valueOf(ABILITY_TYPE_MISMATCH), "Ability type mismatch"), j.a(Integer.valueOf(ABILITY_CONFIG_INVALID), "Invalid ability config"), j.a(Integer.valueOf(ABILITY_DISABLED), "Ability disabled: both local and cloud paths are turned off"), j.a(Integer.valueOf(LOCAL_MODEL_DISABLED), "Local model disabled; cannot fall back to on-device path"), j.a(Integer.valueOf(CLOUD_MODEL_DISABLED), "Cloud model disabled; use AUTO/LOCAL_ONLY or enable cloud path"), j.a(Integer.valueOf(CTA_NOT_GRANTED), "CTA privacy consent not granted; cloud path unavailable"), j.a(Integer.valueOf(PROTOCOL_NOT_AVAILABLE), "Protocol not available"), j.a(Integer.valueOf(PROTOCOL_TYPE_MISMATCH), "Protocol type mismatch"), j.a(Integer.valueOf(PROTOCOL_VERSION_INCOMPATIBLE), "Protocol version incompatible"), j.a(Integer.valueOf(INPUT_TYPE_UNSUPPORTED), "Input type not supported"), j.a(Integer.valueOf(INPUT_DATA_INVALID), "Invalid input data"), j.a(Integer.valueOf(INPUT_IMAGE_FORMAT_UNSUPPORTED), "Image format not supported"), j.a(Integer.valueOf(INPUT_AUDIO_FORMAT_UNSUPPORTED), "Audio format not supported"), j.a(Integer.valueOf(INPUT_TEXT_EMPTY), "Input text is empty"), j.a(Integer.valueOf(OUTPUT_TYPE_MISMATCH), "Output type mismatch"), j.a(Integer.valueOf(OUTPUT_CONVERSION_FAILED), "Output conversion failed"), j.a(Integer.valueOf(INPUT_AUDIO_SIZE_TOO_LARGE), "Audio file size exceeds the limit"), j.a(Integer.valueOf(INPUT_AUDIO_DURATION_UNKNOWN), "Audio duration could not be determined"), j.a(Integer.valueOf(WATCHDOG_SAFE_MODE), "Watchdog triggered safe mode; NPU disabled, inference forced to CPU"), j.a(Integer.valueOf(LEASE_CLOSE_PARTIAL_FAILURE), "InferenceLease close completed with partial failures; resources best-effort released"), j.a(280001, "No valid action recognized"), j.a(280002, "Screen is locked; recognized function not allowed on lock screen"), j.a(280003, "On-device SLA does not support this instruction"));
    }

    private AIEngineError() {
    }

    public static /* synthetic */ String format$default(AIEngineError aIEngineError, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return aIEngineError.format(i10, str);
    }

    public final String format(int code, String customMessage) {
        String module = getModule(code);
        String level = getLevel(code);
        if (customMessage == null) {
            customMessage = getMessage(code);
        }
        return "[" + module + "][" + level + "] " + customMessage + " (" + code + ")";
    }

    public final String getLevel(int code) {
        return code == 0 ? AMapLocationStaticsEntity.SUCCESS_STATUS : code < 0 ? "CANCEL" : (100000 > code || code >= 200000) ? (200000 > code || code >= 300000) ? (300000 > code || code >= 400000) ? "UNKNOWN" : "WARNING" : "BUSINESS" : "SYSTEM";
    }

    public final String getMessage(int code) {
        String str = errorMessages.get(Integer.valueOf(code));
        if (str != null) {
            return str;
        }
        return "Unknown error: " + code;
    }

    public final String getModule(int code) {
        if (code < 0) {
            return "CANCEL";
        }
        int i10 = (code / 1000) % 100;
        return i10 != 0 ? i10 != 10 ? i10 != 20 ? i10 != 30 ? i10 != 40 ? i10 != 50 ? i10 != 60 ? i10 != 70 ? "UNKNOWN" : "CLOUD" : "IO" : "PROTOCOL" : "ABILITY" : "IPC" : "INFERENCE" : "MODEL" : "COMMON";
    }

    public final boolean isBusinessError(int code) {
        return 200000 <= code && code < 300000;
    }

    public final boolean isCancellation(int code) {
        return C1173v.p(-100, Integer.valueOf(TIMEOUT), Integer.valueOf(INTERRUPTED), Integer.valueOf(NATIVE_CANCEL_REQUESTED)).contains(Integer.valueOf(code));
    }

    public final boolean isCloudRetryable(int code) {
        return CLOUD_RETRYABLE_CODES.contains(Integer.valueOf(code));
    }

    public final boolean isSuccess(int code) {
        return code == 0;
    }

    public final boolean isSystemError(int code) {
        return 100000 <= code && code < 200000;
    }

    public final boolean isWarning(int code) {
        return 300000 <= code && code < 400000;
    }
}
