package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class x2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x2 f162535a = null;

    static {
        f162535a = new x2();
    }

    public x2() {
        Boolean r100 = Boolean.TRUE;
        super("live_share_in_more_panel_mode_change_more_icon", "是否允许更换更多按钮icon", r100, r100);
    }
}
