package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class w extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f65442a = null;

    static {
        f65442a = new w();
    }

    public w() {
        Boolean r100 = Boolean.TRUE;
        super("live_audio_opt_channel_name", "是否开启优化直播通知标题", r100, r100, false);
    }
}
