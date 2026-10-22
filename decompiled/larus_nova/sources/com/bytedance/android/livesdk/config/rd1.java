package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.PlayerInnerDrawerConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class rd1 extends SSettingKey<PlayerInnerDrawerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rd1 f121124a = null;

    static {
        f121124a = new rd1();
    }

    public rd1() {
        super("live_inner_draw_player_config", "内流播放器配置", new PlayerInnerDrawerConfig(false, false, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, false, false, false, false, false, false, 8388607, null), new PlayerInnerDrawerConfig(false, false, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, false, false, false, false, false, false, 8388607, null));
    }
}
