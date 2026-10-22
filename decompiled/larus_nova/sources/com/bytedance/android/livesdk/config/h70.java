package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveLogFlushConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class h70 extends SSettingKey<LiveLogFlushConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h70 f120345a = null;

    static {
        f120345a = new h70();
    }

    public h70() {
        super("live_log_flush_config", "直播实时埋点flush方案", new LiveLogFlushConfig(), new LiveLogFlushConfig());
    }
}
