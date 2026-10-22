package com.zyql.protobuf.common;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum HookPoint implements Internal.EnumLite {
    HOOK_POINT_UNSPECIFIED(0),
    HOOK_POINT_SESSION_START(1),
    HOOK_POINT_SESSION_END(2),
    HOOK_POINT_TOOL_CALL_PRE(5),
    HOOK_POINT_TOOL_CALL_POST(6),
    HOOK_POINT_TOOL_CALL_ERROR(7),
    HOOK_POINT_MODEL_CALL_PRE(10),
    HOOK_POINT_MODEL_CALL_POST(11),
    HOOK_POINT_MODEL_CALL_ERROR(12),
    HOOK_POINT_AGENT_START(15),
    HOOK_POINT_AGENT_COMPLETE(16),
    HOOK_POINT_AGENT_ERROR(17),
    HOOK_POINT_HANDOFF_PRE(18),
    HOOK_POINT_HANDOFF_POST(19),
    HOOK_POINT_MESSAGE_PRE(20),
    HOOK_POINT_MESSAGE_POST(21),
    UNRECOGNIZED(-1);

    public static final int HOOK_POINT_AGENT_COMPLETE_VALUE = 16;
    public static final int HOOK_POINT_AGENT_ERROR_VALUE = 17;
    public static final int HOOK_POINT_AGENT_START_VALUE = 15;
    public static final int HOOK_POINT_HANDOFF_POST_VALUE = 19;
    public static final int HOOK_POINT_HANDOFF_PRE_VALUE = 18;
    public static final int HOOK_POINT_MESSAGE_POST_VALUE = 21;
    public static final int HOOK_POINT_MESSAGE_PRE_VALUE = 20;
    public static final int HOOK_POINT_MODEL_CALL_ERROR_VALUE = 12;
    public static final int HOOK_POINT_MODEL_CALL_POST_VALUE = 11;
    public static final int HOOK_POINT_MODEL_CALL_PRE_VALUE = 10;
    public static final int HOOK_POINT_SESSION_END_VALUE = 2;
    public static final int HOOK_POINT_SESSION_START_VALUE = 1;
    public static final int HOOK_POINT_TOOL_CALL_ERROR_VALUE = 7;
    public static final int HOOK_POINT_TOOL_CALL_POST_VALUE = 6;
    public static final int HOOK_POINT_TOOL_CALL_PRE_VALUE = 5;
    public static final int HOOK_POINT_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<HookPoint> internalValueMap = new Internal.EnumLiteMap<HookPoint>() { // from class: com.zyql.protobuf.common.HookPoint.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public HookPoint findValueByNumber(int i10) {
            return HookPoint.forNumber(i10);
        }
    };
    private final int value;

    public static final class HookPointVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new HookPointVerifier();

        private HookPointVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return HookPoint.forNumber(i10) != null;
        }
    }

    HookPoint(int i10) {
        this.value = i10;
    }

    public static HookPoint forNumber(int i10) {
        switch (i10) {
            case 0:
                return HOOK_POINT_UNSPECIFIED;
            case 1:
                return HOOK_POINT_SESSION_START;
            case 2:
                return HOOK_POINT_SESSION_END;
            case 3:
            case 4:
            case 8:
            case 9:
            case 13:
            case 14:
            default:
                return null;
            case 5:
                return HOOK_POINT_TOOL_CALL_PRE;
            case 6:
                return HOOK_POINT_TOOL_CALL_POST;
            case 7:
                return HOOK_POINT_TOOL_CALL_ERROR;
            case 10:
                return HOOK_POINT_MODEL_CALL_PRE;
            case 11:
                return HOOK_POINT_MODEL_CALL_POST;
            case 12:
                return HOOK_POINT_MODEL_CALL_ERROR;
            case 15:
                return HOOK_POINT_AGENT_START;
            case 16:
                return HOOK_POINT_AGENT_COMPLETE;
            case 17:
                return HOOK_POINT_AGENT_ERROR;
            case 18:
                return HOOK_POINT_HANDOFF_PRE;
            case 19:
                return HOOK_POINT_HANDOFF_POST;
            case 20:
                return HOOK_POINT_MESSAGE_PRE;
            case 21:
                return HOOK_POINT_MESSAGE_POST;
        }
    }

    public static Internal.EnumLiteMap<HookPoint> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HookPointVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static HookPoint valueOf(int i10) {
        return forNumber(i10);
    }
}
