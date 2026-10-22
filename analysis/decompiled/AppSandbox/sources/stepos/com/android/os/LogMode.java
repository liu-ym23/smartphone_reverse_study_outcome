package stepos.com.android.os;

import com.google.protobuf.Internal;

/* loaded from: classes.dex */
public enum LogMode implements Internal.EnumLite {
    MODE_UNSET(0),
    MODE_AUTOMATIC(1),
    MODE_BYTES(2);

    public static final int MODE_AUTOMATIC_VALUE = 1;
    public static final int MODE_BYTES_VALUE = 2;
    public static final int MODE_UNSET_VALUE = 0;
    private static final Internal.EnumLiteMap<LogMode> internalValueMap = new Internal.EnumLiteMap<LogMode>() { // from class: stepos.com.android.os.LogMode.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public LogMode findValueByNumber(int i) {
            return LogMode.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static LogMode valueOf(int i) {
        return forNumber(i);
    }

    public static LogMode forNumber(int i) {
        if (i == 0) {
            return MODE_UNSET;
        }
        if (i == 1) {
            return MODE_AUTOMATIC;
        }
        if (i != 2) {
            return null;
        }
        return MODE_BYTES;
    }

    public static Internal.EnumLiteMap<LogMode> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LogModeVerifier.INSTANCE;
    }

    private static final class LogModeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new LogModeVerifier();

        private LogModeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return LogMode.forNumber(i) != null;
        }
    }

    LogMode(int i) {
        this.value = i;
    }
}
