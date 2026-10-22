package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LiveGcControllerConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class t1 extends SSettingKey<LiveGcControllerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t1 f158504a = null;

    static {
        f158504a = new t1();
    }

    public t1() {
        super("live_perf_gc_controller_config", "直播gc控制系统配置", new LiveGcControllerConfig(), new LiveGcControllerConfig());
    }
}
