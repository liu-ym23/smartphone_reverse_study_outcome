package com.bytedance.platform.godzilla.plugin;

/* JADX INFO: loaded from: classes.dex */
public final enum StartType extends Enum<StartType> {
    private static final /* synthetic */ StartType[] $VALUES = null;
    public static final StartType IMMEDIATE = null;
    public static final StartType REGISTER_EXCEPTION = null;

    static {
        StartType r10 = new StartType("IMMEDIATE", 0);
        IMMEDIATE = r10;
        StartType r11 = new StartType("REGISTER_EXCEPTION", 1);
        REGISTER_EXCEPTION = r11;
        $VALUES = new StartType[]{r10, r11};
    }

    private StartType(String r10, int r11) {
        super(r10, r11);
    }

    public static StartType valueOf(String r10) {
        return (StartType) Enum.valueOf(StartType.class, r10);
    }

    public static StartType[] values() {
        return (StartType[]) $VALUES.clone();
    }
}
