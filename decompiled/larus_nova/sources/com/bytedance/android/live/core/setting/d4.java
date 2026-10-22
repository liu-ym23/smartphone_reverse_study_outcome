package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.RealTimePlaybackConfig;
import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class d4 extends SSettingKey<RealTimePlaybackConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d4 f65281a = null;

    static {
        f65281a = new d4();
    }

    public d4() {
        super("live_real_time_playback_config", "普通直播间实时回放功能配置", new RealTimePlaybackConfig(), new RealTimePlaybackConfig());
    }
}
