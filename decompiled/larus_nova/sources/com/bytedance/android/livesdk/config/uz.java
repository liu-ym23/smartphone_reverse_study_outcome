package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletAvatarMockConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class uz extends SSettingKey<HamletAvatarMockConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uz f121411a = null;

    static {
        f121411a = new uz();
    }

    public uz() {
        super("live_hamlet_avatar_mock_config", "hamlet avatat mock参数配置", new HamletAvatarMockConfig(), new HamletAvatarMockConfig());
    }
}
