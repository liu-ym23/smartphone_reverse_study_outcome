package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveEndRoomConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class p0 extends SettingKey<LiveEndRoomConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f154188a = null;

    static {
        f154188a = new p0();
    }

    public p0() {
        super("live_end_room_config", "头像退房优化", new LiveEndRoomConfig(), new LiveEndRoomConfig());
    }
}
