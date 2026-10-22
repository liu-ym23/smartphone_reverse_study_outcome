package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.WindowFpsConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class fg extends SSettingKey<WindowFpsConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fg f120200a = null;

    static {
        f120200a = new fg();
    }

    public fg() {
        super("live_base_window_fps_opt", "直播base window帧率优化", new WindowFpsConfig(), new WindowFpsConfig());
    }
}
