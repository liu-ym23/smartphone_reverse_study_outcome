package Ba;

import stepai.aios.guiexecutor.api.ErrorCode;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class i {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f273a;

    static {
        int[] iArr = new int[ErrorCode.values().length];
        try {
            iArr[ErrorCode.TARGET_NOT_FOUND.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[ErrorCode.TARGET_NOT_CLICKABLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[ErrorCode.TARGET_NOT_VISIBLE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[ErrorCode.TARGET_OUT_OF_BOUNDS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[ErrorCode.ACCESSIBILITY_DISABLED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr[ErrorCode.PERMISSION_DENIED.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr[ErrorCode.SERVICE_UNAVAILABLE.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr[ErrorCode.SYSTEM_ERROR.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr[ErrorCode.TIMEOUT.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr[ErrorCode.INVALID_PARAMETER.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr[ErrorCode.OPERATION_FAILED.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr[ErrorCode.OPERATION_CANCELLED.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr[ErrorCode.UNSUPPORTED_OPERATION.ordinal()] = 13;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr[ErrorCode.INPUT_METHOD_ERROR.ordinal()] = 14;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr[ErrorCode.TEXT_TOO_LONG.ordinal()] = 15;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr[ErrorCode.INVALID_TEXT.ordinal()] = 16;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr[ErrorCode.GESTURE_FAILED.ordinal()] = 17;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr[ErrorCode.INVALID_GESTURE.ordinal()] = 18;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr[ErrorCode.GESTURE_INTERRUPTED.ordinal()] = 19;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            iArr[ErrorCode.NETWORK_ERROR.ordinal()] = 20;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            iArr[ErrorCode.CONNECTION_TIMEOUT.ordinal()] = 21;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            iArr[ErrorCode.TAKEOVER_REQUEST_FAILED.ordinal()] = 22;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            iArr[ErrorCode.TAKEOVER_INVALID_PARAMETER.ordinal()] = 23;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            iArr[ErrorCode.UNKNOWN_ERROR.ordinal()] = 24;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            iArr[ErrorCode.INTERNAL_ERROR.ordinal()] = 25;
        } catch (NoSuchFieldError unused25) {
        }
        try {
            iArr[ErrorCode.CONFIGURATION_ERROR.ordinal()] = 26;
        } catch (NoSuchFieldError unused26) {
        }
        f273a = iArr;
    }
}
