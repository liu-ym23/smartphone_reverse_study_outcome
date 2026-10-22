package com.bytedanceos.common.toolbox;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public final enum DeviceType extends Enum<DeviceType> {
    private static final /* synthetic */ DeviceType[] $VALUES = null;
    public static final DeviceType A1 = null;
    public static final DeviceType BONO = null;
    public static final DeviceType DARWIN = null;
    public static final DeviceType DELTA = null;
    public static final DeviceType M1 = null;
    public static final DeviceType M1L = null;
    public static final DeviceType[] NEW_SELECTOR_LIST = null;
    public static final DeviceType OCEAN = null;
    public static final DeviceType ODIN = null;
    public static final DeviceType[] OLD_DEVICE_LIST = null;
    public static final DeviceType OSBORN = null;
    public static final DeviceType OSCAR = null;
    public static final DeviceType SAILOR = null;
    public static final DeviceType T1 = null;
    public static final DeviceType T2 = null;
    public static final DeviceType THIS = null;
    public static final DeviceType TRIDENT = null;
    public static final DeviceType U1 = null;
    public static final DeviceType UNKNOWN = null;

    private static /* synthetic */ DeviceType[] $values() {
        return new DeviceType[]{T1, T2, U1, M1, M1L, A1, BONO, ODIN, OSBORN, OSCAR, TRIDENT, OCEAN, DELTA, SAILOR, DARWIN, UNKNOWN};
    }

    static {
        DeviceType r10 = new DeviceType("T1", 0);
        T1 = r10;
        DeviceType r11 = new DeviceType("T2", 1);
        T2 = r11;
        DeviceType r12 = new DeviceType("U1", 2);
        U1 = r12;
        DeviceType r13 = new DeviceType("M1", 3);
        M1 = r13;
        DeviceType r14 = new DeviceType("M1L", 4);
        M1L = r14;
        DeviceType r15 = new DeviceType("A1", 5);
        A1 = r15;
        DeviceType r16 = new DeviceType("BONO", 6);
        BONO = r16;
        DeviceType r17 = new DeviceType("ODIN", 7);
        ODIN = r17;
        OSBORN = new DeviceType("OSBORN", 8);
        OSCAR = new DeviceType("OSCAR", 9);
        TRIDENT = new DeviceType("TRIDENT", 10);
        OCEAN = new DeviceType("OCEAN", 11);
        DeviceType r18 = new DeviceType("DELTA", 12);
        DELTA = r18;
        DeviceType r19 = new DeviceType("SAILOR", 13);
        SAILOR = r19;
        DeviceType r110 = new DeviceType("DARWIN", 14);
        DARWIN = r110;
        UNKNOWN = new DeviceType("UNKNOWN", 15);
        $VALUES = $values();
        THIS = getDeviceType();
        OLD_DEVICE_LIST = new DeviceType[]{r10, r11, r12, r13, r14, r15, r16, r17};
        NEW_SELECTOR_LIST = new DeviceType[]{r18, r19, r110};
    }

    private DeviceType(String r10, int r11) {
        super(r10, r11);
    }

    private static DeviceType getDeviceType() {
        String r10 = Build.BOARD.toLowerCase();
        String r11 = Build.DEVICE.toLowerCase();
        if ("msm8974".equals(r10) == false) goto L6;
        return T1;
    L6:
        if ("msm8916".equals(r10) == false) goto L9;
        return U1;
    L9:
        if ("msm8992".equals(r10) == false) goto L12;
        return T2;
    L12:
        if ("msm8996".equals(r10) == false) goto L18;
        if ("colombo".equals(r11) == false) goto L65;
        return M1L;
    L65:
        return M1;
    L18:
        if ("msm8952".equals(r10) == false) goto L21;
        return A1;
    L21:
        if ("mt6797".equals(r10) == true) goto L60;
        if ("s10".equals(r11) == true) goto L60;
        if (r11.contains("oscar") == false) goto L29;
        return OSCAR;
    L29:
        if (r11.contains("ocean") == false) goto L32;
        return OCEAN;
    L32:
        if ("sdm660".equals(r10) == true) goto L75;
        if ("osborn".equals(r11) == true) goto L75;
        if ("msm8953".equals(r10) == true) goto L74;
        if ("odin".equals(r11) == true) goto L74;
        if ("trident".equals(r11) == true) goto L73;
        if ("trident_cmel".equals(r11) == true) goto L73;
        if (r11.contains("delta") == false) goto L50;
        return DELTA;
    L50:
        if (r11.contains("atoll") == false) goto L53;
        return SAILOR;
    L53:
        if (r11.contains("darwin") == false) goto L72;
        return DARWIN;
    L72:
        return UNKNOWN;
    L73:
        return TRIDENT;
    L74:
        return ODIN;
    L75:
        return OSBORN;
    L60:
        return BONO;
    }

    public static boolean is(DeviceType r10) {
        if (THIS != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isNewSelectorStyle() {
        DeviceType[] r10 = NEW_SELECTOR_LIST;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (is(r10[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean isOldDeviceType() {
        DeviceType[] r10 = OLD_DEVICE_LIST;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (is(r10[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean isOneOf(DeviceType... r10) {
        if (r10 != null) goto L5;
    L14:
        return false;
    L5:
        if (r10.length == 0) goto L14;
        int r11 = r10.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L14;
        if (is(r10[r12]) == true) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        return true;
    }

    public static DeviceType valueOf(String r10) {
        return (DeviceType) Enum.valueOf(DeviceType.class, r10);
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }
}
