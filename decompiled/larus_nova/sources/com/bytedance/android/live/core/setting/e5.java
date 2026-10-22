package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class e5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e5 f65290a = null;

    static {
        f65290a = new e5();
    }

    public e5() {
        Boolean r100 = Boolean.TRUE;
        super("live_short_touch_insert_control", "短触区管控能力开关", r100, r100);
    }
}
