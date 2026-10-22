package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class f3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f3 f65296a = null;

    static {
        f65296a = new f3();
    }

    public f3() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_voice_chat_float_window_voice_effect_bugfix", "语音聊天室挂小窗后回到直播间声波问题修复", r100, r100);
    }
}
