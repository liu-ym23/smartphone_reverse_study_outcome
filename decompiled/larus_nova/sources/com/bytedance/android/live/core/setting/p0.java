package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class p0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f65379a = null;

    static {
        f65379a = new p0();
    }

    public p0() {
        Boolean r100 = Boolean.FALSE;
        super("live_dynamic_opt_anniex_enable", "直播短触区切换AnnieX极简卡开关", r100, r100);
    }
}
