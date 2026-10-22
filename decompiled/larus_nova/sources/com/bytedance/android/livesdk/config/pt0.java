package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.StreamColorMonitorConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class pt0 extends SSettingKey<StreamColorMonitorConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pt0 f121006a = null;

    static {
        f121006a = new pt0();
    }

    public pt0() {
        super("live_stream_color_monitor_config", "流色彩采集配置", new StreamColorMonitorConfig(), new StreamColorMonitorConfig());
    }
}
