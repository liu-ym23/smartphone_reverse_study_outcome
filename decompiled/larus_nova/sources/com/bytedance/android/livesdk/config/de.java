package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.ai.config.LiveDetectionConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class de extends SSettingKey<LiveDetectionConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final de f120025a = null;

    static {
        f120025a = new de();
    }

    public de() {
        super("live_detection_setting", LiveDetectionConfig.class, "直播客户端异常实时检测配置", new LiveDetectionConfig(), new LiveDetectionConfig());
    }
}
