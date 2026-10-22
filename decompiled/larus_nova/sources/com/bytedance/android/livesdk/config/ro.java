package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameDisplayRatioConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ro extends SSettingKey<GameDisplayRatioConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ro f121146a = null;

    static {
        f121146a = new ro();
    }

    public ro() {
        super("live_display_ratio_audience_config", "开播画面比例设置观众端配置", new GameDisplayRatioConfig(), new GameDisplayRatioConfig());
    }
}
