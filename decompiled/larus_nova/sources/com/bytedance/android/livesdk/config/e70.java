package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class e70 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e70 f120093a = null;

    static {
        f120093a = new e70();
    }

    public e70() {
        Boolean r100 = Boolean.TRUE;
        super("live_logout_reset_user_attr", "退出登录是否重置user attr", r100, r100);
    }
}
