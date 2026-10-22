package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class v4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v4 f65439a = null;

    static {
        f65439a = new v4();
    }

    public v4() {
        super("live_room_top_right_banner_style_switch", "直播间顶部右侧banner样式开关", Boolean.FALSE, Boolean.TRUE);
    }
}
