package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f65284a = null;

    static {
        f65284a = new e();
    }

    public e() {
        Boolean r100 = Boolean.FALSE;
        super("first_screen_debug_info", "直播间内首屏信息(调试用)", r100, r100);
    }
}
