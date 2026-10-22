package com.blankj.utilcode.util;

/* JADX INFO: loaded from: classes.dex */
public final enum BusUtils$ThreadMode extends Enum<BusUtils$ThreadMode> {
    private static final /* synthetic */ BusUtils$ThreadMode[] $VALUES = null;
    public static final BusUtils$ThreadMode CACHED = null;
    public static final BusUtils$ThreadMode CPU = null;
    public static final BusUtils$ThreadMode IO = null;
    public static final BusUtils$ThreadMode MAIN = null;
    public static final BusUtils$ThreadMode POSTING = null;
    public static final BusUtils$ThreadMode SINGLE = null;

    static {
        BusUtils$ThreadMode r10 = new BusUtils$ThreadMode("MAIN", 0);
        MAIN = r10;
        BusUtils$ThreadMode r11 = new BusUtils$ThreadMode("IO", 1);
        IO = r11;
        BusUtils$ThreadMode r12 = new BusUtils$ThreadMode("CPU", 2);
        CPU = r12;
        BusUtils$ThreadMode r13 = new BusUtils$ThreadMode("CACHED", 3);
        CACHED = r13;
        BusUtils$ThreadMode r14 = new BusUtils$ThreadMode("SINGLE", 4);
        SINGLE = r14;
        BusUtils$ThreadMode r15 = new BusUtils$ThreadMode("POSTING", 5);
        POSTING = r15;
        $VALUES = new BusUtils$ThreadMode[]{r10, r11, r12, r13, r14, r15};
    }

    private BusUtils$ThreadMode(String r10, int r11) {
        super(r10, r11);
    }

    public static BusUtils$ThreadMode valueOf(String r10) {
        return (BusUtils$ThreadMode) Enum.valueOf(BusUtils$ThreadMode.class, r10);
    }

    public static BusUtils$ThreadMode[] values() {
        return (BusUtils$ThreadMode[]) $VALUES.clone();
    }
}
