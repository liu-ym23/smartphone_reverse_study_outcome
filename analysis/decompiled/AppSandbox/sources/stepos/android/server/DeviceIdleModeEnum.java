package stepos.android.server;

import com.google.protobuf.Internal;

/* loaded from: classes.dex */
public enum DeviceIdleModeEnum implements Internal.EnumLite {
    DEVICE_IDLE_MODE_OFF(0),
    DEVICE_IDLE_MODE_LIGHT(1),
    DEVICE_IDLE_MODE_DEEP(2);

    public static final int DEVICE_IDLE_MODE_DEEP_VALUE = 2;
    public static final int DEVICE_IDLE_MODE_LIGHT_VALUE = 1;
    public static final int DEVICE_IDLE_MODE_OFF_VALUE = 0;
    private static final Internal.EnumLiteMap<DeviceIdleModeEnum> internalValueMap = new Internal.EnumLiteMap<DeviceIdleModeEnum>() { // from class: stepos.android.server.DeviceIdleModeEnum.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public DeviceIdleModeEnum findValueByNumber(int i) {
            return DeviceIdleModeEnum.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static DeviceIdleModeEnum valueOf(int i) {
        return forNumber(i);
    }

    public static DeviceIdleModeEnum forNumber(int i) {
        if (i == 0) {
            return DEVICE_IDLE_MODE_OFF;
        }
        if (i == 1) {
            return DEVICE_IDLE_MODE_LIGHT;
        }
        if (i != 2) {
            return null;
        }
        return DEVICE_IDLE_MODE_DEEP;
    }

    public static Internal.EnumLiteMap<DeviceIdleModeEnum> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DeviceIdleModeEnumVerifier.INSTANCE;
    }

    private static final class DeviceIdleModeEnumVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new DeviceIdleModeEnumVerifier();

        private DeviceIdleModeEnumVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return DeviceIdleModeEnum.forNumber(i) != null;
        }
    }

    DeviceIdleModeEnum(int i) {
        this.value = i;
    }
}
