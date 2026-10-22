package com.zyql.protobuf.common;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum LogLevel implements Internal.EnumLite {
    LOG_LEVEL_UNSPECIFIED(0),
    LOG_LEVEL_DEBUG(1),
    LOG_LEVEL_INFO(2),
    LOG_LEVEL_WARN(3),
    LOG_LEVEL_ERROR(4),
    LOG_LEVEL_OFF(5),
    UNRECOGNIZED(-1);

    public static final int LOG_LEVEL_DEBUG_VALUE = 1;
    public static final int LOG_LEVEL_ERROR_VALUE = 4;
    public static final int LOG_LEVEL_INFO_VALUE = 2;
    public static final int LOG_LEVEL_OFF_VALUE = 5;
    public static final int LOG_LEVEL_UNSPECIFIED_VALUE = 0;
    public static final int LOG_LEVEL_WARN_VALUE = 3;
    private static final Internal.EnumLiteMap<LogLevel> internalValueMap = new Internal.EnumLiteMap<LogLevel>() { // from class: com.zyql.protobuf.common.LogLevel.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public LogLevel findValueByNumber(int i10) {
            return LogLevel.forNumber(i10);
        }
    };
    private final int value;

    public static final class LogLevelVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new LogLevelVerifier();

        private LogLevelVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return LogLevel.forNumber(i10) != null;
        }
    }

    LogLevel(int i10) {
        this.value = i10;
    }

    public static LogLevel forNumber(int i10) {
        if (i10 == 0) {
            return LOG_LEVEL_UNSPECIFIED;
        }
        if (i10 == 1) {
            return LOG_LEVEL_DEBUG;
        }
        if (i10 == 2) {
            return LOG_LEVEL_INFO;
        }
        if (i10 == 3) {
            return LOG_LEVEL_WARN;
        }
        if (i10 == 4) {
            return LOG_LEVEL_ERROR;
        }
        if (i10 != 5) {
            return null;
        }
        return LOG_LEVEL_OFF;
    }

    public static Internal.EnumLiteMap<LogLevel> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LogLevelVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static LogLevel valueOf(int i10) {
        return forNumber(i10);
    }
}
