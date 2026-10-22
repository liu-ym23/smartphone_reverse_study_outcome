package com.zyql.protobuf.agent;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum ErrorCode implements Internal.EnumLite {
    ERROR_UNSPECIFIED(0),
    ERROR_TIMEOUT(1),
    ERROR_NOT_FOUND(2),
    ERROR_INVALID_ARGUMENT(3),
    ERROR_PERMISSION_DENIED(4),
    ERROR_INTERNAL(5),
    ERROR_UNAVAILABLE(6),
    ERROR_CANCELLED(7),
    UNRECOGNIZED(-1);

    public static final int ERROR_CANCELLED_VALUE = 7;
    public static final int ERROR_INTERNAL_VALUE = 5;
    public static final int ERROR_INVALID_ARGUMENT_VALUE = 3;
    public static final int ERROR_NOT_FOUND_VALUE = 2;
    public static final int ERROR_PERMISSION_DENIED_VALUE = 4;
    public static final int ERROR_TIMEOUT_VALUE = 1;
    public static final int ERROR_UNAVAILABLE_VALUE = 6;
    public static final int ERROR_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<ErrorCode> internalValueMap = new Internal.EnumLiteMap<ErrorCode>() { // from class: com.zyql.protobuf.agent.ErrorCode.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ErrorCode findValueByNumber(int i10) {
            return ErrorCode.forNumber(i10);
        }
    };
    private final int value;

    public static final class ErrorCodeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ErrorCodeVerifier();

        private ErrorCodeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return ErrorCode.forNumber(i10) != null;
        }
    }

    ErrorCode(int i10) {
        this.value = i10;
    }

    public static ErrorCode forNumber(int i10) {
        switch (i10) {
            case 0:
                return ERROR_UNSPECIFIED;
            case 1:
                return ERROR_TIMEOUT;
            case 2:
                return ERROR_NOT_FOUND;
            case 3:
                return ERROR_INVALID_ARGUMENT;
            case 4:
                return ERROR_PERMISSION_DENIED;
            case 5:
                return ERROR_INTERNAL;
            case 6:
                return ERROR_UNAVAILABLE;
            case 7:
                return ERROR_CANCELLED;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<ErrorCode> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ErrorCodeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static ErrorCode valueOf(int i10) {
        return forNumber(i10);
    }
}
