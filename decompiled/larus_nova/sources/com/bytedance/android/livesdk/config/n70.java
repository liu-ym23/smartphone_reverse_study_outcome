package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class n70 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n70 f120811a = null;

    static {
        f120811a = new n70();
    }

    public n70() {
        Boolean r100 = Boolean.FALSE;
        super("live_long_press_panel_dou_plus_enable", "长按面板抖+入口", r100, r100);
    }
}
