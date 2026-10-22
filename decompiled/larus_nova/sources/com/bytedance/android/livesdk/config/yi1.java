package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.link.InteractFrequencyConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class yi1 extends SSettingKey<InteractFrequencyConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yi1 f121692a = null;

    static {
        f121692a = new yi1();
    }

    public yi1() {
        super("video_equal_switch_frequncy_config", "平权浮窗布局切换频控", new InteractFrequencyConfig(), new InteractFrequencyConfig());
    }
}
