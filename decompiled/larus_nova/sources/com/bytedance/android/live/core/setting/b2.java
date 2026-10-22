package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class b2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b2 f65217a = null;

    static {
        f65217a = new b2();
    }

    public b2() {
        Boolean r100 = Boolean.FALSE;
        super("live_interact_audio_capture_background_guest", "嘉宾侧退后台是否采集音频", r100, r100);
    }
}
