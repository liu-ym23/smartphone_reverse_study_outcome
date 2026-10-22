package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class mi extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mi f120757a = null;

    static {
        f120757a = new mi();
    }

    public mi() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_stream_pause_bg_opt", "直播暂停背景图优化", r100, r100);
    }
}
