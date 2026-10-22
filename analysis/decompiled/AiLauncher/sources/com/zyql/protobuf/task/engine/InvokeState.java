package com.zyql.protobuf.task.engine;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum InvokeState implements Internal.EnumLite {
    OK(0),
    fail(1),
    UNRECOGNIZED(-1);

    public static final int OK_VALUE = 0;
    public static final int fail_VALUE = 1;
    private static final Internal.EnumLiteMap<InvokeState> internalValueMap = new Internal.EnumLiteMap<InvokeState>() { // from class: com.zyql.protobuf.task.engine.InvokeState.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public InvokeState findValueByNumber(int i10) {
            return InvokeState.forNumber(i10);
        }
    };
    private final int value;

    public static final class InvokeStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new InvokeStateVerifier();

        private InvokeStateVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return InvokeState.forNumber(i10) != null;
        }
    }

    InvokeState(int i10) {
        this.value = i10;
    }

    public static InvokeState forNumber(int i10) {
        if (i10 == 0) {
            return OK;
        }
        if (i10 != 1) {
            return null;
        }
        return fail;
    }

    public static Internal.EnumLiteMap<InvokeState> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return InvokeStateVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static InvokeState valueOf(int i10) {
        return forNumber(i10);
    }
}
