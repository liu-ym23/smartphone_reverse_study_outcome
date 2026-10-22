package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
public final enum Priority extends Enum<Priority> {
    private static final /* synthetic */ Priority[] $VALUES = null;
    public static final Priority HIGH = null;
    public static final Priority IMMEDIATE = null;
    public static final Priority LOW = null;
    public static final Priority NORMAL = null;

    static {
        Priority r10 = new Priority("IMMEDIATE", 0);
        IMMEDIATE = r10;
        Priority r11 = new Priority("HIGH", 1);
        HIGH = r11;
        Priority r12 = new Priority("NORMAL", 2);
        NORMAL = r12;
        Priority r13 = new Priority("LOW", 3);
        LOW = r13;
        $VALUES = new Priority[]{r10, r11, r12, r13};
    }

    private Priority(String r10, int r11) {
        super(r10, r11);
    }

    public static Priority valueOf(String r10) {
        return (Priority) Enum.valueOf(Priority.class, r10);
    }

    public static Priority[] values() {
        return (Priority[]) $VALUES.clone();
    }
}
