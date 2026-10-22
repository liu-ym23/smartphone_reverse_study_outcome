package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LivePlayerSmoothEnterRoomConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class li0 extends SSettingKey<LivePlayerSmoothEnterRoomConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final li0 f120682a = null;

    static {
        li0 r100 = new li0();
        f120682a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public li0() {
        super("live_player_smooth_enter_room", "多人场景预览流播放器平滑进房优化", new LivePlayerSmoothEnterRoomConfig(), new LivePlayerSmoothEnterRoomConfig());
    }
}
