package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class t0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f65412a = null;

    static {
        f65412a = new t0();
    }

    public t0() {
        Boolean r100 = Boolean.FALSE;
        super("live_dynamic_unregister_message_enable", "动态化解注册message", r100, r100);
    }
}
