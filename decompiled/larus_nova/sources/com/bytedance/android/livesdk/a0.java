package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class a0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f102991a = null;

    static {
        f102991a = new a0();
    }

    public a0() {
        Boolean r100 = Boolean.FALSE;
        super("live_broadcast_start_page_require_permission_route_out_enable", "主播侧开播页-跳转抖音外部增加海关流量上报", r100, r100);
    }
}
