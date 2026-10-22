package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class v1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v1 f65429a = null;

    static {
        f65429a = new v1();
    }

    public v1() {
        Boolean r100 = Boolean.TRUE;
        super("live_guest_battle_start_panel_to_lynx", "大作战开启面板打开动作迁移到Lynx", r100, r100);
    }
}
