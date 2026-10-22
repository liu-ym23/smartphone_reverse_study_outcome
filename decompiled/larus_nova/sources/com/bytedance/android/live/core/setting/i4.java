package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class i4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i4 f65324a = null;

    static {
        f65324a = new i4();
    }

    public i4() {
        Boolean r100 = Boolean.FALSE;
        super("live_resource_balance_switch_outter_performance", "资源平衡框架外部性能感知开关", r100, r100);
    }
}
