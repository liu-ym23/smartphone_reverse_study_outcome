package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveRTChorusSpatialAudioConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class g6 extends SSettingKey<LiveRTChorusSpatialAudioConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g6 f125383a = null;

    static {
        f125383a = new g6();
    }

    public g6() {
        super("live_ktv_rt_chorus_spatial_audio_config", "合唱派对空间音频布局信息", new LiveRTChorusSpatialAudioConfig(), new LiveRTChorusSpatialAudioConfig());
    }
}
