package com.bytedance.apm.launch;

import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final enum DefaultLaunchMode extends Enum<DefaultLaunchMode> {
    public static final DefaultLaunchMode CLOD_LAUNCH = null;
    public static final DefaultLaunchMode HOT_LAUNCH = null;
    public static final DefaultLaunchMode UNKNOWN_LAUNCH = null;
    public static final DefaultLaunchMode WARM_LAUNCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DefaultLaunchMode[] f190614a = null;

    static {
        DefaultLaunchMode r100 = new DefaultLaunchMode("UNKNOWN_LAUNCH", 0);
        UNKNOWN_LAUNCH = r100;
        DefaultLaunchMode r101 = new DefaultLaunchMode("CLOD_LAUNCH", 1);
        CLOD_LAUNCH = r101;
        DefaultLaunchMode r102 = new DefaultLaunchMode("WARM_LAUNCH", 2);
        WARM_LAUNCH = r102;
        DefaultLaunchMode r103 = new DefaultLaunchMode("HOT_LAUNCH", 3);
        HOT_LAUNCH = r103;
        f190614a = new DefaultLaunchMode[]{r100, r101, r102, r103};
    }

    public static DefaultLaunchMode[] values() {
        return (DefaultLaunchMode[]) f190614a.clone();
    }

    public static DefaultLaunchMode valueOf(String r100) {
        return (DefaultLaunchMode) a.a(DefaultLaunchMode.class, r100);
    }

    public DefaultLaunchMode(String r100, int r101) {
        super(r100, r101);
    }
}
