package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class bi0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bi0 f119871a = null;

    static {
        f119871a = new bi0();
    }

    public bi0() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_layout_screen_size", "播放器布局优化_传入宽高", r100, r100);
    }
}
