package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class di0 extends SSettingKey<PlayerOptimizeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final di0 f120035a = null;

    static {
        di0 r100 = new di0();
        f120035a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public di0() {
        super("live_player_optimize_config", "播放器性能优化配置", new PlayerOptimizeConfig(), new PlayerOptimizeConfig());
    }
}
