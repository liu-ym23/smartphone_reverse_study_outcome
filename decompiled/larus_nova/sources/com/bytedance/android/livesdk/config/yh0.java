package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class yh0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yh0 f121689a = null;

    static {
        f121689a = new yh0();
    }

    public yh0() {
        Boolean r100 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_PLAYER_LAYOUT_OPT_V1, "播放器布局逻辑优化", r100, r100);
    }
}
