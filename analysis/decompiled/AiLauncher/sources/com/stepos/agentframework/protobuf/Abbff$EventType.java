package com.stepos.agentframework.protobuf;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum Abbff$EventType implements Internal.EnumLite {
    EVENT_TYPE_UNSPECIFIED(0),
    MESSAGE_RECEIVED(1),
    MESSAGE_SENT(2),
    MESSAGE_FAILED(3),
    SESSION_CREATED(4),
    SESSION_DELETED(5),
    SESSION_RENAMED(6),
    DEVICE_PAIRED(7),
    DEVICE_UNPAIRED(8),
    DEVICE_HEARTBEAT(9),
    UNRECOGNIZED(-1);

    public static final int DEVICE_HEARTBEAT_VALUE = 9;
    public static final int DEVICE_PAIRED_VALUE = 7;
    public static final int DEVICE_UNPAIRED_VALUE = 8;
    public static final int EVENT_TYPE_UNSPECIFIED_VALUE = 0;
    public static final int MESSAGE_FAILED_VALUE = 3;
    public static final int MESSAGE_RECEIVED_VALUE = 1;
    public static final int MESSAGE_SENT_VALUE = 2;
    public static final int SESSION_CREATED_VALUE = 4;
    public static final int SESSION_DELETED_VALUE = 5;
    public static final int SESSION_RENAMED_VALUE = 6;
    private static final Internal.EnumLiteMap<Abbff$EventType> internalValueMap = new Internal.EnumLiteMap<Abbff$EventType>() { // from class: com.stepos.agentframework.protobuf.Abbff$EventType.a
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Abbff$EventType findValueByNumber(int i10) {
            return Abbff$EventType.forNumber(i10);
        }
    };
    private final int value;

    public static final class b implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new b();

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return Abbff$EventType.forNumber(i10) != null;
        }
    }

    Abbff$EventType(int i10) {
        this.value = i10;
    }

    public static Abbff$EventType forNumber(int i10) {
        switch (i10) {
            case 0:
                return EVENT_TYPE_UNSPECIFIED;
            case 1:
                return MESSAGE_RECEIVED;
            case 2:
                return MESSAGE_SENT;
            case 3:
                return MESSAGE_FAILED;
            case 4:
                return SESSION_CREATED;
            case 5:
                return SESSION_DELETED;
            case 6:
                return SESSION_RENAMED;
            case 7:
                return DEVICE_PAIRED;
            case 8:
                return DEVICE_UNPAIRED;
            case 9:
                return DEVICE_HEARTBEAT;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<Abbff$EventType> internalGetValueMap() {
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
    public static Abbff$EventType valueOf(int i10) {
        return forNumber(i10);
    }
}
