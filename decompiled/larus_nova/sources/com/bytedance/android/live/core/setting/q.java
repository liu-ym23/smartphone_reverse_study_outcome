package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class q extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f65387a = null;

    static {
        f65387a = new q();
    }

    public q() {
        Boolean r100 = Boolean.TRUE;
        super("live_audio_and_video_permission_test_enable", "音视频权限自动化测试环境上报", r100, r100);
    }
}
