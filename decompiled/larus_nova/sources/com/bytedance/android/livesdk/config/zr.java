package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class zr extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zr f121786a = null;

    static {
        f121786a = new zr();
    }

    public zr() {
        super("live_enable_interact_aspect_ratio_layout_opt", "小玩法观众端游戏画面布局优化", Boolean.FALSE, Boolean.TRUE, true);
    }
}
