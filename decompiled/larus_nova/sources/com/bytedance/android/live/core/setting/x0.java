package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class x0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f65451a = null;

    static {
        f65451a = new x0();
    }

    public x0() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_activity_tea_monitor", "允许活动区 tea 上报", r100, r100);
    }
}
