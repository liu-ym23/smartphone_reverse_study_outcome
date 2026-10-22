package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class e3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e3 f65288a = null;

    static {
        f65288a = new e3();
    }

    public e3() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_status_bar_visible_change_adjust_player", "状态栏可见性变化时调整播放器大小", r100, r100);
    }
}
