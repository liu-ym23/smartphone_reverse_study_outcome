package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class df extends SSettingKey<PrivacyConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final df f120027a = null;

    static {
        f120027a = new df();
    }

    public df() {
        super(LiveInitSettingKeys.LIVE_AUDIO_AND_VIDEO_PRIVACY_CONFIG, "音视频隐私开关", new PrivacyConfig(), new PrivacyConfig());
    }
}
