package com.bytedance.apm.launch;

/* JADX INFO: loaded from: classes2.dex */
public final enum DefaultLaunchMode extends Enum<DefaultLaunchMode> {
    private static final /* synthetic */ DefaultLaunchMode[] $VALUES = null;
    public static final DefaultLaunchMode CLOD_LAUNCH = null;
    public static final DefaultLaunchMode HOT_LAUNCH = null;
    public static final DefaultLaunchMode UNKNOWN_LAUNCH = null;
    public static final DefaultLaunchMode WARM_LAUNCH = null;

    private DefaultLaunchMode(String r1, int r2) {
        super(r1, r2);
    }

    public static DefaultLaunchMode valueOf(String r1) {
        return (DefaultLaunchMode) Enum.valueOf(DefaultLaunchMode.class, r1);
    }

    public static DefaultLaunchMode[] values() {
        return (DefaultLaunchMode[]) $VALUES.clone();
    }

    static {
        DefaultLaunchMode r0 = new DefaultLaunchMode("UNKNOWN_LAUNCH", 0);
        UNKNOWN_LAUNCH = r0;
        DefaultLaunchMode r1 = new DefaultLaunchMode("CLOD_LAUNCH", 1);
        CLOD_LAUNCH = r1;
        DefaultLaunchMode r3 = new DefaultLaunchMode("WARM_LAUNCH", 2);
        WARM_LAUNCH = r3;
        DefaultLaunchMode r5 = new DefaultLaunchMode("HOT_LAUNCH", 3);
        HOT_LAUNCH = r5;
        $VALUES = new DefaultLaunchMode[]{r0, r1, r3, r5};
    }
}
