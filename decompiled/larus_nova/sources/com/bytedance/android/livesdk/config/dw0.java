package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class dw0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dw0 f120069a = null;

    static {
        f120069a = new dw0();
    }

    public dw0() {
        Boolean r100 = Boolean.TRUE;
        super("live_usercenter_monitor_hostuser", "是否监控UserCenter hostUser为null", r100, r100);
    }
}
