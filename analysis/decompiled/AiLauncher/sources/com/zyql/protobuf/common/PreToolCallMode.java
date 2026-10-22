package com.zyql.protobuf.common;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum PreToolCallMode implements Internal.EnumLite {
    PRE_TOOL_CALL_MODE_UNSPECIFIED(0),
    PRE_TOOL_CALL_MODE_ALLOW(1),
    PRE_TOOL_CALL_MODE_DENY(2),
    PRE_TOOL_CALL_MODE_ASK(3),
    UNRECOGNIZED(-1);

    public static final int PRE_TOOL_CALL_MODE_ALLOW_VALUE = 1;
    public static final int PRE_TOOL_CALL_MODE_ASK_VALUE = 3;
    public static final int PRE_TOOL_CALL_MODE_DENY_VALUE = 2;
    public static final int PRE_TOOL_CALL_MODE_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<PreToolCallMode> internalValueMap = new Internal.EnumLiteMap<PreToolCallMode>() { // from class: com.zyql.protobuf.common.PreToolCallMode.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public PreToolCallMode findValueByNumber(int i10) {
            return PreToolCallMode.forNumber(i10);
        }
    };
    private final int value;

    public static final class PreToolCallModeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PreToolCallModeVerifier();

        private PreToolCallModeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return PreToolCallMode.forNumber(i10) != null;
        }
    }

    PreToolCallMode(int i10) {
        this.value = i10;
    }

    public static PreToolCallMode forNumber(int i10) {
        if (i10 == 0) {
            return PRE_TOOL_CALL_MODE_UNSPECIFIED;
        }
        if (i10 == 1) {
            return PRE_TOOL_CALL_MODE_ALLOW;
        }
        if (i10 == 2) {
            return PRE_TOOL_CALL_MODE_DENY;
        }
        if (i10 != 3) {
            return null;
        }
        return PRE_TOOL_CALL_MODE_ASK;
    }

    public static Internal.EnumLiteMap<PreToolCallMode> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PreToolCallModeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static PreToolCallMode valueOf(int i10) {
        return forNumber(i10);
    }
}
