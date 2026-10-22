package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LiveAudioSubtitleSetting;

/* JADX INFO: loaded from: classes45.dex */
public final class x extends SSettingKey<LiveAudioSubtitleSetting> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f65450a = null;

    static {
        f65450a = new x();
    }

    public x() {
        super("live_audio_subtitle_setting", "语音聊天室实时字幕开关", new LiveAudioSubtitleSetting(), new LiveAudioSubtitleSetting());
    }
}
