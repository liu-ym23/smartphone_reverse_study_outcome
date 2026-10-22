package com.zyql.protobuf.common;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum HookExecutionMode implements Internal.EnumLite {
    HOOK_EXECUTION_MODE_UNSPECIFIED(0),
    HOOK_EXECUTION_MODE_SYNC(1),
    HOOK_EXECUTION_MODE_ASYNC(2),
    UNRECOGNIZED(-1);

    public static final int HOOK_EXECUTION_MODE_ASYNC_VALUE = 2;
    public static final int HOOK_EXECUTION_MODE_SYNC_VALUE = 1;
    public static final int HOOK_EXECUTION_MODE_UNSPECIFIED_VALUE = 0;
    private static final Internal.EnumLiteMap<HookExecutionMode> internalValueMap = new Internal.EnumLiteMap<HookExecutionMode>() { // from class: com.zyql.protobuf.common.HookExecutionMode.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public HookExecutionMode findValueByNumber(int i10) {
            return HookExecutionMode.forNumber(i10);
        }
    };
    private final int value;

    public static final class HookExecutionModeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new HookExecutionModeVerifier();

        private HookExecutionModeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return HookExecutionMode.forNumber(i10) != null;
        }
    }

    HookExecutionMode(int i10) {
        this.value = i10;
    }

    public static HookExecutionMode forNumber(int i10) {
        if (i10 == 0) {
            return HOOK_EXECUTION_MODE_UNSPECIFIED;
        }
        if (i10 == 1) {
            return HOOK_EXECUTION_MODE_SYNC;
        }
        if (i10 != 2) {
            return null;
        }
        return HOOK_EXECUTION_MODE_ASYNC;
    }

    public static Internal.EnumLiteMap<HookExecutionMode> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HookExecutionModeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static HookExecutionMode valueOf(int i10) {
        return forNumber(i10);
    }
}
