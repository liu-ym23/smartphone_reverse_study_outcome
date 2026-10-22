package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveReuseStreamAdaptLandScapeConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class li extends SSettingKey<LiveReuseStreamAdaptLandScapeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final li f120681a = null;

    static {
        f120681a = new li();
    }

    public li() {
        super("live_broadcast_start_reuse_stream_horization", "音画链路复用兼容横屏竖开", new LiveReuseStreamAdaptLandScapeConfig(), new LiveReuseStreamAdaptLandScapeConfig());
    }
}
