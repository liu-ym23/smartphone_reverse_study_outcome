package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.AnchorVStreamPerfConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class im extends SSettingKey<AnchorVStreamPerfConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final im f120464a = null;

    static {
        f120464a = new im();
    }

    public im() {
        super("live_anchor_video_stream_monitor", "LiveCore性能回调", new AnchorVStreamPerfConfig(), new AnchorVStreamPerfConfig(), true);
    }
}
