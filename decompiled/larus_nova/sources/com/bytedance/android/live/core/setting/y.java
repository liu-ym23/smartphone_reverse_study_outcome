package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class y extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f65458a = null;

    static {
        f65458a = new y();
    }

    public y() {
        Boolean r100 = Boolean.TRUE;
        super("live_audio_subtitle_setting_reget", "语音聊天室实时字幕开关重新获取一次", r100, r100);
    }
}
