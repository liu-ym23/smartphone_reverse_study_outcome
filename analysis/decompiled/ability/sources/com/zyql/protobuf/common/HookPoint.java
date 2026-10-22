package com.zyql.protobuf.common;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum HookPoint implements InterfaceC0974o1 {
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


    /* renamed from: a, reason: collision with root package name */
    public final int f4263a;

    HookPoint(int i) {
        this.f4263a = i;
    }

    public static HookPoint a(int i) {
        switch (i) {
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

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4263a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
