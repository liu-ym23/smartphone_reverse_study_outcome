package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fn extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fn f120217a = null;

    static {
        f120217a = new fn();
    }

    public fn() {
        Boolean r100 = Boolean.FALSE;
        super("live_detail_surfaceview", "混滑容器支持surfaceview", r100, r100, new String[]{"true:使用surfaceview", "false:不使用surfaceview"});
    }
}
