package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.WormholeConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ez0 extends SSettingKey<WormholeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ez0 f120165a = null;

    static {
        ez0 r100 = new ez0();
        f120165a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public ez0() {
        super("live_wormhole_config", "直播wormhole配置", new WormholeConfig(), new WormholeConfig());
    }
}
