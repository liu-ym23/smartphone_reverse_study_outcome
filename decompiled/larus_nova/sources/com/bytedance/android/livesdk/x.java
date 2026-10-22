package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LiveAudioFadeOptConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class x extends SSettingKey<LiveAudioFadeOptConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f162532a = null;

    static {
        f162532a = new x();
    }

    public x() {
        super("live_audio_fader_opt_config", "直播音频淡入淡出实验配置", new LiveAudioFadeOptConfig(false, 0.0f, 0.0f, 0, false, null, 63, null), new LiveAudioFadeOptConfig(false, 0.0f, 0.0f, 0, false, null, 63, null));
    }
}
