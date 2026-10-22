package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class z0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f162558a = null;

    static {
        f162558a = new z0();
    }

    public z0() {
        super("live_jsb_force_portrait_pad", Boolean.FALSE, "JSB的pad强制竖屏开关");
    }
}
