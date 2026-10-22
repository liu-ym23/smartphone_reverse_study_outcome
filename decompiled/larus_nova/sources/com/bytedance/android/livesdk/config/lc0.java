package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.PlayModeEnterInfoConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class lc0 extends SettingKey<PlayModeEnterInfoConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lc0 f120668a = null;

    static {
        lc0 r100 = new lc0();
        f120668a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public lc0() {
        PlayModeEnterInfoConfig.Companion r100 = PlayModeEnterInfoConfig.Companion;
        super("live_multi_scene_play_mode_from_enter_info", "多人场景玩法信息提前获取", r100.defaultConfig(), r100.defaultConfig());
    }
}
