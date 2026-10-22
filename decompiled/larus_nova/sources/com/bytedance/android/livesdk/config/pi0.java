package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.PlayerVrConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class pi0 extends SSettingKey<PlayerVrConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pi0 f120982a = null;

    static {
        f120982a = new pi0();
    }

    public pi0() {
        super("live_player_vr_config", "播放器VR配置", new PlayerVrConfig(false, false, false, false, null, false, null, 0.0f, 255, null), new PlayerVrConfig(false, false, false, false, null, false, null, 0.0f, 255, null));
    }
}
