package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class j6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j6 f65334a = null;

    static {
        f65334a = new j6();
    }

    public j6() {
        Boolean r100 = Boolean.TRUE;
        super("live_vs_reset_video_bottom_for_vertical", "节目直播竖版重置video_bottom", r100, r100);
    }
}
