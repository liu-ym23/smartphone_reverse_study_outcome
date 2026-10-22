package com.bes.sdk.utils;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum DeviceProtocol extends Enum<DeviceProtocol> {
    public static final DeviceProtocol PROTOCOL_BLE = null;
    public static final DeviceProtocol PROTOCOL_CABLE = null;
    public static final DeviceProtocol PROTOCOL_GATT_BR_EDR = null;
    public static final DeviceProtocol PROTOCOL_SPP = null;
    public static final DeviceProtocol PROTOCOL_UNKNOWN = null;
    public static final DeviceProtocol PROTOCOL_USB = null;
    public static final DeviceProtocol PROTOCOL_WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceProtocol[] f33668a = null;
    private String mName;
    private int mValue;

    static {
        DeviceProtocol r100 = new DeviceProtocol("PROTOCOL_UNKNOWN", 0, 0, "Unknown");
        PROTOCOL_UNKNOWN = r100;
        DeviceProtocol r101 = new DeviceProtocol("PROTOCOL_BLE", 1, 1, "Bluetooth Low Energy");
        PROTOCOL_BLE = r101;
        DeviceProtocol r102 = new DeviceProtocol("PROTOCOL_SPP", 2, 16, "Serial Port Profile");
        PROTOCOL_SPP = r102;
        DeviceProtocol r103 = new DeviceProtocol("PROTOCOL_WIFI", 3, 256, "Wi-Fi");
        PROTOCOL_WIFI = r103;
        DeviceProtocol r104 = new DeviceProtocol("PROTOCOL_CABLE", 4, 4096, "Cable");
        PROTOCOL_CABLE = r104;
        DeviceProtocol r105 = new DeviceProtocol("PROTOCOL_USB", 5, 65536, "USB");
        PROTOCOL_USB = r105;
        DeviceProtocol r106 = new DeviceProtocol("PROTOCOL_GATT_BR_EDR", 6, 1048576, "GATT_BR_EDR");
        PROTOCOL_GATT_BR_EDR = r106;
        f33668a = new DeviceProtocol[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static DeviceProtocol[] values() {
        return (DeviceProtocol[]) f33668a.clone();
    }

    public String getName() {
        return this.mName;
    }

    public int getValue() {
        return this.mValue;
    }

    public static DeviceProtocol valueOf(String r100) {
        return (DeviceProtocol) a.a(DeviceProtocol.class, r100);
    }

    public DeviceProtocol(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.mValue = r102;
        this.mName = r103;
    }
}
