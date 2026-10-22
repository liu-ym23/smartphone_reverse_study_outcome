package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class c1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1 f65269a = null;

    static {
        f65269a = new c1();
    }

    public c1() {
        boolean r100 = tb1.c.f545231c;
        super("enable_short_touch_bubble", "短触气泡开关", Boolean.valueOf(r100), Boolean.valueOf(r100));
    }
}
