package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.link.LinkRequestMonitorConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class z7 extends SSettingKey<LinkRequestMonitorConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z7 f121741a = null;

    static {
        f121741a = new z7();
    }

    public z7() {
        super("interact_request_monitor_config", "连麦阶段请求监控配置", new LinkRequestMonitorConfig(), new LinkRequestMonitorConfig());
    }
}
