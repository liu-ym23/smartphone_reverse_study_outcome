package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class h4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h4 f65315a = null;

    static {
        f65315a = new h4();
    }

    public h4() {
        Boolean r100 = Boolean.FALSE;
        super("live_resource_balance_switch_battery", "资源平衡框架低电量开关", r100, r100);
    }
}
