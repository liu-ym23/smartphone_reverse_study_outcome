package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class b5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b5 f104234a = null;

    static {
        f104234a = new b5();
    }

    public b5() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_rtc_test_env", "是否开启RTC测试环境", r100, r100);
    }
}
