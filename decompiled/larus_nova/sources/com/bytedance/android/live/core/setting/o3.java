package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class o3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o3 f65374a = null;

    static {
        f65374a = new o3();
    }

    public o3() {
        Boolean r100 = Boolean.TRUE;
        super("live_opus_ktv_opt", "竖屏ktv性能优化", r100, r100);
    }
}
