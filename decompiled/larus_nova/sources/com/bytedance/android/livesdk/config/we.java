package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class we extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final we f121517a = null;

    static {
        f121517a = new we();
    }

    public we() {
        Boolean r100 = Boolean.TRUE;
        super("live_audience_mini_app_commerce_both_existed", "小程序和购物车共存观众侧开关", r100, r100);
    }
}
