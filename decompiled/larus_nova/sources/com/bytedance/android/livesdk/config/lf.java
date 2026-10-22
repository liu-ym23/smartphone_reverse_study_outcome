package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.AudioRadioChatPanelConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class lf extends SSettingKey<AudioRadioChatPanelConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lf f120674a = null;

    static {
        f120674a = new lf();
    }

    public lf() {
        super("live_audio_radio_chat_panel_config", "电台连线面板配置", new AudioRadioChatPanelConfig(), new AudioRadioChatPanelConfig());
    }
}
