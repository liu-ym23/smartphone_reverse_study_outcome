package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.AdaptiveGradingConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class t9 extends SSettingKey<AdaptiveGradingConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t9 f121279a = null;

    static {
        f121279a = new t9();
    }

    public t9() {
        super("live_adaptive_grading_config", "智能图像增强配置", new AdaptiveGradingConfig(), new AdaptiveGradingConfig());
    }
}
