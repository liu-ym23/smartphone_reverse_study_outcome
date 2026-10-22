package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LivePerfEventKitConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class s1 extends SSettingKey<LivePerfEventKitConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1 f157855a = null;

    static {
        f157855a = new s1();
    }

    public s1() {
        super("live_perf_event_kit_config", "直播体验事件分发配置", new LivePerfEventKitConfig(), new LivePerfEventKitConfig());
    }
}
