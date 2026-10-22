package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class v extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f65427a = null;

    public v() {
        super("live_audio_foreground_service_type_opt", "优化AudioLiveService的ANR", 0, 2);
    }

    static {
        f65427a = new v();
    }
}
