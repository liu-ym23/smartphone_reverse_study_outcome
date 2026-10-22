package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.log.ALoggerConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class oa extends SSettingKey<ALoggerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final oa f120887a = null;

    static {
        f120887a = new oa();
    }

    public oa() {
        super("live_alogger_config", "直播日志打印配置", new ALoggerConfig(), new ALoggerConfig());
    }
}
