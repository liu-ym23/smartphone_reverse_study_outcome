package com.bytedance.platform.godzilla.plugin;

/* JADX INFO: loaded from: classes2.dex */
public final enum StartType extends Enum<StartType> {
    private static final /* synthetic */ StartType[] $VALUES = null;
    public static final StartType IMMEDIATE = null;
    public static final StartType REGISTER_EXCEPTION = null;

    private StartType(String r1, int r2) {
        super(r1, r2);
    }

    public static StartType valueOf(String r1) {
        return (StartType) Enum.valueOf(StartType.class, r1);
    }

    public static StartType[] values() {
        return (StartType[]) $VALUES.clone();
    }

    static {
        StartType r0 = new StartType("IMMEDIATE", 0);
        IMMEDIATE = r0;
        StartType r1 = new StartType("REGISTER_EXCEPTION", 1);
        REGISTER_EXCEPTION = r1;
        $VALUES = new StartType[]{r0, r1};
    }
}
