package com.zyql.protobuf.internetplatform;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum CallState implements Internal.EnumLite {
    OK(0),
    FAIL(1),
    UNRECOGNIZED(-1);

    public static final int FAIL_VALUE = 1;
    public static final int OK_VALUE = 0;
    private static final Internal.EnumLiteMap<CallState> internalValueMap = new Internal.EnumLiteMap<CallState>() { // from class: com.zyql.protobuf.internetplatform.CallState.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public CallState findValueByNumber(int i10) {
            return CallState.forNumber(i10);
        }
    };
    private final int value;

    public static final class CallStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new CallStateVerifier();

        private CallStateVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return CallState.forNumber(i10) != null;
        }
    }

    CallState(int i10) {
        this.value = i10;
    }

    public static CallState forNumber(int i10) {
        if (i10 == 0) {
            return OK;
        }
        if (i10 != 1) {
            return null;
        }
        return FAIL;
    }

    public static Internal.EnumLiteMap<CallState> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return CallStateVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static CallState valueOf(int i10) {
        return forNumber(i10);
    }
}
