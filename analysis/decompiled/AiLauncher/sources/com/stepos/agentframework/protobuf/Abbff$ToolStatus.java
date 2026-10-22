package com.stepos.agentframework.protobuf;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum Abbff$ToolStatus implements Internal.EnumLite {
    TOOL_STATUS_UNSPECIFIED(0),
    PENDING(1),
    RUNNING(2),
    OK(3),
    ERROR(4),
    CANCELLED(5),
    UNRECOGNIZED(-1);

    public static final int CANCELLED_VALUE = 5;
    public static final int ERROR_VALUE = 4;
    public static final int OK_VALUE = 3;
    public static final int PENDING_VALUE = 1;
    public static final int RUNNING_VALUE = 2;
    public static final int TOOL_STATUS_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<Abbff$ToolStatus> internalValueMap = new Internal.EnumLiteMap<Abbff$ToolStatus>() { // from class: com.stepos.agentframework.protobuf.Abbff$ToolStatus.a
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Abbff$ToolStatus findValueByNumber(int i10) {
            return Abbff$ToolStatus.forNumber(i10);
        }
    };
    private final int value;

    public static final class b implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new b();

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return Abbff$ToolStatus.forNumber(i10) != null;
        }
    }

    Abbff$ToolStatus(int i10) {
        this.value = i10;
    }

    public static Abbff$ToolStatus forNumber(int i10) {
        if (i10 == 0) {
            return TOOL_STATUS_UNSPECIFIED;
        }
        if (i10 == 1) {
            return PENDING;
        }
        if (i10 == 2) {
            return RUNNING;
        }
        if (i10 == 3) {
            return OK;
        }
        if (i10 == 4) {
            return ERROR;
        }
        if (i10 != 5) {
            return null;
        }
        return CANCELLED;
    }

    public static Internal.EnumLiteMap<Abbff$ToolStatus> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return b.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static Abbff$ToolStatus valueOf(int i10) {
        return forNumber(i10);
    }
}
