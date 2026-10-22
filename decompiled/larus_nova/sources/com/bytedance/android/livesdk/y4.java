package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class y4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y4 f162548a = null;

    static {
        f162548a = new y4();
    }

    public y4() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_audio_theme_opt", "是否开启语音背景图优化", r100, r100);
    }
}
