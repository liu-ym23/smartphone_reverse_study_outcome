package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LivePullStreamDelayConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class m2 extends SSettingKey<LivePullStreamDelayConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m2 f153485a = null;

    static {
        f153485a = new m2();
    }

    public m2() {
        super("live_pull_stream_delay_config", "直播拉流时机延迟劣化实验配置", new LivePullStreamDelayConfig(), new LivePullStreamDelayConfig());
    }
}
