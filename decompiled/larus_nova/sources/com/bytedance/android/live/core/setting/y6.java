package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.PlayerInnerDrawerConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class y6 extends SSettingKey<PlayerInnerDrawerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y6 f65465a = null;

    static {
        f65465a = new y6();
    }

    public y6() {
        super("live_inner_draw_player_config", "内流播放器配置", new PlayerInnerDrawerConfig(false, false, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, false, false, false, false, false, false, 8388607, null), new PlayerInnerDrawerConfig(false, false, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, false, false, false, false, false, false, 8388607, null));
    }
}
