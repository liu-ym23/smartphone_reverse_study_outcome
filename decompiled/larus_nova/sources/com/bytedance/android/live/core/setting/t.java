package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class t extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f65411a = null;

    static {
        f65411a = new t();
    }

    public t() {
        Boolean r100 = Boolean.TRUE;
        super("live_audio_chat_room_zero_link_opt", "语音聊天室0连加入RTC改造", r100, r100);
    }
}
