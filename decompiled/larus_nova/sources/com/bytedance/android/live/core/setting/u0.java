package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class u0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u0 f65420a = null;

    static {
        f65420a = new u0();
    }

    public u0() {
        Boolean r100 = Boolean.FALSE;
        super("live_dynamic_unregister_wrds_enable", "动态化解注册wrds", r100, r100);
    }
}
