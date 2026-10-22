package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveServerBlurBgConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class lr0 extends SSettingKey<LiveServerBlurBgConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lr0 f120703a = null;

    static {
        lr0 r100 = new lr0();
        f120703a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public lr0() {
        super("live_server_blur_bg_opt", "Server高斯模糊背景优化", new LiveServerBlurBgConfig(), new LiveServerBlurBgConfig());
    }
}
