package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class u40 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u40 f121345a = null;

    static {
        f121345a = new u40();
    }

    public u40() {
        super("live_ktv_open_camera_count_down_time", "ktv开启视频画面延迟时间（单位毫秒）", 3000L, 3000L);
    }
}
