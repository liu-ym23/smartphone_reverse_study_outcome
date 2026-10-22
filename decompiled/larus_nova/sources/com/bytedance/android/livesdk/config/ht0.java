package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.depend.model.LiveStartRoomOptConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ht0 extends SSettingKey<LiveStartRoomOptConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ht0 f120403a = null;

    static {
        f120403a = new ht0();
    }

    public ht0() {
        super("live_start_room_opt_switch", "直播秒开开关", new LiveStartRoomOptConfig(), new LiveStartRoomOptConfig());
    }
}
