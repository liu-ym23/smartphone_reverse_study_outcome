package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.performance.LivePerformancePythiaConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class yf0 extends SSettingKey<LivePerformancePythiaConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yf0 f121682a = null;

    static {
        f121682a = new yf0();
    }

    public yf0() {
        super("live_performance_pythia_config", "pythia配置", new LivePerformancePythiaConfig(), new LivePerformancePythiaConfig());
    }
}
