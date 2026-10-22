package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class zh0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zh0 f121766a = null;

    static {
        f121766a = new zh0();
    }

    public zh0() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_layout_orientation_opt", "播放器布局优化_传入方向", r100, r100);
    }
}
