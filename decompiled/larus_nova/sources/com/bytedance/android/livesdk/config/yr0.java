package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class yr0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yr0 f121711a = null;

    static {
        f121711a = new yr0();
    }

    public yr0() {
        Boolean r100 = Boolean.TRUE;
        super("live_share_to_daily_convert_error_value_enable", "检查异常值", r100, r100);
    }
}
