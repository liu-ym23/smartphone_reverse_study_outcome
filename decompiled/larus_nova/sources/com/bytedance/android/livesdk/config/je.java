package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveAppLoggerConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class je extends SSettingKey<LiveAppLoggerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final je f120518a = null;

    static {
        f120518a = new je();
    }

    public je() {
        super("live_applogger_config", "直播埋点上报配置", new LiveAppLoggerConfig(), new LiveAppLoggerConfig());
    }
}
