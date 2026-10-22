package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.LiveMemGcStepConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class v1 extends SSettingKey<LiveMemGcStepConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v1 f159239a = null;

    static {
        f159239a = new v1();
    }

    public v1() {
        super("live_perf_mem_gc_step_config", "直播堆内存gc step配置", new LiveMemGcStepConfig(), new LiveMemGcStepConfig());
    }
}
