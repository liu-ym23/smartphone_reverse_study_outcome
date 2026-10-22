package com.zyql.protobuf.common;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum LogSender implements Internal.EnumLite {
    LOG_SENDER_UNSPECIFIED(0),
    LOG_SENDER_APP(1),
    LOG_SENDER_RUNTIME(2),
    LOG_SENDER_AGENT(3),
    UNRECOGNIZED(-1);

    public static final int LOG_SENDER_AGENT_VALUE = 3;
    public static final int LOG_SENDER_APP_VALUE = 1;
    public static final int LOG_SENDER_RUNTIME_VALUE = 2;
    public static final int LOG_SENDER_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<LogSender> internalValueMap = new Internal.EnumLiteMap<LogSender>() { // from class: com.zyql.protobuf.common.LogSender.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public LogSender findValueByNumber(int i10) {
            return LogSender.forNumber(i10);
        }
    };
    private final int value;

    public static final class LogSenderVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new LogSenderVerifier();

        private LogSenderVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return LogSender.forNumber(i10) != null;
        }
    }

    LogSender(int i10) {
        this.value = i10;
    }

    public static LogSender forNumber(int i10) {
        if (i10 == 0) {
            return LOG_SENDER_UNSPECIFIED;
        }
        if (i10 == 1) {
            return LOG_SENDER_APP;
        }
        if (i10 == 2) {
            return LOG_SENDER_RUNTIME;
        }
        if (i10 != 3) {
            return null;
        }
        return LOG_SENDER_AGENT;
    }

    public static Internal.EnumLiteMap<LogSender> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LogSenderVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static LogSender valueOf(int i10) {
        return forNumber(i10);
    }
}
