package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class qa extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qa f121038a = null;

    static {
        f121038a = new qa();
    }

    public qa() {
        Boolean r100 = Boolean.FALSE;
        super("live_anchor_accessibility_bugfix_in_hudong_enable", "主播侧无障碍模式bugfix卡关", r100, r100, true);
    }
}
