package com.bytedance.apm.launch;

/* JADX INFO: loaded from: classes.dex */
public final enum DefaultLaunchMode extends Enum<DefaultLaunchMode> {
    private static final /* synthetic */ DefaultLaunchMode[] $VALUES = null;
    public static final DefaultLaunchMode CLOD_LAUNCH = null;
    public static final DefaultLaunchMode HOT_LAUNCH = null;
    public static final DefaultLaunchMode UNKNOWN_LAUNCH = null;
    public static final DefaultLaunchMode WARM_LAUNCH = null;

    static {
        DefaultLaunchMode r10 = new DefaultLaunchMode("UNKNOWN_LAUNCH", 0);
        UNKNOWN_LAUNCH = r10;
        DefaultLaunchMode r11 = new DefaultLaunchMode("CLOD_LAUNCH", 1);
        CLOD_LAUNCH = r11;
        DefaultLaunchMode r12 = new DefaultLaunchMode("WARM_LAUNCH", 2);
        WARM_LAUNCH = r12;
        DefaultLaunchMode r13 = new DefaultLaunchMode("HOT_LAUNCH", 3);
        HOT_LAUNCH = r13;
        $VALUES = new DefaultLaunchMode[]{r10, r11, r12, r13};
    }

    private DefaultLaunchMode(String r10, int r11) {
        super(r10, r11);
    }

    public static DefaultLaunchMode valueOf(String r10) {
        return (DefaultLaunchMode) Enum.valueOf(DefaultLaunchMode.class, r10);
    }

    public static DefaultLaunchMode[] values() {
        return (DefaultLaunchMode[]) $VALUES.clone();
    }
}
