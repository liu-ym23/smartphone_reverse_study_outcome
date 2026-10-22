package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class b0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f104229a = null;

    static {
        f104229a = new b0();
    }

    public b0() {
        Boolean r100 = Boolean.TRUE;
        super("live_chat_channel_text_blur_enable", "频道指示器blur效果开关", r100, r100);
    }
}
