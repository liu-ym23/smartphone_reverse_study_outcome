package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class a2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f65204a = null;

    static {
        f65204a = new a2();
    }

    public a2() {
        Boolean r100 = Boolean.FALSE;
        super("live_interact_audio_capture_background_anchor", "主播侧退后台是否采集音频", r100, r100);
    }
}
