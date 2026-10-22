package com.zyql.protobuf.common;

import com.google.protobuf.Internal;

/* loaded from: classes4.dex */
public enum StoreScope implements Internal.EnumLite {
    STORE_SCOPE_UNSPECIFIED(0),
    STORE_SCOPE_NORMAL(1),
    STORE_SCOPE_USER(2),
    STORE_SCOPE_APP(3),
    STORE_SCOPE_SESSION(4),
    STORE_SCOPE_TEMP(5),
    UNRECOGNIZED(-1);

    public static final int STORE_SCOPE_APP_VALUE = 3;
    public static final int STORE_SCOPE_NORMAL_VALUE = 1;
    public static final int STORE_SCOPE_SESSION_VALUE = 4;
    public static final int STORE_SCOPE_TEMP_VALUE = 5;
    public static final int STORE_SCOPE_UNSPECIFIED_VALUE = 0;
    public static final int STORE_SCOPE_USER_VALUE = 2;
    private static final Internal.EnumLiteMap<StoreScope> internalValueMap = new Internal.EnumLiteMap<StoreScope>() { // from class: com.zyql.protobuf.common.StoreScope.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public StoreScope findValueByNumber(int i10) {
            return StoreScope.forNumber(i10);
        }
    };
    private final int value;

    public static final class StoreScopeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new StoreScopeVerifier();

        private StoreScopeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return StoreScope.forNumber(i10) != null;
        }
    }

    StoreScope(int i10) {
        this.value = i10;
    }

    public static StoreScope forNumber(int i10) {
        if (i10 == 0) {
            return STORE_SCOPE_UNSPECIFIED;
        }
        if (i10 == 1) {
            return STORE_SCOPE_NORMAL;
        }
        if (i10 == 2) {
            return STORE_SCOPE_USER;
        }
        if (i10 == 3) {
            return STORE_SCOPE_APP;
        }
        if (i10 == 4) {
            return STORE_SCOPE_SESSION;
        }
        if (i10 != 5) {
            return null;
        }
        return STORE_SCOPE_TEMP;
    }

    public static Internal.EnumLiteMap<StoreScope> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return StoreScopeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static StoreScope valueOf(int i10) {
        return forNumber(i10);
    }
}
