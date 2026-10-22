package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lt extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lt f120706a = null;

    static {
        f120706a = new lt();
    }

    public lt() {
        super("live_enable_ve_camera2", Boolean.FALSE, "直播是否开启VE camera2 采集");
    }
}
