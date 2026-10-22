package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class p3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p3 f65382a = null;

    static {
        f65382a = new p3();
    }

    public p3() {
        super("live_pc_customize_audio_room_forbid_audio_background", Boolean.TRUE, "PC自定义语音直播间禁用语音背景");
    }
}
