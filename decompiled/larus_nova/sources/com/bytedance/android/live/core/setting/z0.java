package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class z0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f65467a = null;

    static {
        f65467a = new z0();
    }

    public z0() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_lazy_constant", "datacontext contants 懒加载", r100, r100, true);
    }
}
