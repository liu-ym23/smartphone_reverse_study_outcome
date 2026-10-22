package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class s extends SSettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f65403a = null;

    static {
        f65403a = new s();
    }

    public s() {
        super("live_audio_channel_name", "播通知标题", "直播", "直播", false);
    }
}
