package stepos.android.server;

import com.google.protobuf.Internal;

/* loaded from: classes.dex */
public enum ErrorSource implements Internal.EnumLite {
    ERROR_SOURCE_UNKNOWN(0),
    DATA_APP(1),
    SYSTEM_APP(2),
    SYSTEM_SERVER(3);

    public static final int DATA_APP_VALUE = 1;
    public static final int ERROR_SOURCE_UNKNOWN_VALUE = 0;
    public static final int SYSTEM_APP_VALUE = 2;
    public static final int SYSTEM_SERVER_VALUE = 3;
    private static final Internal.EnumLiteMap<ErrorSource> internalValueMap = new Internal.EnumLiteMap<ErrorSource>() { // from class: stepos.android.server.ErrorSource.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ErrorSource findValueByNumber(int i) {
            return ErrorSource.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static ErrorSource valueOf(int i) {
        return forNumber(i);
    }

    public static ErrorSource forNumber(int i) {
        if (i == 0) {
            return ERROR_SOURCE_UNKNOWN;
        }
        if (i == 1) {
            return DATA_APP;
        }
        if (i == 2) {
            return SYSTEM_APP;
        }
        if (i != 3) {
            return null;
        }
        return SYSTEM_SERVER;
    }

    public static Internal.EnumLiteMap<ErrorSource> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ErrorSourceVerifier.INSTANCE;
    }

    private static final class ErrorSourceVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ErrorSourceVerifier();

        private ErrorSourceVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return ErrorSource.forNumber(i) != null;
        }
    }

    ErrorSource(int i) {
        this.value = i;
    }
}
