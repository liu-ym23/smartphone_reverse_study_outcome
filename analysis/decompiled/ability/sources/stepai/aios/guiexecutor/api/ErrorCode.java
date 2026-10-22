package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001d\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lstepai/aios/guiexecutor/api/ErrorCode;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "TARGET_NOT_FOUND", "TARGET_NOT_CLICKABLE", "TARGET_NOT_VISIBLE", "TARGET_OUT_OF_BOUNDS", "ACCESSIBILITY_DISABLED", "PERMISSION_DENIED", "SERVICE_UNAVAILABLE", "SYSTEM_ERROR", "TIMEOUT", "INVALID_PARAMETER", "OPERATION_FAILED", "OPERATION_CANCELLED", "UNSUPPORTED_OPERATION", "INPUT_METHOD_ERROR", "TEXT_TOO_LONG", "INVALID_TEXT", "GESTURE_FAILED", "INVALID_GESTURE", "GESTURE_INTERRUPTED", "NETWORK_ERROR", "CONNECTION_TIMEOUT", "UNKNOWN_ERROR", "INTERNAL_ERROR", "CONFIGURATION_ERROR", "TAKEOVER_REQUEST_FAILED", "TAKEOVER_INVALID_PARAMETER", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorCode {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ErrorCode[] $VALUES;
    public static final ErrorCode TARGET_NOT_FOUND = new ErrorCode("TARGET_NOT_FOUND", 0);
    public static final ErrorCode TARGET_NOT_CLICKABLE = new ErrorCode("TARGET_NOT_CLICKABLE", 1);
    public static final ErrorCode TARGET_NOT_VISIBLE = new ErrorCode("TARGET_NOT_VISIBLE", 2);
    public static final ErrorCode TARGET_OUT_OF_BOUNDS = new ErrorCode("TARGET_OUT_OF_BOUNDS", 3);
    public static final ErrorCode ACCESSIBILITY_DISABLED = new ErrorCode("ACCESSIBILITY_DISABLED", 4);
    public static final ErrorCode PERMISSION_DENIED = new ErrorCode("PERMISSION_DENIED", 5);
    public static final ErrorCode SERVICE_UNAVAILABLE = new ErrorCode("SERVICE_UNAVAILABLE", 6);
    public static final ErrorCode SYSTEM_ERROR = new ErrorCode("SYSTEM_ERROR", 7);
    public static final ErrorCode TIMEOUT = new ErrorCode("TIMEOUT", 8);
    public static final ErrorCode INVALID_PARAMETER = new ErrorCode("INVALID_PARAMETER", 9);
    public static final ErrorCode OPERATION_FAILED = new ErrorCode("OPERATION_FAILED", 10);
    public static final ErrorCode OPERATION_CANCELLED = new ErrorCode("OPERATION_CANCELLED", 11);
    public static final ErrorCode UNSUPPORTED_OPERATION = new ErrorCode("UNSUPPORTED_OPERATION", 12);
    public static final ErrorCode INPUT_METHOD_ERROR = new ErrorCode("INPUT_METHOD_ERROR", 13);
    public static final ErrorCode TEXT_TOO_LONG = new ErrorCode("TEXT_TOO_LONG", 14);
    public static final ErrorCode INVALID_TEXT = new ErrorCode("INVALID_TEXT", 15);
    public static final ErrorCode GESTURE_FAILED = new ErrorCode("GESTURE_FAILED", 16);
    public static final ErrorCode INVALID_GESTURE = new ErrorCode("INVALID_GESTURE", 17);
    public static final ErrorCode GESTURE_INTERRUPTED = new ErrorCode("GESTURE_INTERRUPTED", 18);
    public static final ErrorCode NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 19);
    public static final ErrorCode CONNECTION_TIMEOUT = new ErrorCode("CONNECTION_TIMEOUT", 20);
    public static final ErrorCode UNKNOWN_ERROR = new ErrorCode("UNKNOWN_ERROR", 21);
    public static final ErrorCode INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 22);
    public static final ErrorCode CONFIGURATION_ERROR = new ErrorCode("CONFIGURATION_ERROR", 23);
    public static final ErrorCode TAKEOVER_REQUEST_FAILED = new ErrorCode("TAKEOVER_REQUEST_FAILED", 24);
    public static final ErrorCode TAKEOVER_INVALID_PARAMETER = new ErrorCode("TAKEOVER_INVALID_PARAMETER", 25);

    private static final /* synthetic */ ErrorCode[] $values() {
        return new ErrorCode[]{TARGET_NOT_FOUND, TARGET_NOT_CLICKABLE, TARGET_NOT_VISIBLE, TARGET_OUT_OF_BOUNDS, ACCESSIBILITY_DISABLED, PERMISSION_DENIED, SERVICE_UNAVAILABLE, SYSTEM_ERROR, TIMEOUT, INVALID_PARAMETER, OPERATION_FAILED, OPERATION_CANCELLED, UNSUPPORTED_OPERATION, INPUT_METHOD_ERROR, TEXT_TOO_LONG, INVALID_TEXT, GESTURE_FAILED, INVALID_GESTURE, GESTURE_INTERRUPTED, NETWORK_ERROR, CONNECTION_TIMEOUT, UNKNOWN_ERROR, INTERNAL_ERROR, CONFIGURATION_ERROR, TAKEOVER_REQUEST_FAILED, TAKEOVER_INVALID_PARAMETER};
    }

    static {
        ErrorCode[] errorCodeArr$values = $values();
        $VALUES = errorCodeArr$values;
        $ENTRIES = kotlin.enums.a.a(errorCodeArr$values);
    }

    private ErrorCode(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static ErrorCode valueOf(String str) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, str);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }
}
