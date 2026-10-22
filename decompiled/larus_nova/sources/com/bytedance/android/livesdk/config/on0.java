package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveRoomAPMConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class on0 extends SSettingKey<LiveRoomAPMConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final on0 f120919a = null;

    static {
        f120919a = new on0();
    }

    public on0() {
        super("live_room_apm_setting_config", "直播间诊断APM", new LiveRoomAPMConfig(), new LiveRoomAPMConfig());
    }
}
