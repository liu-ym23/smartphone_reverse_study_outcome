package stepos.android.server;

import com.google.protobuf.Internal;

/* loaded from: classes.dex */
public enum DockStateEnum implements Internal.EnumLite {
    DOCK_STATE_UNDOCKED(0),
    DOCK_STATE_DESK(1),
    DOCK_STATE_CAR(2),
    DOCK_STATE_LE_DESK(3),
    DOCK_STATE_HE_DESK(4);

    public static final int DOCK_STATE_CAR_VALUE = 2;
    public static final int DOCK_STATE_DESK_VALUE = 1;
    public static final int DOCK_STATE_HE_DESK_VALUE = 4;
    public static final int DOCK_STATE_LE_DESK_VALUE = 3;
    public static final int DOCK_STATE_UNDOCKED_VALUE = 0;
    private static final Internal.EnumLiteMap<DockStateEnum> internalValueMap = new Internal.EnumLiteMap<DockStateEnum>() { // from class: stepos.android.server.DockStateEnum.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public DockStateEnum findValueByNumber(int i) {
            return DockStateEnum.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static DockStateEnum valueOf(int i) {
        return forNumber(i);
    }

    public static DockStateEnum forNumber(int i) {
        if (i == 0) {
            return DOCK_STATE_UNDOCKED;
        }
        if (i == 1) {
            return DOCK_STATE_DESK;
        }
        if (i == 2) {
            return DOCK_STATE_CAR;
        }
        if (i == 3) {
            return DOCK_STATE_LE_DESK;
        }
        if (i != 4) {
            return null;
        }
        return DOCK_STATE_HE_DESK;
    }

    public static Internal.EnumLiteMap<DockStateEnum> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DockStateEnumVerifier.INSTANCE;
    }

    private static final class DockStateEnumVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new DockStateEnumVerifier();

        private DockStateEnumVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return DockStateEnum.forNumber(i) != null;
        }
    }

    DockStateEnum(int i) {
        this.value = i;
    }
}
