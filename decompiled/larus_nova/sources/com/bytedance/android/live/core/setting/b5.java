package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class b5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b5 f65220a = null;

    static {
        f65220a = new b5();
    }

    public b5() {
        Boolean r100 = Boolean.FALSE;
        super("live_short_touch_accessibility", "短触图标无障碍开关", r100, r100);
    }
}
