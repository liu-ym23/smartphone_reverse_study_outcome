package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class o2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o2 f65373a = null;

    static {
        f65373a = new o2();
    }

    public o2() {
        Boolean r100 = Boolean.TRUE;
        super("live_mob_inject_pad_global_params", "是否给直播埋点注入pad全局参数", r100, r100);
    }
}
