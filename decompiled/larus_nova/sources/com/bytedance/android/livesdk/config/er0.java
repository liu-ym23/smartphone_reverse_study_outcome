package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class er0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final er0 f120149a = null;

    static {
        f120149a = new er0();
    }

    public er0() {
        Boolean r100 = Boolean.TRUE;
        super("live_secret_shield_enabled", "RechargeScreenShield是否开启防截屏功能", r100, r100);
    }
}
