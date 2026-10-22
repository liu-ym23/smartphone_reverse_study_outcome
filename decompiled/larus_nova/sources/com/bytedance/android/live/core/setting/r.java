package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class r extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f65395a = null;

    static {
        f65395a = new r();
    }

    public r() {
        Boolean r100 = Boolean.TRUE;
        super("live_background_notification_enable", "语音直播后台播放通知开关", r100, r100);
    }
}
