package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class j extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f65327a = null;

    static {
        f65327a = new j();
    }

    public j() {
        Boolean r100 = Boolean.TRUE;
        super("live_add_first_screen_log", "添加首屏埋点", r100, r100, false);
    }
}
