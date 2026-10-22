package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class z extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f162557a = null;

    static {
        f162557a = new z();
    }

    public z() {
        Boolean r100 = Boolean.FALSE;
        super("live_broadcast_live_require_permission_route_out_enable", "主播侧直播间内-跳转抖音外部增加海关流量上报", r100, r100);
    }
}
