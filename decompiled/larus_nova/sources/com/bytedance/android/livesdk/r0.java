package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveGameUniversalLayoutConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class r0 extends SettingKey<LiveGameUniversalLayoutConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f156921a = null;

    static {
        f156921a = new r0();
    }

    public r0() {
        super("live_game_universal_layout_config", "游戏多视图通用布局配置", new LiveGameUniversalLayoutConfig(null, null, 0.0f, false, false, false, 63, null), new LiveGameUniversalLayoutConfig(null, null, 0.0f, false, false, false, 63, null));
    }
}
