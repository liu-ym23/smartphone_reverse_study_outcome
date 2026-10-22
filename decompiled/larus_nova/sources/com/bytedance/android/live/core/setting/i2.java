package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class i2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i2 f65322a = null;

    static {
        f65322a = new i2();
    }

    public i2() {
        Boolean r100 = Boolean.TRUE;
        super("live_load_short_touch_registe_log", "短触loadShortTouch上报", r100, r100);
    }
}
