package com.bes.sdk.utils;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum MessageID extends Enum<MessageID> {
    public static final MessageID A2DP_STATUS = null;
    public static final MessageID ANC_STATUS = null;
    public static final MessageID AUTO_PAUSE = null;
    public static final MessageID AUTO_POWER_OFF = null;
    public static final MessageID BATTERY_STATUS = null;
    public static final MessageID COMBINED_EQ_STATUS = null;
    public static final MessageID DEVICE_INFO = null;
    public static final MessageID DEVICE_LIST_INFO = null;
    public static final MessageID DEVICE_NAME = null;
    public static final MessageID EQ_STATUS = null;
    public static final MessageID FIND_ME_STATUS = null;
    public static final MessageID GESTURE_STATUS = null;
    public static final MessageID IN_EAR_STATUS = null;
    public static final MessageID MULTI_AI_STATUS = null;
    public static final MessageID OTA_STATUS = null;
    public static final MessageID RUNNING_EQ_STATUS = null;
    public static final MessageID SEALING_STATUS = null;
    public static final MessageID SMART_SWITCH_STATUS = null;
    public static final MessageID SYNC_CRC_STATUS = null;
    public static final MessageID TWS_STATUS = null;
    public static final MessageID UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageID[] f33670a = null;
    private String mName;
    private int mValue;

    static {
        MessageID r100 = new MessageID("UNKNOWN", 0, -1, "UnknownCommand");
        UNKNOWN = r100;
        MessageID r101 = new MessageID("DEVICE_LIST_INFO", 1, 1001, "DEVICE_LIST_INFO");
        DEVICE_LIST_INFO = r101;
        MessageID r102 = new MessageID("DEVICE_NAME", 2, 1002, "DEVICE_NAME");
        DEVICE_NAME = r102;
        MessageID r103 = new MessageID("ANC_STATUS", 3, 1003, "ANC_STATUS");
        ANC_STATUS = r103;
        MessageID r104 = new MessageID("AUTO_PAUSE", 4, 1004, "AUTO_PAUSE");
        AUTO_PAUSE = r104;
        MessageID r105 = new MessageID("AUTO_POWER_OFF", 5, 1005, "AUTO_POWER_OFF");
        AUTO_POWER_OFF = r105;
        MessageID r110 = new MessageID("MULTI_AI_STATUS", 6, 1006, "MULTI_AI_STATUS");
        MULTI_AI_STATUS = r110;
        MessageID r111 = new MessageID("A2DP_STATUS", 7, 1007, "A2DP_STATUS");
        A2DP_STATUS = r111;
        MessageID r112 = new MessageID("FIND_ME_STATUS", 8, 1008, "FIND_ME_STATUS");
        FIND_ME_STATUS = r112;
        MessageID r113 = new MessageID("TWS_STATUS", 9, 1009, "TWS_STATUS");
        TWS_STATUS = r113;
        MessageID r114 = new MessageID("SEALING_STATUS", 10, 1010, "SEALING_STATUS");
        SEALING_STATUS = r114;
        MessageID r106 = new MessageID("GESTURE_STATUS", 11, 1011, "GESTURE_STATUS");
        GESTURE_STATUS = r106;
        MessageID r107 = new MessageID("SYNC_CRC_STATUS", 12, 1012, "SYNC_CRC_STATUS");
        SYNC_CRC_STATUS = r107;
        MessageID r108 = new MessageID("DEVICE_INFO", 13, 1013, "DEVICE_INFO");
        DEVICE_INFO = r108;
        MessageID r109 = new MessageID("BATTERY_STATUS", 14, 1014, "BATTERY_STATUS");
        BATTERY_STATUS = r109;
        MessageID r115 = new MessageID("IN_EAR_STATUS", 15, 1015, "IN_EAR_STATUS");
        IN_EAR_STATUS = r115;
        MessageID r116 = new MessageID("SMART_SWITCH_STATUS", 16, 1016, "SMART_SWITCH_STATUS");
        SMART_SWITCH_STATUS = r116;
        MessageID r117 = new MessageID("OTA_STATUS", 17, 2001, "OTA_STATUS");
        OTA_STATUS = r117;
        MessageID r118 = new MessageID("EQ_STATUS", 18, 3001, "EQ_STATUS");
        EQ_STATUS = r118;
        MessageID r119 = new MessageID("RUNNING_EQ_STATUS", 19, 3002, "RUNNING_EQ_STATUS");
        RUNNING_EQ_STATUS = r119;
        MessageID r120 = new MessageID("COMBINED_EQ_STATUS", 20, 3003, "COMBINED_EQ_STATUS");
        COMBINED_EQ_STATUS = r120;
        f33670a = new MessageID[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120};
    }

    public static MessageID[] values() {
        return (MessageID[]) f33670a.clone();
    }

    public String getCmdName() {
        return this.mName;
    }

    public int getValue() {
        return this.mValue;
    }

    public static MessageID valueOf(String r100) {
        return (MessageID) a.a(MessageID.class, r100);
    }

    public MessageID(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.mValue = r102;
        this.mName = r103;
    }
}
