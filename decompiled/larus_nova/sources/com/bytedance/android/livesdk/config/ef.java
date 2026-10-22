package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.AudioBgDeviceConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ef extends SettingKey<AudioBgDeviceConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ef f120120a = null;

    static {
        f120120a = new ef();
    }

    public ef() {
        super("live_audio_bg_device_config", "语音静态背景降级机型打分", AudioBgDeviceConfig.defaultConfig(), AudioBgDeviceConfig.defaultConfig());
    }
}
