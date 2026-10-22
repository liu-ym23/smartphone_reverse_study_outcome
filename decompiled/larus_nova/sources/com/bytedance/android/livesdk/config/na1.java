package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.AVMonitorLogConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class na1 extends SSettingKey<AVMonitorLogConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final na1 f120817a = null;

    static {
        f120817a = new na1();
    }

    public na1() {
        super("multi_link_av_monitor_log_config", "多人场景音频链路埋点配置", new AVMonitorLogConfig(), new AVMonitorLogConfig());
    }
}
